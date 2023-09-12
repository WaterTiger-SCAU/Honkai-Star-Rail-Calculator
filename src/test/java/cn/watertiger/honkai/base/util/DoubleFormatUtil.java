package cn.watertiger.honkai.base.util;

/**
 * 测试套件
 * 用于 {@link Double} 和文本的转换
 *
 * @author water-tiger
 */
public class DoubleFormatUtil {
    public static double formatByText(String rateText) {
        String replace = rateText.replace("%", "");
        return Double.parseDouble(replace) / 100;
    }

    public static String formatByRate(double rate) {
        return rate * 100 + "%";
    }
}
