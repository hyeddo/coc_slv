package qst.aws_source;

import coc.handson.dto.CocHelloRequest;
import coc.handson.dto.CocHelloResponseV2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v2")
@Slf4j
public class CocHandsOnControllerV2 implements CocHandsOnApi{
    @Override
    public ResponseEntity<?> hello(CocHelloRequest cocHelloRequest) {
        return ResponseEntity.ok(new CocHelloResponseV2(cocHelloRequest.getId(), cocHelloRequest.getName(), "이것은 버전2"));
    }
}
