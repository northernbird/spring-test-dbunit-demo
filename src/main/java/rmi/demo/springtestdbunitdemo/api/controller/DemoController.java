package rmi.demo.springtestdbunitdemo.api.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import rmi.demo.springtestdbunitdemo.api.constant.MediaTypeConstants;
import rmi.demo.springtestdbunitdemo.api.dto.DemoCreateDto;
import rmi.demo.springtestdbunitdemo.api.dto.DemoDto;
import rmi.demo.springtestdbunitdemo.db.entity.DemoEntity;
import rmi.demo.springtestdbunitdemo.service.DemoService;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.net.URI;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/demo")
@ApiResponses({
    @ApiResponse(code = 500,
        message = "Internal server error. Please contact system administrator"),
    @ApiResponse(code = 400, message = "Invalid request format. Please check request")
})
@Validated
public class DemoController {

  @Autowired
  private DemoService demoService;

  @Autowired
  private ModelMapper modelMapper;

  /**
   * Read all policy resource.
   * @return Corresponding HTTP response status code & messages
   */
  @ApiOperation(value = "Demo readAll method",
      notes = "Read all existing demo data",
      response = DemoDto.class)
  @ApiResponses(value = {
      @ApiResponse(code = 200,
          message = "success response",
          response = DemoDto.class,
          responseContainer = "List"),
  })
  @GetMapping(produces = MediaTypeConstants.APPLICATION_JSON_UTF8_VALUE)
  public ResponseEntity<List<DemoDto>> readAll() {
    List<DemoEntity> entities = demoService.findAll();
    List<DemoDto> resultList =
        Arrays.asList(modelMapper.map(entities, DemoDto[].class));

    return ResponseEntity.ok(resultList);
  }

  @ApiOperation(value = "Demo create method",
      notes = "Create new demo entity")
  @ApiResponses(value = {
      @ApiResponse(code = 201, message = "success response")})
  @PostMapping(consumes = MediaTypeConstants.APPLICATION_JSON_UTF8_VALUE)
  public ResponseEntity<Void> createDemo(@Valid @RequestBody DemoCreateDto request) {

    DemoEntity insertEntity = modelMapper.map(request, DemoEntity.class);
    demoService.create(insertEntity);

    /*
     * Create resource location
     */
    URI location = ServletUriComponentsBuilder.fromCurrentRequest()
        .path("/{id}")
        .buildAndExpand(insertEntity.getId())
        .toUri();
    return ResponseEntity.created(location).build();

  }

  @ApiOperation(value = "Demo update method",
      notes = "Update existing demo entity")
  @ApiResponses(value = {
      @ApiResponse(code = 204,
          message = "success response"),
      @ApiResponse(code = 404,
          message = "The given demo entity doesn't exist in service")
  })
  @PutMapping(value = "/{id}",
      consumes = MediaTypeConstants.APPLICATION_JSON_UTF8_VALUE)
  public ResponseEntity<Void> updateDemo(
      @PathVariable("id") @NotNull Long id,
      @Valid @RequestBody DemoCreateDto request) {

    DemoEntity demoEntity = demoService.find(id);
    modelMapper.map(request, demoEntity);
    demoService.update(demoEntity);

    return ResponseEntity.noContent().build();
  }


}
