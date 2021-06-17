package com.fontys.StudyGuide.services;

import com.fontys.StudyGuide.models.Study.Subject;
import com.fontys.StudyGuide.repository.SubjectRepository;
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
class SubjectServiceTest
{
    @Autowired
    private SubjectService service;

    @MockBean
    private SubjectRepository repository;

    @Before
    public void init() { MockitoAnnotations.initMocks(this); }

    private Subject s = null;

    @Test
    void createSubject()
    {
        s = gen();
        service.createSubject(s);
        Mockito.verify(repository,Mockito.times(1)).save(s);
    }

    @Test
    void getAllSubjects()
    {
        s = gen();
        var s2 = gen();
        var s3 = gen();
        s2.setId(2);
        s3.setId(3);

        List<Subject> list = new ArrayList<>();
        list .add(s);
        list .add(s2);
        list .add(s3);

        Mockito.when(repository.findAll()).thenReturn(list);
        List<Subject> result = service.getAllSubjects();
        assertEquals(3,result.size());
        Mockito.verify(repository,Mockito.times(1)).findAll();
    }

    @Test
    void getSubject()
    {
        s = gen();
        Mockito.when(repository.findById(1)).thenReturn(Optional.of(s));
        Subject result = service.getSubject(1);

        assertEquals(s.getEc(),result.getEc());
        assertEquals(s.getContent(),result.getContent());
        assertEquals(s.getName(),result.getName());
        Mockito.verify(repository, Mockito.times(1)).findById(1);
    }

    @Test
    void getCompetenciesBySubject() {
    }

    @Test
    void updateSubject()
    {
        s =gen();
        Mockito.when(repository.findById(1)).thenReturn(Optional.of(s));
        service.updateSubject(s);
        Mockito.verify(repository,Mockito.times(1)).save(s);
    }

    @Test
    void deleteSubject()
    {
        s=gen();
        Mockito.when(repository.findById(1)).thenReturn(Optional.of(s));
        service.deleteSubject(1);
        Mockito.verify(repository,Mockito.times(1)).deleteById(1);
    }

    private Subject gen()
    {
        var sub = new Subject();
        sub.setId(1);
        sub.setName("subjectName");
        sub.setContent("content");
        sub.setEc(6);

        return sub;
    }
}