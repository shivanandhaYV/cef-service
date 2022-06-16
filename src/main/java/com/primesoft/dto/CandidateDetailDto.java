package com.primesoft.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class CandidateDetailDto implements Serializable {
    private UUID id;
    private String candidateName;
    private String email;
    private String mobile;
    private Integer jobId;
    private String communicationSkills;
    private String domainKnowldge;
    private String collaborationSkills;
    private String cultureFit;
    private LocalDateTime createdAt;
    private String createdBy;
    private LocalDateTime updatedAt;
    private String updatedBy;
    private List<DomainKnowledgeDto> domainKnowledges;
    private List<InterviewRoundDto> interviewRounds;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public void setCandidateName(String candidateName) {
        this.candidateName = candidateName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Integer getJobId() {
        return jobId;
    }

    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }

    public String getCommunicationSkills() {
        return communicationSkills;
    }

    public void setCommunicationSkills(String communicationSkills) {
        this.communicationSkills = communicationSkills;
    }

    public String getDomainKnowldge() {
        return domainKnowldge;
    }

    public void setDomainKnowldge(String domainKnowldge) {
        this.domainKnowldge = domainKnowldge;
    }

    public String getCollaborationSkills() {
        return collaborationSkills;
    }

    public void setCollaborationSkills(String collaborationSkills) {
        this.collaborationSkills = collaborationSkills;
    }

    public String getCultureFit() {
        return cultureFit;
    }

    public void setCultureFit(String cultureFit) {
        this.cultureFit = cultureFit;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public List<DomainKnowledgeDto> getDomainKnowledges() {
        return domainKnowledges;
    }

    public void setDomainKnowledges(List<DomainKnowledgeDto> domainKnowledges) {
        this.domainKnowledges = domainKnowledges;
    }

    public List<InterviewRoundDto> getInterviewRounds() {
        return interviewRounds;
    }

    public void setInterviewRounds(List<InterviewRoundDto> interviewRounds) {
        this.interviewRounds = interviewRounds;
    }
}
