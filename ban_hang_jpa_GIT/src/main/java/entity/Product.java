package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "Product")
//@NamedQuery(name="Product.findAll", query="SELECT c FROM Product c")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ProductID")
    private int productID;

    @Column(name = "ProductName", columnDefinition = "nvarchar(1000)")
    private String productName;

    @Column(name = "Description", columnDefinition = "nvarchar(2000)")
    private String description;

    @Column(name = "Price")
    private int price;

    @Column(name = "imageLink", columnDefinition = "nvarchar(1000)")
    private String imageLink;

    @ManyToOne
    @JoinColumn(name = "CategoryID", nullable = false, insertable = false, updatable = false)
    private Category category;

    @Column(name = "SellerID")
    private int sellerID;

    @Column(name = "Amount")
    private int amount;

    @Column(name = "stoke")
    private int stoke;

    
	public Product() {
		super();
	}

	public Product(int productID, String productName, String description, int price, String imageLink,
			Category category, int sellerID, int amount, int stoke) {
		super();
		this.productID = productID;
		this.productName = productName;
		this.description = description;
		this.price = price;
		this.imageLink = imageLink;
		this.category = category;
		this.sellerID = sellerID;
		this.amount = amount;
		this.stoke = stoke;
	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getImageLink() {
		return imageLink;
	}

	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public int getSellerID() {
		return sellerID;
	}

	public void setSellerID(int sellerID) {
		this.sellerID = sellerID;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getStoke() {
		return stoke;
	}

	public void setStoke(int stoke) {
		this.stoke = stoke;
	}

	@Override
	public String toString() {
		return "Product [productID=" + productID + ", productName=" + productName + ", description=" + description
				+ ", price=" + price + ", imageLink=" + imageLink + ", category=" + category + ", sellerID=" + sellerID
				+ ", amount=" + amount + ", stoke=" + stoke + "]";
	}

    // Getters and setters
    
}
