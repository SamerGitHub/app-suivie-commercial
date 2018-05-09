package com.example.demo.web;

import com.example.demo.firebase.FcmPushTest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TestFireBaseNotification {


    @GetMapping("/testFirebase")
    public String pushNotification()
    {


        List<String>stringList=new ArrayList<>();
        stringList.add("f2cZIwtJM3c:APA91bFraY2HE1ZpBaf1OYELWfmf_-dHbdd49bhnJo63X-J2j0ng5rjgeOxBdzqQm1EcLlk7AKnqV9JLZr4JgngGCXQtxQocI_ExZD-WQut4H3EfR9ql0Nhy5QINs_MS9TJdrafC_ud2");
        //stringList.add("mohammed");
        try {
            String response= FcmPushTest.pushFCMNotification(stringList,123456L);
            System.out.println("response :: "+response);
        }
        catch (Exception ex)
        {
            System.out.println("message Exeption : "+ex.getMessage());
        }

        return "hello";
    }

}
