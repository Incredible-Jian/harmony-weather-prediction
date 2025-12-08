package com.example.finalwork.utils;

import ohos.aafwk.ability.AbilitySlice;
import ohos.global.resource.RawFileEntry;
import ohos.global.resource.ResourceManager;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/*
* 读取resources/rawfile文件夹当中的文件内容
* */
public class RawFileUtils {


    public static String readRawFile(AbilitySlice context, String filename){
        // 1.获取资源管理器对象
        ResourceManager manager = context.getResourceManager();
        //2 .获取rawfile文件夹当中的文件对象
        RawFileEntry entry = manager.getRawFileEntry(
                String.format("resources/rawfile/%s", filename));
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        //3.打开文件
        try {
            InputStream is = entry.openRawFile();
            int len = 0;
            byte[]data = new byte[1024];
            while ((len = is.read(data))!=-1){
                baos.write(data,0,len);
            }
            is.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return baos.toString();
    }

}