package cs157a.retailinWebApp.dao;

import java.util.List;

import cs157a.retailinWebApp.entity.Department;
import cs157a.retailinWebApp.entity.Users;

public interface DepartmentDAO {
	public List<Department> getDepartments();
	public void  saveDepartment(Department theDeparment);
	public Department getDepartment(Integer deptID);
	public void deleteDepartment(Integer deptID);
}
