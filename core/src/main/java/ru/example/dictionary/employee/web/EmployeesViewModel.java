package ru.example.dictionary.employee.web;

import org.zkoss.bind.annotation.Init;
import ru.example.dictionary.employee.entity.EmployeeEntity;
import ru.example.dictionary.employee.service.EmployeeService;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.List;

//@VariableResolver(org.zkoss.zkplus.jndi.JndiVariableResolver.class)
public class EmployeesViewModel {

    private List<EmployeeEntity> employeeList;
    private Context context;
    private EmployeeService employeeService;

    @Init
    public void init() throws NamingException {
        context = new InitialContext();
        employeeService = (EmployeeService) context.lookup("java:app/core/EmployeeService");
        employeeList = employeeService.getEmployees(null);
    }

    public List<EmployeeEntity> getEmployeeList() {
        return employeeList;
    }

}

