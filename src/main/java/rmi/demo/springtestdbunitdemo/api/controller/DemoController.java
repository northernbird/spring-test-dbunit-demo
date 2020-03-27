package rmi.demo.springtestdbunitdemo.api.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import rmi.demo.springtestdbunitdemo.api.constant.MediaTypeConstants;
import rmi.demo.springtestdbunitdemo.api.dto.DemoCreateDto;
import rmi.demo.springtestdbunitdemo.db.entity.DemoEntity;
import rmi.demo.springtestdbunitdemo.service.DemoService;

import javax.validation.Valid;
import java.net.URI;

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


}
