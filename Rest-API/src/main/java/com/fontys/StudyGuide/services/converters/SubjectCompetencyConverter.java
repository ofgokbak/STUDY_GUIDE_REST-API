package com.fontys.StudyGuide.services.converters;

import com.fontys.StudyGuide.dto.Subject_competencyDto;
import com.fontys.StudyGuide.models.Study.Subject_competency;
import com.fontys.StudyGuide.services.CompetencyService;
import com.fontys.StudyGuide.services.SubjectService;
import org.springframework.stereotype.Component;

@Component
public class Subject_competency_converter {
    private final SubjectService subjectService;
    private final CompetencyService competencyService;

    public Subject_competency_converter(SubjectService subjectService, CompetencyService competencyService) {
        this.subjectService = subjectService;
        this.competencyService = competencyService;
    }

    public Subject_competency convertToEntity(Subject_competencyDto subject_competencyDto){
        Subject_competency subject_competency = new Subject_competency();

        subject_competency.setId(subject_competencyDto.getId());
        subject_competency.setLevel(subject_competencyDto.getLevel());
        subject_competency.setCompetency(competencyService.getCompetency(subject_competencyDto.getCompetency_id()));
        subject_competency.setSubject(subjectService.getSubject(subject_competencyDto.getSubject_id()));

        return  subject_competency;
    }
    public Subject_competencyDto convertToDto(Subject_competency subject_competency){
        Subject_competencyDto subject_competencyDto = new Subject_competencyDto();

        subject_competencyDto.setId(subject_competency.getId());
        subject_competencyDto.setLevel(subject_competency.getLevel());
        subject_competencyDto.setCompetency_id(subject_competency.getCompetency().getId());
        subject_competencyDto.setSubject_id(subject_competency.getSubject().getId());

        return subject_competencyDto;
    }
}
