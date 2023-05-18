package capstone.avo.backend.fcm.controller;

import capstone.avo.backend.fcm.dto.FCMMessageDto;
import capstone.avo.backend.fcm.service.FCMService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/fcm")
public class FCMController {
    private final FCMService fcmService;

    @PostMapping()
    public String sendNotification(@RequestBody FCMMessageDto messageDto){
        return fcmService.sendNotification(messageDto);
    }
}
