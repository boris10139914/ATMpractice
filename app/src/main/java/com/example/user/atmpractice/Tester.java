package com.example.user.atmpractice;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by user on 2018/1/2.
 */

public class Tester {
    public static void main(String[] args) {
        Date now =new Date();
        System.out.println(now);
        System.out.println(now.getTime());
        SimpleDateFormat sdf =new SimpleDateFormat("yyyy/MM/dd HH:mm");
        System.out.println(sdf.format(now));
        String s ="1997/10/13";
        try {
            Date birthday =sdf.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
