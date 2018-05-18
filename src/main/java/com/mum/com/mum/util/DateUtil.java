package com.mum.com.mum.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Wenqiang on 5/18/18.
 */
public class DateUtil {

    public static final String DATETIME_DEFAULT_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static String getString(Date date) {
        if(null==date){
            return "";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(DATETIME_DEFAULT_FORMAT);
        String result = sdf.format(date);
        return result;
    }
}
