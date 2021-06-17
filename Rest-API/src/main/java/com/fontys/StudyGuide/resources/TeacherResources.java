package com.fontys.StudyGuide.resources;


import com.fontys.StudyGuide.dto.TeacherDto;
import com.fontys.StudyGuide.models.Users.Teacher;
import com.fontys.StudyGuide.services.TeacherService;
import com.fontys.StudyGuide.services.converters.Teacher_converter;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;

@RequestMapping("api/teachers")
@RestController
@CrossOrigin("*")
public class TeacherResources {

    private final TeacherService teacherService;
    private final Teacher_converter teacher_converter;


    public TeacherResources(TeacherService teacherService, Teacher_converter teacher_converter) {
        this.teacherService = teacherService;
        this.teacher_converter = teacher_converter;
    }


    @PostMapping
    public void addNewTeacher(@Valid @NonNull @RequestBody TeacherDto teacherDto) {
        teacherService.createTeacher(teacher_converter.convertToEntity(teacherDto));
    }

    @GetMapping(path = "{pcn}")
    public TeacherDto getTeacher(@PathVariable("pcn") int pcn) {
       return teacher_converter.convertToDto(teacherService.getTeacher(pcn));
    }


    @GetMapping
    public List<TeacherDto> getAllTeachers() {
        List<Teacher> teacherList = teacherService.getAllTeachers();
        List<TeacherDto> teacherDtoList = new ArrayList<>();
        teacherList.forEach(teacher -> teacherDtoList.add(teacher_converter.convertToDto(teacher)));
        return teacherDtoList;
    }

    @PutMapping(path = "{pcn}")
    public void updateTeacher(@Valid @NonNull @RequestBody TeacherDto teacherDto, @PathVariable("pcn") int pcn){
        teacherDto.setPcn(pcn);
        teacherService.updateTeacher(teacher_converter.convertToEntity(teacherDto));
    }

    @DeleteMapping(path = "{id}")
    public void deleteTeacher(@PathVariable("id") int id) { teacherService.deleteTeacher(id);}

    //TODO Users might need to be separated, OOP does not work for now.
}
