package employeDao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.Role;
import hibernateUtil.Hibernateutil;

public class RoleImp implements RoleInterface{

	@Override
	public void SaveRole(Role role) {
		
	       Transaction transaction = null;
	        try(Session session = Hibernateutil.getSessionFactory().openSession()){
	            // start the transaction
	            transaction = session.beginTransaction();
	            // save employee
	            session.save(role);
	            // commit the transaction
	            transaction.commit();
	        } catch(Exception e) {
	            if(transaction != null) {
	                transaction.rollback();
	            }
	        }
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Role> getRoles() {
	    Transaction transaction = null;
        List<Role> role = null;
        try(Session session = Hibernateutil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            
            role = session.createQuery("from Role").list();
            
            transaction.commit();
        } catch(Exception e) {
            if(transaction != null) {
                transaction.rollback();
            }
        }
		return role;
	}

	@Override
	public Role getRoleById(Long id) {
		
		   Transaction transaction = null;
	        Role role = null ;
	        try(Session session = Hibernateutil.getSessionFactory().openSession()){
	            transaction = session.beginTransaction();
	            
	            role = (Role) session.get(Role.class, id);
	            Hibernate.initialize(role);
	            transaction.commit();
	        } catch(Exception e) {
	            if(transaction != null) {
	                transaction.rollback();
	            }
	        }
		return role;
	}

	@Override
	public Role updateRole(Role role) {
		
	       Transaction transaction = null;
	        try(Session session = Hibernateutil.getSessionFactory().openSession()){
	            transaction = session.beginTransaction();
	            session.update(role);
	            
	            transaction.commit();
	        } catch(Exception e) {
	            if(transaction != null) {
	                transaction.rollback();
	            }
	        }
		return role;
	}

	@Override
	public void deleteRole(int id) {
		 Transaction transaction = null;
	        try (Session session = Hibernateutil.getSessionFactory().openSession()) {
	        
	            transaction = session.beginTransaction();
	            Role role = session.get(Role.class, id);
	            if (role != null) {
	                session.delete(role);
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

}
