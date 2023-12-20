package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import JPAConfig.JPAConfig;
import entity.Category;
import entity.Product;

public class ProductDAO {
	public static void main(String[] args) {
        // Create a new Product
        Product product = new Product();
        product.setProductName("Sample Product");
        product.setDescription("This is a sample product description.");
        product.setPrice(100);
        product.setImageLink("https://example.com/image.jpg");
        
        // Assuming you have a Category object, set it for the product
        Category category = new Category();
        category.setCategoryID(1);  // Set the actual category ID
        product.setCategory(category);
        
        product.setSellerID(123);  // Set the actual seller ID
        product.setAmount(50);
        product.setStoke(100);

        insert(product);
        }
	public static void insert(Product product) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA"); 
		EntityManager em=emf.createEntityManager();
		try
		{
			em.getTransaction().begin();
			em.persist(product);
			em.getTransaction().commit(); 
			System.out.println("them moi thanh cong");
		}
		catch (Exception e)
		{
			em.getTransaction().rollback(); 
			System.out.println("them moi that bai");
		}
	}
}
