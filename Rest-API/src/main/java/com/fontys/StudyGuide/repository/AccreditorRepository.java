package com.fontys.StudyGuide.repository;

import com.fontys.StudyGuide.models.Users.Accreditor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccreditorRepository extends CrudRepository<Accreditor,Integer> {

    Accreditor findByPcn(int pcn);

    void deleteByPcn(int pcn);
}

