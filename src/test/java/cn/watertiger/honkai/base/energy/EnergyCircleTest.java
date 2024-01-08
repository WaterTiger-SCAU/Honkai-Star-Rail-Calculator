package cn.watertiger.honkai.base.energy;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

class EnergyCircleTest {
    @Test
    @DisplayName("能量循环测试")
    void testEnergyCircle() {
        EnergyCircle energyCircle = new EnergyCircle()
                // EEA 循环
                .buildCircle(Lists.newArrayList(
                        EnergyCircle.Action.Q,
                        EnergyCircle.Action.E,
                        EnergyCircle.Action.E,
                        EnergyCircle.Action.E
                ))
                // 1.194
                .buildImprove(Lists.newArrayList(
                        EnergyCircle.Improve.SMALL,
                        EnergyCircle.Improve.ROPE
                ))
                .buildTarget(110);

        List<Pair<EnergyCircle.Action, BigDecimal>> step = energyCircle.generateStep();

        BigDecimal total = energyCircle.generateTotal();

        System.out.println(step);

        Assertions.assertEquals(1, total.compareTo(energyCircle.getTargetEnergy()));
    }
}