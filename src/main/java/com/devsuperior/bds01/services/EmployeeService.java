package com.devsuperior.bds01.services;

import com.devsuperior.bds01.dto.EmployeeDTO;
import com.devsuperior.bds01.entities.Employee;
import com.devsuperior.bds01.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    @Transactional(readOnly = true)
    public Page<EmployeeDTO> findAll() {
        Page<Employee> result = repository.findAll(PageRequest.of(0, 10, Sort.by("name")));

        return result.map(EmployeeDTO::new);
    }
}
