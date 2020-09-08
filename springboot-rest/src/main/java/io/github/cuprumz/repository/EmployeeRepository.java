package io.github.cuprumz.repository;

import io.github.cuprumz.model.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

}
