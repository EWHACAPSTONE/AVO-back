package capstone.avo.backend.flask;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

//RestController Annotation 안하면 경로 에러남
@RestController
@RequestMapping("/flask")
public class FlaskController {
    @GetMapping()
    @ResponseStatus(value=HttpStatus.OK)
    public String Test() {
        String url = "http://ec2-52-78-239-63.ap-northeast-2.compute.amazonaws.com:5000/";
        String sb = "";

        try {
            HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();
            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"));
            String line = null;
            while ((line = br.readLine()) != null) {
                sb = sb + line + "\n";
            }
            System.out.println("Flask에서 전달한 값 : ");
            if (sb.toString().contains("ok")) {
                System.out.println("test");
            }
            br.close();
            System.out.println("" + sb.toString()+"\n");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}
