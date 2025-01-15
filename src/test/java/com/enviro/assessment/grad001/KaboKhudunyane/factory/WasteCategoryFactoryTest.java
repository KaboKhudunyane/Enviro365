package  com.enviro.assessment.grad001.KaboKhudunyane.factory;
import com.enviro.assessment.grad001.KaboKhudunyane.domain.WasteCategory;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class WasteCategoryFactoryTest {
    @Test
    void testCreateWasteCategoryWithValidInput() {
        String name = "Recyclable";
        String description = "Materials that can be recycled";
        WasteCategory wasteCategory = WasteCategoryFactory.createWasteCategory(name, description);
        assertNotNull(wasteCategory);
        assertEquals(name, wasteCategory.getName());
        assertEquals(description, wasteCategory.getDescription());
        System.out.println(wasteCategory);
    }
    @Test
    void testCreateWasteCategoryWithNullInputs() {
        String name = "";
        String description = "";
        WasteCategory wasteCategory = WasteCategoryFactory.createWasteCategory(name, description);
        assertNull(wasteCategory);
        System.out.println(wasteCategory);
    }
}