package com.enviro.assessment.grad001.KaboKhudunyane.factory;

import com.enviro.assessment.grad001.KaboKhudunyane.domain.CollectionPoint;

public class CollectionPointFactory {

    public static CollectionPoint createCollectionPoint(String location, String contactDetails){

        if(location == null || location.isBlank() || contactDetails == null || contactDetails.isBlank()){
            return null;
        }
        return  new CollectionPoint.Builder().setLocation(location).setContactDetails(contactDetails).build();

    }
}
