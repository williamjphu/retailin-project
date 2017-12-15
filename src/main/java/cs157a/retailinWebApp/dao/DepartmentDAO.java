package cs157a.retailinWebApp.dao;

import java.util.List;

import cs157a.retailinWebApp.entity.Department;

public interface DepartmentDAO {
	public List<Department> listDepartments();
	public void addDepartment(Department department);
	public void updateDepartment(Department department);
	public void deleteDepartment(Integer deptID);
	public Department getDepartmentById(Integer deptID);
}
