package de.demo.statechange.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateEmployeeDto {

  private Integer id;
  private String name;
  private String surname;
  private String email;
}
