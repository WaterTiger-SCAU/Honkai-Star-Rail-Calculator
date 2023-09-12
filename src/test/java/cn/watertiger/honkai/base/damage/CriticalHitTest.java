package cn.watertiger.honkai.base.damage;

import cn.watertiger.honkai.base.util.DoubleFormatUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class CriticalHitTest {
    public static Stream<Arguments> criticalPairProvider() {
        return Stream.of(
                // 默认双爆
                Arguments.of("5%", "50%"),
                // 克拉拉的双爆
                Arguments.of("59%", "109%"),
                // mock 的双爆数据
                Arguments.of("100%", "120%"),
                // 这是我的毕业丹恒恒的双爆
                Arguments.of("61%", "142%"),
                // 这是我的小毕业饮月的双爆
                Arguments.of("78%", "174%")
        );
    }

    @DisplayName("暴击期望测试")
    @ParameterizedTest
    @MethodSource("criticalPairProvider")
    void test(String criticalRateText, String criticalDamageText) {
        double criticalRate = DoubleFormatUtil.formatByText(criticalRateText);
        double criticalDamage = DoubleFormatUtil.formatByText(criticalDamageText);

        CriticalHit criticalHit = new CriticalHit(criticalRate, criticalDamage);
        // 计算暴击期望
        double criticalExpect = criticalHit.getCriticalExpect();

        System.out.printf("暴击率: %s --> (%s)%n", criticalRateText, criticalRate);
        System.out.printf("暴击伤害: %s --> (%s)%n", criticalDamageText, criticalDamage);
        System.out.printf("期望伤害: %s --> (%s)%n", DoubleFormatUtil.formatByRate(criticalExpect), criticalExpect);

        Assertions.assertEquals(criticalRate * criticalDamage, criticalExpect);
    }
}