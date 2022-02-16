/*package unittest;


import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import employeDao.EmployeImp;
import entity.Employe;


class Emptest {

	private EmployeImp empimp;
	@Test
	void testSaveEmployee() {
		
		Employe employe = new Employe();
		
		employe.setEmail("hamim@jammil");
		employe.setFirstName("dani");
		employe.setLastName("drakula");
		employe.setPassword("azerty");
		
		EmployeImp EmpImp = new EmployeImp();
		EmpImp.saveEmployee(employe);
		
		List<Employe> listemp = EmpImp.getEmployes();
		
		Assert.assertEquals(employe.getFirstName(),listemp.get(1).getFirstName());
		
	}

	
	@Test
	void testGetEmpById() {
		 Employe emp = empimp.getEmpById(1);
		    Assert.assertNotNull(emp);
	        Assert.assertEquals("jamal", emp.getEmail());
	        Assert.assertEquals("Mahmoudy", emp.getLastName());
	        
	}
    
}

*/
