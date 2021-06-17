package com.fontys.StudyGuide.services.converters;

import com.fontys.StudyGuide.dto.StudyDto;
import com.fontys.StudyGuide.models.Study.AcademicYearPlan;
import com.fontys.StudyGuide.models.Study.Study;
import com.fontys.StudyGuide.services.AcademicYearPlanService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Study_converter {
    private final AcademicYearPlanService academicYearPlanService;

    public Study_converter(AcademicYearPlanService academicYearPlanService) {
        this.academicYearPlanService = academicYearPlanService;
    }
    public Study convertToEntity(StudyDto studyDto){
        Study study = new Study();
        study.setId(studyDto.getId());
        study.setName(studyDto.getName());
        if(studyDto.getAcademicYearPlan_idList() != null)
        {
            List<AcademicYearPlan> academicYearPlans = new ArrayList<>();
            studyDto.getAcademicYearPlan_idList().forEach(id-> academicYearPlans.add(academicYearPlanService.getAcademicYearPlan(id)));
            study.setAcademicYearPlanList(academicYearPlans);
        }
        return study;
    }

    public StudyDto convertToDto(Study study){
        StudyDto studyDto = new StudyDto();
        studyDto.setId(study.getId());
        studyDto.setName(study.getName());
        if(study.getAcademicYearPlanList() != null)
        {
            List<Integer> idList = new ArrayList<>();
            study.getAcademicYearPlanList().forEach(year-> idList.add(year.getId()));
            studyDto.setAcademicYearPlan_idList(idList);
        }

        return studyDto;
    }
}
