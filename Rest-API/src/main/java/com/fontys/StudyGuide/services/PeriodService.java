package com.fontys.StudyGuide.services;

import com.fontys.StudyGuide.models.Study.Period;
import com.fontys.StudyGuide.models.Study.Yearly_plan;
import com.fontys.StudyGuide.repository.PeriodRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PeriodService {
    private final PeriodRepository periodRepository;
    private final Yearly_planService yearly_planService;

    public PeriodService(PeriodRepository periodRepository, Yearly_planService yearly_planService) {
        this.periodRepository = periodRepository;
        this.yearly_planService = yearly_planService;
    }

    public void createPeriod(Period period) {
        Yearly_plan yearly_plan = yearly_planService.getYearly_Plan(period.getYearInPlan().getId());
        if(yearly_plan.getPeriods()!=null)
        {
            yearly_plan.getPeriods().add(period);
        }
        else
        {
            List<Period> periods = new ArrayList<>();
            periods.add(period);
            yearly_plan.setPeriods(periods);
        }
        yearly_planService.updateYearly_Plan(yearly_plan);
    }

    public List<Period> getAllPeriods() {
        List<Period> periods = new ArrayList<>();
        periodRepository.findAll().forEach(periods::add);
        return periods;
    }

    public Period getPeriod(int id) {
        return periodRepository.findById(id).orElse(null);
    }

    public void updatePeriod(Period period) {
        periodRepository.save(period);
    }

    public void deletePeriod(int id) {
        periodRepository.deleteById(id);
    }
}
