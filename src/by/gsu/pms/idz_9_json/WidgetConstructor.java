package by.gsu.pms.idz_9_json;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;

public class WidgetConstructor {
    public WidgetConstructor(String city,
                             String country,
                             String iconUrl,
                             String weatherDesriptionShort,
                             String weatherDescriptionLong,
                             int minTemp, int maxTemp,
                             int currentTemp,
                             String humidity,
                             String pressure,
                             String windSpeed,
                             String windAngle,
                             Double clouds) {
        this.city = city;
        this.country = country;
        this.iconUrl = iconUrl;
        this.weatherDesriptionShort = weatherDesriptionShort;
        this.weatherDescriptionLong = weatherDescriptionLong;
        this.minTemp = minTemp;
        this.maxTemp = maxTemp;
        this.currentTemp = currentTemp;
        this.humidity = humidity;
        this.pressure = pressure;
        this.windSpeed = windSpeed;
        this.windAngle = windAngle;
        this.clouds = clouds;
    }

    String city;
    String country;
    String iconUrl;
    String weatherDesriptionShort;
    String weatherDescriptionLong;
    int minTemp;
    int maxTemp;
    int currentTemp;
    String humidity;
    String pressure;
    String windSpeed;
    String windAngle;
    Double clouds;

    @Override
    public String toString() {
        return "WidgetConstructor{" +
                "name='" + city + '\'' +
                ", country='" + country + '\'' +
                ", icon_url='" + iconUrl + '\'' +
                ", weatherDesriptionShort='" + weatherDesriptionShort + '\'' +
                ", weatherDescriptionLong='" + weatherDescriptionLong + '\'' +
                ", minTemp=" + minTemp +
                ", maxTemp=" + maxTemp +
                ", currentTemp=" + currentTemp +
                ", humidity='" + humidity + '\'' +
                ", pressure='" + pressure + '\'' +
                ", windSpeed='" + windSpeed + '\'' +
                ", windAngle='" + windAngle + '\'' +
                ", clouds=" + clouds +
                '}';
    }

    public String getWidgetCode() {
        String paragraphCloseTag = "</p>\n";
        return "<h3>Weather for "+ city +", "+country+"</h3>\n" +
                "<img class=\"weather-icon\" src=\""+iconUrl+"\">\n" +
                "<p>Краткое описание погоды: "+ weatherDesriptionShort +paragraphCloseTag +
                "<p>Расширенное описание погоды: "+ weatherDescriptionLong +paragraphCloseTag +
                "<p>Текущая температура в градусах Цельсия: "+ currentTemp +paragraphCloseTag +
                "<p>Давление в мм ртутного столба: "+ pressure +paragraphCloseTag +
                "<p>Влажность в процентах: "+ humidity +paragraphCloseTag +
                "<p>Минимальная температура за сегодня: "+ minTemp +paragraphCloseTag +
                "<p>Максимальная температура за сегодня: "+ maxTemp +paragraphCloseTag +
                "<p>Скорость ветра: "+ windSpeed +paragraphCloseTag +
                "<p>Направление ветра: "+ windAngle +paragraphCloseTag +
                "<p>Облачность в процентах: "+ clouds +paragraphCloseTag;
    }

    public void saveWidgetToFile() {
        String widgetCode = getWidgetCode();

        try (FileWriter myWriter = new FileWriter("Weather widget.html", Charset.forName("Windows-1251"))) {
            myWriter.write(widgetCode);
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }
}