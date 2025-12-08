package com.example.finalwork.slice;

import com.example.finalwork.ResourceTable;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.components.Button;
import ohos.agp.components.Component;
import ohos.agp.components.TextField;
import ohos.agp.window.dialog.ToastDialog;
import ohos.hiviewdfx.HiLog;
import ohos.hiviewdfx.HiLogLabel;


import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.*;
;

public class SearchAbilitySlice extends AbilitySlice implements Component.ClickedListener {
    public static String API_URL = "http://apis.juhe.cn/simpleWeather/query";
    public static String API_KEY = "cf5f5a35e112f32480eeefe4fc1fa896";
    HiLogLabel label = new HiLogLabel(HiLog.INFO,12,"lsh");
    TextField cityTf;
    Button searchBtn,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn10;
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_search);
        initView();
        String city = intent.getStringParam("city");
        btn1.setText(city);
    }

    private void initView() {
        cityTf = findComponentById(ResourceTable.Id_search_tf1);
        searchBtn = findComponentById(ResourceTable.Id_b1);
        searchBtn.setClickedListener(this);
        btn1 = findComponentById(ResourceTable.Id_b2);
        btn2 = findComponentById(ResourceTable.Id_c1);
        btn3 = findComponentById(ResourceTable.Id_c2);
        btn4 = findComponentById(ResourceTable.Id_c3);
        btn5 = findComponentById(ResourceTable.Id_c4);
        btn6 = findComponentById(ResourceTable.Id_c5);
        btn7 = findComponentById(ResourceTable.Id_c6);
        btn8 = findComponentById(ResourceTable.Id_c7);
        btn9 = findComponentById(ResourceTable.Id_c8);
        btn10 = findComponentById(ResourceTable.Id_c9);
        btn1.setClickedListener(this);
        btn2.setClickedListener(this);
        btn3.setClickedListener(this);
        btn4.setClickedListener(this);
        btn5.setClickedListener(this);
        btn6.setClickedListener(this);
        btn7.setClickedListener(this);
        btn8.setClickedListener(this);
        btn9.setClickedListener(this);
        btn10.setClickedListener(this);
        //  loadData();
    }

    private void loadData(String queryParams) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                String response = doGet(API_URL, queryParams);
                try {
                        getMainTaskDispatcher().asyncDispatch(new Runnable() {
                            @Override
                            public void run() {
                                JSONObject jsonObject = JSONObject.fromObject(response);
                                System.out.println("调用接口成功");
                                JSONObject result = jsonObject.getJSONObject("result");
                                JSONObject realtime = result.getJSONObject("realtime");
                                JSONArray future = result.getJSONArray("future");
                                String cityname = result.getString("city");
                                String weather = (realtime.getString("info")) + " " + (realtime.getString("direct")+realtime.getString("power"))+("空气:" + realtime.getString("aqi"));
                                String temperature = (realtime.getString("temperature")) + "℃";
                                Intent intent = new Intent();
                                JSONObject o1 = future.getJSONObject(0);
                                JSONObject o2 = future.getJSONObject(1);
                                JSONObject o3 = future.getJSONObject(2);
                                JSONObject o4 = future.getJSONObject(3);
                                JSONObject o5 = future.getJSONObject(4);
                                String weather1 = o1.getString("weather");
                                String weather2 = o2.getString("weather");
                                String weather3 = o3.getString("weather");
                                String weather4 = o4.getString("weather");
                                String weather5 = o5.getString("weather");
                                intent.setParam("day1",weather1);
                                intent.setParam("day2",weather2);
                                intent.setParam("day3",weather3);
                                intent.setParam("day4",weather4);
                                intent.setParam("day5",weather5);
                                intent.setParam("city",cityname);
                                intent.setParam("weather",weather);
                                intent.setParam("temperature",temperature);
                                present(new WeatherInfoAbilitySlice(),intent);
                            }
                        });


                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    @Override
    public void onActive() {
        super.onActive();
    }

    @Override
    public void onForeground(Intent intent) {
        super.onForeground(intent);
    }
    @Override
    public void onClick(Component component) {
        switch (component.getId()){
            case ResourceTable.Id_b1:
                String city = cityTf.getText();
                String url =  queryWeather(city);
                loadData(url);
                break;
            case ResourceTable.Id_b2:
                String city2 = btn1.getText();
                String url2 =  queryWeather(city2);
                loadData(url2);
                break;
            case ResourceTable.Id_c1:
                String city3 = btn2.getText();
                String url3 =  queryWeather(city3);
                loadData(url3);
                break;
            case ResourceTable.Id_c2:
                String city4 = btn3.getText();
                String url4 =  queryWeather(city4);
                loadData(url4);
                break;
            case ResourceTable.Id_c3:
                String city5 = btn4.getText();
                String url5 =  queryWeather(city5);
                loadData(url5);
                break;
            case ResourceTable.Id_c4:
                String city6 = btn5.getText();
                String url6 =  queryWeather(city6);
                loadData(url6);
                break;
            case ResourceTable.Id_c5:
                String city7 = btn6.getText();
                String url7 =  queryWeather(city7);
                loadData(url7);
                break;
            case ResourceTable.Id_c6:
                String city8 = btn7.getText();
                String url8 =  queryWeather(city8);
                loadData(url8);
                break;
            case ResourceTable.Id_c7:
                String city9 = btn8.getText();
                String url9 =  queryWeather(city9);
                loadData(url9);
                break;
            case ResourceTable.Id_c8:
                String city10 = btn9.getText();
                String url10 =  queryWeather(city10);
                loadData(url10);
                break;
            case ResourceTable.Id_c9:
                String city11 = btn10.getText();
                String url11 =  queryWeather(city11);
                loadData(url11);
                break;
        }
    }

    private void showToast(String city) {
        new ToastDialog(this)
                .setText(city)
                .show();
    }

    private String queryWeather(String city) {
        Map<String,Object> params = new HashMap<>();
        params.put("city",city);
        params.put("key",API_KEY);
        String queryParams = urlencode(params);
       return  queryParams;
    }

    public static String urlencode(Map<String, ?> data) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, ?> i : data.entrySet()) {
            try {
                sb.append(i.getKey()).append("=").append(URLEncoder.encode(i.getValue() + "", "UTF-8")).append("&");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        String result = sb.toString();
        result = result.substring(0, result.lastIndexOf("&"));
        return result;
    }
    public static String doGet(String httpUrl, String queryParams) {
        HttpURLConnection connection = null;
        InputStream inputStream = null;
        BufferedReader bufferedReader = null;
        String result = null;// 返回结果字符串
        try {
            // 创建远程url连接对象
            URL url = new URL(new StringBuffer(httpUrl).append("?").append(queryParams).toString());
            // 通过远程url连接对象打开一个连接，强转成httpURLConnection类
            connection = (HttpURLConnection) url.openConnection();
            // 设置连接方式：get
            connection.setRequestMethod("GET");
            // 设置连接主机服务器的超时时间：15000毫秒
            connection.setConnectTimeout(5000);
            // 设置读取远程返回的数据时间：60000毫秒
            connection.setReadTimeout(6000);
            // 发送请求
            connection.connect();
            // 通过connection连接，获取输入流
            if (connection.getResponseCode() == 200) {
                inputStream = connection.getInputStream();
                // 封装输入流，并指定字符集
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
                // 存放数据
                StringBuilder sbf = new StringBuilder();
                String temp;
                while ((temp = bufferedReader.readLine()) != null) {
                    sbf.append(temp);
                    sbf.append(System.getProperty("line.separator"));
                }
                result = sbf.toString();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            if (null != bufferedReader) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != inputStream) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                connection.disconnect();// 关闭远程连接
            }
        }
        return result;
    }
}
