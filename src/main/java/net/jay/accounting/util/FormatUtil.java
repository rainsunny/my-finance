package net.jay.accounting.util;

import java.math.BigDecimal;

/**
 * Created by wangjie on 6/12/14 8:34 PM.
 */
public class FormatUtil
{



    public static String formatNumber(BigDecimal num) {
        return formatNumber(num.doubleValue());
    }

    public static String formatNumber(double num) {
        return String.format("%1$,.2f", num); // x,xxx.xx
    }
}
