package com.fontys.StudyGuide.repository;

import com.fontys.StudyGuide.models.Users.Teacher;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends CrudRepository<Teacher,Integer> {

    Teacher findByPcn(int pcn);

}