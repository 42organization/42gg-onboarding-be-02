package onboarding2.be2.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDto {
    private long id;
    private String title;
    private String text;

    public ResponseDto(Long id, String title,String text) {
        this.id = id;
        this.title = title;
        this.text = text;
    }
}
