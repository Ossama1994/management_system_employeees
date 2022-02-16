package employeDao;


import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.Employe;
import hibernateUtil.Hibernateutil;

public class EmployeImp implements EmpInterface {
	
	 public void saveEmployee(Employe employee) {
	        Transaction transaction = null;
	        try(Session session = Hibernateutil.getSessionFactory().openSession()){
	            transaction = session.beginTransaction();
	            session.save(employee);
	            transaction.commit();
	        } catch(Exception e) {
	            if(transaction != null) {
	                transaction.rollback();
	            }
	        }
	    }
	 
	 @SuppressWarnings("unchecked")
	public List<Employe> getEmployes() {
	        Transaction transaction = null;
	        List<Employe> emps = null;
	        try(Session session = Hibernateutil.getSessionFactory().openSession()){
	            transaction = session.beginTransaction();
	            
	            emps = session.createQuery("from Employe").list();
	            
	            transaction.commit();
	        } catch(Exception e) {
	            if(transaction != null) {
	                transaction.rollback();
	            }
	        }
	        return emps;
	        
	    }
	 public Employe getEmpById(long id) {
		 
	        Transaction transaction = null;
	        Employe emp = null ;
	        try(Session session = Hibernateutil.getSessionFactory().openSession()){
	            transaction = session.beginTransaction();
	            
	            emp = (Employe) session.get(Employe.class, id);
	            Hibernate.initialize(emp);
	            transaction.commit();
	        } catch(Exception e) {
	            if(transaction != null) {
	                transaction.rollback();
	            }
	        }
		 return emp;
	 }
	 
	 public Employe updateEmp(Employe emp) {
		 
		 Transaction transaction = null;
		 
	        try (Session session = Hibernateutil.getSessionFactory().openSession()) {
	            transaction = session.beginTransaction();
	            session.merge(emp);
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }
	  
	    return emp;
	    
	 }
	 public void deleteEmp(Long id) {

	        Transaction transaction = null;
	        try (Session session = Hibernateutil.getSessionFactory().openSession()) {
	        
	            transaction = session.beginTransaction();
	            Employe emp = session.get(Employe.class, id);
	            if (emp != null) {
	                session.delete(emp);
	                System.out.println("user is deleted");
	            }
	            
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }
	    }

	@Override
	public Employe getEmpByEmail(String email) {
		
        Transaction transaction = null;
        Employe emp = null ;
        try(Session session = Hibernateutil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            
            emp = (Employe) session.get(Employe.class, email);
            Hibernate.initialize(emp);
            transaction.commit();
        } catch(Exception e) {
            if(transaction != null) {
                transaction.rollback();
            }
        }
	 return emp;
	}
}
