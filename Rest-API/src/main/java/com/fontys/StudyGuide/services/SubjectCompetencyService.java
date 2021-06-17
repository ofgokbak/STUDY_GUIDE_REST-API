package com.fontys.StudyGuide.services;

import com.fontys.StudyGuide.models.Study.Subject;
import com.fontys.StudyGuide.models.Study.Subject_competency;
import com.fontys.StudyGuide.repository.Subject_competencyRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class Subject_competencyService {
    private final Subject_competencyRepository subject_competencyRepository;
    private final SubjectService subjectService;

    public Subject_competencyService(Subject_competencyRepository subject_competencyRepository, SubjectService subjectService) {
        this.subject_competencyRepository = subject_competencyRepository;
        this.subjectService = subjectService;
    }

    public void createSubject_Competency(Subject_competency subject_competency) {
        Subject subject = subjectService.getSubject(subject_competency.getSubject().getId());
        if(subject.getCompetencies()!=null)
        {
            subject.getCompetencies().add(subject_competency);
        }
        else
        {
            List<Subject_competency> competencies = new ArrayList<>();
            competencies.add(subject_competency);
            subject.setCompetencies(competencies);
        }
        subjectService.updateSubject(subject);
    }

    public Subject_competency getSubject_Competency(int id) {
        return subject_competencyRepository.findById(id).orElse(null);
    }

    public List<Subject_competency> getSubject_Competencies() {
        List<Subject_competency> subject_competencies = new ArrayList<>();
        subject_competencyRepository.findAll().forEach(subject_competencies::add);
        return subject_competencies;
    }

    public Subject_competency updateSubject_Competency(Subject_competency subject_competency) {
        return subject_competencyRepository.save(subject_competency);
    }

    public void deleteSubject_Competency(int id) {
        subject_competencyRepository.deleteById(id);
    }

}
