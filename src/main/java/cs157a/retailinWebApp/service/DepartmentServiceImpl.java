package cs157a.retailinWebApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cs157a.retailinWebApp.dao.DepartmentDAO;
import cs157a.retailinWebApp.entity.Department;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	@Autowired
	private DepartmentDAO deptDao;
	
	@Override
	public List<Department> listDepartments() {
		return deptDao.listDepartments();
	}

	@Override
	public void addDepartment(Department department) {
		deptDao.addDepartment(department);
	}

	@Override
	public void updateDepartment(Department department) {
		deptDao.updateDepartment(department);
	}

	@Override
	public void deleteDepartment(Integer deptID) {
		deptDao.deleteDepartment(deptID);
	}

	@Override
	public Department getDepartmentById(Integer deptID) {
		return deptDao.getDepartmentById(deptID);
	}

}
