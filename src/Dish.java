import com.coffeeshop.enums.*;
public class Dish {
	String dishName;
	double price;
	DishCategory category;
	
	Dish(String dishName,double price, DishCategory category){
		this.dishName = dishName;
		this.price=price;
		this.category=category;
	}
}
