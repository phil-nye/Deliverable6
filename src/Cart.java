public class Cart {
    HashMap<String, Item> cart;

    public Cart() {
        cart = new HashMap<String, Item>();
    }

    public int showCart() {
        if(cart == null || cart.equals(null)) {
            System.out.println("Nothing!");
            return -1;
        }

        int num = 1;
        System.out.println("Cart: ");
        for(String key : cart.keySet()) {
            Item merch = cart.get(key);

            System.out.print("\t" + num++);
            System.out.println(merch.printItem() + "\n");
        }

        return 0;
    }

    public void addItem(Item item) {
        cart.put(item.getItemName(), item);
    }

    public int removeItem(String itemName) {
        if(cart == null || cart.equals(null)) { // no items in cart
            System.out.println("Nothing!");
            return -1;
        }

        if(cart.containsKey(itemName)) {
            cart.remove(itemName);
            showCart();

            return 0;
        }

        System.out.println("Item is not in cart; or something else.")
        // item not in cart, or something else
        return 1;
    }
}
