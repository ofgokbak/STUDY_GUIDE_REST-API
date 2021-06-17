package com.fontys.StudyGuide.resources;

import com.fontys.StudyGuide.dto.Study_variantDto;
import com.fontys.StudyGuide.models.Study.Study_variant;
import com.fontys.StudyGuide.services.Study_variantService;
import com.fontys.StudyGuide.services.converters.Study_variant_converter;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("api/study_variant")
@RestController
@CrossOrigin("*")
public class Study_variantResources {
    private final Study_variantService study_variantService;
    private final Study_variant_converter study_variant_converter;

    public Study_variantResources(Study_variantService study_variantService, Study_variant_converter study_variant_converter) {
        this.study_variantService = study_variantService;
        this.study_variant_converter = study_variant_converter;
    }


    @PostMapping
    public void addNewStudy_variant(@Valid @NonNull @RequestBody Study_variantDto study_variantDto) {
        study_variantService.createStudy_Variant(study_variant_converter.convertToEntity(study_variantDto));
    }

    @GetMapping(path = "{id}")
    public Study_variant getStudy_variant(@PathVariable("id") int id) {
        return study_variantService.getStudy_Variant(id);
    }


    @GetMapping
    public List<Study_variantDto> getAllStudy_variants() {
        List<Study_variant> study_variantList = study_variantService.getAllStudy_Variants();
        List<Study_variantDto> study_variantDtoList = new ArrayList<>();
        study_variantList.forEach(study_variant -> study_variantDtoList.add(study_variant_converter.convertToDto(study_variant)));
        return study_variantDtoList;
    }

    @PutMapping(path = "{id}")
    public void updateStudy_variant(@Valid @NonNull @RequestBody Study_variantDto study_variantDto, @PathVariable("id") int id){
        study_variantDto.setId(id);
        study_variantService.updateStudy_Variant(study_variant_converter.convertToEntity(study_variantDto));
    }

    @DeleteMapping(path = "{id}")
    public void deleteStudy_variant(@PathVariable("id") int id) { study_variantService.deleteStudy_Variant(id);}

}
