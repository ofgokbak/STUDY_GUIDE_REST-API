package com.fontys.StudyGuide.services.converters;

import com.fontys.StudyGuide.dto.Study_variantDto;
import com.fontys.StudyGuide.models.Study.Competency;
import com.fontys.StudyGuide.models.Study.Study_variant;
import com.fontys.StudyGuide.models.Study.Yearly_plan;
import com.fontys.StudyGuide.services.AcademicYearPlanService;
import com.fontys.StudyGuide.services.CompetencyService;
import com.fontys.StudyGuide.services.VariantService;
import com.fontys.StudyGuide.services.Yearly_planService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Study_variant_converter {
    private final Yearly_planService yearly_planService;
    private final VariantService variantService;
    private final AcademicYearPlanService academicYearPlanService;
    private final CompetencyService competencyService;

    public Study_variant_converter(Yearly_planService yearly_planService, VariantService variantService, AcademicYearPlanService academicYearPlanService, CompetencyService competencyService) {
        this.yearly_planService = yearly_planService;
        this.variantService = variantService;
        this.academicYearPlanService = academicYearPlanService;
        this.competencyService = competencyService;
    }

    public Study_variant convertToEntity(Study_variantDto study_variantDto) {
        Study_variant study_variant = new Study_variant();

        study_variant.setId(study_variantDto.getId());
        study_variant.setVariant(variantService.getVariantByName(study_variantDto.getVariant()));
        study_variant.setAcademicYearPlan(academicYearPlanService.getAcademicYearPlan(study_variantDto.getAcademicYearPlanId()));
        if (study_variantDto.getYearly_plan_idList() != null) {
            List<Yearly_plan> yearly_planList = new ArrayList<>();
            study_variantDto.getYearly_plan_idList().forEach(id -> yearly_planList.add(yearly_planService.getYearly_Plan(id)));
            study_variant.setYearly_plans(yearly_planList);
        }
        if(study_variantDto.getCompetencies() != null) {
            List<Competency> competencyList = new ArrayList<>();
            study_variantDto.getCompetencies().forEach(c-> competencyList.add(competencyService.getCompetencyByName(c)));
            study_variant.setCompetencies(competencyList);
        }
        return study_variant;
    }

    public Study_variantDto convertToDto(Study_variant study_variant) {
        Study_variantDto study_variantDto = new Study_variantDto();

        study_variantDto.setId(study_variant.getId());
        study_variantDto.setVariant(study_variant.getVariant().getName());
        study_variantDto.setAcademicYearPlanId(study_variant.getAcademicYearPlan().getId());
        if (study_variant.getYearly_plans() != null) {
            List<Integer> idList = new ArrayList<>();
            study_variant.getYearly_plans().forEach(plan ->idList.add(plan.getId()));
            study_variantDto.setYearly_plan_idList(idList);
        }
        if(study_variant.getCompetencies() != null){
            List<String> competencyList = new ArrayList<>();
            study_variant.getCompetencies().forEach(competency -> competencyList.add(competency.getName()));
            study_variantDto.setCompetencies(competencyList);
        }
        return study_variantDto;
    }
}
