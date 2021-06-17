package com.fontys.StudyGuide.repository;

import com.fontys.StudyGuide.models.Study.Yearly_plan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Yearly_planRepository extends CrudRepository<Yearly_plan,Integer> {
}
