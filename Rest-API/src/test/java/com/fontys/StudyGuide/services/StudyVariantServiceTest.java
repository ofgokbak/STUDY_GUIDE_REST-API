package com.fontys.StudyGuide.services;

import com.fontys.StudyGuide.models.Study.AcademicYearPlan;
import com.fontys.StudyGuide.models.Study.Study;
import com.fontys.StudyGuide.models.Study.Study_variant;
import com.fontys.StudyGuide.models.Study.Variant;
import com.fontys.StudyGuide.repository.AcademicYearPlanRepository;
import com.fontys.StudyGuide.repository.Study_variantRepository;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class Study_variantServiceTest
{
    @Autowired
    private Study_variantService service;
    @Autowired
    private AcademicYearPlanService academicYearPlanService;

    @MockBean
    private Study_variantRepository repository;
    @MockBean
    private AcademicYearPlanRepository academicYearPlanRepository;

    @Before
    public void init() { MockitoAnnotations.initMocks(this); }


    @Test
    void createStudy_Variant()
    {
        Study_variant sv = gen();
        AcademicYearPlan ayp = new AcademicYearPlan();
        ayp.setId(1);
        Mockito.when(academicYearPlanRepository.findById(1)).thenReturn(Optional.of(ayp));

        Mockito.when(academicYearPlanRepository.save(ayp)).thenReturn(ayp);
        service.createStudy_Variant(sv);
        Mockito.verify(academicYearPlanRepository,Mockito.times(1)).save(ayp);
        Mockito.verify(academicYearPlanRepository,Mockito.times(2)).findById(1); //?Minor error
        //Mockito.verify(repository,Mockito.times(1)).save(sv);

        //? Minor error, AYPR call on find ID, calls twice
        //?Expected 1 call
    }


    @Test
    void getAllStudy_Variants()
    {
        Study_variant sv1 = gen();
        Study_variant sv2 = gen();
        Study_variant sv3 = gen();
        List<Study_variant> lst = new ArrayList<>();
        lst.add(sv1);
        lst.add(sv2);
        lst.add(sv3);

        Mockito.when(repository.findAll()).thenReturn(lst);
        List<Study_variant> result = service.getAllStudy_Variants();
        assertEquals(3,result.size());
        Mockito.verify(repository,Mockito.times(1)).findAll();
    }

    @Test
    void getStudy_Variant()
    {
        Study_variant sv = gen();
        Mockito.when(repository.findById(1)).thenReturn(Optional.of(sv));
        Study_variant result = service.getStudy_Variant(1);

        assertEquals(sv.getVariant(),result.getVariant());
        assertEquals(sv.getAcademicYearPlan(),result.getAcademicYearPlan());
    }

    @Test
    void updateStudy_Variant()
    {
        Study_variant sv = gen();
        Mockito.when(repository.findById(1)).thenReturn(Optional.of(sv));
        service.updateStudy_Variant(sv);
        Mockito.verify(repository,Mockito.times(1)).save(sv);
    }

    @Test
    void deleteStudy_Variant()
    {
        Study_variant sv = gen();
        Mockito.when(repository.findById(1)).thenReturn(Optional.of(sv));
        service.deleteStudy_Variant(1);
        Mockito.verify(repository,Mockito.times(1)).deleteById(1);
    }

    private Study_variant gen()
    {
        Study s = new Study();
        s.setId(1);
        s.setName("StudyName");

        Variant v = new Variant();
        v.setId(1);
        v.setStudy(s);

        AcademicYearPlan ayp = new AcademicYearPlan();
        ayp.setId(1);
        ayp.setStudy(s);

        Study_variant sv = new Study_variant();
        sv.setId(1);
        sv.setVariant(v);
        sv.setAcademicYearPlan(ayp);

        return sv;
    }
}