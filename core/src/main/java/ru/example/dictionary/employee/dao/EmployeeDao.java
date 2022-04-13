package ru.example.dictionary.employee.dao;

import ru.example.dictionary.employee.entity.EmployeeEntity;

import javax.ejb.Local;
import java.util.List;

@Local
public interface EmployeeDao {

    List<EmployeeEntity> list(List<Integer> ids);
}
