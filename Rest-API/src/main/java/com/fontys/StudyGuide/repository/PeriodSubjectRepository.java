package com.fontys.StudyGuide.repository;

import com.fontys.StudyGuide.models.Study.Period_subject;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Period_subjectRepository extends CrudRepository<Period_subject,Integer> {
}
