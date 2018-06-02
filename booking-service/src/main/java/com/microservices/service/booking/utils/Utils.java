package com.microservices.service.booking.utils;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;


@Component
public class Utils {

    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    public Date createDateFromDateString(String dateString){
        Date date = null;
        if(StringUtils.isNotBlank(dateString)) {
            try {
                date = new Date(DATE_FORMAT.parse(dateString).getTime());
            }catch(ParseException pe){
                date = new Date(new java.util.Date().getTime());
            }
        }else{
            date = new Date(new java.util.Date().getTime());
        }
        return date;
    }
}
