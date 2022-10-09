package app.feed.producer.producerwikimedia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProducerWikimediaApplication implements CommandLineRunner {

  public static void main(String[] args) {
    SpringApplication.run(ProducerWikimediaApplication.class, args);
  }

  @Autowired private WikiMediaEventRegistrer wikiMediaEventRegistrer;

  @Override
  public void run(String... args) throws Exception {
    wikiMediaEventRegistrer.register();
  }
}
