package qst.aws_source.queue;

import coc.handson.dto.CocHelloRequest;
import coc.handson.dto.TransferwiseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.net.URI;

@Component
@RequiredArgsConstructor
@Slf4j
public class CocHandsOnKafka {

    private final KafkaTemplate<String, Object> kafkaTemplate;
    private final WebClient webClient;

    public void produceMessage(CocHelloRequest cocHelloRequest){
        log.info(" == produce message == ");

        kafkaTemplate.send("coc.practice.23200227", "NEW", cocHelloRequest);

        log.info(" == send message == ");
    }

    @KafkaListener(topics = "coc.practice.23200227")
    public void consumeMessage(@Payload CocHelloRequest data,
                               @Header(name = KafkaHeaders.RECEIVED_KEY, required = false) String key,
                               @Header(name = KafkaHeaders.RECEIVED_TOPIC) String topic,
                               @Header(name = KafkaHeaders.RECEIVED_TIMESTAMP) long timestamp,
                               @Header(name = KafkaHeaders.OFFSET)long offset){
        log.info("listener ====== [{}] [{}] [{}] [{}] [{}]", key, topic, timestamp, offset, data.toString());

        if("NEW".equals(key))
        {
            String response = webClient.post()
                    .uri(URI.create("https://api.sandbox.transferwise.tech/v3/quotes"))
                    .bodyValue(new TransferwiseDto("USD", "KRW", 200L, null))
                    .exchangeToMono(clientResponse -> clientResponse.bodyToMono(String.class))
                    .block();
            kafkaTemplate.send("coc.submit", "23200227", response)
                    .whenCompleteAsync((result, ex) -> {
                        if( ex == null) {
                            log.info(" == 정상실행 == {}", result.getProducerRecord().key());
                        } else {
                            log.error(" == 에러발생 ==");
                        }
                    });

        }

    }
}
