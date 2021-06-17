package com.fontys.StudyGuide.services;

import com.fontys.StudyGuide.models.Study.Assessment;
import com.fontys.StudyGuide.repository.AssessmentRepository;
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
class AssessmentServiceTest
{
    @Autowired
    private AssessmentService assessmentService;

    @MockBean
    private AssessmentRepository assessmentRepository;

    @Before
    public void init() { MockitoAnnotations.initMocks(this); }


    @Test
    void createAssessment()
    {
        Assessment a = fakeGenerator();
        assessmentService.createAssessment(a);
        Mockito.verify(assessmentRepository,Mockito.times(1)).save(a);
    }

    @Test
    void getAssessment()
    {
        Assessment a = fakeGenerator();
        Mockito.when(assessmentRepository.findById(1)).thenReturn(Optional.of(a));
        Assessment result = assessmentService.getAssessment(1);

        assertEquals(a.getId(),result.getId());
        assertEquals(a.getDetails(),result.getDetails());
        assertEquals(a.getName(),result.getName());
    }

    @Test
    void getAllAssessments()
    {
        Assessment a = fakeGenerator();
        Assessment a2 = fakeGenerator();
        Assessment a3 = fakeGenerator();
        a2.setId(2);
        a2.setDetails("Details2");
        a2.setName("Name2");
        a3.setId(3);
        a3.setDetails("Details");
        a3.setName("Name");

        List<Assessment> list = new ArrayList<>();
        list.add(a);
        list.add(a2);
        list.add(a3);

        Mockito.when(assessmentRepository.findAll()).thenReturn(list);
        List<Assessment> result = assessmentService.getAllAssessments();
        assertEquals(3, result.size());
        Mockito.verify(assessmentRepository,Mockito.times(1)).findAll();
    }

    @Test
    void updateAssessment()
    {
        Assessment a = fakeGenerator();
        Mockito.when(assessmentRepository.findById(1)).thenReturn(Optional.of(a));
        assessmentService.updateAssessment(a);
        Mockito.verify(assessmentRepository,Mockito.times(1)).save(a);
    }

    @Test
    void deleteAssessment()
    {
        int id = 1;
        Assessment a = fakeGenerator();
        Mockito.when(assessmentRepository.findById(id)).thenReturn(Optional.of(a));
        assessmentService.deleteAssessment(id);
        Mockito.verify(assessmentRepository, Mockito.times(1)).deleteById(id);
    }

    private Assessment fakeGenerator()
    {
        Assessment a = new Assessment();
        a.setId(1);
        a.setDetails("Details");
        a.setName("Name");

        return a;
    }
}