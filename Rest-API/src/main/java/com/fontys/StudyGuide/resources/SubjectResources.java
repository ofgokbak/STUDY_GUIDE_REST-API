package com.fontys.StudyGuide.resources;
import com.fontys.StudyGuide.dto.SubjectDto;
import com.fontys.StudyGuide.models.Study.Subject;
import com.fontys.StudyGuide.services.SubjectService;
import com.fontys.StudyGuide.services.converters.Subject_converter;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@RequestMapping("api/subjects")
@RestController
@CrossOrigin("*")
public class SubjectResources {
    private final SubjectService subjectService;
    private final Subject_converter subject_converter;

    public SubjectResources(SubjectService subjectService, Subject_converter subject_converter) {
        this.subjectService = subjectService;
        this.subject_converter = subject_converter;
    }


    @PostMapping
    public void addNewSubject(@Valid @NonNull @RequestBody SubjectDto subjectDto) {
        subjectService.createSubject(subject_converter.convertToEntity(subjectDto));
    }

    @GetMapping(path = "{id}")
    public Subject getSubject(@PathVariable("id") int id) {
        return subjectService.getSubject(id);
    }


    @GetMapping
    public List<Subject> getAllSubjects() {
        return subjectService.getAllSubjects();
    }

    @PutMapping(path = "{id}")
    public void updateSubject(@Valid @NonNull @RequestBody SubjectDto subjectDto, @PathVariable("id") int id){
        subjectDto.setId(id);
        subjectService.updateSubject(subject_converter.convertToEntity(subjectDto));
    }

    @DeleteMapping(path = "{id}")
    public void deleteSubject(@PathVariable("id") int id) { subjectService.deleteSubject(id);}

}