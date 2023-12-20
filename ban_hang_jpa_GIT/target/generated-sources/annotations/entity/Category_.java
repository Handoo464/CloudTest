package entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Category.class)
public abstract class Category_ {

	public static volatile SingularAttribute<Category, String> icon;
	public static volatile SingularAttribute<Category, String> categoryName;
	public static volatile SingularAttribute<Category, Integer> categoryID;
	public static volatile ListAttribute<Category, Product> products;

	public static final String ICON = "icon";
	public static final String CATEGORY_NAME = "categoryName";
	public static final String CATEGORY_ID = "categoryID";
	public static final String PRODUCTS = "products";

}

