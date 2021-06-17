package com.fontys.StudyGuide.resources;

import com.fontys.StudyGuide.models.Study.Assessment;
import com.fontys.StudyGuide.services.AssessmentService;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("api/assessment")
@RestController
@CrossOrigin("*")
public class AssessmentResources {
    private final AssessmentService assessmentService;

    public AssessmentResources(AssessmentService assessmentService) {
        this.assessmentService = assessmentService;
    }


    @PostMapping
    public void addAssessment(@Valid @NonNull @RequestBody Assessment assessment) {
        assessmentService.createAssessment(assessment);
    }

    @GetMapping(path = "{id}")
    public Assessment getAssessment(@PathVariable("id") int id) {
        return assessmentService.getAssessment(id);
    }


    @GetMapping
    public List<Assessment> getAllAssessments() {
        return new ArrayList<>(assessmentService.getAllAssessments());
    }

    @PutMapping(path = "{id}")
    public void updateAssessment(@Valid @NonNull @RequestBody Assessment assessment, @PathVariable("id") int id) {
        assessment.setId(id);
        assessmentService.updateAssessment(assessment);
    }

    @DeleteMapping(path = "{id}")
    public void deleteAssessment(@PathVariable("id") int id) {
        assessmentService.deleteAssessment(id);
    }

}
