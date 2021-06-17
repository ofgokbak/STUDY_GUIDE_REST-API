package com.fontys.StudyGuide.services;

import com.fontys.StudyGuide.models.Study.Study;
import com.fontys.StudyGuide.repository.StudyRepository;
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
class StudyServiceTest
{
    @Autowired
    private StudyService service;

    @MockBean
    private StudyRepository repository;

    @Before
    public void init() { MockitoAnnotations.initMocks(this); }

    @Test
    void createStudy()
    {
        Study s = gen();
        service.createStudy(s);
        Mockito.verify(repository,Mockito.times(1)).save(s);
    }

    @Test
    void getAllStudies()
    {
        Study s1 = gen();
        Study s2 = gen();
        Study s3 = gen();
        List<Study> list = new ArrayList<>();
        list.add(s1);
        list.add(s2);
        list.add(s3);

        Mockito.when(repository.findAll()).thenReturn(list);
        List<Study> result = service.getAllStudies();
        assertEquals(3,result.size());
        Mockito.verify(repository,Mockito.times(1)).findAll();
    }

    @Test
    void getStudy()
    {
        Study s = gen();
        Mockito.when(repository.findById(1)).thenReturn(Optional.of(s));
        Study result = service.getStudy(1);

        assertEquals(s.getName(),result.getName());
    }

    @Test
    void getStudyByName()
    {
    }

    @Test
    void updateStudy()
    {
        Study s = gen();
        Mockito.when(repository.findById(1)).thenReturn(Optional.of(s));
        service.updateStudy(s);
        Mockito.verify(repository,Mockito.times(1)).save(s);
    }

    @Test
    void deleteStudy()
    {
        Study s = gen();
        Mockito.when(repository.findById(1)).thenReturn(Optional.of(s));
        service.deleteStudy(1);
        Mockito.verify(repository,Mockito.times(1)).deleteById(1);
    }

    private Study gen()
    {
        Study s = new Study();
        s.setId(1);
        s.setName("StudyName");

        return s;
    }
}