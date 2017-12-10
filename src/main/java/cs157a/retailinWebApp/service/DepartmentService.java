package cs157a.retailinWebApp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import cs157a.retailinWebApp.entity.Department;

@Service
public interface DepartmentService {
	public List<Department> listDepartments();
	public void addDepartment(Department department);
	public void updateDepartment(Department department);
	public void deleteDepartment(Integer deptID);
	public Department getDepartmentById(Integer deptID);
}
