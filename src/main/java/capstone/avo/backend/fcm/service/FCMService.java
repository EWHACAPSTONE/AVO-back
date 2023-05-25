package capstone.avo.backend.fcm.service;

import capstone.avo.backend.fcm.dto.FCMMessageDto;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class FCMService {
    private final FirebaseMessaging firebaseMessaging;

    public String sendNotification(FCMMessageDto messageDto){
        /*
        Notification notification=Notification.builder()
                .setTitle(messageDto.getTitle())
                .setBody(messageDto.getBody())
                .build();
        Message message = Message.builder()
                .setToken("daqE6Gf2Q6m-XJDrrerDQW:APA91bFOLwMdZUDFbmlPPEkgxJ2OzmFRc8eUGofbwyk9ZsEZz4tNfm0Lfyewz9fwfElwTgVhx42_uokiWBPVRWpT9KUvWR46Dv_5muVbKPticv7vnF4-wW3lWISnJQv_BozZUV27zf4e")
                .setNotification(notification)
                .build();

         */
        Map<String, String> data = new HashMap<>();
        data.put("title", messageDto.getTitle());
        data.put("body", messageDto.getBody());
        Message message = Message.builder()
                .setToken("daqE6Gf2Q6m-XJDrrerDQW:APA91bFOLwMdZUDFbmlPPEkgxJ2OzmFRc8eUGofbwyk9ZsEZz4tNfm0Lfyewz9fwfElwTgVhx42_uokiWBPVRWpT9KUvWR46Dv_5muVbKPticv7vnF4-wW3lWISnJQv_BozZUV27zf4e")
                .putAllData(data)
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