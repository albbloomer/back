package com.company.store.serializer;

import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.errors.SerializationException;

import java.util.Map;

public class CustomErrorHandlingDeserializer<T> implements Deserializer<T> {

    private final Deserializer<T> innerDeserializer;

    public CustomErrorHandlingDeserializer(Deserializer<T> innerDeserializer) {
        this.innerDeserializer = innerDeserializer;
    }

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
        innerDeserializer.configure(configs, isKey);
    }

    @Override
    public T deserialize(String topic, byte[] data) {
        try {
            return innerDeserializer.deserialize(topic, data);
        } catch (SerializationException e) {
            System.err.println("Deserialization error on topic: " + topic + ", data: " + new String(data) +
                    ", exception: " + e.getMessage());
            // Optional: Add fallback logic or rethrow exception
            return null; // Return null for bad data
        }
    }

    @Override
    public void close() {
        innerDeserializer.close();
    }
}
