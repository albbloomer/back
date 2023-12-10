package com.company.processor.publish;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import org.springframework.stereotype.Component;

@Component
public class SqsPublisher {

    private static final int DELAY_SECONDS = 0;

    private final AmazonSQS sqs;
    private static final String QUERY_URL = " ";

    public SqsPublisher() {
        this.sqs = AmazonSQSClientBuilder.defaultClient();
    }

    public void sendMessage(final String message) {
        SendMessageRequest sendMessageRequest = new SendMessageRequest()
                .withQueueUrl(QUERY_URL)
                .withMessageBody(message)
                .withDelaySeconds(DELAY_SECONDS);
        sqs.sendMessage(sendMessageRequest);
    }
}