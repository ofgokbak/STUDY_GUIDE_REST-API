package com.fontys.StudyGuide.services;

import com.fontys.StudyGuide.models.Users.Accreditor;
import com.fontys.StudyGuide.repository.AccreditorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccreditorService {
    private final AccreditorRepository accreditorRepository;

    public AccreditorService(AccreditorRepository accreditorRepository) {
        this.accreditorRepository = accreditorRepository;
    }

    public void createAccreditor(Accreditor accreditor)
    {
        accreditorRepository.save(accreditor);
    }
    public List<Accreditor> getAllAccreditors()
    {
        List<Accreditor> accreditors = new ArrayList<>();
        accreditorRepository.findAll().forEach(accreditors::add);
        return accreditors;
    }
    public Accreditor getAccreditor(int pcn)
    {
        return accreditorRepository.findByPcn(pcn);
    }
    public Accreditor updateAccreditor(Accreditor accreditor)
    {
        return accreditorRepository.save(accreditor);
    }
    public void deleteAccreditor(int pcn)
    {
        accreditorRepository.deleteByPcn(pcn);
    }
}
