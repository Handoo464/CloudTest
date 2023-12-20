package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import JPAConfig.JPAConfig;
import entity.Category;
public class CategoryDAO{
	
	public static void main(String[] args) {
        // Tạo một đối tượng Category để insert
        //Category category = new Category();
        //category.setCategoryName("Electronics");
        //category.setIcon("electronics-icon.png");
        //insert(category);
		
    }
	
	public List<Category> findAll() {
		EntityManager enma=JPAConfig.getEntityManager();
		TypedQuery<Category> query=enma.createNamedQuery("Category.findAll", Category.class);
		return query.getResultList();
	}
	
	public void insert(Category category) throws Exception{
		EntityManager enma=JPAConfig.getEntityManager();
		EntityTransaction trans=enma.getTransaction();
		try {
			trans.begin();
			enma.persist(category);
			trans.commit(); 
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
			throw e;
		}
		finally {
			enma.close();
		}
		
	}

	public void update(Category category) throws Exception{
		EntityManager enma=JPAConfig.getEntityManager();
		EntityTransaction trans=enma.getTransaction();
		try {
			trans.begin();
			enma.merge(category);
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
			throw e;
		}
		finally {
			enma.close();
		}
		
	}

	public Category findById(int categoryID) {
		EntityManager enma=JPAConfig.getEntityManager();
		Category category=enma.find(Category.class, categoryID);
		return category;
	}

	public void delete(int id) throws Exception{
		EntityManager enma=JPAConfig.getEntityManager();
		EntityTransaction trans=enma.getTransaction();
		try {
			trans.begin();
			Category category =enma.find(Category.class, id);
			if(category!=null)
			{
				enma.remove(category);
			}
			else
			{
				throw new Exception("Khong tim thay");
			}
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
			throw e;
		}finally {
			enma.close();
		}
		
	}

	public int count() {
		EntityManager enma=JPAConfig.getEntityManager();
		String jpql ="Select count(c) From Category c";
		javax.persistence.Query query=enma.createQuery(jpql);
		return ((Long)query.getSingleResult()).intValue();
	}


	public List<Category> findByCategoryNames(String categoryName) {
		EntityManager enma=JPAConfig.getEntityManager();
		String jpql ="Select c From Category Where c.categoryName like :categoryName";
		TypedQuery<Category> query=enma.createQuery(jpql,Category.class);
		query.setParameter("CategoryName","%"+ categoryName+ "%");
		return query.getResultList();
	}

	public List<Category> findAll(int page, int pagesize) {
		EntityManager enma=JPAConfig.getEntityManager();
		TypedQuery<Category> query=enma.createNamedQuery("Category.findAll", Category.class);
		query.setFirstResult(page*pagesize);
		query.setMaxResults(pagesize);
		return query.getResultList();
	}

}
