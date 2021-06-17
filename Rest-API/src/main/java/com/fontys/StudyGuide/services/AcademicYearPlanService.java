package com.fontys.StudyGuide.services;

import com.fontys.StudyGuide.models.Study.AcademicYearPlan;
import com.fontys.StudyGuide.models.Study.Competency;
import com.fontys.StudyGuide.models.Study.Study;
import com.fontys.StudyGuide.repository.AcademicYearPlanRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AcademicYearPlanService {
    private final AcademicYearPlanRepository academicYearPlanRepository;
    private final StudyService studyService;

    public AcademicYearPlanService(AcademicYearPlanRepository academicYearPlanRepository, StudyService studyService) {
        this.academicYearPlanRepository = academicYearPlanRepository;
        this.studyService = studyService;
    }

    public void addAcademicYearPlan(AcademicYearPlan academicYearPlan)
    {
        Study study = academicYearPlan.getStudy();
        if(study.getAcademicYearPlanList() != null)
        {
            study.getAcademicYearPlanList().add(academicYearPlan);
        }
        else
        {
            List<AcademicYearPlan> academicYearPlanList = new ArrayList<>();
            academicYearPlanList.add(academicYearPlan);
            study.setAcademicYearPlanList(academicYearPlanList);
        }
        studyService.updateStudy(study);
    }
    public List<AcademicYearPlan> getAcademicYearPlans()
    {
        List<AcademicYearPlan> courseTypeList = new ArrayList<>();
        academicYearPlanRepository.findAll().forEach(courseTypeList::add);
        return courseTypeList;
    }
    public AcademicYearPlan getAcademicYearPlan(int id)
    {
        return academicYearPlanRepository.findById(id).orElse(null);
    }
    public AcademicYearPlan updateAcademicYearPlan(AcademicYearPlan academicYearPlan)
    {
        if(getAcademicYearPlan(academicYearPlan.getId()) != null)
        {
            return academicYearPlanRepository.save(academicYearPlan);
        }
        return null;
    }
    public int deleteAcademicYearPlan(int id)
    {
        if(getAcademicYearPlan(id) != null)
        {
            academicYearPlanRepository.deleteById(id);
            return 1;
        }
        return 0;
    }

}
