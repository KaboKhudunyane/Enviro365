package com.enviro.assessment.grad001.KaboKhudunyane.controller;
import com.enviro.assessment.grad001.KaboKhudunyane.domain.WasteCategory;
import jakarta.validation.Valid;
import com.enviro.assessment.grad001.KaboKhudunyane.service.WasteCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api")
public class WasteCategoryController {
    private final WasteCategoryService wasteCategoryService;
    @Autowired
    public WasteCategoryController(WasteCategoryService wasteCategoryService) {
        this.wasteCategoryService = wasteCategoryService;
    }
    //create
    @PostMapping("/createWasteCategory")
    public WasteCategory createWasteCategory(@Valid @RequestBody WasteCategory wasteCategory) {
        wasteCategory.setId(null);
        return wasteCategoryService.saveWasteCategory(wasteCategory);
    }
    //read
    @GetMapping("/getAllWasteCategories")
    public List<WasteCategory> getAllWasteCategories() {
        return wasteCategoryService.getAllWasteCategories();
    }
    @GetMapping("/getWasteCategory/{id}")
    public ResponseEntity<WasteCategory> getWasteCategoryById(@PathVariable Long id) {
        return wasteCategoryService.getWasteCategoryById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    //update
    @PutMapping("/updateWasteCategory/{id}")
    public ResponseEntity<WasteCategory> updateWasteCategory(@PathVariable Long id, @RequestBody WasteCategory wasteCategory) {
        if (wasteCategoryService.getWasteCategoryById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        wasteCategory.setId(id);
        return ResponseEntity.ok(wasteCategoryService.saveWasteCategory(wasteCategory));
    }
    //delete
    @DeleteMapping("/deleteWasteCategory/{id}")
    public ResponseEntity<Void> deleteWasteCategory(@PathVariable Long id) {
        if (wasteCategoryService.getWasteCategoryById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        wasteCategoryService.deleteWasteCategory(id);
        return ResponseEntity.noContent().build();
    }
}