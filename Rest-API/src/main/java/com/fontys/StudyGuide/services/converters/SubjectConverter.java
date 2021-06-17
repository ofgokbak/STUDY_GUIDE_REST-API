package com.fontys.StudyGuide.services.converters;

import com.fontys.StudyGuide.dto.SubjectDto;
import com.fontys.StudyGuide.models.Study.Assessment;
import com.fontys.StudyGuide.models.Study.Subject;
import com.fontys.StudyGuide.models.Study.Subject_competency;
import com.fontys.StudyGuide.services.AssessmentService;
import com.fontys.StudyGuide.services.Subject_competencyService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Subject_converter {
    private final Subject_competencyService subject_competencyService;
    private final AssessmentService assessmentService;

    public Subject_converter(Subject_competencyService subject_competencyService, AssessmentService assessmentService) {
        this.subject_competencyService = subject_competencyService;
        this.assessmentService = assessmentService;
    }

    public Subject convertToEntity(SubjectDto subjectDto) {
        Subject subject = new Subject();

        subject.setId(subjectDto.getId());
        subject.setEc(subjectDto.getEc());
        subject.setName(subjectDto.getName());
        subject.setContent(subjectDto.getContent());
        subject.setVakCode(subjectDto.getVakCode());
        subject.setObjectives(subjectDto.getObjectives());
        subject.setDidacticElements(subjectDto.getDidacticElements());
        subject.setResearch(subjectDto.getResearch());
        subject.setPerformanceIndicators(subjectDto.getPerformanceIndicators());
        subject.setResources(subjectDto.getResources());
        subject.setClassTime(subjectDto.getClassTime());
        if (subjectDto.getAssessmentIdList() != null) {
            List<Assessment> assessmentList = new ArrayList<>();
            subjectDto.getAssessmentIdList().forEach(id -> assessmentList.add(assessmentService.getAssessment(id)));
            subject.setAssessments(assessmentList);
        }
        if (subjectDto.getSubject_competencyIdList() != null) {
            List<Subject_competency> subject_competencyList = new ArrayList<>();
            subjectDto.getSubject_competencyIdList().forEach(id -> subject_competencyList.add(subject_competencyService.getSubject_Competency(id)));
            subject.setCompetencies(subject_competencyList);
        }
        return subject;
    }

    public SubjectDto convertToDto(Subject subject) {
        SubjectDto subjectDto = new SubjectDto();
        subjectDto.setId(subject.getId());
        subjectDto.setEc(subject.getEc());
        subjectDto.setName(subject.getName());
        subjectDto.setContent(subject.getContent());
        subjectDto.setVakCode(subject.getVakCode());
        subjectDto.setObjectives(subject.getObjectives());
        subjectDto.setDidacticElements(subject.getDidacticElements());
        subjectDto.setResearch(subject.getResearch());
        subjectDto.setPerformanceIndicators(subject.getPerformanceIndicators());
        subjectDto.setResources(subject.getResources());
        subjectDto.setClassTime(subject.getClassTime());

        if (subject.getAssessments() != null) {
            List<Integer> idList = new ArrayList<>();
            subject.getAssessments().forEach(assessment -> idList.add(assessment.getId()));
            subjectDto.setAssessmentIdList(idList);
        }
        if (subject.getCompetencies() != null)
        {
            List<Integer>idList = new ArrayList<>();
            subject.getCompetencies().forEach(competency -> idList.add(competency.getId()));
            subjectDto.setSubject_competencyIdList(idList);
        }
        return subjectDto;

    }
}
