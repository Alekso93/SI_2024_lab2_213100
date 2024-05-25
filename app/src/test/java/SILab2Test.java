// src/test/java/SILab2Test.java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

public class SILab2Test {

    @Test
    public void testEveryBranch() {
        // Test 1
        List<Item> items1 = new ArrayList<>();
        items1.add(new Item("testname1", "12345", 20, 10));
        items1.add(new Item("testname2", "54321", 60, 20));
        items1.add(new Item("testname3", "17542", 40, 30));
        assertFalse(SILab2.checkCart(items1, 50));

        // Test 2
        List<Item> items2 = new ArrayList<>();
        items2.add(new Item(null, null, 300, -10));
        Exception exception = assertThrows(RuntimeException.class, () -> SILab2.checkCart(items2, 5000));
        assertEquals("No barcode!", exception.getMessage());

        // Test 3
        List<Item> items3 = new ArrayList<>();
        items3.add(new Item("item", "01234", 400, 10));
        assertTrue(SILab2.checkCart(items3, 5000));

        // Test 4
        Exception exception2 = assertThrows(RuntimeException.class, () -> SILab2.checkCart(null, 100));
        assertEquals("allItems list can't be null!", exception2.getMessage());

        // Test 5
        List<Item> items5 = new ArrayList<>();
        items5.add(new Item("item", "01234", 400, -10));
        assertFalse(SILab2.checkCart(items5, 5000));

        // Test 6
        List<Item> items6 = new ArrayList<>();
        items6.add(new Item("item", "!1234", 400, -10));
        Exception exception3 = assertThrows(RuntimeException.class, () -> SILab2.checkCart(items6, 5000));
        assertEquals("Invalid character in item barcode!", exception3.getMessage());
    }

    @Test
    public void testMultipleCondition() {
        // Combinations for item.getPrice() > 300 && item.getDiscount() > 0 && item.getBarcode().charAt(0) == '0'

        // True, True, True
        List<Item> items1 = new ArrayList<>();
        items1.add(new Item("item", "01234", 400, 10));
        assertTrue(SILab2.checkCart(items1, 5000));

        // True, True, False
        List<Item> items2 = new ArrayList<>();
        items2.add(new Item("item", "11234", 400, 10));
        assertTrue(SILab2.checkCart(items2, 5000));

        // True, False, True
        List<Item> items3 = new ArrayList<>();
        items3.add(new Item("item", "01234", 400, 0));
        assertTrue(SILab2.checkCart(items3, 5000));

        // False, True, True
        List<Item> items4 = new ArrayList<>();
        items4.add(new Item("item", "01234", 200, 10));
        assertTrue(SILab2.checkCart(items4, 5000));

        // True, False, False
        List<Item> items5 = new ArrayList<>();
        items5.add(new Item("item", "11234", 400, 0));
        assertTrue(SILab2.checkCart(items5, 5000));

        // False, True, False
        List<Item> items6 = new ArrayList<>();
        items6.add(new Item("item", "11234", 200, 10));
        assertTrue(SILab2.checkCart(items6, 5000));

        // False, False, True
        List<Item> items7 = new ArrayList<>();
        items7.add(new Item("item", "01234", 200, 0));
        assertTrue(SILab2.checkCart(items7, 5000));

        // False, False, False
        List<Item> items8 = new ArrayList<>();
        items8.add(new Item("item", "11234", 200, 0));
        assertTrue(SILab2.checkCart(items8, 5000));
    }
}
