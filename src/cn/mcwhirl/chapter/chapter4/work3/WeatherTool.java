package cn.mcwhirl.chapter.chapter4.work3;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WeatherTool {
    private static final String USER_KEY = "你的高德天气key";

    public static void queryWeather(String cityCode) {
        try {
            // 构建请求URL
            String urlString = "https://restapi.amap.com/v3/weather/weatherInfo?city=" + cityCode + "&key=" + USER_KEY;
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            // 检查响应码
            int responseCode = conn.getResponseCode();
            if (responseCode != 200) {
                throw new RuntimeException("HTTP GET Request Failed with Error code : " + responseCode);
            }

            // 读取响应
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8")); // 确保设置了UTF-8编码
            StringBuilder response = new StringBuilder();
            String output;
            while ((output = in.readLine()) != null) {
                response.append(output);
            }
            in.close();

            // 打印响应内容
            String responseStr = response.toString();
            System.out.println("Response:- " + responseStr);

            // 使用fastjson解析JSON
            JSONObject jsonResponse = JSON.parseObject(responseStr);


            // 输出天气信息
            if ("1".equals(jsonResponse.getString("status"))) {
                JSONObject lives = jsonResponse.getJSONArray("lives").getJSONObject(0);
                System.out.println("城市: " + lives.getString("city"));
                System.out.println("天气: " + lives.getString("weather"));
                System.out.println("温度: " + lives.getString("temperature") + "°C");
                System.out.println("风向: " + lives.getString("winddirection"));
                System.out.println("风力: " + lives.getString("windpower") + "级");
                System.out.println("湿度: " + lives.getString("humidity"));
                System.out.println("发布时间: " + lives.getString("reporttime"));
            } else {
                System.out.println("查询失败，原因：" + jsonResponse.getString("info"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void weatherTool() {
        // 城市代码，比如北京的城市代码为：110000
        String cityCode = "420100";
        queryWeather(cityCode);
    }
}
