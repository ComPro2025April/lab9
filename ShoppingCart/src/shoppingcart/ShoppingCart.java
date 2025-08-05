package shoppingcart;
import java.util.ArrayList;


import java.util.Iterator;

import products.Product;

public class ShoppingCart {
	ArrayList<CartLine> cartLines = new ArrayList<CartLine>();

	public void printProducts() {
		System.out.println("Content of the shoppingcart:");
		for (CartLine cline : cartLines) {
			System.out.println(STR."\{cline.getQuantity()} \{cline.getProduct().getProductNumber()} \{cline.getProduct().getDescription()} \{cline.getProduct().getPrice()}");
		}
		System.out.println("Total price = "+getT());
	}

	public void addProduct(Product product) {
		for (CartLine cline : cartLines) {
			if (cline.getProduct().getProductNumber().equals(product.getProductNumber())) {
				cline.setQuantity(cline.getQuantity()+1);
				return;
			}
		}
		CartLine cline = new CartLine();
		cline.setProduct(product);
		cline.setQuantity(1);
		cartLines.add(cline);
	}

	public void removeProduct(Product product) {
		Iterator<CartLine> iter = cartLines.iterator();
		while (iter.hasNext()){
			CartLine cline = iter.next();
			if (cline.getProduct().getProductNumber().equals(product.getProductNumber())){
				if (cline.getQuantity()>1){
					cline.setQuantity(cline.getQuantity()-1);
				}
				else{
					iter.remove();
				}
			}
		}
	}

	// get total price
	public double getT(){
		double totalPrice = 0.0;
		for (CartLine cartLine : cartLines) {
			totalPrice=totalPrice+(cartLine.getProduct().getPrice() * cartLine.getQuantity());
		}
		return totalPrice;
	}
}
