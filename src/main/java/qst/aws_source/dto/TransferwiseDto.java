package qst.aws_source.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransferwiseDto {
    private String sourceCurrency;
    private String targetCurrency;
    private Long sourceAmount;
    private Long targetAmount;
}

