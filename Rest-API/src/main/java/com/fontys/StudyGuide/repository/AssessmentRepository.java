package com.fontys.StudyGuide.repository;

import com.fontys.StudyGuide.models.Study.Assessment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssessmentRepository extends CrudRepository<Assessment, Integer> {
}
