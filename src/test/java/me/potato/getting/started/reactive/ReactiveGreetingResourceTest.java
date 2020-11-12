package me.potato.getting.started.reactive;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsStringIgnoringCase;

import io.quarkus.test.junit.QuarkusTest;
import javax.ws.rs.core.Response.Status;
import org.junit.jupiter.api.Test;

@QuarkusTest
class ReactiveGreetingResourceTest {

  @Test
  void helloTest() {
    given().get(ReactiveGreetingResource.ROOT_PATH)
           .then()
           .statusCode(Status.OK.getStatusCode())
           .body(containsStringIgnoringCase("hello"));

  }

  @Test
  void greetingTest() {
    given().pathParam("name", "potato")
           .get(ReactiveGreetingResource.ROOT_PATH + ReactiveGreetingResource.GREETING_PATH + "/{name}")
           .then()
           .statusCode(Status.OK.getStatusCode())
           .body(containsStringIgnoringCase("potato"));
  }

  @Test
  void greetingsTest() {
    given().pathParam("count", 10)
           .pathParam("name", "potato")
           .get(ReactiveGreetingResource.ROOT_PATH + ReactiveGreetingResource.GREETING_PATH + "/{count}/{name}")
           .then()
           .statusCode(Status.OK.getStatusCode())
           .body(containsStringIgnoringCase("9"))
           .body(containsStringIgnoringCase("potato"));
  }
}