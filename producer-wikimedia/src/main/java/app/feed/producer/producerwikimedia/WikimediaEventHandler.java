package app.feed.producer.producerwikimedia;

import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.MessageEvent;
import org.springframework.kafka.core.KafkaTemplate;

public class WikimediaEventHandler implements EventHandler {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final String topic;

    public WikimediaEventHandler(KafkaTemplate<String, String> kafkaTemplate, String topic) {
        this.kafkaTemplate = kafkaTemplate;
        this.topic = topic;
    }
    @Override
    public void onOpen() {

    }

    @Override
    public void onClosed() {

    }

    @Override
    public void onMessage(String s, MessageEvent messageEvent) {
        kafkaTemplate.send(topic, s);
    }

    @Override
    public void onComment(String s) {

    }

    @Override
    public void onError(Throwable throwable) {

    }
}
