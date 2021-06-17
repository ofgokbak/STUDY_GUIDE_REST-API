package com.fontys.StudyGuide.services;

import com.fontys.StudyGuide.models.Study.Competency;
import com.fontys.StudyGuide.models.Study.Subject;
import com.fontys.StudyGuide.repository.SubjectRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SubjectService {
    private final SubjectRepository subjectRepository;

    public SubjectService(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    public void createSubject(Subject subject){
        subjectRepository.save(subject);
    }
    public List<Subject> getAllSubjects(){
        List<Subject> subjectList = new ArrayList<>();
        subjectRepository.findAll().forEach(subjectList::add);
        return subjectList;
    }
    public Subject getSubject(int id){
        return subjectRepository.findById(id).orElse(null);
    }
    public List<Competency> getCompetenciesBySubject(int id){
        List<Competency> competencies = new ArrayList<>();
        getSubject(id).getCompetencies().forEach(subject_competency -> competencies.add(subject_competency.getCompetency()));
        return  competencies;
    }
    public Subject updateSubject(Subject subject){
        return subjectRepository.save(subject);
    }
    public void deleteSubject(int id){
        subjectRepository.deleteById(id);
    }
}
