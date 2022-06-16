package com.primesoft.mapper;

import com.primesoft.dto.CandidateDetailDto;
import com.primesoft.entity.CandidateDetail;
import org.mapstruct.BeanMapping;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface CandidateDetailMapper {
    @Mapping(source = "domainKnowledges", target = "domainKnowledges")
    @Mapping(source = "interviewRounds", target = "interviewRounds")
    CandidateDetail candidateDetailDtoToCandidateDetail(CandidateDetailDto candidateDetailDto);

    @InheritInverseConfiguration(name = "candidateDetailDtoToCandidateDetail")
    CandidateDetailDto candidateDetailToCandidateDetailDto(CandidateDetail candidateDetail);

    @InheritConfiguration(name = "candidateDetailDtoToCandidateDetail")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateCandidateDetailFromCandidateDetailDto(CandidateDetailDto candidateDetailDto, @MappingTarget CandidateDetail candidateDetail);
}
