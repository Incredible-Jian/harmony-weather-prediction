package com.example.finalwork;

import com.example.finalwork.slice.WeatherInfoAbilitySlice;
import ohos.aafwk.ability.Ability;
import ohos.aafwk.content.Intent;

public class MainAbility extends Ability {
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setMainRoute(WeatherInfoAbilitySlice.class.getName());
    }
}
