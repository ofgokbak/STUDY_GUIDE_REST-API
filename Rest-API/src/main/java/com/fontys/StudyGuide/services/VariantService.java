package com.fontys.StudyGuide.services;

import com.fontys.StudyGuide.models.Study.Variant;
import com.fontys.StudyGuide.repository.VariantRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VariantService {
    private final VariantRepository variantRepository;

    public VariantService(VariantRepository variantRepository) {
        this.variantRepository = variantRepository;
    }


    public Variant createVariant(Variant variant){ return variantRepository.save(variant);}
    public Variant getVariant(int id){ return variantRepository.findById(id).orElse(null);}
    public List<Variant> getAllVariants(){
        List<Variant> variantList = new ArrayList<>();
        variantRepository.findAll().forEach(variantList::add);
        return variantList;
    }
    public Variant updateVariant(Variant variant){
        return variantRepository.save(variant);
    }
    public void deleteVariant(int id){ variantRepository.deleteById(id);}

    public Variant getVariantByName(String variantName) {
        return variantRepository.findByName(variantName);
    }
}
