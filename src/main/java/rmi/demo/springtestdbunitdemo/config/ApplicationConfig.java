package rmi.demo.springtestdbunitdemo.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ApplicationConfig {

  @Bean
  @Scope("singleton")
  public ModelMapper getModelMapper() {
    ModelMapper modelMapper = new ModelMapper();
    return modelMapper;
  }

}
