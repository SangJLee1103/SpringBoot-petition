package myproject.petition.domain.info;

import lombok.Data;

@Data
public class Info {
    private Long id;
    private String subject;
    private String field;
    private String content;
    //private Integer count; //청원자 수

    public Info() { }

    public Info(String subject, String field, String content) {
        this.subject = subject;
        this.field = field;
        this.content = content;
    }
}
