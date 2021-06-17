package com.fontys.StudyGuide.services;

import com.fontys.StudyGuide.models.Study.Competency;
import com.fontys.StudyGuide.repository.CompetencyRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CompetencyService {
    private final CompetencyRepository competencyRepository;

    public CompetencyService(CompetencyRepository competencyRepository) {
        this.competencyRepository = competencyRepository;
    }
        public void createCompetency(Competency competency){ competencyRepository.save(competency);}
    public Competency getCompetency(int id){ return competencyRepository.findById(id).orElse(null);}
    public Competency getCompetencyByName(String name) { return  competencyRepository.findByName(name);}
    public List<Competency> getAllCompetencies()
    {
        List<Competency> competencies = new ArrayList<>();
        competencyRepository.findAll().forEach(competencies::add);
        return competencies;
    }
    public Competency updateCompetency(Competency competency){ return competencyRepository.save(competency);}
    public void deleteCompetency(int id) { competencyRepository.deleteById(id);}
}
