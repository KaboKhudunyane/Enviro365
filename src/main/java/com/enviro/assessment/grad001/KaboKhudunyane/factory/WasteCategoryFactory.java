package com.enviro.assessment.grad001.KaboKhudunyane.factory;

import com.enviro.assessment.grad001.KaboKhudunyane.domain.WasteCategory;

public class WasteCategoryFactory {

    public static WasteCategory createWasteCategory(String name, String description) {
        if (name == null || name.isBlank() || description == null || description.isBlank()) {
            return null; // Return null if inputs are invalid
        }
        return new WasteCategory.Builder()
                .setName(name)
                .setDescription(description)
                .build();
    }
}