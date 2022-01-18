package myproject.petition.validation;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class PetitionEditValidation {

    @NotNull
    private Long id;

    @NotBlank
    private String subject;

    @NotBlank
    private String field;

    @NotBlank
    private String content;
}
