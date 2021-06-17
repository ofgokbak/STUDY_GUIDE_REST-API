package com.fontys.StudyGuide.repository;

import com.fontys.StudyGuide.models.Study.AcademicYearPlan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AcademicYearPlanRepository extends CrudRepository<AcademicYearPlan,Integer> {
}
