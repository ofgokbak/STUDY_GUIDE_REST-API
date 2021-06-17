package com.fontys.StudyGuide.services.converters;

import com.fontys.StudyGuide.dto.Period_subjectDto;
import com.fontys.StudyGuide.models.Study.Period_subject;
import com.fontys.StudyGuide.models.Users.Teacher;
import com.fontys.StudyGuide.services.PeriodService;
import com.fontys.StudyGuide.services.SubjectService;
import com.fontys.StudyGuide.services.TeacherService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Period_subject_converter {
    private final PeriodService periodService;
    private final SubjectService subjectService;
    private final TeacherService teacherService;

    public Period_subject_converter(PeriodService periodService, SubjectService subjectService, TeacherService teacherService) {
        this.periodService = periodService;
        this.subjectService = subjectService;
        this.teacherService = teacherService;
    }

    public Period_subject convertToEntity(Period_subjectDto period_subjectDto){
        Period_subject period_subject = new Period_subject();

        period_subject.setId(period_subjectDto.getId());
        period_subject.setPeriod(periodService.getPeriod(period_subjectDto.getPeriod_id()));
        period_subject.setSubject(subjectService.getSubject(period_subjectDto.getSubject_id()));
        if(period_subjectDto.getTeacherIdList() != null)
        {
            List<Teacher> teacherList = new ArrayList<>();
            period_subjectDto.getTeacherIdList().forEach(pcn->teacherList.add(teacherService.getTeacher(pcn)));
            period_subject.setTeachers(teacherList);
        }

        return period_subject;
    }

    public Period_subjectDto convertToDto(Period_subject period_subject){
        Period_subjectDto period_subjectDto = new Period_subjectDto();

        period_subjectDto.setId(period_subject.getId());
        period_subjectDto.setPeriod_id(period_subject.getPeriod().getId());
        period_subjectDto.setSubject_id(period_subject.getSubject().getId());
        period_subjectDto.setStudyName(period_subject.getPeriod().getYearInPlan().getVariant().getAcademicYearPlan().getStudy().getName());
        if(period_subject.getTeachers() != null)
        {
            List<String> nameList = new ArrayList<>();
            period_subject.getTeachers().forEach(teacher -> nameList.add(teacher.getFirstName()+" "+teacher.getLastName()));
            period_subjectDto.setTeacherNameList(nameList);
            List<Integer> idList = new ArrayList<>();
            period_subject.getTeachers().forEach(teacher -> idList.add(teacher.getId()));
            period_subjectDto.setTeacherIdList(idList);
        }
        return period_subjectDto;
    }

}
