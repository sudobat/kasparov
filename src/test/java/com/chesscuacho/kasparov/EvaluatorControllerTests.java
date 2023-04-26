package com.chesscuacho.kasparov;

import com.chesscuacho.kasparov.http.EvaluatorController;
import com.chesscuacho.kasparov.http.EvaluatorResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class EvaluatorControllerTests {

    @Value(value = "${local.server.port}")
    private int port;

    @Autowired
    private EvaluatorController controller;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void contextLoads() {
        assertThat(controller).isNotNull();
    }

    @Test
    public void evaluateShouldReturnResponseContainingScore() throws Exception {
        assertThat(this.restTemplate
                .getForObject("http://localhost:" + port + "/api/v1/evaluate",
                        String.class))
                .contains("score");
    }
    @Test
    public void evaluateShouldReturnJsonResponse() throws Exception {
        String body = this.restTemplate
                .getForObject("http://localhost:" + port + "/api/v1/evaluate?fen=rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR",
                        String.class);

        assertThat(body).isEqualTo("{\"score\":0}");
    }
}
