package controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

import static org.assertj.core.api.BDDAssertions.then;

/**
 * @author lxp
 * @date 2019/6/26 下午7:33
 * @Version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(properties = {"management.server.port=1111"})
public class GreetingControllerTests {
    @LocalServerPort
    private int port;

    @Value("${local.management.port}")
    private int mgt;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void shouldReturn200WhenSendingRequestToController() {
        System.out.println(String.format("Port:%s",this.port));
        @SuppressWarnings("rawtypes")
        ResponseEntity<Map> entity = this.testRestTemplate
            .getForEntity("http://localhost:" + this.port + "/greeting", Map.class);
        then(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    public void shouldReturn200WhenSendingRequestToManagementEndpoint() {
        System.out.println(String.format("Port:%s",this.mgt));
        @SuppressWarnings("rawtypes")
        ResponseEntity<Map> entity = this.testRestTemplate
            .getForEntity("http://localhost:" + this.mgt + "/actuator/info", Map.class);
        then(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
}
