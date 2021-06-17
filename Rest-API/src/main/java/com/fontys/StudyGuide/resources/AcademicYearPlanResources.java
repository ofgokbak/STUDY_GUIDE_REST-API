package com.fontys.StudyGuide.resources;
import com.fontys.StudyGuide.dto.AcademicYearPlanDto;
import com.fontys.StudyGuide.models.Study.AcademicYearPlan;
import com.fontys.StudyGuide.services.AcademicYearPlanService;
import com.fontys.StudyGuide.services.converters.Academic_year_plan_converter;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
@RequestMapping("api/academic_year_plan")
@RestController
@CrossOrigin("*")
public class Academic_year_planResources {
    private final AcademicYearPlanService academicYearPlanService;
    private final Academic_year_plan_converter academic_year_plan_converter;

    public Academic_year_planResources(AcademicYearPlanService academicYearPlanService, Academic_year_plan_converter academic_year_plan_converter) {
        this.academicYearPlanService = academicYearPlanService;
        this.academic_year_plan_converter = academic_year_plan_converter;
    }


    @PostMapping
    public void addNewAcademic_year_plan(@Valid @NonNull @RequestBody AcademicYearPlanDto academicYearPlanDto) {
        academicYearPlanService.addAcademicYearPlan(academic_year_plan_converter.convertToEntity(academicYearPlanDto));
    }

    @GetMapping(path = "{id}")
    public AcademicYearPlanDto getAcademic_year_plan(@PathVariable("id") int id) {
        return academic_year_plan_converter.convertToDto(academicYearPlanService.getAcademicYearPlan(id));
    }


    @GetMapping
    public List<AcademicYearPlanDto> getAllAcademic_year_plans() {
        List<AcademicYearPlan> academicYearPlanList = academicYearPlanService.getAcademicYearPlans();
        List<AcademicYearPlanDto> academicYearPlanDtoList = new ArrayList<>();
        academicYearPlanList.forEach(academicYearPlan -> academicYearPlanDtoList.add(academic_year_plan_converter.convertToDto(academicYearPlan)));
        return academicYearPlanDtoList;
    }

    @PutMapping(path = "{id}")
    public void updateAcademic_year_plan(@Valid @NonNull @RequestBody AcademicYearPlanDto academicYearPlanDto, @PathVariable("id") int id)
    {
        academicYearPlanDto.setId(id);
        if(academicYearPlanService.updateAcademicYearPlan(academic_year_plan_converter.convertToEntity(academicYearPlanDto)) == null)
        {
            throw new IllegalArgumentException("Object does not exist");
        }
    }

    @DeleteMapping(path = "{id}")
    public void deleteAcademic_year_plan(@PathVariable("id") int id)
    {
        if(academicYearPlanService.deleteAcademicYearPlan(id) == 0)
        {
            throw new IllegalArgumentException("Object does not exist");
        }
    }

}