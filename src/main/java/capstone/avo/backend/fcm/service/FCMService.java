package capstone.avo.backend.fcm.service;

import capstone.avo.backend.fcm.dto.FCMMessageDto;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FCMService {
    private final FirebaseMessaging firebaseMessaging;

    public String sendNotification(FCMMessageDto messageDto){
        Notification notification=Notification.builder()
                .setTitle(messageDto.getTitle())
                .setBody(messageDto.getBody())
                .build();
        Message message = Message.builder()
                .setToken(messageDto.getToken())
                .setNotification(notification)
                .build();
        try{
            firebaseMessaging.send(message);
            return "알림 전송 성공";
        } catch(FirebaseMessagingException e){
            e.printStackTrace();
            return "알림 보내기 실패";
        }
    }

}