package cn.watertiger.honkai.base.damage;

import cn.watertiger.honkai.base.util.DoubleFormatUtil;
import com.google.common.collect.Lists;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

class DamageIncreaseTest {
    public static Stream<Arguments> increaseListProvider() {
        return Stream.of(
                Arguments.of(
                        // 希儿再现增幅 + 满级量子球
                        Lists.newArrayList("80%", "38.8%"),
                        // 期望
                        "218.8%"
                ),
                Arguments.of(
                        // 停云大招 + 丹恒满行迹 & 风伤球 + 普攻对减速增伤行迹
                        Lists.newArrayList("50%", "71.2%", "40%"),
                        // 期望
                        "261.2%"
                )
        );
    }

    @ParameterizedTest
    @MethodSource("increaseListProvider")
    void test(List<String> increaseTextList, String exceptText) {
        DamageIncrease damageIncrease = new DamageIncrease();

        increaseTextList.stream()
                .map(DoubleFormatUtil::formatByText)
                .forEach(damageIncrease::addDamageIncrease);

        double total = damageIncrease.calculateTotal();

        Assertions.assertEquals(total, DoubleFormatUtil.formatByText(exceptText));
    }
}