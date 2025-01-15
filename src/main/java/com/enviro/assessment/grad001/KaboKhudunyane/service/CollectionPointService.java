package com.enviro.assessment.grad001.KaboKhudunyane.service;

import com.enviro.assessment.grad001.KaboKhudunyane.domain.CollectionPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.enviro.assessment.grad001.KaboKhudunyane.repository.CollectionPointRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CollectionPointService {
    public final CollectionPointRepository collectionPointRepository;
    @Autowired
    public CollectionPointService(CollectionPointRepository collectionPointRepository) {
        this.collectionPointRepository = collectionPointRepository;
    }
    //create
    public CollectionPoint createCollectionPoint(CollectionPoint collectionPoint){
        return collectionPointRepository.save(collectionPoint);
    }
    //read
    public List<CollectionPoint> getAllCollectionPoints(){
        return collectionPointRepository.findAll();
    }
    public Optional<CollectionPoint> findCollectionPointById(Long id){
        return collectionPointRepository.findById(id);
    }
    //delete
    public void deleteCollectionPoint(Long id){
        collectionPointRepository.deleteById(id);
    }
}