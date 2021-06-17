package com.fontys.StudyGuide.repository;

import com.fontys.StudyGuide.models.Study.Study_variant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Study_variantRepository extends CrudRepository<Study_variant,Integer> {
}
