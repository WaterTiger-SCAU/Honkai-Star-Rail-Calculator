package cn.watertiger.honkai.base.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.stream.Stream;

class DoubleMathUtilTest {
    public static Stream<Arguments> doubleCalculateProvider() {
        return Stream.of(
                Arguments.of(1.1, 1.3)
        );
    }

    private boolean newScaleEq(double d) {
        return BigDecimal.valueOf(d).setScale(5, RoundingMode.HALF_UP).doubleValue() == d;
    }

    @ParameterizedTest
    @MethodSource("doubleCalculateProvider")
    void testAdd(double a, double b) {
        double doubleOperationResult = a + b;
        double utilOperationResult = DoubleMathUtil.add(a, b);

        System.out.println("doubleOperationResult:" + doubleOperationResult);
        System.out.println("utilOperationResult:" + utilOperationResult);

        Assertions.assertTrue(
                !newScaleEq(doubleOperationResult)
                && newScaleEq(utilOperationResult)
        );
    }

    @ParameterizedTest
    @MethodSource("doubleCalculateProvider")
    void testSubtract(double a, double b) {
        double doubleOperationResult = a - b;
        double utilOperationResult = DoubleMathUtil.subtract(a, b);

        System.out.println("doubleOperationResult:" + doubleOperationResult);
        System.out.println("utilOperationResult:" + utilOperationResult);

        Assertions.assertTrue(
                !newScaleEq(doubleOperationResult)
                        && newScaleEq(utilOperationResult)
        );
    }

    @ParameterizedTest
    @MethodSource("doubleCalculateProvider")
    void testMultiply(double a, double b) {
        double doubleOperationResult = a * b;
        double utilOperationResult = DoubleMathUtil.multiply(a, b);

        System.out.println("doubleOperationResult:" + doubleOperationResult);
        System.out.println("utilOperationResult:" + utilOperationResult);

        Assertions.assertTrue(
                !newScaleEq(doubleOperationResult)
                        && newScaleEq(utilOperationResult)
        );
    }

    @ParameterizedTest
    @MethodSource("doubleCalculateProvider")
    void testDivide(double a, double b) {
        double doubleOperationResult = a / b;
        double utilOperationResult = DoubleMathUtil.divide(a, b);

        System.out.println("doubleOperationResult:" + doubleOperationResult);
        System.out.println("utilOperationResult:" + utilOperationResult);

        Assertions.assertTrue(
                !newScaleEq(doubleOperationResult)
                        && newScaleEq(utilOperationResult)
        );
    }
}