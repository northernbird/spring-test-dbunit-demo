package rmi.demo.springtestdbunitdemo.api.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringJUnit4ClassRunner.class)
public class DemoControllerIntegrationTest extends BaseControllerIntegrationTest {

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private HttpHeaders userHeader;

  /**
   * TestCase: Return all event resources found by receptionNumber.
   */
  @Test
//  @DatabaseSetup(value = "/event/ReadEventTest/testdata.xml")
  public void test_get_events_find_by_receptionNumber() throws Exception {

    String request = "{\n" +
        "  \"description\": \"Adam Smith was an 18th-century Scottish economist, philosopher, and author\",\n" +
        "  \"name\": \"Adam Smith\"\n" +
        "}";

    MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/demo")
        .headers(userHeader)
        .contentType(MediaType.APPLICATION_JSON)
        .content(request))
        .andExpect(status().isCreated())
        .andReturn();

  }


}
