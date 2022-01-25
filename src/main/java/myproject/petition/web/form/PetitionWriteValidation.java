package myproject.petition.web.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Data
public class PetitionWriteValidation {

    @NotBlank(message = "청원 제목은 필수입니다.")
    private String subject;

    @NotEmpty(message = "청원 분야는 필수입니다.")
    private String field;

    @NotBlank(message = "청원 내용은 필수입니다.")
    private String content;
}
