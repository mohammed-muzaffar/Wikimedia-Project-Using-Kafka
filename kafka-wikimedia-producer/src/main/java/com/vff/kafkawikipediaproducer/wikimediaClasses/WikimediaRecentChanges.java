package com.vff.kafkawikipediaproducer.wikimediaClasses;

import com.launchdarkly.eventsource.MessageEvent;
import org.apache.commons.logging.Log;
import org.apache.kafka.clients.consumer.internals.events.ApplicationEvent;
import org.apache.kafka.clients.consumer.internals.events.BackgroundEvent;
import com.launchdarkly.eventsource.EventHandler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

import java.io.IOException;
import java.util.Optional;

public class WikimediaRecentChanges implements EventHandler {

    private static final Logger logger = LoggerFactory.getLogger(WikimediaRecentChanges.class);

    private KafkaTemplate<String, String> kafkaTemplate;
    @Autowired
    private String topic;

    public WikimediaRecentChanges(KafkaTemplate<String, String> kafkaTemplate, String topic) {
        this.kafkaTemplate = kafkaTemplate;
        this.topic = topic;
    }


    @Override
    public void onOpen() throws Exception {

    }

    @Override
    public void onClosed() throws Exception {

    }

    @Override
    public void onMessage(String s, MessageEvent messageEvent) throws Exception {
        logger.info(String.format("event data %s", messageEvent.getData()));

        kafkaTemplate.send(topic, messageEvent.getData());
    }

    @Override
    public void onComment(String s) throws Exception {

    }

    @Override
    public void onError(Throwable throwable) {

    }
}
