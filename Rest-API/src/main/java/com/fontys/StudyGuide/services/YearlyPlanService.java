package com.fontys.StudyGuide.services;

import com.fontys.StudyGuide.models.Study.Study_variant;
import com.fontys.StudyGuide.models.Study.Yearly_plan;
import com.fontys.StudyGuide.repository.Yearly_planRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class Yearly_planService {
    private final Yearly_planRepository yearly_planRepository;
    private final Study_variantService study_variantService;

    public Yearly_planService(Yearly_planRepository yearly_planRepository, Study_variantService study_variantService) {
        this.yearly_planRepository = yearly_planRepository;
        this.study_variantService = study_variantService;
    }

    public void createYearly_Plan(Yearly_plan yearly_plan) {
        Study_variant variant = study_variantService.getStudy_Variant(yearly_plan.getVariant().getId());
        if(variant.getYearly_plans()!=null)
        {
            variant.getYearly_plans().add(yearly_plan);
        }
        else
        {
            List<Yearly_plan> plans = new ArrayList<>();
            plans.add(yearly_plan);
            variant.setYearly_plans(plans);
        }
        study_variantService.updateStudy_Variant(variant);
    }

    public Yearly_plan getYearly_Plan(int id) {
        return yearly_planRepository.findById(id).orElse(null);
    }

    public List<Yearly_plan> getAllYearly_Plans() {
        List<Yearly_plan> yearly_plans = new ArrayList<>();
        yearly_planRepository.findAll().forEach(yearly_plans::add);
        return yearly_plans;
    }

    public Yearly_plan updateYearly_Plan(Yearly_plan yearly_plan) {
        return yearly_planRepository.save(yearly_plan);
    }

    public void deleteYearly_Plan(int id) {
        yearly_planRepository.deleteById(id);
    }
}
