package qst.aws_source;

import coc.handson.dto.CocHelloRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;

public class MessageDeserializer implements Deserializer<CocHelloRequest> {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public CocHelloRequest deserialize(String s, byte[] bytes) {
        try {
            return objectMapper.readValue(new String(bytes), CocHelloRequest.class);
        } catch (JsonProcessingException e) {
            System.out.println(e.getOriginalMessage());
            throw new SerializationException(e);
        }
    }
}
