package rmi.demo.springtestdbunitdemo.api.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@Getter
@Setter
public class DemoCreateDto {

  @NotBlank
  @ApiModelProperty(dataType = "string",
      value = "Name property",
      example = "Adam Smith",
      required = true)
  private String name;

  @NotBlank
  @ApiModelProperty(dataType = "string",
      value = "Description property",
      example = "Adam Smith was an 18th-century Scottish economist, philosopher, and author",
      required = true)
  private String description;

}
