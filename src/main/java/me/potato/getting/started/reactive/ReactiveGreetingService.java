package me.potato.getting.started.reactive;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import java.time.Duration;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ReactiveGreetingService {

  public Uni <String> greeting(String name) {
    return Uni.createFrom()
              .item(name)
              .onItem()
              .transform(n -> String.format("Hello %s", name));
  }


  public Multi <String> greetings(int count, String name) {
    return Multi.createFrom()
                .ticks()
                .every(Duration.ofSeconds(1))
                .onItem()
                .transform(n -> String.format("Hello %s - %d", name, n))
                .transform()
                .byTakingFirstItems(count);
  }
}
