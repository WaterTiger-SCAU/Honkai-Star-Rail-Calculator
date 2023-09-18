package cn.watertiger.honkai.base.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * 双精度浮点数计算工具
 * 默认保留两位小数
 *
 * @author water-tiger
 */
public class DoubleMathUtil {
    private DoubleMathUtil() {
    }

    /**
     * 不会丢失精度的加法计算
     *
     * @param a 加数
     * @param b 被加数
     * @return 结果
     */
    public static double add(double a, double b) {
        BigDecimal b1 = BigDecimal.valueOf(a);
        BigDecimal b2 = BigDecimal.valueOf(b);

        return b1.add(b2)
                .setScale(10, RoundingMode.HALF_UP)
                .doubleValue();
    }

    /**
     * 不会丢失精度的减法计算
     *
     * @param a 减数
     * @param b 被减数
     * @return 结果
     */
    public static double subtract(double a, double b) {
        BigDecimal b1 = BigDecimal.valueOf(a);
        BigDecimal b2 = BigDecimal.valueOf(b);

        return b1.subtract(b2)
                .setScale(10, RoundingMode.HALF_UP)
                .doubleValue();
    }

    /**
     * 不会丢失精度的乘法计算
     *
     * @param a 乘数
     * @param b 被乘数
     * @return 结果
     */
    public static double multiply(double a, double b) {
        BigDecimal b1 = BigDecimal.valueOf(a);
        BigDecimal b2 = BigDecimal.valueOf(b);

        return b1.multiply(b2)
                .setScale(10, RoundingMode.HALF_UP)
                .doubleValue();
    }

    /**
     * 不会丢失精度的除法计算
     *
     * @param a 除数
     * @param b 被除数
     * @return 结果
     */
    public static double divide(double a, double b) {
        BigDecimal b1 = BigDecimal.valueOf(a);
        BigDecimal b2 = BigDecimal.valueOf(b);

        return b1.divide(b2, 5, RoundingMode.HALF_UP)
                .doubleValue();
    }
}
