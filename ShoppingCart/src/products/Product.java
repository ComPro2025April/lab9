package products;

public class Product {
	private String productNumber;
	private Double price;
	private String description;

	public Product(String productNumber, Double price, String description) {
		this.productNumber = productNumber;
		this.price = price;
		this.description = description;
	}

	public String getProductNumber() {
		return productNumber;
	}

	public void setProductNumber(String productNumber) {
		this.productNumber = productNumber;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
