package com.fontys.StudyGuide.services;

import com.fontys.StudyGuide.models.Study.Competency;
import com.fontys.StudyGuide.models.Study.Subject;
import com.fontys.StudyGuide.models.Study.Subject_competency;
import com.fontys.StudyGuide.repository.SubjectRepository;
import com.fontys.StudyGuide.repository.Subject_competencyRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
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
class Subject_competencyServiceTest
{
    @Autowired
    Subject_competencyService service;
    @Autowired
    private SubjectService subjectService;

    @MockBean
    Subject_competencyRepository repository;
    @MockBean
    private SubjectRepository subjectRepository;

    private Subject_competency _sc = null;

    @Test
    void createSubject_Competency()
    {
        _sc=gen();
        Subject s = new Subject();
        s.setId(1);
        Mockito.when(subjectRepository.findById(1)).thenReturn(Optional.of(s));

        Mockito.when(subjectRepository.save(s)).thenReturn(s);
        service.createSubject_Competency(_sc);
        Mockito.verify(subjectRepository,Mockito.times(1)).save(s);
        Mockito.verify(subjectRepository,Mockito.times(1)).findById(1);
        //Mockito.verify(repository,Mockito.times(1)).save(_sc);

    }

    @Test
    void getSubject_Competency()
    {
        _sc=gen();
        Mockito.when(repository.findById(1)).thenReturn(Optional.of(_sc));
        Subject_competency result = service.getSubject_Competency(1);

        assertEquals(_sc.getCompetency(),result.getCompetency());
        assertEquals(_sc.getSubject(),result.getSubject());
        assertEquals(_sc.getLevel(),result.getLevel());
    }

    @Test
    void getSubject_Competencies()
    {
        _sc=gen();
        var _sc2 = gen();
        var _sc3=gen();
        _sc2.setId(2);
        _sc3.setId(3);
        List<Subject_competency> list = new ArrayList<>();
        list.add(_sc);
        list.add(_sc2);
        list.add(_sc3);

        Mockito.when(repository.findAll()).thenReturn(list);
        List<Subject_competency> result = service.getSubject_Competencies();
        assertEquals(3,result.size());
        Mockito.verify(repository,Mockito.times(1)).findAll();
    }

    @Test
    void updateSubject_Competency()
    {
        _sc=gen();
        Mockito.when(repository.findById(1)).thenReturn(Optional.of(_sc));
        service.updateSubject_Competency(_sc);
        Mockito.verify(repository,Mockito.times(1)).save(_sc);
    }

    @Test
    void deleteSubject_Competency()
    {
        _sc=gen();
        Mockito.when(repository.findById(1)).thenReturn(Optional.of(_sc));
        service.deleteSubject_Competency(1);
        Mockito.verify(repository,Mockito.times(1)).deleteById(1);
    }

    private Subject_competency gen()
    {
        Competency c = new Competency();
        c.setId(1);
        c.setName("competencyName");

        Subject s = new Subject();
        s.setId(1);
        s.setName("subjectName");

        Subject_competency sc = new Subject_competency();
        sc.setId(1);
        sc.setLevel(1);
        sc.setCompetency(c);
        sc.setSubject(s);

        return sc;
    }
}