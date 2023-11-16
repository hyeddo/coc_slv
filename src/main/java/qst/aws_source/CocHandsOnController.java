package qst.aws_source;

import coc.handson.dto.CocHelloRequest;
import coc.handson.dto.CocHelloResponse;
import coc.handson.queue.CocHandsOnKafka;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/v1")
@Slf4j
@RequiredArgsConstructor
public class CocHandsOnController implements CocHandsOnApi {


    private final CocHandsOnKafka cocHandsOnKafka;

    //private final static Logger log = LoggerFactory.getLogger(CocHandsOnController.class);
    @Override
    public ResponseEntity<?> hello(CocHelloRequest cocHelloRequest) {
        CocHelloResponse cocHelloResponse = new CocHelloResponse();

        cocHelloResponse.setId(cocHelloRequest.getId());
        cocHelloResponse.setName(cocHelloRequest.getName());
        cocHelloResponse.setTeam(cocHelloRequest.getTeam());
        cocHelloResponse.setMessage(String.format("Hello, %s!", cocHelloRequest.getName()));
        cocHelloResponse.setTimestamp(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

        cocHandsOnKafka.produceMessage(cocHelloRequest);

        log.info(" response == > {} ", cocHelloResponse);
        return ResponseEntity.ok(cocHelloResponse);
    }
}
