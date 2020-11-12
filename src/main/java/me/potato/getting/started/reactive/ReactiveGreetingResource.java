package me.potato.getting.started.reactive;

import io.smallrye.mutiny.Uni;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import lombok.RequiredArgsConstructor;

@Path(ReactiveGreetingResource.ROOT_PATH)
@RequiredArgsConstructor
public class ReactiveGreetingResource {

  public static final String ROOT_PATH     = "/hello";
  public static final String GREETING_PATH = "/greeting";

  private final ReactiveGreetingService service;


  // sync
  @GET
  @Produces(MediaType.TEXT_PLAIN)
  public String hello() {
    return "hello world";
  }

  @GET
  @Path(GREETING_PATH + "/{name}")
  @Produces(MediaType.TEXT_PLAIN)
  public Uni <String> getGreeting(@PathParam("name") String name) {
    return service.greeting(name);
  }

}
