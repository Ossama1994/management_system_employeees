package employeDao;

import java.util.List;

import entity.Role;

public interface RoleInterface {
	
	 void SaveRole(Role role);
	 List<Role> getRoles();
	 Role getRoleById(Long id);
	 Role updateRole(Role role);
	 void deleteRole(int id);
	 
}
