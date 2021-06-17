package com.fontys.StudyGuide.resources;

import com.fontys.StudyGuide.dto.Yearly_planDto;
import com.fontys.StudyGuide.models.Study.Yearly_plan;
import com.fontys.StudyGuide.services.Yearly_planService;
import com.fontys.StudyGuide.services.converters.Yearly_plan_converter;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("api/yearly_plan")
@RestController
@CrossOrigin("*")
public class Yearly_planResources {
    private final Yearly_planService yearly_planService;
    private final Yearly_plan_converter yearly_plan_converter;

    public Yearly_planResources(Yearly_planService yearly_planService, Yearly_plan_converter yearly_plan_converter) {
        this.yearly_planService = yearly_planService;
        this.yearly_plan_converter = yearly_plan_converter;
    }


    @PostMapping
    public void addYearly_plan(@Valid @NonNull @RequestBody Yearly_planDto yearly_planDto) {
        yearly_planService.createYearly_Plan(yearly_plan_converter.convertToEntity(yearly_planDto));
    }

    @GetMapping(path = "{id}")
    public Yearly_planDto getVariant(@PathVariable("id") int id) {
        return yearly_plan_converter.convertToDto(yearly_planService.getYearly_Plan(id));
    }


    @GetMapping
    public List<Yearly_planDto> getAllYearly_plans() {
        List<Yearly_plan> yearly_planList = yearly_planService.getAllYearly_Plans();
        List<Yearly_planDto> yearly_planDtoList = new ArrayList<>();
        yearly_planList.forEach(yearly_plan -> yearly_planDtoList.add(yearly_plan_converter.convertToDto(yearly_plan)));
        return yearly_planDtoList;
    }

    @PutMapping(path = "{id}")
    public void updateYearly_plan(@Valid @NonNull @RequestBody Yearly_planDto yearly_planDto, @PathVariable("id") int id) {
        yearly_planDto.setId(id);
        yearly_planService.updateYearly_Plan(yearly_plan_converter.convertToEntity(yearly_planDto));
    }

    @DeleteMapping(path = "{id}")
    public void deleteYearly_plan(@PathVariable("id") int id) {
        yearly_planService.deleteYearly_Plan(id);
    }
}
