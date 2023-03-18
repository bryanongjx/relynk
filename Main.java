import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Product> cart =  new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        Double subtotal = 0.0;
        Double shipping = 0.0;
        Double VAT = 0.0;
        Double discount_shoes = 0.0;
        Double shipping_discount = 0.0;
        Double jacket_discount = 0.0;
        Double total = 0.0;
        System.out.println("Hi what can I do for you today?");


        String input = sc.nextLine();

        if (input.startsWith("createCart")) {
                String[] inputArr = input.split(" --product=");

            // create cart
            for (String elem : inputArr) {
                if (elem.equals("T-shirt")) {
                    cart.add(new Product("T-shirt", 30.99, "US", 0.2, 2.0));
                } else if (elem.equals("Blouse")) {
                    cart.add(new Product("Blouse", 10.99, "UK", 0.3, 3.0));
                } else if (elem.equals("Pants")) {
                    cart.add(new Product("Pants", 64.99, "UK", 0.9, 3.0));
                } else if (elem.equals("Sweatpants")) {
                    cart.add(new Product("Sweatpants", 84.99, "CN", 1.1, 2.0));
                } else if (elem.equals("Jacket")) {
                    cart.add(new Product("Jacket", 199.99, "US", 2.2, 2.0));
                } else if (elem.equals("Shoes")) {
                    cart.add(new Product("Shoes", 79.99, "CN", 1.3, 2.0));
                } else {
                    continue;
                }
            }

            // get invoice without discounts
            for (Product product : cart) {
                subtotal += product.price;
                shipping += product.getShipping();
                VAT += product.getVAT();
            }
            System.out.println("Subtotal: " + subtotal);
            System.out.println("Shipping: " + shipping);
            System.out.println("VAT: " + VAT);

            int top_counter = 0;
            int item_counter = 0;
            Boolean is_jacket_present = false;
            for (Product product : cart) {
                if (product.type.equals("Jacket")) {
                    is_jacket_present = true;
                }
            }

            // get discounts 
            for (Product product : cart) {
                if (product.type.equals("Shoes")) {
                    discount_shoes -= product.price * 0.1;
                }
                if (product.type.equals("Blouse") || product.type.equals("T-shirt")) {
                    top_counter += 1;
                }
                item_counter += 1;
            }
            if (item_counter >= 2) {
                shipping_discount -= 10.0;
            }
            if (top_counter >= 2 && is_jacket_present) {
                jacket_discount -= (199.99 / 2);
            }
            System.out.println("Discounts:");
            System.out.println("10% off shoes: " + discount_shoes);
            System.out.println("50% off jacket: " + jacket_discount);
            System.out.println("Shipping discount: " + shipping_discount);

            // calculate total
            total = subtotal + shipping + VAT + discount_shoes + jacket_discount + shipping_discount;
            System.out.println("Total: " + total);
        } 
    }
}