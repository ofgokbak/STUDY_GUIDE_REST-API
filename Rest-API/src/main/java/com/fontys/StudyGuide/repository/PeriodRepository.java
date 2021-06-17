package com.fontys.StudyGuide.repository;

import com.fontys.StudyGuide.models.Study.Period;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeriodRepository extends CrudRepository<Period,Integer> {

}