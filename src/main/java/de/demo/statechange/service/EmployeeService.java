package de.demo.statechange.service;

import de.demo.statechange.domain.CreateEmployeeDto;
import de.demo.statechange.domain.Employee;
import de.demo.statechange.domain.State;
import de.demo.statechange.repository.EmployeeRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public void setEmployeeRepository(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Iterable<Employee> listAllEmployees() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> getEmployeeById(Integer id) {
        return employeeRepository.findById(id);
    }

    public boolean createEmployee(CreateEmployeeDto createEmployeeDto) {
        employeeRepository.save(new Employee(createEmployeeDto.getName(), createEmployeeDto.getSurname(),
            createEmployeeDto.getEmail(), State.ADDED));
        return true;
    }

    public boolean editEmployee(Integer id, State state) {
        Optional<Employee> employeeById = getEmployeeById(id);
        if (employeeById.isPresent()) {
            Employee employee = employeeById.get();
            employee.setState(state);
            employeeRepository.save(employee);
            return true;
        }
        return false;
    }

    public boolean deleteEmployee(Integer id) {
        employeeRepository.deleteById(id);
        return true;
    }

}
