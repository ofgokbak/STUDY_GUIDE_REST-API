package com.fontys.StudyGuide.services;

import com.fontys.StudyGuide.models.Study.Assessment;
import com.fontys.StudyGuide.repository.AssessmentRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AssessmentService {
    private final AssessmentRepository assessmentRepository;

    public AssessmentService(AssessmentRepository assessmentRepository) {
        this.assessmentRepository = assessmentRepository;
    }
        public void createAssessment(Assessment assessment){ assessmentRepository.save(assessment);}
    public Assessment getAssessment(int id){ return assessmentRepository.findById(id).orElse(null);}
    public List<Assessment> getAllAssessments()
    {
        List<Assessment> assessments = new ArrayList<>();
        assessmentRepository.findAll().forEach(assessments::add);
        return assessments;
    }
    public Assessment updateAssessment(Assessment assessment){ return assessmentRepository.save(assessment);}
    public void deleteAssessment(int id) { assessmentRepository.deleteById(id);}
}
