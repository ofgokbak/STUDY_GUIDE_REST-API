package com.fontys.StudyGuide.repository;

import com.fontys.StudyGuide.models.Study.Subject_competency;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Subject_competencyRepository extends CrudRepository<Subject_competency,Integer> {
}
