import java.util.*;
import java.text.DecimalFormat;

// developer Angela Tackett CMIS 141 23JAN23
/* This program will take user inputs for order details,
 * calculate the discount percentage, the amount to be
 * discounted, and return all order inputs and totals
 * prior to (subtotal) and after discount is applied.
 * Improper input data types will not be accepted by 
 * program. */

public class OrderTaker {
    	public static void main(String[] args) {
		
		//initialize scanner
		Scanner scan = new Scanner(System.in);
        //establish format - used for $ prices
		DecimalFormat df = new DecimalFormat("#,###.##");
        //establish format- used for %
        DecimalFormat dfp = new DecimalFormat("##");
		
		//declare variables
		int customer_id, quantity;
		double unit_price, subtotal, quant_cast;
        double disc_percent, tot_discounted, total;
		String prod_description;
		double discount;
		
		//Instructions for user inputs
		System.out.println("\nORDER INSTRUCTIONS \n  "
				+ "After entering inputs "
				+ "press 'enter' or 'return'.\n");
		
		//prompt for customer id + while LOOP ->input type verification
		System.out.print("Enter Customer ID: ");
			while (!scan.hasNextInt()) {
			    System.out.print("Not an integer - re-enter Customer ID:");
			    scan.next();
			}
		customer_id = scan.nextInt();
		
		//prompt for unit price
		System.out.print("Enter unit price (e.g. 3.5): $");
			while (!scan.hasNextDouble()) {
			    System.out.print("Not a decimal - re-enter unit price:");
			    scan.next();
			}
		unit_price = scan.nextDouble();
		
		//prompt for quantity
		System.out.print("Enter quantity: ");
			while (!scan.hasNextInt()) {
				System.out.print("Not an integer - re-enter quantity:");
				scan.next();
			}
		quantity = scan.nextInt();
		
		//prompt for product description
		System.out.print("Enter product description: ");
		prod_description = scan.next();
				
		//prompt for discount
		System.out.print("Enter discount in decimal format (e.g. .10): ");
			while (!scan.hasNextDouble()) {
			    System.out.print("Not a decimal - re-enter discount:");
			    scan.next();
			}
		discount = scan.nextDouble();
				
		
		//ORDER DETAILS PRIOR TO APPLIED DISCOUNT
		quant_cast = (double) quantity;  //type cast for arithmetic operation
		subtotal = unit_price * quant_cast; //calculates total prior to discount added
        tot_discounted = subtotal * discount; //calculates amount to be discounted
        total = subtotal - tot_discounted; //calculates total after applied discount
		
		disc_percent = discount * 100.00;
		// type cast disc_percent to double in order to find actual deducted
				
		System.out.print("\n\nORDER DETAILS\n------------\n\nCustomer ID: "
				+ customer_id);
		
		//printf format method
		System.out.printf("\nUnit Price: $" + df.format(unit_price)); 
		System.out.print("\nQuantity: "	+ quantity 
				+ "\nProduct Description: " + prod_description);
		
		//printf format method
		System.out.printf("\n\nSubtotal: $" + df.format(subtotal));
		System.out.print("\n\nDiscount: " + dfp.format(disc_percent) + "%");		
	
        System.out.print("\nDiscounted Amount: $" + df.format(tot_discounted) 
        + "\n\nTotal Due: $" + df.format(total));

        in.close();

    }

}
