package qst.aws_source.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class CocHelloResponseV2 {
    private Long shinhanId;
    private String name;
    private String memo;
}
