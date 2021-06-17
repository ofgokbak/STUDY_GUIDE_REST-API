package com.fontys.StudyGuide.services.converters;

import com.fontys.StudyGuide.dto.VariantDto;
import com.fontys.StudyGuide.models.Study.Variant;
import com.fontys.StudyGuide.services.StudyService;
import org.springframework.stereotype.Component;

@Component
public class Variant_converter {
    private final StudyService studyService;

    public Variant_converter(StudyService studyService) {
        this.studyService = studyService;
    }

    public Variant convertToEntity(VariantDto variantDto){
        Variant variant = new Variant();

        variant.setId(variantDto.getId());
        variant.setName(variantDto.getName());
        variant.setStudy(studyService.getStudyByName(variantDto.getStudy()));

        return variant;
    }

    public VariantDto convertToDto(Variant variant){
        VariantDto variantDto = new VariantDto();

        variantDto.setId(variant.getId());
        variantDto.setName(variant.getName());
        variantDto.setStudy(variant.getStudy().getName());

        return variantDto;
    }
}
