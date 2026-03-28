import java.util.ArrayList;
import java.util.Objects;

public class GroceryListManager {
    //private static final HashMap<String, listItem> groceryList = new HashMap<>();
    private static final ArrayList<listItem> groceryList = new ArrayList<>();
    //addItem(String item):
        //This method adds the given item to the grocery list.
    static void addItem(String item, double price, String category, int amount){
        item = item.toLowerCase();
        category = category.toLowerCase();
        listItem listitem = new listItem();
        listitem.name=item;
        listitem.category=category;
        listitem.price=price;
        listitem.amount=amount;
        if (!checkItem(item)) {
            groceryList.add(listitem);
            System.out.println(item+" added successfully.");
        } else {
            System.out.println(item + " already in list, updating quantity.");
            updateQuantity(item, amount);
        }
    }

    //removeItem(String item):
        // This method removes the given item from the grocery list.
    static void removeItem(String item){
        item = item.toLowerCase();
        if (checkItem(item)) {
            System.out.println("Removing "+item+" from list...");
            for (int i = 0; i < groceryList.toArray().length; i++) {
                if (groceryList.get(i).name.equals(item)) {
                    groceryList.remove(i);
                }
            }
            System.out.println("Updated "+GroceryListManager.displayList());
        }
        else System.out.println("No such item in list");
    }

    //displayList():
        // This method displays all the items in the grocery list.
    static String displayList(){
        StringBuilder list = new StringBuilder();
        list.append("Grocery list: \n");
        for (int i = 0; i < groceryList.toArray().length; i++) {
            list.append(i+1).append(". ").append(groceryList.get(i).name).append(" ")
                    .append(groceryList.get(i).price).append(" € ").append(groceryList.get(i).category).append(" ")
                    .append(groceryList.get(i).amount).append("\n");
        }
        list.append("Total cost: ").append(GroceryListManager.calculateTotalCost()).append(" €\n");
        return list.toString();
    }

    //checkItem(String item):
        // This method checks if the given item is present in the grocery list and returns a boolean value.
    static boolean checkItem(String item){
        item = item.toLowerCase();
        for (int i = 0; i < groceryList.toArray().length; i++) {
            if (groceryList.get(i).name.equals(item))
                return true;
        }
        return false;
    }

    //calculateTotalCost():
        //This method calculates and returns the total cost of all items in the grocery list.
    static double calculateTotalCost(){
        double cost=0;
        for (int i = 0; i < groceryList.toArray().length; i++){
            cost += (groceryList.get(i).price * groceryList.get(i).amount);
        }
        return cost;
    }

    //displayByCategory(String category):
        //This method displays all items in the specified category.
    static String displayByCategory(String category){
        category = category.toLowerCase();
        StringBuilder filter = new StringBuilder();
        filter.append("Grocery list, category ").append(category).append(": \n");
        for (int i = 0; i < groceryList.toArray().length; i++) {
            if (groceryList.get(i).category.equals(category))
                filter.append(i+1).append(". ").append(groceryList.get(i).name).append(" ")
                        .append(groceryList.get(i).price).append(" € ").append(groceryList.get(i).category).append(" ")
                        .append(groceryList.get(i).amount).append("\n");
        }
        return filter.toString();
    }

    //updateQuantity(String item, int newQuantity):
        //This method updates the quantity of the specified item in the grocery list.
    static void updateQuantity(String item, int newQuantity){
        item = item.toLowerCase();
        for (int i = 0; i < groceryList.toArray().length; i++) {
            if (groceryList.get(i).name.equals(item)){
                System.out.println(groceryList.get(i).name+" quantity updated.");
                groceryList.get(i).amount = newQuantity;
                System.out.println("Updated "+GroceryListManager.displayList());
            }
        }
    }

    //displayAvailableItems():
        //This method displays items that have a positive quantity along with their quantities.
    static String displayAvailableItems(){
        StringBuilder filter = new StringBuilder();
        filter.append("Grocery list, available items:\n");
        for (int i = 0; i < groceryList.toArray().length; i++) {
            if (groceryList.get(i).amount > 0)
                filter.append(i+1).append(". ").append(groceryList.get(i).name).append(" ")
                        .append(groceryList.get(i).price).append(" € ").append(groceryList.get(i).category).append(" ")
                        .append(groceryList.get(i).amount).append("\n");
        }
        return filter.toString();
    }

    //Note: You are encouraged to enhance the exercise by
    // adding error handling to handle cases such as adding duplicate items,
    // removing non-existent items, and so on.

    public static void main(String[] args){
        System.out.println("Adding items:");
        GroceryListManager.addItem("Apples", 1, "Fruits",3);
        GroceryListManager.addItem("Milk", 2,"Dairy",2);
        GroceryListManager.addItem("Bread", 5, "Bakery",3);
        GroceryListManager.addItem("milk", 2, "Dairy",5);

        System.out.println("Display list:");
        System.out.println(GroceryListManager.displayList());
        System.out.println(GroceryListManager.displayByCategory("Dairy"));
        System.out.println("Is \"Milk\" in the grocery list? "+GroceryListManager.checkItem("Milk"));

        System.out.println("Remove, add, update:");
        GroceryListManager.removeItem("Milk");
        GroceryListManager.addItem("Milk", 2,"Dairy",2);
        GroceryListManager.updateQuantity("Milk", 4);
        GroceryListManager.updateQuantity("BRead", 0);
        System.out.println(displayAvailableItems());

    }
}