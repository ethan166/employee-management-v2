//package com.hteiktan.repository;
//
//import java.util.List;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.PersistenceUnit;
//import javax.persistence.Query;
//
//import org.springframework.context.annotation.Scope;
//import org.springframework.stereotype.Repository;
//
//import com.hteiktan.entity.AddressEntity;
//import com.hteiktan.entity.EmployeeEntity;
//
//@Repository("employeeRepository")
//@Scope("singleton")
//public class EmployeeRepositoryImpl implements EmployeeRepository {
//
//	
//	private EntityManagerFactory entityManagerFactory;
//	@PersistenceUnit
//	public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
//		this.entityManagerFactory = entityManagerFactory;
//	}
//	
//	public void insertEmployee(EmployeeEntity emp) {
//		EntityManager entityManager = this.entityManagerFactory.createEntityManager();	
//		entityManager.getTransaction().begin();
//		entityManager.persist(emp);
//		entityManager.getTransaction().commit();
//	}
//	
//	public int removeEmployee(int empId) {
//		//employee.remove(empId);
//		EntityManager entityManager = this.entityManagerFactory.createEntityManager();
//		entityManager.getTransaction().begin();
//		int result = 0;
//		try { 
//			EmployeeEntity emp = entityManager.find(EmployeeEntity.class, empId);
//			entityManager.remove(emp);
//			entityManager.getTransaction().commit();
//			result = 1;
//			
//		} catch (Exception exp) {
//			entityManager.getTransaction().rollback();
//		}
//		entityManager.close();
//		return result;
//	}
//
//    @Override
//	@SuppressWarnings("unchecked")
//	public List<EmployeeEntity> fetchEmployee() {
//		EntityManager entityManager = this.entityManagerFactory.createEntityManager();
//		//List<EmployeeEntity> result = (List<EmployeeEntity>) entityManager.createQuery("from employee").getResultList();
//	    //return result;
//		Query query = entityManager.createQuery("Select e from EmployeeEntity e");
//		return (List<EmployeeEntity>) query.getResultList();
//	}
//    
//    @Override
//    public void update(int empId, AddressEntity address) {
//    	EntityManager entityManager = this.entityManagerFactory.createEntityManager();
//    	entityManager.getTransaction().begin();
//    	EmployeeEntity emp = entityManager.find(EmployeeEntity.class, empId);
//    	emp.setAddress(address);
//    	entityManager.getTransaction().commit();
//    }
//}
//
