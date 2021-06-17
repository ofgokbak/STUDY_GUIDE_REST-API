package com.fontys.StudyGuide.services;

import com.fontys.StudyGuide.models.Study.Study;
import com.fontys.StudyGuide.models.Study.Variant;
import com.fontys.StudyGuide.repository.VariantRepository;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.configuration.injection.MockInjection;
import org.mockito.internal.configuration.injection.MockInjectionStrategy;
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
class VariantServiceTest
{
    @Autowired
    private VariantService service;

    @MockBean
    private VariantRepository repository;

    @Before
    public void init() { MockitoAnnotations.initMocks(this); }

    private Variant v = null;

    @Test
    void createVariant()
    {
        v = gen();
        service.createVariant(v);
        Mockito.verify(repository,Mockito.times(1)).save(v);
    }

    @Test
    void getVariant()
    {
        v=gen();
        Mockito.when(repository.findById(1)).thenReturn(Optional.of(v));
        var result = service.getVariant(1);

        assertEquals(v.getName(),result.getName());
        assertEquals(v.getStudy(),result.getStudy());
        Mockito.verify(repository,Mockito.times(1)).findById(1);
    }

    @Test
    void getAllVariants()
    {
        v= gen();
        var v2 = gen();
        var v3 = gen();
        v2.setId(2);
        v3.setId(3);

        List<Variant> list = new ArrayList<>();
        list.add(v);
        list.add(v2);
        list.add(v3);

        Mockito.when(repository.findAll()).thenReturn(list);
        var result = service.getAllVariants();
        assertEquals(3,result.size());
        Mockito.verify(repository,Mockito.times(1)).findAll();
    }

    @Test
    void updateVariant()
    {
        v=gen();
        Mockito.when(repository.findById(1)).thenReturn(Optional.of(v));
        service.updateVariant(v);
        Mockito.verify(repository, Mockito.times(1)).save(v);
    }

    @Test
    void deleteVariant()
    {
        v=gen();
        Mockito.when(repository.findById(1)).thenReturn(Optional.of(v));
        service.deleteVariant(1);
        Mockito.verify(repository,Mockito.times(1)).deleteById(1);
    }

    @Test
    void getVariantByName() {
    }

    private Variant gen()
    {
        Study s = new Study();
        s.setId(1);
        s.setName("studyName");

        Variant temp = new Variant();
        temp.setId(1);
        temp.setName("variantName");
        temp.setStudy(s);

        return temp;
    }
}