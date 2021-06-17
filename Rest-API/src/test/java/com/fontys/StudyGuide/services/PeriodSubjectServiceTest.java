package com.fontys.StudyGuide.services;

import com.fontys.StudyGuide.models.Study.Period;
import com.fontys.StudyGuide.models.Study.Period_subject;
import com.fontys.StudyGuide.models.Study.Subject;
import com.fontys.StudyGuide.models.Users.Teacher;
import com.fontys.StudyGuide.repository.PeriodRepository;
import com.fontys.StudyGuide.repository.Period_subjectRepository;
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
class Period_subjectServiceTest
{
    @Autowired
    private Period_subjectService periodSubjectService;

    @MockBean
    private Period_subjectRepository periodSubjectRepository;

    @Autowired
    private PeriodService periodService;

    @MockBean
    private PeriodRepository periodRepository;

    @Before
    public void init() { MockitoAnnotations.initMocks(this); }


    @Test
    void createPeriod_Subject()
    {
        Period_subject ps = generator();
        Period period = new Period();
        period.setId(1);
        Mockito.when(periodRepository.findById(1)).thenReturn(Optional.of(period));

        Mockito.when(periodRepository.save(period)).thenReturn(period);
        periodSubjectService.createPeriod_Subject(ps);
        Mockito.verify(periodRepository,Mockito.times(1)).save(period);
        Mockito.verify(periodRepository, Mockito.times(1)).findById(1);
    }



    @Test
    void getPeriod_Subject()
    {
        Period_subject ps = generator();
        Mockito.when(periodSubjectRepository.findById(1)).thenReturn(Optional.of(ps));
        Period_subject result = periodSubjectService.getPeriod_Subject(1);

        assertEquals(ps.getId(),result.getId());
        assertEquals(ps.getPeriod(), result.getPeriod());
        assertEquals(ps.getSubject(), result.getSubject());
        assertEquals(ps.getTeachers(), result.getTeachers());
    }

    @Test
    void getAllPeriod_Subjects()
    {
        Period_subject ps1 = generator();
        Period_subject ps2 = generator();
        Period_subject ps3 = generator();
        ps2.setId(2);
        ps3.setId(3);

        List<Period_subject> list = new ArrayList<>();
        list.add(ps1);
        list.add(ps2);
        list.add(ps3);

        Mockito.when(periodSubjectRepository.findAll()).thenReturn(list);
        List<Period_subject> result = periodSubjectService.getAllPeriod_Subjects();
        assertEquals(3, result.size());
        Mockito.verify(periodSubjectRepository,Mockito.times(1)).findAll();
    }

    @Test
    void updatePeriod_Subject()
    {
        Period_subject ps = generator();
        Mockito.when(periodSubjectRepository.findById(1)).thenReturn(Optional.of(ps));
        periodSubjectService.updatePeriod_Subject(ps);
        Mockito.verify(periodSubjectRepository,Mockito.times(1)).save(ps);
    }

    @Test
    void deletePeriod_Subject()
    {
        int id = 1;
        Period_subject ps = generator();
        Mockito.when(periodSubjectRepository.findById(id)).thenReturn(Optional.of(ps));
        periodSubjectService.deletePeriod_Subject(id);
        Mockito.verify(periodSubjectRepository,Mockito.times(1)).deleteById(id);
    }

    private Period_subject generator()
    {
        Period p = new Period();
        p.setId(1);
        p.setName("PeriodName");

        Subject s = new Subject();
        s.setId(1);
        s.setName("SubjectName");

        Teacher t = new Teacher();
        t.setId(1);
        t.setPcn(1);
        t.setFirstName("fName");
        t.setLastName("lName");
        List<Teacher> tList = new ArrayList<>();
        tList.add(t);

        Period_subject ps = new Period_subject();
        ps.setId(1);
        ps.setPeriod(p);
        ps.setSubject(s);
        ps.setTeachers(tList);

        return ps;
    }
}