package com.fontys.StudyGuide.repository;

import com.fontys.StudyGuide.models.Study.Variant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VariantRepository extends CrudRepository<Variant,Integer> {
    Variant findByName(String variantName);
}
