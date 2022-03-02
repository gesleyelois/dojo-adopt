package br.com.alura.dojoadopt.utils;

import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;

public class YearsUtil {

    public static String between(Temporal start, Temporal end) {
        long year = ChronoUnit.YEARS.between(start, end);

        if(year < 0) {
            return "-";
        }

        if(year == 0) {
            return "Meses";
        }

        if(year == 1) {
            return "1 ano";
        }

        return "%d anos".formatted(year);
    }
}
