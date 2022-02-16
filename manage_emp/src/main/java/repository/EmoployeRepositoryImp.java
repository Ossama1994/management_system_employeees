package repository;


import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.Employe;
import hibernateUtil.Hibernateutil;

public class EmoployeRepositoryImp implements EmoployeRepositoryInt {
	
	
	@Override
	public Boolean validateEmail(String email,String password) {

	        try(Session session = Hibernateutil.getSessionFactory().openSession()){

  	            String Hql = "From Employe E WHERE E.email = :email";
	            
	            return session.createQuery(Hql, Employe.class)
	            		.setParameter("email", email)
	            		.stream()
	            		.filter(e -> e.getEmail().equals(email))
	            		.filter(e -> e.getPassword().equals(password))
	            		.findAny()
	            		.isPresent();
	            
	        } catch(Exception e) {
	        	e.printStackTrace();
	        }
	        return false;
	}

}
