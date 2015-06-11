package com.util;

import java.util.List;

/**
 * Created by huyan on 15/5/17.
 */
public class StringUtils {

    public static String valueOf(Object data){
        if (data == null){
            return "";
        }
        return String.valueOf(data);
    }

    public static String parseListToString(List<String> datas){

        StringBuilder builder = new StringBuilder();

        if (datas == null || datas.isEmpty()){
            return "";
        }
        for (int i=0; i< datas.size(); i++){

            if (i< datas.size()-1){
                builder.append(datas.get(i)).append(",");
            } else {
                builder.append(datas.get(i));
            }
        }

        return builder.toString();
    }

}
