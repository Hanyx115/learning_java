import java.util.ArrayList;
import java.util.Collections;
import static java.util.Collections.max;
import static java.util.Collections.*;

public class Main {
    class GroceryItemOrder {
        private String name;
        private int quantity;
        private double pricePerUnit;

        public GroceryItemOrder(String name, double pricePerUnit) {
            this.name = name;
            this.pricePerUnit = pricePerUnit;
            this.quantity = 0; // Initialize quantity to 0
        }

        public double getCost() {
            return quantity * pricePerUnit;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }
    }

    public class GroceryList {
        private ArrayList<GroceryItemOrder> itemList;
        private static final int MAX_ITEMS = 10;

        public GroceryList() {
            itemList = new ArrayList<>();
        }

        public void add(GroceryItemOrder item) {
            if (itemList.size() < MAX_ITEMS) {
                itemList.add(item);
            } else {
                System.out.println("Cannot add item. The list is full.");
            }
        }

        public double getTotalCost() {
            double totalCost = 0;
            for (GroceryItemOrder item : itemList) {
                totalCost += item.getCost();
            }
            return totalCost;
        }
    public void main(String[] args) {
        // Create an ArrayList of Strings
        ArrayList<Integer> hany = new ArrayList<>();
        hany.add(1);
        hany.add(2);
        hany.add(3);
        hany.add(4);
        hany.add(5);
        hany.add(6);
        System.out.println("Maximum value in the list: " + max(hany));
        sort(hany);
        System.out.println(hany);
        GroceryItemOrder item1 = new GroceryItemOrder("Apples", 2.50);
        GroceryItemOrder item2 = new GroceryItemOrder("Milk", 3.20);
        GroceryItemOrder item3 = new GroceryItemOrder("Bread", 1.80);

        // Adding items to the grocery list
        GroceryList groceryList = new GroceryList();
        groceryList.add(item1);
        groceryList.add(item2);
        groceryList.add(item3);

        // Setting quantities
        item1.setQuantity(2);
        item2.setQuantity(1);
        item3.setQuantity(3);

        // Displaying total cost
        System.out.println("Total cost of groceries: $" + groceryList.getTotalCost());



    }
}
}
