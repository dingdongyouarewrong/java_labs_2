package by.gsu.pms.idz_9_json;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static java.lang.System.exit;


public class Runner {

    static final String LOCATION = "homel";
    public static void  main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        System.out.println("Due the security reason, we can not share our private Open Weather Key. " +
                "Please, entry your own key to use this program");
        String apiKey = keyboard.nextLine();
        System.out.println("Key is "+apiKey);
        String urlString = "http://api.openweathermap.org/data/2.5/weather?q=" + LOCATION + "&appid=" + apiKey + "&units =imperial";
        WidgetConstructor constructor = null;

        try{

            StringBuilder result = new StringBuilder();
            URL url = new URL(urlString);
            URLConnection conn = url.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null){
                result.append(line);
            }

            reader.close();
            System.out.println(result);

            Map<String, Object > respMap = jsonToMap (result.toString());
            Map<String, Object > mainMap = jsonToMap (respMap.get("main").toString());
            Map<String, Object > windMap = jsonToMap (respMap.get("wind").toString());
            Map<String, Object > sysMap = jsonToMap (respMap.get("sys").toString());
            Map<String, Object > weatherMap = ((Map) ((ArrayList) respMap.get("weather")).get(0));
            String city = respMap.get("name").toString();
            String country = sysMap.get("country").toString();
            String iconId = weatherMap.get("icon").toString();
            String iconUrl = "http://openweathermap.org/img/w/"+iconId+".png";
            String weatherDesriptionShort = String.valueOf(weatherMap.get("main"));
            String weatherDescriptionLong = String.valueOf(weatherMap.get("description"));
            int minTemp = (int) ((double) mainMap.get("temp_min") - 275);
            int maxTemp = (int) ((double) mainMap.get("temp_max") - 275);
            int currentTemp = (int) ((double) mainMap.get("temp") - 275);
            String humidity = String.valueOf(mainMap.get("humidity"));
            String pressure = String.valueOf(mainMap.get("pressure"));
            String windSpeed = String.valueOf(windMap.get("speed"));
            String windAngle = String.valueOf(windMap.get("deg"));
            Double clouds = (Double) ((Map<String, Object >) respMap.get("clouds")).get("all");
            constructor = new WidgetConstructor(city,
                                                country,
                                                iconUrl,
                                                weatherDesriptionShort,
                                                weatherDescriptionLong,
                                                minTemp,
                                                maxTemp,
                                                currentTemp,
                                                humidity,
                                                pressure,
                                                windSpeed,
                                                windAngle,
                                                clouds);
            System.out.println(constructor.getWidgetCode());

        }catch (IOException e){
            System.out.println(e.getMessage());
            exit(0);
        }

        System.out.println("Entry 'yes', if you want to save widget to the new file, and 'no' if you don't");
        String answer = keyboard.nextLine();
        if (answer.equals("yes")) {
            constructor.saveWidgetToFile();
        }


    }

    public static Map<String,Object> jsonToMap(String str){
        return new Gson().fromJson(str,new TypeToken<HashMap<String,Object>>() {}.getType());
    }
}
