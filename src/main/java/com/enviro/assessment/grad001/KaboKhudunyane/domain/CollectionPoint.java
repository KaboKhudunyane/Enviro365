package com.enviro.assessment.grad001.KaboKhudunyane.domain;
import jakarta.persistence.*;
@Entity
public class CollectionPoint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String location;
    private String contactDetails;
    public CollectionPoint(){}
    private CollectionPoint(Builder builder){
        this.id = builder.id;
        this.location = builder.location;
        this.contactDetails = builder.contactDetails;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public String getContactDetails() {
        return contactDetails;
    }
    public void setContactDetails(String contactDetails) {
        this.contactDetails = contactDetails;
    }
    @Override
    public String toString() {
        return "CollectionPoint{" +
                "id=" + id +
                ", location='" + location + '\'' +
                ", contactDetails='" + contactDetails + '\'' +
                '}';
    }
    public static class Builder {
        private Long id;
        private String location;
        private String contactDetails;
        public Builder setId(Long id){
            this.id = id;
            return this;
        }
        public Builder setLocation(String location){
            this.location = location;
            return this;
        }
        public Builder setContactDetails(String contact){
            this.contactDetails = contact;
            return this;
        }
        public Builder copy(CollectionPoint collectionPoint){
            this.id = collectionPoint.id;
            this.location = collectionPoint.location;
            this.contactDetails = collectionPoint.contactDetails;
            return this;
        }
        public CollectionPoint build(){
            return new CollectionPoint(this);
        }
    }
}