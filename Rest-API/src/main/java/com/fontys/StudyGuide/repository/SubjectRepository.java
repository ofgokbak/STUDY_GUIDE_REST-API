package com.fontys.StudyGuide.repository;

import com.fontys.StudyGuide.models.Study.Subject;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends CrudRepository<Subject,Integer> {

}
