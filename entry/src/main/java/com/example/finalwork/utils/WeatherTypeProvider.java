package com.example.finalwork.utils;

import com.example.finalwork.ResourceTable;
import com.example.finalwork.bean.WeatherTypeBean;
import ohos.aafwk.ability.AbilitySlice;
import ohos.agp.components.*;

import java.util.List;

public class WeatherTypeProvider extends BaseItemProvider {
    private AbilitySlice context;
    private List<WeatherTypeBean.ResultDTO>mDatas;

    public WeatherTypeProvider(AbilitySlice context, List<WeatherTypeBean.ResultDTO> mDatas) {
        this.context = context;
        this.mDatas = mDatas;
    }

    @Override
    public int getCount() {
        return mDatas.size();
    }

    @Override
    public Object getItem(int i) {
        return mDatas.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public Component getComponent(int i, Component component, ComponentContainer componentContainer) {
        if(component == null){
            component = LayoutScatter.getInstance(context)
                    .parse(ResourceTable.Layout_ability_weathertype,componentContainer,false);
        }
        Text idTv = component.findComponentById(ResourceTable.Id_wlist_tv2);
        Text typeTv = component.findComponentById(ResourceTable.Id_wlist_tv3);
        String id = mDatas.get(i).getWid();
        String type = mDatas.get(i).getWeather();
        idTv.setText(id);
        typeTv.setText(type);
        return component;
    }
}