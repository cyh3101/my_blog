package com.cyh.blog.utils;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by cai on 2017/6/28.
 */
public class CustomDataConverter implements Converter<String , Date>{
    public Date convert(String s) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try{
            return simpleDateFormat.parse(s);
        }catch (ParseException e){
            e.printStackTrace();
        }
        return null;
    }
}
