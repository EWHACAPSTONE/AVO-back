package capstone.avo.backend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

@RestController
@RequestMapping("/status")
@RequiredArgsConstructor
public class AvoController {

    @GetMapping
    @ResponseStatus(value= HttpStatus.OK)
    public String returnStatus(){
        JsonObject obj = new JsonObject();
        obj.addProperty("status", "shouting");
        return obj.toString();
    }
}
