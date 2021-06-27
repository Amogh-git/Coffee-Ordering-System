import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.coffeeshop.enums.DishCategory;
import com.coffeeshop.utils.IOUtility;

public class CoffeeOrderSystem {
	static ArrayList<Dish> dishes = new ArrayList<Dish>();
	
	public static void setMenu() {
		dishes.add(new Dish("coffee1", 5, DishCategory.valueOf("COFFEE")));
		dishes.add(new Dish("coffee2", 10, DishCategory.valueOf("COFFEE")));
		dishes.add(new Dish("tea1", 5, DishCategory.valueOf("TEA")));
		dishes.add(new Dish("sandwitch1", 20, DishCategory.valueOf("SANDWITCH")));
	}
	public static void displayMenu() {
		System.out.println("Dish\t\tPrice");
		for(Dish d:dishes) {
			System.out.println(d.dishName+"............$"+d.price);
		}
	}
	public static Order placeOrder() throws Exception {
		String continu = "";
		Order order = new Order();
		do {
			System.out.println("Enter dish name to order ");
			String dishName = IOUtility.getStringInput();
			System.out.println("Enter quantity of dish ");
			int quantity = IOUtility.getIntegerInput();
			order.dishDetails.put(getDish(dishName), quantity);
			System.out.println("Anything else(yes/no)");
			continu = IOUtility.getStringInput();
		}while(continu.toLowerCase().equals("yes"));
		return order;
	}
	public static void generateBill(Order order) {
		double totalPrice=0;
		for(Entry<Dish, Integer> i:order.dishDetails.entrySet()) {
			totalPrice += i.getValue() * i.getKey().price;
		}
		order.totalPrice = totalPrice;
	}
	
	
	public static Dish getDish(String dish) throws Exception {
		return dishes.stream().filter(d->d.dishName.equals(dish)).findAny().orElseThrow();
	}
	
	public static void displayBill(Order order) {
		System.out.println("------------Here is your bill-----------\nDish\t\tPrice\t\tquantity");
		for(Entry<Dish, Integer> i:order.dishDetails.entrySet()) {
			System.out.println(i.getKey().dishName+"\t\t"+i.getKey().price+"\t\t"+i.getValue());
		}
		System.out.println("-----------Total Charges-----------\n$"+order.totalPrice);
		
	}
}
