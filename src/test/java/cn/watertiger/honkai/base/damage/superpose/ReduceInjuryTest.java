package cn.watertiger.honkai.base.damage.superpose;

import cn.watertiger.honkai.base.util.DoubleFormatUtil;
import com.google.common.collect.Lists;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

class ReduceInjuryTest {
    public static Stream<Arguments> reduceInjuryValueProvider() {
        return Stream.of(
                Arguments.of(
                        // 敌方未破韧
                        Lists.newArrayList(ReduceInjury.Constant.ENEMY_UNBROKEN.getValue()),
                        // 期望
                        "90%"
                ),
                Arguments.of(
                        // 敌方破韧
                        Lists.newArrayList(ReduceInjury.Constant.ENEMY_BROKEN.getValue()),
                        // 期望
                        "100%"
                )
        );
    }

    @ParameterizedTest
    @MethodSource("reduceInjuryValueProvider")
    void test(List<Double> reduceInjuryList, String expectText) {
        ReduceInjury reduceInjury = new ReduceInjury();

        reduceInjuryList.forEach(reduceInjury::superpose);
        Double total = reduceInjury.calculateTotal();

        Assertions.assertEquals(total, DoubleFormatUtil.formatByText(expectText));
    }
}