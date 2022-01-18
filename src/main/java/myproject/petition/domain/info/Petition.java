package myproject.petition.domain.info;

import lombok.Data;

@Data
public class Petition {


    private Long id;
    private String subject;
    private String field;
    private String content;
    //private Integer count; //청원자 수

    public Petition() { }

    public Petition(String subject, String field, String content) {
        this.subject = subject;
        this.field = field;
        this.content = content;
    }
}
