package de.demo.statechange.controller;

import de.demo.statechange.domain.CreateEmployeeDto;
import de.demo.statechange.domain.Employee;
import de.demo.statechange.domain.EditEmployeeDto;
import de.demo.statechange.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

  private EmployeeService employeeService;

  @Autowired
  public void setEmployeeService(EmployeeService employeeService) {
    this.employeeService = employeeService;
  }

  @RequestMapping(method = RequestMethod.GET)
  @ResponseBody
  public Iterable<Employee> list() {
    return employeeService.listAllEmployees();
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  @ResponseBody
  public Employee getEmployeeById(@PathVariable Integer id) {
    return employeeService.getEmployeeById(id).orElse(null);
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.PATCH)
  @ResponseBody
  public boolean edit(@PathVariable Integer id,
      @RequestBody EditEmployeeDto employeeDto) {
    return employeeService.editEmployee(id, employeeDto.getState());
  }

  @RequestMapping(method = RequestMethod.POST)
  @ResponseBody
  public boolean createEmployee(@RequestBody CreateEmployeeDto createEmployeeDto) {
    return employeeService.createEmployee(createEmployeeDto);
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  @ResponseBody
  public boolean deleteEmployee(@PathVariable Integer id) {
    return employeeService.deleteEmployee(id);
  }

}
