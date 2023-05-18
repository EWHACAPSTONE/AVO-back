package capstone.avo.backend.fcm.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class FCMMessageDto {
    private String title;
    private String body;

    @Builder
    public FCMMessageDto(String title, String body){
        this.title=title;
        this.body=body;
    }
}
