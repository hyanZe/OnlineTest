package top.jayczee.backend.util;

/**
 * @author liuxing
 * @since 2022-08-19
 */
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import org.jetbrains.annotations.NotNull;

public class EmptyValue {
    public static final int INT = 0;
    public static final long BIGINT = 0L;
    public static final double DOUBLE = 0.0;
    public static final double DOUBLE_AS_MIN = -1.0E-5;
    public static final double DOUBLE_AS_MAX = 1.0E-5;
    public static final float FLOAT = 0.0F;
    public static final double FLOAT_AS_MIN = -9.999999747378752E-6;
    public static final double FLOAT_AS_MAX = 9.999999747378752E-6;
    public static final @NotNull String CHAR = "";
    public static final @NotNull String VARCHAR = "";
    public static final @NotNull BigDecimal DECIMAL = new BigDecimal("0.00");
    public static final @NotNull BigDecimal DECIMAL_AS_MIN = new BigDecimal("-0.00001");
    public static final @NotNull BigDecimal DECIMAL_AS_MAX = new BigDecimal("0.00001");
    public static final @NotNull LocalDate DATE = LocalDate.of(1000, 1, 1);
    public static final @NotNull LocalTime TIME = LocalTime.of(0, 0, 0, 0);
    public static final @NotNull LocalDateTime DATE_TIME;

    private EmptyValue() {
    }

    static {
        DATE_TIME = LocalDateTime.of(DATE, TIME);
    }
}
