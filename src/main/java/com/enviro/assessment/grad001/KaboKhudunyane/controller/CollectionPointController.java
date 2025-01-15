package com.enviro.assessment.grad001.KaboKhudunyane.controller;
import com.enviro.assessment.grad001.KaboKhudunyane.domain.CollectionPoint;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.enviro.assessment.grad001.KaboKhudunyane.service.CollectionPointService;

import java.util.List;
@RestController
@RequestMapping("/api")
public class CollectionPointController {
    private final CollectionPointService collectionPointService;
    @Autowired
    public CollectionPointController(CollectionPointService collectionPointService) {
        this.collectionPointService = collectionPointService;
    }
    //create
    @PostMapping("/createCollectionPoint")
    public CollectionPoint createCollectionPoint(@Valid @RequestBody CollectionPoint collectionPoint) {
        return collectionPointService.createCollectionPoint(collectionPoint);
    }
    //read
    @GetMapping("/getAllCollectionPoints")
    public List<CollectionPoint> getAllCollectionPoints() {
        return collectionPointService.getAllCollectionPoints();
    }
    @GetMapping("/getCollectionPoint/{id}")
    public ResponseEntity<CollectionPoint> findCollectionPointById(@PathVariable Long id) {
        return collectionPointService.findCollectionPointById(id)
                .map(ResponseEntity :: ok)
                .orElseGet(()-> ResponseEntity.notFound().build());
    }
    //update
    @PutMapping("/updateCollectionPoint/{id}")
    public ResponseEntity<CollectionPoint> updateCollectionPoint(@PathVariable Long id, CollectionPoint collectionPoint){
        if(collectionPointService.findCollectionPointById(id).isEmpty()){
            return ResponseEntity.notFound().build();
        }
        collectionPoint.setId(id);
        return ResponseEntity.ok(collectionPointService.createCollectionPoint(collectionPoint));
    }
    //delete
    @DeleteMapping("/deleteCollectionPoint/{id}")
    public ResponseEntity<Void> deleteCollectionPoint(@PathVariable Long id){
        if(collectionPointService.findCollectionPointById(id).isEmpty()){
            return ResponseEntity.notFound().build();
        }
        collectionPointService.deleteCollectionPoint(id);
        return ResponseEntity.noContent().build();
    }
}