package com.fontys.StudyGuide.services;

import com.fontys.StudyGuide.models.Users.Student;
import com.fontys.StudyGuide.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    public void createStudent(Student student)
    {
        studentRepository.save(student);
    }
    public List<Student> getAllStudents()
    {
        List<Student> students = new ArrayList<>();
        studentRepository.findAll().forEach(students::add);
        return students;
    }
    public Student getStudent(int pcn)
    {
        return studentRepository.findByPcn(pcn);
    }
    public Student updateStudent(Student student)
    {
        return studentRepository.save(student);
    }
    public void deleteStudent(int pcn)
    {
        studentRepository.deleteByPcn(pcn);
    }
}
