package com.fontys.StudyGuide.resources;

import com.fontys.StudyGuide.dto.Subject_competencyDto;
import com.fontys.StudyGuide.models.Study.Subject_competency;
import com.fontys.StudyGuide.services.Subject_competencyService;
import com.fontys.StudyGuide.services.converters.Subject_competency_converter;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("api/subject_competency")
@RestController
@CrossOrigin("*")
public class Subject_competencyResources {
    private final Subject_competencyService subject_competencyService;
    private final Subject_competency_converter subject_competency_converter;

    public Subject_competencyResources(Subject_competencyService subject_competencyService, Subject_competency_converter subject_competency_converter) {
        this.subject_competencyService = subject_competencyService;
        this.subject_competency_converter = subject_competency_converter;
    }


    @PostMapping
    public void addNewSubject_competency(@Valid @NonNull @RequestBody Subject_competencyDto subject_competencyDto) {
        subject_competencyService.createSubject_Competency(subject_competency_converter.convertToEntity(subject_competencyDto));
    }

    @GetMapping(path = "{id}")
    public Subject_competencyDto getSubject_competency(@PathVariable("id") int id) {
        return subject_competency_converter.convertToDto(subject_competencyService.getSubject_Competency(id));
    }


    @GetMapping
    public List<Subject_competencyDto> getAllSubject_competencies() {
        List<Subject_competency> subject_competencyList = subject_competencyService.getSubject_Competencies();
        List<Subject_competencyDto> subject_competencyDtoList = new ArrayList<>();
        subject_competencyList.forEach(subject_competency -> subject_competencyDtoList.add(subject_competency_converter.convertToDto(subject_competency)));
        return subject_competencyDtoList;
    }

    @PutMapping(path = "{id}")
    public void updateSubject_competency(@Valid @NonNull @RequestBody Subject_competencyDto subject_competencyDto, @PathVariable("id") int id){
        subject_competencyDto.setId(id);
        subject_competencyService.updateSubject_Competency(subject_competency_converter.convertToEntity(subject_competencyDto));
    }

    @DeleteMapping(path = "{id}")
    public void deleteSubject_competency(@PathVariable("id") int id) { subject_competencyService.deleteSubject_Competency(id);}

}
