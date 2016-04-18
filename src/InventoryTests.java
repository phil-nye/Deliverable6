import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class InventoryTests {
    // Given an empty inventory file or no inventory file to read in
    // Then the system should report an error
    @Test
    public void emptyInventory() {
        Inventory inv = new Inventory();

        if(inv.size() == 0) {
            assertError
        }
    }
}
