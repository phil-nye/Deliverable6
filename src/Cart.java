public class Cart {
    HashMap<String, Item> cart;

    //cart will always start empty
    public Cart() {
        cart = new HashMap<String, Item>();
    }

    public String showCart() {
        if(cart == null || cart.equals(null)) {
            System.out.println("Nothing!");
            return -1;
        }

        String str = "";
        int num = 1;
        System.out.println("Cart: ");
        for(String key : cart.keySet()) {
            Item merch = cart.get(key);

            str += "\t" + num++ + ")\t";
            str += merch.printItem() + "\n\n";
        }

        return 0;
    }

    public int addItem(Item item) {
        if(cart.containsKey(item.getItemName())) {
            System.out.println("[" + item.getItemName() + "] already exists!")

            return 1;
        }
        else if(!cart.containskey(item.getItemName()) || cart.isEmpty()) {
            cart.put(item.getItemName(), item);

            return 0;
        }

        return -1;
    }

    public int modifyItem(String oldItemName, Item newItem) {
        if(cart.containsKey(oldItemName)) {
            cart.remove(oldItemName);
            cart.put(newItem.getItemName(), newItem);
            System.out.println("[" + cart.get(oldItemName).printItem() + "] is now [" + newItem.printItem() + "]");

            return 0;
        }

        return -1;
    }

    public int removeItem(String itemName) {
        if(cart == null || cart.equals(null)) { // no items in cart
            System.out.println("[" + itemName + "] not found.");

            return -1;
        }

        if(cart.containsKey(itemName)) {
            cart.remove(itemName);
            System.out.println("[" + itemName + "] removed");

            return 0;
        }

        System.out.println("Item is not in cart; or something else.")
        // item not in cart, or something else
        return 1;
    }
}
