package ru.example.dictionary.employee.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee_address", schema = "dictionary")
@Getter
@Setter
public class EmployeeAddressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Basic
    @Column(name = "employee_id")
    private Integer employeeId;
    private String postcode;
    private String city;
    private String street;
    private String house;
    private String apartment;

}
