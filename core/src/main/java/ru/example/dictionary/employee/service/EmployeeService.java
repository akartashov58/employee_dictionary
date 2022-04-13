package ru.example.dictionary.employee.service;

import ru.example.dictionary.employee.dao.EmployeeDao;
import ru.example.dictionary.employee.entity.EmployeeEntity;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.util.List;

@Singleton
@Startup
@LocalBean
public class EmployeeService {

    @EJB
    private EmployeeDao employeeDao;

    public List<EmployeeEntity> getEmployees(List<Integer> ids) {
        return employeeDao.list(ids);
    }

}
