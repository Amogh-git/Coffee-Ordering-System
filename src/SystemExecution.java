
import com.coffeeshop.utils.IOUtility;
public class SystemExecution {
	
	public static void main(String[] args) {
		
		CoffeeOrderSystem.setMenu();
		int choice=0;
		do {
			IOUtility.displayOptions();
			choice = IOUtility.getIntegerInput();
			switch(choice) {
			case 1:
				CoffeeOrderSystem.displayMenu();
				break;
			case 2:
				Order order = new Order();
				try {
					order=CoffeeOrderSystem.placeOrder();
				}
				catch(Exception e) {
					System.out.println("Could not place order "+e.getMessage());
					break;
				}
				CoffeeOrderSystem.generateBill(order);
				CoffeeOrderSystem.displayBill(order);
				break;
			}
		}while(choice<3);
	}

}
