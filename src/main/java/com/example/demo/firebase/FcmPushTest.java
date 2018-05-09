package com.example.demo.firebase;


import org.json.JSONArray;
import org.json.JSONObject;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class FcmPushTest {

    // Method to send Notifications from server to client end.

    public final static String AUTH_KEY_FCM = "AAAA4nxmkag:APA91bH4BV5vO_l3eZIZmXE45_p-ZgJcd7m8HsRTM_bxRw6VJxLhinoa_QVnZVqXG8-JWr_DVm1bjEsEix1MQoSAbJOMok0mNMMqskXs0QFLB42l2ibnKi08UEbF36sbm5nCjW_9GdHn";
    public final static String API_URL_FCM = "https://fcm.googleapis.com/fcm/send";

    // userDeviceIdKey is the device id you will query from your database

    public static String pushFCMNotification(List<String> putIds2/*, DemandeRequestDTO demandeRequestDTO*/, Long idDemande)
            throws Exception {
        String authKey = AUTH_KEY_FCM; // You FCM AUTH key
        String FMCurl = API_URL_FCM;

        URL url = new URL(FMCurl);
        HttpURLConnection vConnection = (HttpURLConnection) url.openConnection();

        vConnection.setUseCaches(true);
        vConnection.setDoInput(true);
        vConnection.setDoOutput(true);
        vConnection.setRequestMethod("POST");
        vConnection.setRequestProperty("Authorization", "key=" + authKey);
        vConnection.setRequestProperty("Content-Type", "application/json");
        vConnection.setRequestProperty("project_id", "972749705640");
        vConnection.setRequestProperty("Accept", "application/json");

        JSONObject json = new JSONObject();
        JSONObject info = new JSONObject();
        JSONObject infoData = new JSONObject();

        info.put("body","Il y a une Nouvelle mission"); // Notification body
        infoData.put("body",idDemande.toString());
        //info.put("title", "Demande de course");
        json.put("notification", info);
        json.put("data",infoData);

        System.out.println("***************************************************" + idDemande);
        /*
            "to" to send message for one device
         */
        //json.put("to", userDeviceIdKey.trim()); // deviceID

        JSONArray regId = null;
        regId = new JSONArray();
        for (String aPutIds2 : putIds2) {
            regId.put(aPutIds2);
        }
        /*
            "registration_ids" to send message for many devices
         */
        json.put("registration_ids", regId);

        vConnection.connect();
        try(OutputStreamWriter wr = new OutputStreamWriter(vConnection.getOutputStream())){

            wr.write(json.toString());
            wr.flush();
        }catch(Exception e){
            e.printStackTrace();
        }

        if (vConnection.getResponseCode() != HttpURLConnection.HTTP_OK) {
            throw new RuntimeException("Failed : HTTP error code : " + vConnection.getResponseCode());
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(
                (vConnection.getInputStream())));

        String output;
        String response = null;
        System.out.println("Output from Server .... \n");
        while ((output = br.readLine()) != null) {
            System.out.println(output);
            response=output;
        }

        vConnection.disconnect();
        return response;

    }




}
