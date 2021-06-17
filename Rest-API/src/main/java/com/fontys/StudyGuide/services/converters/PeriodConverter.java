package com.fontys.StudyGuide.services.converters;

import com.fontys.StudyGuide.dto.PeriodDto;
import com.fontys.StudyGuide.models.Study.Period;
import com.fontys.StudyGuide.models.Study.Period_subject;
import com.fontys.StudyGuide.services.Period_subjectService;
import com.fontys.StudyGuide.services.Yearly_planService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Period_converter {
    private final Period_subjectService period_subjectService;
    private final Yearly_planService yearly_planService;

    public Period_converter(Period_subjectService period_subjectService, Yearly_planService yearly_planService) {
        this.period_subjectService = period_subjectService;
        this.yearly_planService = yearly_planService;
    }

    public Period convertToEntity(PeriodDto periodDto) {
        Period period = new Period();
        period.setId(periodDto.getId());
        period.setName(periodDto.getName());
        period.setYearInPlan(yearly_planService.getYearly_Plan(periodDto.getYearly_planId()));
        if (periodDto.getPeriod_subjectIdList() != null) {
            List<Period_subject> subjectList = new ArrayList<>();
            periodDto.getPeriod_subjectIdList().forEach(id -> subjectList.add(period_subjectService.getPeriod_Subject(id)));
            period.setSubjects(subjectList);
        }

        return period;
    }

    public PeriodDto convertToDto(Period period) {
        PeriodDto periodDto = new PeriodDto();

        periodDto.setId(period.getId());
        periodDto.setName(period.getName());
        periodDto.setYearly_planId(period.getYearInPlan().getId());
        if (period.getSubjects() != null) {
            List<Integer> idList = new ArrayList<>();
            period.getSubjects().forEach(subject -> idList.add(subject.getId()));
            periodDto.setPeriod_subjectIdList(idList);
        }

        return periodDto;
    }
}
