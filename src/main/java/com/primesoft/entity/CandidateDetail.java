package com.primesoft.entity;


import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "candidate_details")
public class CandidateDetail {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator",
            parameters = {
                    @Parameter(
                            name = "uuid_gen_strategy_class",
                            value = "org.hibernate.id.uuid.CustomVersionOneStrategy"
                    )
            }
    )
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "candidate_name", nullable = false)
    private String candidateName;


    @Column(name = "email", nullable = false)
    private String email;


    @Column(name = "mobile", nullable = false)
    private String mobile;

    @Column(name = "job_id", nullable = false)
    private Integer jobId;


    @Column(name = "communication_skills", nullable = false)
    private String communicationSkills;


    @Column(name = "domain_knowldge")
    private String domainKnowldge;


    @Column(name = "collaboration_skills", nullable = false)
    private String collaborationSkills;


    @Column(name = "culture_fit", nullable = false)
    private String cultureFit;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;


    @Column(name = "created_by", nullable = false)
    private String createdBy;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;


    @Column(name = "updated_by")
    private String updatedBy;


    @OneToMany(mappedBy = "candidateDetail", orphanRemoval = true)
    private List<DomainKnowledge> domainKnowledges;

    @OneToMany(mappedBy = "candidateDetail", orphanRemoval = true)
    private List<InterviewRound> interviewRounds;

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

    public List<DomainKnowledge> getDomainKnowledges() {
        return domainKnowledges;
    }

    public void setDomainKnowledges(List<DomainKnowledge> domainKnowledges) {
        this.domainKnowledges = domainKnowledges;
    }

    public List<InterviewRound> getInterviewRounds() {
        return interviewRounds;
    }

    public void setInterviewRounds(List<InterviewRound> interviewRounds) {
        this.interviewRounds = interviewRounds;
    }
}