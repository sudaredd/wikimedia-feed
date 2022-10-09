package com.example.consumerdatabase;

import com.example.consumerdatabase.entity.WikimediaData;
import com.example.consumerdatabase.repository.WikimediaDataRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class WikimediaKafkaConsumer {


    private WikimediaDataRepository dataRepository;

    public WikimediaKafkaConsumer(WikimediaDataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    @KafkaListener(
        topics = "${spring.kafka.topic.name}",
        groupId = "${spring.kafka.consumer.group-id:wki-feed-comsumer}"
    )
    public void onMessage(String eventMessage){

        log.info(String.format("Event message received -> %s", eventMessage));

        WikimediaData wikimediaData = new WikimediaData();
        wikimediaData.setWikiEventData(eventMessage);

        dataRepository.save(wikimediaData);
    }
}
