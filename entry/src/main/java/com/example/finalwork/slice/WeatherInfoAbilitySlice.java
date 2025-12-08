package com.example.finalwork.slice;

import com.example.finalwork.ResourceTable;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.components.Button;
import ohos.agp.components.Component;
import ohos.agp.components.Text;

public class WeatherInfoAbilitySlice extends AbilitySlice implements Component.ClickedListener {
    Text cityTv,temTv,conditionTv,day1Tv,day2Tv,day3Tv,day4Tv,day5Tv;
    Button btn1,btn2;
    Intent intent;
    Button life_btn1,life_btn2,life_btn3,life_btn4,life_btn5,life_btn6,life_btn7,life_btn8,life_btn9;
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_weatherinfo);
        initView();
        if(intent.getStringParam("weather")!=null){
            String city = intent.getStringParam("city");
            String weather = intent.getStringParam("weather");
            String temperature = intent.getStringParam("temperature");
            String day1 = intent.getStringParam("day1");
            String day2 = intent.getStringParam("day2");
            String day3 = intent.getStringParam("day3");
            String day4 = intent.getStringParam("day4");
            String day5 = intent.getStringParam("day5");
            cityTv.setText(city);
            conditionTv.setText(weather);
            temTv.setText(temperature);
            day1Tv.setText(day1);
            day2Tv.setText(day2);
            day3Tv.setText(day3);
            day4Tv.setText(day4);
            day5Tv.setText(day5);
        }
    }

    private void initView() {
        cityTv = findComponentById(ResourceTable.Id_weather_city_tv);
        temTv = findComponentById(ResourceTable.Id_weather_tem_tv);
        conditionTv = findComponentById(ResourceTable.Id_weather_condition_tv);
        day1Tv = findComponentById(ResourceTable.Id_weather_condition_tv1);
        day2Tv = findComponentById(ResourceTable.Id_weather_condition_tv2);
        day3Tv = findComponentById(ResourceTable.Id_weather_condition_tv3);
        day4Tv = findComponentById(ResourceTable.Id_weather_condition_tv4);
        day5Tv = findComponentById(ResourceTable.Id_weather_condition_tv5);
        life_btn1 = findComponentById(ResourceTable.Id_life_count_btn1);
        life_btn2 = findComponentById(ResourceTable.Id_life_count_btn2);
        life_btn3 = findComponentById(ResourceTable.Id_life_count_btn3);
        life_btn4 = findComponentById(ResourceTable.Id_life_count_btn4);
        life_btn5 = findComponentById(ResourceTable.Id_life_count_btn5);
        life_btn6 = findComponentById(ResourceTable.Id_life_count_btn6);
        life_btn7 = findComponentById(ResourceTable.Id_life_count_btn7);
        life_btn8 = findComponentById(ResourceTable.Id_life_count_btn8);
        life_btn9 = findComponentById(ResourceTable.Id_life_count_btn9);
        life_btn1.setClickedListener(this);
        life_btn2.setClickedListener(this);
        life_btn3.setClickedListener(this);
        life_btn4.setClickedListener(this);
        life_btn5.setClickedListener(this);
        life_btn6.setClickedListener(this);
        life_btn7.setClickedListener(this);
        life_btn8.setClickedListener(this);
        life_btn9.setClickedListener(this);
        btn1 = findComponentById(ResourceTable.Id_weather_btn1);
        btn1.setClickedListener(this);
        btn2 = findComponentById(ResourceTable.Id_weather_btn2);
        btn2.setClickedListener(this);
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
        switch (component.getId()) {
            case ResourceTable.Id_weather_btn1:
                intent = new Intent();
                intent.setParam("city",cityTv.getText());
                present(new SearchAbilitySlice(),intent);
                break;
            case ResourceTable.Id_weather_btn2:
                intent = new Intent();
                present(new WeatherTypeAbilitySlice(),intent);
                break;
            case ResourceTable.Id_life_count_btn1:
                intent = new Intent();
                String guomin = "guomin";
                intent.setParam("life",guomin);
                intent.setParam("city",cityTv.getText());
                present(new HealthAbilitySlice(),intent);
                break;
            case ResourceTable.Id_life_count_btn2:
                intent = new Intent();
                String cy = "chuanyi";
                intent.setParam("life",cy);
                intent.setParam("city",cityTv.getText());
                present(new HealthAbilitySlice(),intent);
                break;
            case ResourceTable.Id_life_count_btn3:
                intent = new Intent();
                String ssd = "shushidu";
                intent.setParam("life",ssd);
                intent.setParam("city",cityTv.getText());
                present(new HealthAbilitySlice(),intent);
                break;
            case ResourceTable.Id_life_count_btn4:
                intent = new Intent();
                String dy = "diaoyu";
                intent.setParam("life",dy);
                intent.setParam("city",cityTv.getText());
                present(new HealthAbilitySlice(),intent);
                break;
            case ResourceTable.Id_life_count_btn5:
                intent = new Intent();
                String gm = "ganmao";
                intent.setParam("life",gm);
                intent.setParam("city",cityTv.getText());
                present(new HealthAbilitySlice(),intent);
                break;
            case ResourceTable.Id_life_count_btn6:
                intent = new Intent();
                String zwx = "ziwaixian";
                intent.setParam("life",zwx);
                intent.setParam("city",cityTv.getText());
                present(new HealthAbilitySlice(),intent);
                break;
            case ResourceTable.Id_life_count_btn7:
                intent = new Intent();
                String xc = "xiche";
                intent.setParam("life",xc);
                intent.setParam("city",cityTv.getText());
                present(new HealthAbilitySlice(),intent);
                break;
            case ResourceTable.Id_life_count_btn8:
                intent = new Intent();
                String yd = "yundong";
                intent.setParam("life",yd);
                intent.setParam("city",cityTv.getText());
                present(new HealthAbilitySlice(),intent);
                break;
            case ResourceTable.Id_life_count_btn9:
                intent = new Intent();
                String ds = "daisan";
                intent.setParam("life",ds);
                intent.setParam("city",cityTv.getText());
                present(new HealthAbilitySlice(),intent);
                break;
        }
    }
}
