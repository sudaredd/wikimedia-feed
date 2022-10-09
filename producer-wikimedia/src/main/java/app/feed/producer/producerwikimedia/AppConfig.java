package app.feed.producer.producerwikimedia;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.kafka.config.TopicBuilder;

import java.util.List;

@Configuration
public class AppConfig {

  @Value("${spring.kafka.topic.name}")
  private String topicName;

  @Bean
  @Primary
  KafkaProperties kafkaProperties(KafkaProperties kafkaProperties) {
    kafkaProperties.setBootstrapServers(List.of("DESKTOP-VMET04L:9092"));
    return kafkaProperties;
  }

  @Bean
  public NewTopic topic() {
    return TopicBuilder.name(topicName).build();
  }
}
