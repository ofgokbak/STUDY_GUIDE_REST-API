package com.fontys.StudyGuide.services.converters;

import com.fontys.StudyGuide.dto.Yearly_planDto;
import com.fontys.StudyGuide.models.Study.Period;
import com.fontys.StudyGuide.models.Study.Yearly_plan;
import com.fontys.StudyGuide.services.PeriodService;
import com.fontys.StudyGuide.services.Study_variantService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Yearly_plan_converter {
    private final Study_variantService study_variantService;
    private final PeriodService periodService;

    public Yearly_plan_converter(Study_variantService study_variantService, PeriodService periodService) {
        this.study_variantService = study_variantService;
        this.periodService = periodService;
    }

    public Yearly_plan convertToEntity(Yearly_planDto yearly_planDto) {
        Yearly_plan yearly_plan = new Yearly_plan();

        yearly_plan.setId(yearly_planDto.getId());
        yearly_plan.setYearNumber(yearly_planDto.getYearNumber());
        yearly_plan.setVariant(study_variantService.getStudy_Variant(yearly_planDto.getStudy_variant_id()));

        if (yearly_planDto.getPeriod_idList() != null) {
            List<Period> periodList = new ArrayList<>();
            yearly_planDto.getPeriod_idList().forEach(id -> periodList.add(periodService.getPeriod(id)));
            yearly_plan.setPeriods(periodList);
        }

        return yearly_plan;
    }

    public Yearly_planDto convertToDto(Yearly_plan yearly_plan) {
        Yearly_planDto yearly_planDto = new Yearly_planDto();

        yearly_planDto.setId(yearly_plan.getId());
        yearly_planDto.setYearNumber(yearly_plan.getYearNumber());
        yearly_planDto.setStudy_variant_id(yearly_plan.getVariant().getId());
        if(yearly_plan.getPeriods()!=null)
        {
            List<Integer>idList = new ArrayList<>();
            yearly_plan.getPeriods().forEach(period -> idList.add(period.getId()));
            yearly_planDto.setPeriod_idList(idList);
        }
        return yearly_planDto;
    }
}
