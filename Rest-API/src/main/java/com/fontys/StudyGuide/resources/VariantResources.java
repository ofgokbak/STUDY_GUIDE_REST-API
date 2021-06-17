package com.fontys.StudyGuide.resources;

import com.fontys.StudyGuide.dto.VariantDto;
import com.fontys.StudyGuide.models.Study.Variant;
import com.fontys.StudyGuide.services.VariantService;
import com.fontys.StudyGuide.services.converters.Variant_converter;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("api/variant")
@RestController
@CrossOrigin("*")
public class VariantResources {
    private final VariantService variantService;
    private final Variant_converter variant_converter;

    public VariantResources(VariantService variantService, Variant_converter variant_converter) {
        this.variantService = variantService;
        this.variant_converter = variant_converter;
    }


    @PostMapping
    public void addNewVariant(@Valid @NonNull @RequestBody VariantDto variantDto) {
        variantService.createVariant(variant_converter.convertToEntity(variantDto));
    }

    @GetMapping(path = "{id}")
    public VariantDto getVariant(@PathVariable("id") int id) {
        return variant_converter.convertToDto(variantService.getVariant(id));
    }


    @GetMapping
    public List<VariantDto> getAllVariants() {
        List<Variant> variantList = variantService.getAllVariants();
        List<VariantDto> variantDtoList = new ArrayList<>();
        variantList.forEach(variant -> variantDtoList.add(variant_converter.convertToDto(variant)));
        return variantDtoList;
    }

    @PutMapping(path = "{id}")
    public void updateVariant(@Valid @NonNull @RequestBody VariantDto variantDto, @PathVariable("id") int id) {
        variantDto.setId(id);
        variantService.updateVariant(variant_converter.convertToEntity(variantDto));
    }

    @DeleteMapping(path = "{id}")
    public void deleteVariant(@PathVariable("id") int id) {
        variantService.deleteVariant(id);
    }


}
