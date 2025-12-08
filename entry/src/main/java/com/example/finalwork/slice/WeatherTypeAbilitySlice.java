package com.example.finalwork.slice;

import com.example.finalwork.ResourceTable;
import com.example.finalwork.bean.WeatherTypeBean;
import com.example.finalwork.utils.RawFileUtils;
import com.example.finalwork.utils.WeatherTypeProvider;
import com.google.gson.Gson;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.components.Button;
import ohos.agp.components.Component;
import ohos.agp.components.ListContainer;

import java.util.ArrayList;
import java.util.List;

public class WeatherTypeAbilitySlice extends AbilitySlice implements Component.ClickedListener {
    ListContainer lc;
    List<WeatherTypeBean.ResultDTO>mDatas =new ArrayList<>();
    WeatherTypeProvider provider;
    Intent intent;
    Button weathertypebtn;
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_item_weathertype);
        initView();
        getData();
    }

    private void initView() {
        weathertypebtn = findComponentById(ResourceTable.Id_wkinds_btn);
        weathertypebtn.setClickedListener(this);
        lc = findComponentById(ResourceTable.Id_weather_kinds_lc);
        provider = new WeatherTypeProvider(this,mDatas);
        lc.setItemProvider(provider);
    }

    private void getData() {
        String json = RawFileUtils.readRawFile(this, "WeatherType.json");
        WeatherTypeBean weatherTypeBean = new Gson().fromJson(json, WeatherTypeBean.class);
        List<WeatherTypeBean.ResultDTO> list = weatherTypeBean.getResult();
        //将加载到的数据，放入数据源
        mDatas.addAll(list);
        //提示适配器更新
        provider.notifyDataChanged();
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
            case ResourceTable.Id_wkinds_btn:
                intent = new Intent();
                present(new WeatherInfoAbilitySlice(),intent);
                break;
        }
    }
}
