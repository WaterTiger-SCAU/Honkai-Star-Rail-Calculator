package cn.watertiger.honkai.base.damage.superpose;

import cn.watertiger.honkai.base.util.DoubleFormatUtil;
import cn.watertiger.honkai.base.util.DoubleMathUtil;
import com.google.common.collect.Lists;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

class ResistanceTest {
    public static Stream<Arguments> resistanceProvider() {
        return Stream.of(
                // 丹恒天赋 39% 风穿透
                Arguments.of(Lists.newArrayList("39%"), Resistance.Constant.ENEMY_EFFECTIVE),
                Arguments.of(Lists.newArrayList("39%"), Resistance.Constant.ENEMY_INEFFECTIVE),
                Arguments.of(Lists.newArrayList("39%"), Resistance.Constant.ENEMY_RESISTANCE),
                // 佩拉 12% 冰抗性降低
                Arguments.of(Lists.newArrayList("12%"), Resistance.Constant.ENEMY_EFFECTIVE),
                // 佩拉 12% 冰抗性降低 + 罗刹全属性 20% 抗性降低
                Arguments.of(Lists.newArrayList("12%", "20%"), Resistance.Constant.ENEMY_EFFECTIVE)
        );
    }

    @ParameterizedTest
    @MethodSource("resistanceProvider")
    void test(List<String> resistanceList, Resistance.Constant resistanceType) {
        Resistance resistance = new Resistance();
        resistance.setConstant(resistanceType);

        resistanceList.stream()
                .map(DoubleFormatUtil::formatByText)
                .forEach(resistance::superpose);

        Double total = resistance.calculateTotal();
        System.out.println("抗性增伤系数: " + total);

        // 抗性穿透总值
        double resistanceAntiTotal = resistanceList.stream()
                .map(DoubleFormatUtil::formatByText)
                .reduce(DoubleMathUtil::add)
                .orElse(0.0);

        Assertions.assertEquals(
                total,
                DoubleMathUtil.subtract(
                        1,
                        DoubleMathUtil.subtract(resistanceType.getValue(), resistanceAntiTotal)
                )
        );
    }
}