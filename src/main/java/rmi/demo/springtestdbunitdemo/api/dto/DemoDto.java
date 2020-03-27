package rmi.demo.springtestdbunitdemo.api.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@Getter
@Setter
public class DemoDto {

  private Long id;

  @NotBlank
  private String name;

  @NotBlank
  private String description;

}
