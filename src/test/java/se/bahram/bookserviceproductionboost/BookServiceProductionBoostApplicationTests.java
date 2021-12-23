package se.bahram.bookserviceproductionboost;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(properties = "spring.datasource.url=jdbc:tc:postgresql:13:///")
class BookServiceProductionBoostApplicationTests {

    @Autowired
    WebTestClient webTestClient;

    @Test
    void contextLoads() {
        var bookToCreate = new Book(null, "The Hobbit");

        webTestClient
                .post()
                .uri("/books")
                .bodyValue(bookToCreate)
                .exchange()
                .expectStatus()
                .is2xxSuccessful()
                .expectBody(Book.class).value(actualBook -> {
                    assertThat(actualBook.id()).isNotNull();
                    assertThat(actualBook.title()).isEqualTo(bookToCreate.title());
                });
    }

}
