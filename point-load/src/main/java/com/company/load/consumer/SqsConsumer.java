package com.company.load.consumer;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.amazonaws.services.sqs.model.Message;
import com.amazonaws.services.sqs.model.ReceiveMessageRequest;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SqsConsumer {

    private static final int MAX_NUMBER_OF_MESSAGE = 10;
    private static final int WAIT_TIME_SECONDS = 3;
    private static final String QUERY_URL = " ";

    private final AmazonSQS sqs;

    public SqsConsumer() {
        this.sqs = AmazonSQSClientBuilder.defaultClient();
    }

    public List<Message> receiveMessages() {
        ReceiveMessageRequest receiveMessageRequest = new ReceiveMessageRequest(QUERY_URL)
                .withMaxNumberOfMessages(MAX_NUMBER_OF_MESSAGE)
                .withWaitTimeSeconds(WAIT_TIME_SECONDS);
        return sqs.receiveMessage(receiveMessageRequest).getMessages();
    }
}