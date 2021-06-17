package com.fontys.StudyGuide.services;

import com.fontys.StudyGuide.models.Study.Period;
import com.fontys.StudyGuide.models.Study.Period_subject;
import com.fontys.StudyGuide.models.Study.Yearly_plan;
import com.fontys.StudyGuide.repository.PeriodRepository;
import com.fontys.StudyGuide.repository.Yearly_planRepository;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


@RunWith(SpringRunner.class)
@SpringBootTest
class PeriodServiceTest
{
    @Autowired
    private PeriodService periodService;
    @Autowired
    private Yearly_planService yearlyPlanService;

    @MockBean
    private PeriodRepository periodRepository;
    @MockBean
    private Yearly_planRepository yearlyPlanRepository;

    @Before
    public void init() { MockitoAnnotations.initMocks(this); }


    @Test
    void createPeriod()
    {
        Period p = generator();
        Yearly_plan yp = new Yearly_plan();
        yp.setId(1);

        Mockito.when(yearlyPlanRepository.findById(1)).thenReturn(Optional.of(yp));
        Mockito.when(yearlyPlanRepository.save(yp)).thenReturn(yp);

        periodService.createPeriod(p);
        Mockito.verify(yearlyPlanRepository,Mockito.times(1)).save(yp);
        Mockito.verify(yearlyPlanRepository,Mockito.times(1)).findById(1);
        //Mockito.verify(periodRepository,Mockito.times(1)).save(p);
    }


    @Test
    void getAllPeriods()
    {
        Period p1 = generator();
        Period p2 = generator();
        Period p3 = generator();
        p2.setId(2);
        p3.setId(3);

        List<Period> pList = new ArrayList<>();
        pList.add(p1);
        pList.add(p2);
        pList.add(p3);

        Mockito.when(periodRepository.findAll()).thenReturn(pList);
        List<Period> result = periodService.getAllPeriods();
        assertEquals(3, result.size());
        Mockito.verify(periodRepository,Mockito.times(1)).findAll();
    }

    @Test
    void getPeriod()
    {
        Period p = generator();
        int id = 1;
        Mockito.when(periodRepository.findById(id)).thenReturn(Optional.of(p));
        Period result = periodService.getPeriod(id);

        assertEquals(p.getName(),result.getName());
        assertEquals(p.getSubjects(),result.getSubjects());
        assertEquals(p.getYearInPlan(),result.getYearInPlan());
    }

    @Test
    void updatePeriod()
    {
        Period p = generator();
        int id = 1;
        Mockito.when(periodRepository.findById(id)).thenReturn(Optional.of(p));
        periodService.updatePeriod(p);
        Mockito.verify(periodRepository,Mockito.times(1)).save(p);
    }

    @Test
    void deletePeriod()
    {
        int id =1;
        Period p = generator();
        Mockito.when(periodRepository.findById(id)).thenReturn(Optional.of(p));
        periodService.deletePeriod(id);
        Mockito.verify(periodRepository,Mockito.times(1)).deleteById(id);
    }

    private Period generator()
    {
        Period_subject ps = new Period_subject();
        ps.setId(1);
        List<Period_subject> psList = new ArrayList<>();
        psList.add(ps);

        Yearly_plan yp = new Yearly_plan();
        yp.setId(1);

        Period p = new Period();
        p.setId(1);
        p.setName("periodName");
        p.setSubjects(psList);
        p.setYearInPlan(yp);

        return p;
    }
}