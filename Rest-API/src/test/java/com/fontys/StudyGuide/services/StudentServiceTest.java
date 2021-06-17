package com.fontys.StudyGuide.services;

import com.fontys.StudyGuide.models.Users.Student;
import com.fontys.StudyGuide.repository.StudentRepository;
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
class StudentServiceTest
{
    @Autowired
    private StudentService service;

    @MockBean
    private StudentRepository repository;

    @Before
    public void init() { MockitoAnnotations.initMocks(this); }

    @Test
    void createStudent()
    {
        Student s = gen();
        service.createStudent(s);
        Mockito.verify(repository,Mockito.times(1)).save(s);
    }

    @Test
    void getAllStudents()
    {
        Student s1 = gen();
        Student s2 = gen();
        Student s3 = gen();
        s2.setId(2);
        s2.setPcn(2);
        s3.setId(3);
        s3.setPcn(3);

        List<Student> list = new ArrayList<>();
        list.add(s1);
        list.add(s2);
        list.add(s3);

        Mockito.when(repository.findAll()).thenReturn(list);
        List<Student> result = service.getAllStudents();
        assertEquals(3,result.size());
        Mockito.verify(repository,Mockito.times(1)).findAll();
    }

    @Test
    void getStudent()
    {
        Student s = gen();
        int pcn =1;
        Mockito.when(repository.findByPcn(pcn)).thenReturn(s);
        Student result = service.getStudent(pcn);

        assertEquals(s.getEmail(),result.getEmail());
        assertEquals(s.getFirstName(),result.getFirstName());
        assertEquals(s.getLastName(),result.getLastName());
        assertEquals(s.getPassword(), result.getPassword());
    }

    @Test
    void updateStudent()
    {
        Student s = gen();
        int id = 1;
        Mockito.when(repository.findById(id)).thenReturn(Optional.of(s));
        service.updateStudent(s);
        Mockito.verify(repository,Mockito.times(1)).save(s);
    }

    @Test
    void deleteStudent()
    {
        int id =1;
        Student s = gen();
        Mockito.when(repository.findById(id)).thenReturn(Optional.of(s));
        service.deleteStudent(id);
        Mockito.verify(repository, Mockito.times(1)).deleteByPcn(id);
    }

    private Student gen()
    {
        Student s = new Student();
        s.setId(1);
        s.setEmail("name@mail.com");
        s.setFirstName("fName");
        s.setLastName("lName");
        s.setPcn(1);
        s.setIsAdmin(0);
        s.setPassword("pwd");
        return s;
    }
}