package de.demo.statechange.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import de.demo.statechange.domain.CreateEmployeeDto;
import de.demo.statechange.domain.Employee;
import de.demo.statechange.domain.State;
import de.demo.statechange.repository.EmployeeRepository;
import java.util.Optional;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class EmployeeServiceTest {

  private EmployeeService employeeService;
  private EmployeeRepository repo;

  @Before
  public void init() {
    employeeService = new EmployeeService();
    repo = mock(EmployeeRepository.class);
    employeeService.setEmployeeRepository(repo);
  }

  @Test
  public void testCreateEmployee() {
    CreateEmployeeDto createEmployeeDto = new CreateEmployeeDto();
    createEmployeeDto.setEmail("test@test.de");
    createEmployeeDto.setName("Name");
    createEmployeeDto.setSurname("Surname");
    assertTrue(employeeService.createEmployee(createEmployeeDto));
  }

  @Test
  public void testEditEmployee() {
    when(repo.findById(eq(1))).thenReturn(Optional.of(new Employee(1, "name",
        "surname", "email@email.com", State.ADDED)));
    assertTrue(employeeService.editEmployee(1, State.ACTIVE));
  }


}
