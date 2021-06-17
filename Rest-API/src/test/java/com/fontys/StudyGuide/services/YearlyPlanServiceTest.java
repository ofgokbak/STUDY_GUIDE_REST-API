package com.fontys.StudyGuide.services;

import com.fontys.StudyGuide.models.Study.Period;
import com.fontys.StudyGuide.models.Study.Study_variant;
import com.fontys.StudyGuide.models.Study.Variant;
import com.fontys.StudyGuide.models.Study.Yearly_plan;
import com.fontys.StudyGuide.repository.Study_variantRepository;
import com.fontys.StudyGuide.repository.Yearly_planRepository;
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
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class Yearly_planServiceTest
{
    @Autowired
    private Yearly_planService service;
    @Autowired
    private Study_variantService studyVariantService;

    @MockBean
    private Yearly_planRepository repository;
    @MockBean
    private Study_variantRepository studyVariantRepository;

    @Before
    public void init() { MockitoAnnotations.initMocks(this); }

    private Yearly_plan yp = null;

    @Test
    void createYearly_Plan()
    {
        yp=gen();
        Study_variant sv = new Study_variant();
        sv.setId(1);
        Mockito.when(studyVariantRepository.findById(1)).thenReturn(Optional.of(sv));

        Mockito.when(studyVariantRepository.save(sv)).thenReturn(sv);
        service.createYearly_Plan(yp);
        Mockito.verify(studyVariantRepository,Mockito.times(1)).save(sv);
        Mockito.verify(studyVariantRepository,Mockito.times(1)).findById(1);
        //Mockito.verify(repository,Mockito.times(1)).save(yp);
    }

    @Test
    void getYearly_Plan()
    {
        yp=gen();
        Mockito.when(repository.findById(1)).thenReturn(Optional.of(yp));
        var result = service.getYearly_Plan(1);

        assertEquals(yp.getYearNumber(),result.getYearNumber());
        assertEquals(yp.getPeriods(),result.getPeriods());
    }

    @Test
    void getAllYearly_Plans()
    {
        yp=gen();
        var yp2=gen();
        var yp3=gen();
        yp2.setId(2);
        yp3.setId(3);

        List<Yearly_plan> list = new ArrayList<>();
        list.add(yp);
        list.add(yp2);
        list.add(yp3);

        Mockito.when(repository.findAll()).thenReturn(list);
        var result = service.getAllYearly_Plans();
        assertEquals(3,result.size());
        Mockito.verify(repository,Mockito.times(1)).findAll();
    }

    @Test
    void updateYearly_Plan()
    {
        yp=gen();
        Mockito.when(repository.findById(1)).thenReturn(Optional.of(yp));
        service.updateYearly_Plan(yp);
        Mockito.verify(repository,Mockito.times(1)).save(yp);
    }

    @Test
    void deleteYearly_Plan()
    {
        yp=gen();
        Mockito.when(repository.findById(1)).thenReturn(Optional.of(yp));
        service.deleteYearly_Plan(1);
        Mockito.verify(repository,Mockito.times(1)).deleteById(1);
    }

    private Yearly_plan gen()
    {
        var p = new Period();
        p.setId(1);
        p.setName("periodName");
        List<Period> pList = new ArrayList<>();
        pList.add(p);

        Variant v = new Variant();
        v.setId(1);
        v.setName("variant1");

        Study_variant sv = new Study_variant();
        sv.setId(1);
        sv.setVariant(v);

        var temp = new Yearly_plan();
        temp.setId(1);
        temp.setYearNumber(2020);
        temp.setPeriods(pList);
        temp.setVariant(sv);
        return temp;
    }
}