package com.fontys.StudyGuide.repository;

import com.fontys.StudyGuide.models.Study.Competency;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompetencyRepository extends CrudRepository<Competency,Integer> {
    Competency findByName(String name);
}
