package br.com.alura.dojoadopt.utils;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import static org.assertj.core.api.Assertions.assertThat;

class YearsUtilTest {

    @Test
    void between__should_return_dash() {
        LocalDate startDate = LocalDate.parse("2023-01-01");
        LocalDate endDate = LocalDate.parse("2022-01-01");

        assertThat(ChronoUnit.YEARS.between(startDate, endDate)).isLessThan(0);
        assertThat(YearsUtil.between(startDate, endDate)).isEqualTo("-");
    }

    @Test
    void between__should_return_months() {
        LocalDate startDate = LocalDate.parse("2022-01-01");
        LocalDate endDate = LocalDate.parse("2022-01-01");

        assertThat(ChronoUnit.YEARS.between(startDate, endDate)).isEqualTo(0);
        assertThat(YearsUtil.between(startDate, endDate)).isEqualTo("Meses");
    }

    @Test
    void between__should_return_one_year() {
        LocalDate startDate = LocalDate.parse("2021-01-01");
        LocalDate endDate = LocalDate.parse("2022-01-01");

        assertThat(ChronoUnit.YEARS.between(startDate, endDate)).isEqualTo(1);
        assertThat(YearsUtil.between(startDate, endDate)).isEqualTo("1 ano");
    }

    @Test
    void between__should_return_more_than_a_year() {
        LocalDate startDate = LocalDate.parse("2019-01-01");
        LocalDate endDate = LocalDate.parse("2022-01-01");

        assertThat(ChronoUnit.YEARS.between(startDate, endDate)).isGreaterThan(1);
        assertThat(YearsUtil.between(startDate, endDate)).isEqualTo("3 anos");
    }
}