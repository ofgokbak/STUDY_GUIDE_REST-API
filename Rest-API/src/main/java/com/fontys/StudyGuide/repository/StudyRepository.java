package com.fontys.StudyGuide.repository;

import com.fontys.StudyGuide.models.Study.Study;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudyRepository extends CrudRepository<Study,Integer> {
    Study findByName(String name);

}
