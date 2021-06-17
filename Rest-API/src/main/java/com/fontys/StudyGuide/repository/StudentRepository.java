package com.fontys.StudyGuide.repository;

import com.fontys.StudyGuide.models.Users.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<Student,Integer> {
    Student findByPcn(int pcn);

    void deleteByPcn(int pcn);
}