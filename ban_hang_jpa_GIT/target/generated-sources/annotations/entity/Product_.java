package entity;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Product.class)
public abstract class Product_ {

	public static volatile SingularAttribute<Product, String> imageLink;
	public static volatile SingularAttribute<Product, Integer> amount;
	public static volatile SingularAttribute<Product, Integer> stoke;
	public static volatile SingularAttribute<Product, Integer> sellerID;
	public static volatile SingularAttribute<Product, Integer> productID;
	public static volatile SingularAttribute<Product, Integer> price;
	public static volatile SingularAttribute<Product, String> description;
	public static volatile SingularAttribute<Product, Category> category;
	public static volatile SingularAttribute<Product, String> productName;

	public static final String IMAGE_LINK = "imageLink";
	public static final String AMOUNT = "amount";
	public static final String STOKE = "stoke";
	public static final String SELLER_ID = "sellerID";
	public static final String PRODUCT_ID = "productID";
	public static final String PRICE = "price";
	public static final String DESCRIPTION = "description";
	public static final String CATEGORY = "category";
	public static final String PRODUCT_NAME = "productName";

}

