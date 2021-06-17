package com.fontys.StudyGuide.resources;

import com.fontys.StudyGuide.models.Study.Competency;
import com.fontys.StudyGuide.services.CompetencyService;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("api/competency")
@RestController
@CrossOrigin("*")
public class CompetencyResources {
    private final CompetencyService competencyService;

    public CompetencyResources(CompetencyService competencyService) {
        this.competencyService = competencyService;
    }


    @PostMapping
    public void addCompetency(@Valid @NonNull @RequestBody Competency competency) {
        competencyService.createCompetency(competency);
    }

    @GetMapping(path = "{id}")
    public Competency getCompetency(@PathVariable("id") int id) {
        return competencyService.getCompetency(id);
    }


    @GetMapping
    public List<Competency> getAllCompetencies() {
        return new ArrayList<>(competencyService.getAllCompetencies());
    }

    @PutMapping(path = "{id}")
    public void updateCompetency(@Valid @NonNull @RequestBody Competency competency, @PathVariable("id") int id) {
        competency.setId(id);
        competencyService.updateCompetency(competency);
    }

    @DeleteMapping(path = "{id}")
    public void deleteCompetency(@PathVariable("id") int id) {
        competencyService.deleteCompetency(id);
    }
}
