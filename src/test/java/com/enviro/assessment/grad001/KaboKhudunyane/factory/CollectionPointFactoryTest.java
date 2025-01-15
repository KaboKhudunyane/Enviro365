package com.enviro.assessment.grad001.KaboKhudunyane.factory;
import  com.enviro.assessment.grad001.KaboKhudunyane.domain.CollectionPoint;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class CollectionPointFactoryTest {
    @Test
    void testCreateCollectionPointWithValidInput() {
        String location = "Cape Town";
        String contactDetails = "Phone: 0123456789";
        CollectionPoint collectionPoint = CollectionPointFactory.createCollectionPoint(location, contactDetails);
        assertNotNull(collectionPoint);
        assertEquals(location, collectionPoint.getLocation());
        System.out.println(collectionPoint);
    }
    @Test
    void testCreateCollectionPointWithNullInputs() {
        String location = " ";
        String contactDetails = "";
        CollectionPoint collectionPoint = CollectionPointFactory.createCollectionPoint(location, contactDetails);
        assertNull(collectionPoint);
        System.out.println(collectionPoint);
    }
}