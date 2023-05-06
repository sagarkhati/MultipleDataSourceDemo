package com.ssk.db1.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ssk.db1.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
