package com.fontys.StudyGuide.services;

import com.fontys.StudyGuide.models.Study.Competency;
import com.fontys.StudyGuide.models.Study.Study;
import com.fontys.StudyGuide.repository.CompetencyRepository;
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
class CompetencyServiceTest
{
    @Autowired
    private CompetencyService competencyService;

    @MockBean
    private CompetencyRepository competencyRepository;

    @Before
    public void init() { MockitoAnnotations.initMocks(this); }

    @Test
    void createCompetency()
    {
        Competency c = generator();
        competencyService.createCompetency(c);
        Mockito.verify(competencyRepository,Mockito.times(1)).save(c);
    }

    @Test
    void getCompetency()
    {
        Competency c = generator();
        Mockito.when(competencyRepository.findById(1)).thenReturn(Optional.of(c));
        Competency result = competencyService.getCompetency(1);

        assertEquals(c.getId(),result.getId());
        assertEquals(c.getName(),result.getName());
    }

    @Test
    void getCompetencyByName()
    {
    }

    @Test
    void getAllCompetencies()
    {
        Competency c1 = generator();
        Competency c2 = generator();
        Competency c3 = generator();
        c2.setId(2);
        c2.setName("Name2");
        c3.setId(3);
        c3.setName("Name3");

        List<Competency> list = new ArrayList<>();
        list.add(c1);
        list.add(c2);
        list.add(c3);

        Mockito.when(competencyRepository.findAll()).thenReturn(list);
        List<Competency> result = competencyService.getAllCompetencies();
        assertEquals(3, result.size());
        Mockito.verify(competencyRepository,Mockito.times(1)).findAll();
    }

    @Test
    void updateCompetency()
    {
        int id = 1;
        Competency c = generator();
        Mockito.when(competencyRepository.findById(id)).thenReturn(Optional.of(c));
        competencyService.deleteCompetency(id);
        Mockito.verify(competencyRepository,Mockito.times(1)).deleteById(id);
    }


    private Competency generator()
    {
        Competency c = new Competency();
        c.setId(1);
        c.setName("Name");

        return c;
    }
}