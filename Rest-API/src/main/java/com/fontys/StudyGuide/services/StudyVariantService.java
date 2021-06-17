package com.fontys.StudyGuide.services;

import com.fontys.StudyGuide.models.Study.AcademicYearPlan;
import com.fontys.StudyGuide.models.Study.Study_variant;
import com.fontys.StudyGuide.repository.Study_variantRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class Study_variantService {
    private final Study_variantRepository study_variantRepository;
    private final AcademicYearPlanService academicYearPlanService;

    public Study_variantService(Study_variantRepository study_variantRepository, AcademicYearPlanService academicYearPlanService) {
        this.study_variantRepository = study_variantRepository;
        this.academicYearPlanService = academicYearPlanService;
    }

    public void createStudy_Variant(Study_variant study_variant) {
        AcademicYearPlan academicYearPlan = academicYearPlanService.getAcademicYearPlan(study_variant.getAcademicYearPlan().getId());
        if(academicYearPlan.getVariants()!=null)
        {
            academicYearPlan.getVariants().add(study_variant);
        }
        else
        {
            List<Study_variant> variants = new ArrayList<>();
            variants.add(study_variant);
            academicYearPlan.setVariants(variants);
        }
        academicYearPlanService.updateAcademicYearPlan(academicYearPlan);
    }

    public List<Study_variant> getAllStudy_Variants() {
        List<Study_variant> study_variants = new ArrayList<>();
        study_variantRepository.findAll().forEach(study_variants::add);
        return study_variants;
    }

    public Study_variant getStudy_Variant(int id) {
        return study_variantRepository.findById(id).orElse(null);
    }

    public Study_variant updateStudy_Variant(Study_variant study_variant) {
        return study_variantRepository.save(study_variant);
    }

    public void deleteStudy_Variant(int id) {
        study_variantRepository.deleteById(id);
    }
}
