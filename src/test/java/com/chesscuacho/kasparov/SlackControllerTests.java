package com.chesscuacho.kasparov;

import com.chesscuacho.kasparov.http.EvaluatorController;
import com.chesscuacho.kasparov.http.SlackController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SlackControllerTests {

    @Value(value = "${local.server.port}")
    private int port;

    @Autowired
    private SlackController controller;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void contextLoads() {
        assertThat(controller).isNotNull();
    }

    @Test
    public void evaluateShouldReturnResponseContaining() throws Exception {
        assertThat(this.restTemplate
                .getForObject("http://localhost:" + port + "/api/v1/slack-evaluate?entrada=ppp",
                        String.class))
                .contains("ppp");
    }
    @Test
    public void evaluateShouldReturnJsonResponse() throws Exception {
        String body = this.restTemplate
                .getForObject("http://localhost:" + port + "/api/v1/slack-evaluate?entrada=rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR",
                        String.class);

        assertThat(body).contains("respuesta");
    }
}
