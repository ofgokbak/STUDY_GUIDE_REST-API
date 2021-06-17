package com.fontys.StudyGuide.services;

import com.fontys.StudyGuide.models.Study.Assessment;
import com.fontys.StudyGuide.models.Study.Competency;
import com.fontys.StudyGuide.models.Study.Study;
import com.fontys.StudyGuide.repository.StudyRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudyService {
    private final StudyRepository studyRepository;

    public StudyService(StudyRepository studyRepository) {
        this.studyRepository = studyRepository;
    }

    public Study createStudy(Study studyProgram) {
        return studyRepository.save(studyProgram);
    }

    public List<Study> getAllStudies()
    {
        List<Study> studies = new ArrayList<>();
        studyRepository.findAll().forEach(studies::add);
        return studies;
    }

    public Study getStudy(int id) {
        return studyRepository.findById(id).orElse(null);
    }

    public Study getStudyByName(String name) {
        return studyRepository.findByName(name);
    }
    public Study updateStudy(Study study){
        return studyRepository.save(study);
    }
    public void deleteStudy(int id){
        studyRepository.deleteById(id);
    }

}
