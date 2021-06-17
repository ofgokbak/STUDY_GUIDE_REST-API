package com.fontys.StudyGuide.resources;

import com.fontys.StudyGuide.dto.StudyDto;
import com.fontys.StudyGuide.models.Study.Study;
import com.fontys.StudyGuide.services.StudyService;
import com.fontys.StudyGuide.services.converters.Study_converter;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("api/study")
@RestController
@CrossOrigin("*")
public class StudyResources {
    private final StudyService studyService;
    private final Study_converter study_converter;

    public StudyResources(StudyService studyService, Study_converter study_converter) {
        this.studyService = studyService;
        this.study_converter = study_converter;
    }


    @PostMapping
    public void addNewStudy(@Valid @NonNull @RequestBody StudyDto studyDto) {
        Study study = studyService.getStudyByName(studyDto.getName());
        if(study == null)
        {
            studyService.createStudy(study_converter.convertToEntity(studyDto));
        }
        else{
            throw new IllegalArgumentException("Study already exists");
        }
    }

    @GetMapping(path = "{id}")
    public Study getStudy(@PathVariable("id") int id) {
       return studyService.getStudy(id);
    }


    @GetMapping
    public List<StudyDto> getAllStudies() {
        List<Study> studyList = studyService.getAllStudies();
        List<StudyDto> studyDtoList = new ArrayList<>();
        studyList.forEach(study -> studyDtoList.add(study_converter.convertToDto(study)));
        return studyDtoList;
    }

    @PutMapping(path = "{id}")
    public void updateStudy(@Valid @NonNull @RequestBody StudyDto studyDto, @PathVariable("id") int id){
        studyDto.setId(id);
        studyService.updateStudy(study_converter.convertToEntity(studyDto));
    }

    @DeleteMapping(path = "{id}")
    public void deleteStudy(@PathVariable("id") int id) { studyService.deleteStudy(id);}

}
