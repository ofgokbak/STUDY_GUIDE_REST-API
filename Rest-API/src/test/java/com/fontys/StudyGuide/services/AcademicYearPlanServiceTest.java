package com.fontys.StudyGuide.services;

import com.fontys.StudyGuide.models.Study.AcademicYearPlan;
import com.fontys.StudyGuide.models.Study.Study;
import com.fontys.StudyGuide.repository.AcademicYearPlanRepository;
import com.fontys.StudyGuide.repository.StudyRepository;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@RunWith(SpringRunner.class)
@SpringBootTest
class AcademicYearPlanServiceTest
{
    @Autowired
    private AcademicYearPlanService academicYearPlanService;

    @MockBean
    private AcademicYearPlanRepository academicYearPlanRepository;
    @MockBean
    private StudyRepository studyRepository;

    @Before
    public void init() { MockitoAnnotations.initMocks(this); }

    @Test
    void addAcademicYearPlan()
    {
        AcademicYearPlan ayp = fakeGenerator();
        academicYearPlanService.addAcademicYearPlan(ayp);
        Mockito.verify(studyRepository, Mockito.times(1)).save(ayp.getStudy());
    }

    @Test
    void getAcademicYearPlans()
    {
        //Create Local variables
        AcademicYearPlan fake = fakeGenerator();
        AcademicYearPlan fake2 = fakeGenerator();
        AcademicYearPlan fake3 = fakeGenerator();
        fake2.setAcademicYear(2021);
        fake2.setId(2);
        fake3.setAcademicYear(2022);
        fake3.setId(3);

        //Add variables to List
        List<AcademicYearPlan> academicYearPlanList = new ArrayList<>();
        academicYearPlanList.add(fake);
        academicYearPlanList.add(fake2);
        academicYearPlanList.add(fake3);

        Mockito.when(academicYearPlanRepository.findAll()).thenReturn(academicYearPlanList);
        List<AcademicYearPlan> result = academicYearPlanService.getAcademicYearPlans();
        assertEquals(3, result.size());
        Mockito.verify(academicYearPlanRepository,Mockito.times(1)).findAll();
    }

    @Test
    void getAcademicYearPlan()
    {
        AcademicYearPlan ayp = fakeGenerator();
        Mockito.when(academicYearPlanRepository.findById(1)).thenReturn(java.util.Optional.of(ayp));
        AcademicYearPlan result = academicYearPlanService.getAcademicYearPlan(1);

        assertEquals(ayp.getId(),result.getId());
        assertEquals(ayp.getAcademicYear(),result.getAcademicYear());
        assertEquals(ayp.getVariants(),result.getVariants());
        assertEquals(ayp.getStudy(),result.getStudy());
    }

    @Test
    void updateAcademicYearPlan()
    {
        AcademicYearPlan ayp = fakeGenerator();
        Mockito.when(academicYearPlanRepository.findById(1)).thenReturn(java.util.Optional.of(ayp));
        academicYearPlanService.updateAcademicYearPlan(ayp);
        Mockito.verify(academicYearPlanRepository,Mockito.times(1)).save(ayp);
    }

    @Test
    void deleteAcademicYearPlan()
    {
        int aypID = 1;
        AcademicYearPlan ayp = fakeGenerator();
        Mockito.when(academicYearPlanRepository.findById(aypID)).thenReturn(java.util.Optional.of(ayp));
        academicYearPlanService.deleteAcademicYearPlan(aypID);
        Mockito.verify(academicYearPlanRepository,Mockito.times(1)).deleteById(aypID);
    }


    private AcademicYearPlan fakeGenerator()
    {
        Study study = new Study();
        study.setId(1);
        study.setName("ICT");
        AcademicYearPlan ayp = new AcademicYearPlan();
        ayp.setId(1);
        ayp.setStudy(study);
        ayp.setAcademicYear(2020);

        return ayp;
    }
}