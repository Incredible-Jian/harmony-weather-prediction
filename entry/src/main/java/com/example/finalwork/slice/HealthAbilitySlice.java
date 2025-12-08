package com.example.finalwork.slice;

import com.example.finalwork.ResourceTable;
import com.example.finalwork.bean.LifeCountBean;
import com.example.finalwork.utils.HealthInfoProvider;
import com.example.finalwork.utils.HttpUtils;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import net.sf.json.JSONObject;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.components.Button;
import ohos.agp.components.Component;
import ohos.agp.components.Text;
import ohos.agp.window.dialog.ToastDialog;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.example.finalwork.slice.SearchAbilitySlice.API_KEY;

public class HealthAbilitySlice extends AbilitySlice implements Component.ClickedListener {
    Text feelTv,titleTv;
    Text desTv;
    Button btn1;
    HealthInfoProvider provider;
    public static String API_URL = "http://apis.juhe.cn/simpleWeather/life";
    List<LifeCountBean.ResultDTO.LifeDTO> dtos = new ArrayList<>();
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_health);
        String city = intent.getStringParam("city");
        String url = queryHealth(city);
        String counttype = intent.getStringParam("life");
        loadData(url,counttype);
        initView();
    }

    private void loadData(String queryParams,String counttype) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                String response = HttpUtils.doGet(API_URL,queryParams);
                getMainTaskDispatcher().asyncDispatch(new Runnable() {
                    @Override
                    public void run() {
                        JSONObject jsonObject = JSONObject.fromObject(response);
                        JSONObject result = jsonObject.getJSONObject("result");
                        JSONObject life = result.getJSONObject("life");
                        JSONObject kongtiao = life.getJSONObject("kongtiao");
                        JSONObject guomin = life.getJSONObject("guomin");
                        JSONObject daisan = life.getJSONObject("daisan");
                        JSONObject xiche = life.getJSONObject("xiche");
                        JSONObject ziwaixian = life.getJSONObject("ziwaixian");
                        JSONObject yundong = life.getJSONObject("yundong");
                        JSONObject diaoyu = life.getJSONObject("diaoyu");
                        JSONObject shushidu = life.getJSONObject("shushidu");
                        JSONObject chuanyi = life.getJSONObject("chuanyi");
                        JSONObject ganmao = life.getJSONObject("ganmao");
                        if(counttype.equals("chuanyi")){
                            feelTv.setText(chuanyi.getString("v"));
                            desTv.setText(chuanyi.getString("des"));
                            titleTv.setText("穿衣");
                        }else if(counttype.equals("daisan")){
                            feelTv.setText(daisan.getString("v"));
                            desTv.setText(daisan.getString("des"));
                            titleTv.setText("带伞");
                        }else if(counttype.equals("diaoyu")){
                            feelTv.setText(diaoyu.getString("v"));
                            desTv.setText(diaoyu.getString("des"));
                            titleTv.setText("钓鱼");
                        }else if(counttype.equals("ganmao")){
                            feelTv.setText(ganmao.getString("v"));
                            desTv.setText(ganmao.getString("des"));
                            titleTv.setText("感冒");
                        }else if(counttype.equals("guomin")){
                            feelTv.setText(guomin.getString("v"));
                            desTv.setText(guomin.getString("des"));
                            titleTv.setText("过敏");
                        }else if(counttype.equals("kongtiao")){
                            feelTv.setText(kongtiao.getString("v"));
                            desTv.setText(kongtiao.getString("des"));
                            titleTv.setText("空调");
                        }else if(counttype.equals("shushidu")){
                            feelTv.setText(shushidu.getString("v"));
                            desTv.setText(shushidu.getString("des"));
                            titleTv.setText("舒适度");
                        }else if(counttype.equals("xiche")){
                            feelTv.setText(xiche.getString("v"));
                            desTv.setText(xiche.getString("des"));
                            titleTv.setText("洗车");
                        }else if(counttype.equals("yundong")){
                            feelTv.setText(yundong.getString("v"));
                            desTv.setText(yundong.getString("des"));
                            titleTv.setText("运动");
                        }else {
                            feelTv.setText(ziwaixian.getString("v"));
                            desTv.setText(ziwaixian.getString("des"));
                            titleTv.setText("紫外线");
                        }
                    }
                });
            }
        }).start();
    }

    private void initView() {
        btn1 = findComponentById(ResourceTable.Id_health_re);
        btn1.setClickedListener(this);
        feelTv = findComponentById(ResourceTable.Id_health_v_feel);
        desTv = findComponentById(ResourceTable.Id_health_des_s);
        titleTv = findComponentById(ResourceTable.Id_health_title);
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
        if(component.getId() == ResourceTable.Id_health_re){
            Intent intent = new Intent();
            present(new WeatherInfoAbilitySlice(),intent);
        }
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
    private void showToast(String city) {
        new ToastDialog(this)
                .setText(city)
                .show();
    }
    private String queryHealth(String city) {
        Map<String,Object> params = new HashMap<>();
        params.put("city",city);
        params.put("key",API_KEY);
        String queryParams = urlencode(params);
        return  queryParams;
    }
}
