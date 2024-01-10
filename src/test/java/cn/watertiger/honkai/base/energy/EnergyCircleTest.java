package cn.watertiger.honkai.base.energy;

import org.apache.commons.lang3.tuple.Pair;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static cn.watertiger.honkai.base.energy.EnergyAction.*;
import static cn.watertiger.honkai.base.energy.EnergyCircle.ENERGY_ROPE;
import static cn.watertiger.honkai.base.energy.EnergyCircle.INNER_EQUIPMENT;

class EnergyCircleTest {
    @Test
    @DisplayName("能量循环测试")
    void testEnergyCircle() {
        EnergyCircle energyCircle = new EnergyCircle()
                // 循环
                .buildCircle(Q, E, A, E)
                // 充能效率
                .buildImprove(INNER_EQUIPMENT, ENERGY_ROPE)
                .buildTarget(100);

        List<Pair<EnergyAction, BigDecimal>> step = energyCircle.generateStep();

        BigDecimal total = energyCircle.generateTotal();

        System.out.println(step);

        Assertions.assertEquals(1, total.compareTo(energyCircle.getTargetEnergy()));
    }
}