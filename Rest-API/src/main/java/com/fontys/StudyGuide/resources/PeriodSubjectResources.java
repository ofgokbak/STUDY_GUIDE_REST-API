package com.fontys.StudyGuide.resources;

import com.fontys.StudyGuide.dto.Period_subjectDto;
import com.fontys.StudyGuide.models.Study.Period_subject;
import com.fontys.StudyGuide.services.Period_subjectService;
import com.fontys.StudyGuide.services.converters.Period_subject_converter;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("api/period_subject")
@RestController
@CrossOrigin("*")
public class Period_subjectResources {
    private final Period_subjectService period_subjectService;
    private final Period_subject_converter period_subject_converter;

    public Period_subjectResources(Period_subjectService period_subjectService, Period_subject_converter period_subject_converter) {
        this.period_subjectService = period_subjectService;
        this.period_subject_converter = period_subject_converter;
    }


    @PostMapping
    public void addNewPeriod_subject(@Valid @NonNull @RequestBody Period_subjectDto period_subjectDto) {
        period_subjectService.createPeriod_Subject(period_subject_converter.convertToEntity(period_subjectDto));
    }

    @GetMapping(path = "{id}")
    public Period_subjectDto getPeriod_subject(@PathVariable("id") int id) {
        return period_subject_converter.convertToDto(period_subjectService.getPeriod_Subject(id));
    }


    @GetMapping
    public List<Period_subjectDto> getAllPeriod_subjects() {
        List<Period_subject> period_subjectList = period_subjectService.getAllPeriod_Subjects();
        List<Period_subjectDto> period_subjectDtoList = new ArrayList<>();
        period_subjectList.forEach(academicYearPlan -> period_subjectDtoList.add(period_subject_converter.convertToDto(academicYearPlan)));
        return period_subjectDtoList;
    }

    @PutMapping(path = "{id}")
    public void updatePeriod_subject(@Valid @NonNull @RequestBody Period_subjectDto period_subjectDto, @PathVariable("id") int id){
        period_subjectDto.setId(id);
        period_subjectService.updatePeriod_Subject(period_subject_converter.convertToEntity(period_subjectDto));
    }

    @DeleteMapping(path = "{id}")
    public void deletePeriod_subject(@PathVariable("id") int id) { period_subjectService.deletePeriod_Subject(id);}

}
