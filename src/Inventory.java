import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.lang.Float;
import java.lang.Integer;

import java.util.HashMap;

public class Inventory {
    private HashMap<String, Item> itemMap;

    public Inventory() {
        itemMap = null;
    }

    public Inventory(String inv_name) {
        addToInv(inv_name);
    }

    private int initInv(String inv_file) throws IOException {
        try {
            BufferedReader infile = new BufferedReader(new FileReader(inv_file));

            // Inventory file is a pipe separated list of items
            String line = "";
            while((line = infile.readLine()) != null) {
                String details[] = line.split("\\|");

                // each line is formatted as [itemName]|[itemCount]|[itemPrice]

                Item item = new Item(details[0], Integer.parseInt(details[1]), Float.parseFloat(details[2]));
                itemMap.put(details[0], item);
            }

            return 0;
        }
        catch(IOException ioe) {
            System.out.println("ERROR: Cannot read in inventory file.");
            ioe.printStackTrace();

            return -1;
        }

        return 1;   //something weird has happened to get to this line
    }

    public int addNewItem(String newName, int newCount, float newPrice) {
        if(itemMap.containsKey(newName)) {  // check if item already exits
            Item existingItem = itemMap.get(newName);
            System.out.println("\nItem already exits!");
            System.out.println("Here it is! " + "\n\tName: " + existingItem.getItemName() + "\n\tCount: " + existingItem.getItemCount() + "\n\tPrice: " + existingItem.getItemPrice());

            return 1;
        }
        else if(!itemMap.containsKey(newName)) {
            Item newItem = new Item(newName, newCount, newPrice);
            itemMap.put(newName, newItem);

            return 0;
        }

        return -1;
    }

    public int modifyExisting(String oldName, Item itemInfo) {
        if(itemInfo == null) {  // not a valid entry
            System.out.println("Item not specified.")
            return -1;
        }

        if(itemMap.containsKey(oldName)) {  // can only modify and existing item
            itemMap.put(oldName, itemInfo);
            return 0;
        }

        System.out.println("Item [" + oldName "] does not exist.");
        return 1;
    }

    public int removeItem(String itemName) {
        if(itemMap.containsKey(itemName)) {
            itemMap.remove(itemName);

            return 0;
        }
        else {
            System.out.println("NOTHING TO DO: " + itemName + "not in the Inventory.");

            return -1;
        }
    }
}
