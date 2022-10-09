package com.example.consumerdatabase;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class ConsumerDatabaseApplication {

  public static void main(String[] args) {
    SpringApplication.run(ConsumerDatabaseApplication.class, args);
  }

  @Slf4j
  @Component
  static class PrintBeans implements CommandLineRunner {

    @Autowired
    ApplicationContext applicationContext;

    @Override
    public void run(String... args) throws Exception {
      String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
      for (String bean : beanDefinitionNames) {
        log.info("bean=> {}", bean);
      }
    }
  }
}
