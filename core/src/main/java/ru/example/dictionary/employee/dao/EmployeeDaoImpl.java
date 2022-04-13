package ru.example.dictionary.employee.dao;

import org.hibernate.Session;
import ru.example.dictionary.employee.entity.EmployeeEntity;
import ru.example.dictionary.util.HibernateUtil;

import javax.ejb.Singleton;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@Singleton
public class EmployeeDaoImpl implements EmployeeDao {

    public List<EmployeeEntity> list(List<Integer> ids) {
        final Session session = HibernateUtil.getSessionFactory().openSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<EmployeeEntity> criteria = builder.createQuery(EmployeeEntity.class);
        criteria.from(EmployeeEntity.class);
        List<EmployeeEntity> employees = session.createQuery(criteria).getResultList();

        session.close();
        return employees;
    }

}
