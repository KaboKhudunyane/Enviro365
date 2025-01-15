package com.enviro.assessment.grad001.KaboKhudunyane.service;
import com.enviro.assessment.grad001.KaboKhudunyane.domain.WasteCategory;
import com.enviro.assessment.grad001.KaboKhudunyane.repository.WasteCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
@Service
public class WasteCategoryService {
    private final WasteCategoryRepository wasteCategoryRepository;
    @Autowired
    public WasteCategoryService(WasteCategoryRepository wasteCategoryRepository) {
        this.wasteCategoryRepository = wasteCategoryRepository;
    }
    //create + update
    public WasteCategory saveWasteCategory(WasteCategory wasteCategory) {
        return wasteCategoryRepository.save(wasteCategory);
    }
    //read
    public List<WasteCategory> getAllWasteCategories() {
        return wasteCategoryRepository.findAll();
    }
    public Optional<WasteCategory> getWasteCategoryById(Long id) {
        return wasteCategoryRepository.findById(id);
    }

    //delete
    public void deleteWasteCategory(Long id) {
        wasteCategoryRepository.deleteById(id);
    }
}