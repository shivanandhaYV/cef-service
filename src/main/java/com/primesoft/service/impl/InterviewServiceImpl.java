package com.primesoft.service.impl;

import com.primesoft.dto.CandidateDetailDto;
import com.primesoft.dto.InterviewQuestionDto;
import com.primesoft.entity.CandidateDetail;
import com.primesoft.entity.DomainKnowledge;
import com.primesoft.entity.InterviewQuestion;
import com.primesoft.entity.InterviewRound;
import com.primesoft.mapper.CandidateDetailMapper;
import com.primesoft.repo.CandidateRepository;
import com.primesoft.repo.DomainKnowledgeRepository;
import com.primesoft.repo.InterviewQuestionsRepository;
import com.primesoft.repo.InterviewRoundRepository;
import com.primesoft.service.InterviewService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class InterviewServiceImpl implements InterviewService {

    @Autowired
    private CandidateRepository candidateRepo;

    @Autowired
    private DomainKnowledgeRepository domainKnowledgeRepo;

    @Autowired
    private InterviewRoundRepository interviewRoundRepo;

    @Autowired
    private InterviewQuestionsRepository interviewQuestionsRepo;

    @Autowired
    private CandidateDetailMapper candidateDetailMapper;


    @Override
    @Transactional
    public CandidateDetailDto saveCandidateDetails(CandidateDetailDto candidateDetail) {
        CandidateDetail candidateDetail1 = candidateDetailMapper.candidateDetailDtoToCandidateDetail(candidateDetail);
        CandidateDetail candidate = candidateRepo.save(candidateDetail1);

        List<DomainKnowledge> domainKnowledges = candidateDetail1.getDomainKnowledges()
                .parallelStream()
                .map(data -> {
                    data.setCandidateDetail(candidate);
                    return data;
                }).collect(Collectors.toList());

        domainKnowledgeRepo.saveAll(domainKnowledges);

        List<InterviewQuestion> questions = new ArrayList<>();
        List<InterviewRound> interviewRounds = candidateDetail1.getInterviewRounds()
                .parallelStream()
                .map(data -> {
                    questions.addAll(data.getInterviewQuestions());
                    data.setCandidateDetail(candidate);
                    return data;
                }).collect(Collectors.toList());
        interviewRoundRepo.saveAll(interviewRounds);

        List<InterviewQuestion> interviewQuestions = questions
                .parallelStream()
                .map(data -> {
                    data.setInterviewRound(interviewRounds.get(0));
                    return data;
                }).collect(Collectors.toList());

        interviewQuestionsRepo.saveAll(interviewQuestions);


        return candidateDetailMapper.candidateDetailToCandidateDetailDto(candidateRepo.findById(candidate.getId()).get());
    }

    @Override
    public CandidateDetailDto getCandidateDetails(UUID id) {
        return candidateDetailMapper.candidateDetailToCandidateDetailDto(candidateRepo.findById(id).get());
    }

    @Override
    @Transactional
    public String updateCandidateDetails(CandidateDetailDto candidateDetailDto) {
        CandidateDetail candidateDetail1 = candidateRepo.findById(candidateDetailDto.getId()).get();
        candidateRepo.save(candidateDetail1);

        /*domain knowledge update*/
        List<DomainKnowledge> domainKnowldges = candidateDetailDto.getDomainKnowledges()
                .parallelStream()
                .map(data -> {
                    DomainKnowledge domainKnowledge = null;
                    if (Objects.nonNull(data.getId()))
                        domainKnowledge = domainKnowledgeRepo.findById(data.getId()).orElse(new DomainKnowledge());
                    else
                        domainKnowledge = new DomainKnowledge();

                    if(Objects.isNull(domainKnowledge.getCandidateDetail()))
                        domainKnowledge.setCandidateDetail(candidateDetail1);
                    BeanUtils.copyProperties(data, domainKnowledge);
                    return domainKnowledge;
                }).collect(Collectors.toList());

        /* interview round updates*/

        List<InterviewQuestionDto> interviewQuestionDtos = new ArrayList<>();

        List<InterviewRound> interviewRounds = candidateDetailDto.getInterviewRounds()
                .parallelStream()
                .map(data -> {
                    interviewQuestionDtos.addAll(data.getInterviewQuestions());
                    InterviewRound interviewRound = null;
                    if (Objects.nonNull(data.getId()))
                        interviewRound = interviewRoundRepo.findById(data.getId()).orElse(new InterviewRound());
                    else
                        interviewRound = new InterviewRound();
                    if (Objects.nonNull(interviewRound.getCandidateDetail()))
                        interviewRound.setCandidateDetail(candidateDetail1);
                    BeanUtils.copyProperties(data, interviewRound);
                    return interviewRound;
                }).collect(Collectors.toList());


        domainKnowledgeRepo.saveAll(domainKnowldges);
        interviewRoundRepo.saveAll(interviewRounds);

        List<InterviewQuestion> interviewQuestions = interviewQuestionDtos
                .parallelStream()
                .map(data -> {
                    InterviewQuestion interviewQuestion = null;
                    if (Objects.nonNull(data.getId()))
                        interviewQuestion = interviewQuestionsRepo.findById(data.getId()).orElse(new InterviewQuestion());
                    else
                        interviewQuestion = new InterviewQuestion();
                    if (Objects.isNull(interviewQuestion.getInterviewRound()))
                        interviewQuestion.setInterviewRound(interviewRounds.get(0));
                    return interviewQuestion;
                }).collect(Collectors.toList());

        interviewQuestionsRepo.saveAll(interviewQuestions);

        return "Interview Candidate Details Updated Successfully";
    }

    @Override
    public String deleteCandidateDetails(UUID id) {
        candidateRepo.deleteById(id);
        return "Candidate Details Deleted Successfully";
    }
}
