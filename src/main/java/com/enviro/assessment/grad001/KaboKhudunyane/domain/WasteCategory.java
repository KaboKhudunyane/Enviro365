package com.enviro.assessment.grad001.KaboKhudunyane.domain;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
@Entity
public class WasteCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Name is required")
    @Size(max = 50, message = "Name must not exceed 50 characters")
    private String name;
    @NotBlank(message = "Description is required")
    @Size(max = 200, message = "Description must not exceed 200 characters")
    private String description;
    public WasteCategory(){
    }
    private WasteCategory(Builder builder){
        this.id = builder.id;
        this.name = builder.name;
        this.description = builder.description;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    @Override
    public String toString() {
        return "WasteCategory{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
    public static class Builder{
        private Long id;
        private String name;
        private String description;
        public Builder setId(Long id){
            this.id = id;
            return this;
        }
        public Builder setName(String name){
            this.name = name;
            return this;
        }
        public Builder setDescription(String description){
            this.description = description;
            return this;
        }
        public Builder copy(WasteCategory wasteCategory){
            this.id = wasteCategory.id;
            this.name = wasteCategory.name;
            this.description = wasteCategory.description;
            return this;
        }
        public WasteCategory build(){
            return new WasteCategory(this);
        }
    }
}