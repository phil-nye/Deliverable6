public class Item {
    private String name;
    private int count;
    private float price;

    public Item() {
        name = null;
        count = 0;
        price = 0.00;
    }

    public Item(String n, int c, float p) {
        name = n;
        count = c;
        price = p;
    }

    public String getItemName() {
        return name;
    }

    public int getItemCount() {
        return count;
    }

    public float getItemPrice() {
        return price;
    }

    public void modifyName(String newName) {
        name = newName;
    }

    public void modifyCount(int newCount) {
        count = newCount;
    }

    public void modifyPrice(float newPrice) {
        price = newPrice;
    }

    public String printItem() {
        String str = "Name: " + name + " [x" + count + "]" + "\n\tTotal: $" + price;

        return str;
    }
}
