package com.jihwan.section01.params;

import java.time.Month;

public class DateValidattor {
    public static boolean isCollect(Month month) {
        int mothValue = month.getValue();

        return mothValue >= 1  && mothValue <=12;
    }

    public static int getLastDayOf(Month month) {

        return month.maxLength();

    }
}
