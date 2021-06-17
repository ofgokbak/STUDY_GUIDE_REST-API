package com.fontys.StudyGuide.services;

import com.fontys.StudyGuide.models.Study.Period;
import com.fontys.StudyGuide.models.Study.Period_subject;
import com.fontys.StudyGuide.repository.Period_subjectRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class Period_subjectService {
    private final Period_subjectRepository period_subjectRepository;
    private final PeriodService periodService;

    public Period_subjectService(Period_subjectRepository period_subjectRepository, PeriodService periodService) {
        this.period_subjectRepository = period_subjectRepository;
        this.periodService = periodService;
    }

    public void createPeriod_Subject(Period_subject period_subject) {

        Period period = periodService.getPeriod(period_subject.getPeriod().getId());
        if(period.getSubjects()!=null)
        {
            period.getSubjects().add(period_subject);
        }
        else
        {
            List<Period_subject> subjects = new ArrayList<>();
            subjects.add(period_subject);
            period.setSubjects(subjects);
        }
        periodService.updatePeriod(period);
    }

    public Period_subject getPeriod_Subject(int id) {
        return period_subjectRepository.findById(id).orElse(null);
    }

    public List<Period_subject> getAllPeriod_Subjects() {
        List<Period_subject> period_subjects = new ArrayList<>();
        period_subjectRepository.findAll().forEach(period_subjects::add);
        return period_subjects;
    }

    public void updatePeriod_Subject(Period_subject period_subject) {
        period_subjectRepository.save(period_subject);
    }

    public void deletePeriod_Subject(int id) {
        period_subjectRepository.deleteById(id);
    }
}
