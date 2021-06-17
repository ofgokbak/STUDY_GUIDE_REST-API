package com.fontys.StudyGuide.services.converters;

import com.fontys.StudyGuide.dto.TeacherDto;
import com.fontys.StudyGuide.models.Study.Period_subject;
import com.fontys.StudyGuide.models.Users.Teacher;
import com.fontys.StudyGuide.services.Period_subjectService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Teacher_converter {
    private final Period_subjectService period_subjectService;

    public Teacher_converter(Period_subjectService period_subjectService) {
        this.period_subjectService = period_subjectService;
    }

    public Teacher convertToEntity(TeacherDto teacherDto) {
        Teacher teacher = new Teacher();

        teacher.setPcn(teacherDto.getPcn());
        teacher.setFirstName(teacherDto.getFirstName());
        teacher.setLastName(teacherDto.getLastName());
//        teacher.setAuthorization(teacherDto.getAuthorization());
        teacher.setEmail(teacherDto.getEmail());
        teacher.setIsAdmin(teacherDto.getIsAdmin());
        teacher.setPassword(teacherDto.getPassword());
        if (teacherDto.getPeriod_subjectIdList() != null) {
            List<Period_subject> period_subjectList = new ArrayList<>();
            teacherDto.getPeriod_subjectIdList().forEach(id -> period_subjectList.add(period_subjectService.getPeriod_Subject(id)));
            teacher.setSubjects(period_subjectList);
        }
        return teacher;
    }

    public TeacherDto convertToDto(Teacher teacher) {
        TeacherDto teacherDto = new TeacherDto();

        teacherDto.setPcn(teacher.getPcn());
//        teacherDto.setAuthorization(teacher.getAuthorization());
        teacherDto.setEmail(teacher.getEmail());
        teacherDto.setLastName(teacher.getLastName());
        teacherDto.setFirstName(teacher.getFirstName());
        teacherDto.setPassword(teacher.getPassword());
        teacherDto.setIsAdmin(teacher.getIsAdmin());
        if (teacher.getSubjects() != null) {
            List<Integer> idList = new ArrayList<>();
            teacher.getSubjects().forEach(subject -> idList.add(subject.getId()));
            teacherDto.setPeriod_subjectIdList(idList);
        }
        return teacherDto;
    }
}
