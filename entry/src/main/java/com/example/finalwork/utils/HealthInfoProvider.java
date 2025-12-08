package com.example.finalwork.utils;

import com.example.finalwork.ResourceTable;
import com.example.finalwork.bean.LifeCountBean;
import com.example.finalwork.bean.WeatherTypeBean;
import ohos.aafwk.ability.AbilitySlice;
import ohos.agp.components.*;

import java.util.ArrayList;
import java.util.List;

public class HealthInfoProvider extends BaseItemProvider {
    AbilitySlice context;

    public HealthInfoProvider(AbilitySlice context, List<LifeCountBean.ResultDTO.LifeDTO> lifeDTOS) {
        this.context = context;
        this.lifeDTOS = lifeDTOS;
    }

    List<LifeCountBean.ResultDTO.LifeDTO>  lifeDTOS = new ArrayList<>();
    @Override
    public int getCount() {
        return lifeDTOS.size();
    }

    @Override
    public Object getItem(int i) {
        return lifeDTOS.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public Component getComponent(int i, Component component, ComponentContainer componentContainer) {
        if(component == null){
            component = LayoutScatter.getInstance(context)
                    .parse(ResourceTable.Layout_ability_health,componentContainer,false);
            Text feelTv = component.findComponentById(ResourceTable.Id_health_v_feel);
            Text desTv = component.findComponentById(ResourceTable.Id_health_des_s);
            LifeCountBean.ResultDTO.LifeDTO lifeDTO = lifeDTOS.get(i);
            if(lifeDTO.getChuanyi().equals("chuanyi")){
                feelTv.setText(lifeDTO.getChuanyi().getV());
                desTv.setText(lifeDTO.getChuanyi().getDes());
            }else if(lifeDTO.getDaisan().equals("daisan")){
                feelTv.setText(lifeDTO.getDaisan().getV());
                desTv.setText(lifeDTO.getDaisan().getDes());
            }else if(lifeDTO.getDiaoyu().equals("diaoyu")){
                feelTv.setText(lifeDTO.getDiaoyu().getV());
                desTv.setText(lifeDTO.getDiaoyu().getDes());
            }else if(lifeDTO.getGanmao().equals("ganmao")){
                feelTv.setText(lifeDTO.getGanmao().getV());
                desTv.setText(lifeDTO.getGanmao().getDes());
            }else if(lifeDTO.getGuomin().equals("guomin")){
                feelTv.setText(lifeDTO.getGuomin().getV());
                desTv.setText(lifeDTO.getGuomin().getDes());
            }else if(lifeDTO.getKongtiao().equals("kongtiao")){
                feelTv.setText(lifeDTO.getKongtiao().getV());
                desTv.setText(lifeDTO.getKongtiao().getDes());
            }else if(lifeDTO.getShushidu().equals("shushidu")){
                feelTv.setText(lifeDTO.getShushidu().getV());
                desTv.setText(lifeDTO.getShushidu().getDes());
            }else if(lifeDTO.getXiche().equals("xiche")){
                feelTv.setText(lifeDTO.getXiche().getV());
                desTv.setText(lifeDTO.getXiche().getDes());
            }else if(lifeDTO.getYundong().equals("yundong")){
                feelTv.setText(lifeDTO.getYundong().getV());
                desTv.setText(lifeDTO.getYundong().getDes());
            }else{
                feelTv.setText(lifeDTO.getZiwaixian().getV());
                desTv.setText(lifeDTO.getZiwaixian().getDes());
            }
        }
        return component;
    }
}