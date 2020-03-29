package rmi.demo.springtestdbunitdemo.api.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
public class DemoDto {

  @NotBlank
  @ApiModelProperty(dataType = "integer",
      value = "ID",
      example = "1",
      required = true)
  private Long id;

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

  @NotNull
  @ApiModelProperty(dataType = "date",
      value = "createTimestamp",
      example = "2020/01/01",
      required = true)
  private LocalDateTime createTimestamp;

  @NotNull
  @ApiModelProperty(dataType = "date",
      value = "updateTimestamp",
      example = "2020/01/01",
      required = true)
  private LocalDateTime updateTimestamp;

  @NotBlank
  @ApiModelProperty(dataType = "string",
      value = "user",
      example = "create user",
      required = true)
  private String createUser;

  @NotBlank
  @ApiModelProperty(dataType = "string",
      value = "user",
      example = "update user",
      required = true)
  private String updateUser;

}
