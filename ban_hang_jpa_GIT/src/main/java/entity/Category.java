package entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Category")
@NamedQuery(name="Category.findAll", query="SELECT c FROM Category c")
public class Category implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CategoryID")
	private int categoryID;
	
	@Column(name = "categoryName", columnDefinition = "nvarchar(200)")
	private String categoryName;
	@Column(name = "icon", columnDefinition = "nvarchar(200)")
	private String icon;
	@OneToMany(mappedBy = "category")
	private List<Product> products;
	
	public int getCategoryID() {
		return categoryID;
	}
	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	public Category(int categoryID, String categoryName, String icon, List<Product> products) {
		super();
		this.categoryID = categoryID;
		this.categoryName = categoryName;
		this.icon = icon;
		this.products = products;
	}
	public Category() {
		super();
	}
	@Override
	public String toString() {
		return "Category [categoryID=" + categoryID + ", categoryName=" + categoryName + ", icon=" + icon
				+ ", products=" + products + "]";
	}
	
	
	
	
}
