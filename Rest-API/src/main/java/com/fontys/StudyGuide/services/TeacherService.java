package com.fontys.StudyGuide.services;

import com.fontys.StudyGuide.models.Users.Teacher;
import com.fontys.StudyGuide.repository.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherService {
    private final TeacherRepository teacherRepository;

    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public Teacher createTeacher(Teacher teacher){
        return teacherRepository.save(teacher);
    }
    public Teacher getTeacher(int pcn){
        return teacherRepository.findByPcn(pcn);
    }
    public List<Teacher> getAllTeachers(){
        List<Teacher> teacherList = new ArrayList<>();
        teacherRepository.findAll().forEach(teacherList::add);
        return teacherList;
    }
    public Teacher updateTeacher(Teacher teacher){ return teacherRepository.save(teacher);}
    public void deleteTeacher(int id){ teacherRepository.deleteById(id);}


}
