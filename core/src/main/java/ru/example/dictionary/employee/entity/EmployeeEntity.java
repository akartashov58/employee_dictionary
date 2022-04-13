package ru.example.dictionary.employee.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "employee", schema = "dictionary")
@Getter
@Setter
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String surname;
    private String name;
    private String patronymic;
    private Integer phone;

    @OneToMany(mappedBy="employeeId", fetch = FetchType.EAGER)
    private List<EmployeeAddressEntity> address;

    public String getFullName() {
        StringBuilder builder = new StringBuilder();
        builder.append(surname);
        builder.append(" ");
        builder.append(name);
        builder.append(" ");
        if (patronymic != null) {
            builder.append(patronymic);
        }
        return builder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeEntity that = (EmployeeEntity) o;
        return surname.equals(that.surname) && name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(surname, name);
    }
}
