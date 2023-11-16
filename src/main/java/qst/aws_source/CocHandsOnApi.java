package qst.aws_source;

import coc.handson.dto.CocHelloRequest;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface CocHandsOnApi {

    @Operation(summary = "#1. Hello, 이지연! API 만들기")
    @PostMapping("/hello")
    ResponseEntity<?> hello(@RequestBody CocHelloRequest cocHelloRequest);
}
