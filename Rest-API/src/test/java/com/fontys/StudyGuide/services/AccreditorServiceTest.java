package com.fontys.StudyGuide.services;

import com.fontys.StudyGuide.models.Users.Accreditor;
import com.fontys.StudyGuide.repository.AccreditorRepository;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@RunWith(SpringRunner.class)
@SpringBootTest
class AccreditorServiceTest
{
    @Autowired
    private AccreditorService accreditorService;

    @MockBean
    private AccreditorRepository accreditorRepository;

    @Before
    public void init() { MockitoAnnotations.initMocks(this); }


    @Test
    void createAccreditor()
    {
        Accreditor accreditor = fakeGenerator();
        accreditorService.createAccreditor(accreditor);
        Mockito.verify(accreditorRepository,Mockito.times(1)).save(accreditor);
    }

    @Test
    void getAllAccreditors()
    {
        Accreditor ac = fakeGenerator();
        Accreditor ac2 = fakeGenerator();
        Accreditor ac3 = fakeGenerator();

        ac.setId(2);
        ac.setEmail("test2@email.com");
        ac.setFirstName("fName2");
        ac.setLastName("lName2");
        ac.setIsAdmin(0);
        ac.setPassword("pwd2");
        ac.setPcn(2);

        ac.setId(3);
        ac.setEmail("test3@email.com");
        ac.setFirstName("fName3");
        ac.setLastName("lName3");
        ac.setIsAdmin(0);
        ac.setPassword("pwd3");
        ac.setPcn(3);

        List<Accreditor> accreditorList = new ArrayList<>();
        accreditorList.add(ac);
        accreditorList.add(ac2);
        accreditorList.add(ac3);

        Mockito.when(accreditorRepository.findAll()).thenReturn(accreditorList);
        List<Accreditor> result = accreditorService.getAllAccreditors();
        assertEquals(3, result.size());
        Mockito.verify(accreditorRepository, Mockito.times(1)).findAll();
    }

    @Test
    void getAccreditor()
    {
        Accreditor accreditor = fakeGenerator();
        Mockito.when(accreditorRepository.findByPcn(1)).thenReturn(accreditor);
        Accreditor result = accreditorService.getAccreditor(1);

        assertEquals(accreditor.getId(), result.getId());
        assertEquals(accreditor.getEmail(), result.getEmail());
        assertEquals(accreditor.getFirstName(),result.getFirstName());
        assertEquals(accreditor.getLastName(),result.getLastName());
        assertEquals(accreditor.getPassword(),result.getPassword());
        assertEquals(accreditor.getIsAdmin(),result.getIsAdmin());

        //!Gets Accreditor PCN instead of ID
        //!Null Error with Result
    }

    @Test
    void updateAccreditor()
    {
        Accreditor accreditor = fakeGenerator();
        Mockito.when(accreditorRepository.findById(1)).thenReturn(Optional.of(accreditor));
        accreditorService.updateAccreditor(accreditor);
        Mockito.verify(accreditorRepository,Mockito.times(1)).save(accreditor);
    }

    @Test
    void deleteAccreditor()
    {
        int aPCN=1;
        Accreditor a = fakeGenerator();
        Mockito.when(accreditorRepository.findById(aPCN)).thenReturn(Optional.of(a));
        accreditorService.deleteAccreditor(aPCN);
        Mockito.verify(accreditorRepository,Mockito.times(1)).deleteByPcn(aPCN);
    }

    private Accreditor fakeGenerator()
    {
        Accreditor ac = new Accreditor();
        ac.setId(1);
        ac.setEmail("test@email.com");
        ac.setFirstName("fName");
        ac.setLastName("lName");
        ac.setIsAdmin(0);
        ac.setPassword("pwd");
        ac.setPcn(1);

        return ac;
    }
}