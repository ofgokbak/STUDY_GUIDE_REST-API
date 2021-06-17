package com.fontys.StudyGuide.services.converters;

import com.fontys.StudyGuide.dto.AcademicYearPlanDto;
import com.fontys.StudyGuide.models.Study.AcademicYearPlan;
import com.fontys.StudyGuide.models.Study.Study_variant;
import com.fontys.StudyGuide.services.CompetencyService;
import com.fontys.StudyGuide.services.StudyService;
import com.fontys.StudyGuide.services.Study_variantService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class Academic_year_plan_converter {
    private final StudyService studyService;
    private final Study_variantService study_variantService;
    private final CompetencyService competencyService;

    public Academic_year_plan_converter(StudyService studyService, Study_variantService study_variantService, CompetencyService competencyService) {
        this.studyService = studyService;
        this.study_variantService = study_variantService;
        this.competencyService = competencyService;
    }

    public AcademicYearPlan convertToEntity(AcademicYearPlanDto academicYearPlanDto) {
        AcademicYearPlan academicYearPlan = new AcademicYearPlan();
        academicYearPlan.setId(academicYearPlanDto.getId());
        academicYearPlan.setAcademicYear(academicYearPlanDto.getYear());
        academicYearPlan.setStudy(studyService.getStudyByName(academicYearPlanDto.getStudy()));
        if(academicYearPlanDto.getStudy_variant_idList()!=null)
        {
            List<Study_variant> study_variantList = new ArrayList<>();
            academicYearPlanDto.getStudy_variant_idList().forEach(id-> study_variantList.add(study_variantService.getStudy_Variant(id)));
            academicYearPlan.setVariants(study_variantList);
        }

        return academicYearPlan;
    }

    public AcademicYearPlanDto convertToDto(AcademicYearPlan academicYearPlan) {
        AcademicYearPlanDto academicYearPlanDto = new AcademicYearPlanDto();
        academicYearPlanDto.setId(academicYearPlan.getId());
        if(academicYearPlan.getVariants() != null)
        {
            List<Integer> idList = new ArrayList<>();
            academicYearPlan.getVariants().forEach(study_variant -> idList.add(study_variant.getId()));
            academicYearPlanDto.setStudy_variant_idList(idList);
        }
        academicYearPlanDto.setStudy(academicYearPlan.getStudy().getName());
        academicYearPlanDto.setYear(academicYearPlan.getAcademicYear());

        return academicYearPlanDto;
    }
}
