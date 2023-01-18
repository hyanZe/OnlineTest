package top.jayczee.backend.util;

/**
 * @author liuxing
 * @since 2022-08-19
 */
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class EmptySugar {
    public EmptySugar() {
    }

    public static boolean isEmptyValue(String v) {
        return v == null || v.equals("");
    }

    public static boolean isEmptyValue(Integer v) {
        return v == null || v == 0;
    }

    public static boolean isEmptyValue(Long v) {
        return v == null || v == 0L;
    }

    public static boolean isEmptyValue(Double v) {
        return v == null || v == 0.0;
    }

    public static boolean isEmptyValue(Float v) {
        return v == null || v == 0.0F;
    }

    public static boolean isEmptyValue(BigDecimal v) {
        return v == null || v.equals(EmptyValue.DECIMAL);
    }

    public static boolean isEmptyValue(LocalDate v) {
        return v == null || v.equals(EmptyValue.DATE);
    }

    public static boolean isEmptyValue(LocalTime v) {
        return v == null || v.equals(EmptyValue.TIME);
    }

    public static boolean isEmptyValue(LocalDateTime v) {
        return v == null || v.equals(EmptyValue.DATE_TIME);
    }

    public static boolean asEmptyValue(String v) {
        return v == null || v.trim().isEmpty();
    }

    public static boolean asEmptyValue(Integer v) {
        return v == null || v == 0;
    }

    public static boolean asEmptyValue(Long v) {
        return v == null || v == 0L;
    }

    public static boolean asEmptyValue(Double x) {
        if (x == null) {
            return true;
        } else {
            double v = x;
            return v > -1.0E-5 && v < 1.0E-5;
        }
    }

    public static boolean asEmptyValue(Float x) {
        if (x == null) {
            return true;
        } else {
            float v = x;
            return (double)v > -9.999999747378752E-6 && (double)v < 9.999999747378752E-6;
        }
    }

    public static boolean asEmptyValue(BigDecimal v) {
        return v == null || v.compareTo(EmptyValue.DECIMAL_AS_MIN) > 0 && v.compareTo(EmptyValue.DECIMAL_AS_MAX) < 0;
    }

    public static boolean asEmptyValue(LocalDate v) {
        return v == null || v.getYear() == EmptyValue.DATE.getYear() && v.getMonth() == EmptyValue.DATE.getMonth() && v.getDayOfMonth() == EmptyValue.DATE.getDayOfMonth();
    }

    public static boolean asEmptyValue(LocalTime v) {
        return v == null || v.getHour() == EmptyValue.TIME.getHour() && v.getMinute() == EmptyValue.TIME.getMinute() && v.getSecond() == EmptyValue.TIME.getSecond();
    }

    public static boolean asEmptyValue(LocalDateTime v) {
        return v == null || asEmptyValue(v.toLocalDate()) && asEmptyValue(v.toLocalTime());
    }

    public static String nullToEmpty(String v) {
        return v == null ? "" : v;
    }

    public static Integer nullToEmpty(Integer v) {
        return v == null ? 0 : v;
    }

    public static Long nullToEmpty(Long v) {
        return v == null ? 0L : v;
    }

    public static Double nullToEmpty(Double v) {
        return v == null ? 0.0 : v;
    }

    public static Float nullToEmpty(Float v) {
        return v == null ? 0.0F : v;
    }

    public static BigDecimal nullToEmpty(BigDecimal v) {
        return v == null ? EmptyValue.DECIMAL : v;
    }

    public static LocalDate nullToEmpty(LocalDate v) {
        return v == null ? EmptyValue.DATE : v;
    }

    public static LocalTime nullToEmpty(LocalTime v) {
        return v == null ? EmptyValue.TIME : v;
    }

    public static LocalDateTime nullToEmpty(LocalDateTime v) {
        return v == null ? EmptyValue.DATE_TIME : v;
    }

    public static boolean nullToTrue(Boolean v) {
        return v == null || v;
    }

    public static boolean nullToFalse(Boolean v) {
        return v != null && v;
    }

    public static String emptyToNull(String v) {
        return asEmptyValue(v) ? null : v;
    }

    public static Integer emptyToNull(Integer v) {
        return asEmptyValue(v) ? null : v;
    }

    public static Long emptyToNull(Long v) {
        return asEmptyValue(v) ? null : v;
    }

    public static Double emptyToNull(Double v) {
        return asEmptyValue(v) ? null : v;
    }

    public static Float emptyToNull(Float v) {
        return asEmptyValue(v) ? null : v;
    }

    public static BigDecimal emptyToNull(BigDecimal v) {
        return asEmptyValue(v) ? null : v;
    }

    public static LocalDate emptyToNull(LocalDate v) {
        return asEmptyValue(v) ? null : v;
    }

    public static LocalTime emptyToNull(LocalTime v) {
        return asEmptyValue(v) ? null : v;
    }

    public static LocalDateTime emptyToNull(LocalDateTime v) {
        return asEmptyValue(v) ? null : v;
    }

    public static Boolean emptyToNull(Boolean v) {
        return nullToTrue(v) ? null : v;
    }
}
