package qst.aws_source.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CocHelloResponse {
    private Long id;
    private String name;
    private String team;
    private String message;
    private String timestamp;
}
