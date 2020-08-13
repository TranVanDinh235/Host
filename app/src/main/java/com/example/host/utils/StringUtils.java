package com.example.host.utils;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringUtils {
    public static String toRate(String rate){
        return rate + "₫";
    }

    public static String toRate(String rate, int promotion){
        int rateInt = Integer.parseInt(rate) * promotion / 100;
        return rateInt + "₫";
    }

    public static String cutString(String str, int length){
        if(str.length() > length){
            for(int i = length; i > length - 10; i --){
                if(str.charAt(i) == ' '){
                    return str.substring(0, i) + "..";
                }
            }
            return str.substring(0, length) + "..";
        }
        return str;
    }

    public static List<String> strToList(String str){
        String[] strings = str.split(";");
        return Arrays.asList(strings);
    }

    public static String listToStr(List<String> list){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < list.size(); i ++){
            sb.append(list.get(i));
            sb.append(';');
        }
        String s = sb.toString();
        if(!s.equalsIgnoreCase("")){
            return s.substring(0, s.length() -1);
        } else return "";
    }
}

