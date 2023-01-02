package com.kafkasender.consumer;

import com.kafkasender.utilities.AppConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class KafkaConsumer {

    private static final Logger logger = LoggerFactory.getLogger(com.kafkasender.consumer.KafkaConsumer.class);

    @KafkaListener(topics = AppConstants.TOPIC_NAME, groupId = AppConstants.GROUP_ID)
    public void consume(String message){
        List<String> list = Arrays.stream(message.split(" "))
                        .collect(Collectors.toList());
        list.forEach(System.out::println);

        logger.info(String.format("Message received -> %s", message));
    }
}
