package rmi.demo.springtestdbunitdemo.config;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;

@TestConfiguration
public class BasicTestConfig {
  @Bean
  HttpHeaders withUserInfo() {
    HttpHeaders headers = new HttpHeaders();
    headers.add("Authorization", "Basic dXNlcjpwYXNzd29yZA==");
    return headers;
  }
}
