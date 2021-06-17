package com.fontys.StudyGuide.services;

import com.fontys.StudyGuide.models.Users.Teacher;
import com.fontys.StudyGuide.repository.TeacherRepository;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
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
class TeacherServiceTest
{
    @Autowired
    private TeacherService service;

    @MockBean
    private TeacherRepository repository;

    @Before
    public void init() { MockitoAnnotations.initMocks(this); }

    private Teacher t;

    @Test
    void createTeacher()
    {
        t=gen();
        service.createTeacher(t);
        Mockito.verify(repository,Mockito.times(1)).save(t);
    }

    @Test
    void getTeacher()
    {
        t=gen();
        Mockito.when(repository.findByPcn(1)).thenReturn(t);
        var result = service.getTeacher(1);

        assertEquals(t.getFirstName(),result.getFirstName());
        assertEquals(t.getLastName(),result.getLastName());
        assertEquals(t.getEmail(),result.getEmail());
        assertEquals(t.getPassword(),result.getPassword());
    }

    @Test
    void getAllTeachers()
    {
        t=gen();
        var t2 = gen();
        var t3 = gen();
        t2.setId(2);
        t3.setId(3);

        List<Teacher> list = new ArrayList<>();
        list.add(t);
        list.add(t2);
        list.add(t3);

        Mockito.when(repository.findAll()).thenReturn(list);
        var result = service.getAllTeachers();
        assertEquals(3,result.size());
        Mockito.verify(repository,Mockito.times(1)).findAll();
    }

    @Test
    void updateTeacher()
    {
        t=gen();
        Mockito.when(repository.findById(1)).thenReturn(Optional.of(t));
        service.updateTeacher(t);
        Mockito.verify(repository,Mockito.times(1)).save(t);
    }

    @Test
    void deleteTeacher()
    {
        t=gen();
        Mockito.when(repository.findById(1)).thenReturn(Optional.of(t));
        service.deleteTeacher(1);
        Mockito.verify(repository,Mockito.times(1)).deleteById(1);
    }

    private Teacher gen()
    {
        var teach = new Teacher();
        teach.setId(1);
        teach.setFirstName("fName");
        teach.setLastName("lName");
        teach.setEmail("test@mail.com");
        teach.setPassword("pwd");

        return teach;
    }
}