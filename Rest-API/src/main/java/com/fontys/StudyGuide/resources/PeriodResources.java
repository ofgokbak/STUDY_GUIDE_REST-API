package com.fontys.StudyGuide.resources;

import com.fontys.StudyGuide.dto.PeriodDto;
import com.fontys.StudyGuide.models.Study.Period;
import com.fontys.StudyGuide.services.PeriodService;
import com.fontys.StudyGuide.services.converters.Period_converter;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
@RequestMapping("api/period")
@RestController
@CrossOrigin("*")
public class PeriodResources {
    private final PeriodService periodService;
    private final Period_converter period_converter;

    public PeriodResources(PeriodService periodService, Period_converter period_converter) {
        this.periodService = periodService;
        this.period_converter = period_converter;
    }


    @PostMapping
    public void addNewPeriod(@Valid @NonNull @RequestBody PeriodDto periodDto) {
        periodService.createPeriod(period_converter.convertToEntity(periodDto));
    }

    @GetMapping(path = "{id}")
    public PeriodDto getPeriod(@PathVariable("id") int id) {
        return period_converter.convertToDto(periodService.getPeriod(id));
    }


    @GetMapping
    public List<PeriodDto> getAllPeriods() {
        List<Period> periodList = periodService.getAllPeriods();
        List<PeriodDto> periodDtoList = new ArrayList<>();
        periodList.forEach(period -> periodDtoList.add(period_converter.convertToDto(period)));
        return periodDtoList;
    }

    @PutMapping(path = "{id}")
    public void updatePeriod(@Valid @NonNull @RequestBody PeriodDto periodDto, @PathVariable("id") int id){
        periodDto.setId(id);
        periodService.updatePeriod(period_converter.convertToEntity(periodDto));
    }

    @DeleteMapping(path = "{id}")
    public void deletePeriod(@PathVariable("id") int id) { periodService.deletePeriod(id);}

}
