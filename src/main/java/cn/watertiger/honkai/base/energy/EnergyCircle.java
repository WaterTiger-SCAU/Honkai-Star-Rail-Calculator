package cn.watertiger.honkai.base.energy;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.tuple.Pair;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

/**
 * 能量循环计算
 *
 * @author water-tiger
 */
public class EnergyCircle {

    public static final double NONE = 0;
    /**
     * 内圈遗器
     */
    public static final double INNER_EQUIPMENT = 0.05;
    /**
     * 充能绳
     */
    public static final double ENERGY_ROPE = 0.194;

    private List<EnergyAction> circle = Lists.newArrayList();

    private BigDecimal energyImprove;

    private BigDecimal targetEnergy;

    public EnergyCircle buildCircle(int... energyList) {
        circle = EnergyAction.buildActionEnergyList(energyList);
        return this;
    }

    public EnergyCircle buildImprove(double... improveList) {
        if (ArrayUtils.isEmpty(improveList)) {
            energyImprove = BigDecimal.ONE.add(BigDecimal.valueOf(NONE));
            return this;
        }

        BigDecimal base = BigDecimal.ONE;

        energyImprove = Arrays.stream(improveList)
                .boxed()
                .map(BigDecimal::valueOf)
                .reduce(base, BigDecimal::add);
        return this;
    }

    public EnergyCircle buildTarget(double value) {
        targetEnergy = BigDecimal.valueOf(value);
        return this;
    }

    public List<Pair<EnergyAction, BigDecimal>> generateStep() {
        Preconditions.checkArgument(CollectionUtils.isNotEmpty(circle));

        List<Pair<EnergyAction, BigDecimal>> res = Lists.newArrayList();
        for (EnergyAction action : circle) {
            BigDecimal actionEnergyValue = energyImprove.multiply(BigDecimal.valueOf(action.getEnergyValue()));
            res.add(Pair.of(action, actionEnergyValue));
        }
        return res;
    }

    public BigDecimal generateTotal() {
        BigDecimal result = BigDecimal.ZERO;
        for (Pair<EnergyAction, BigDecimal> pair : generateStep()) {
            result = result.add(pair.getValue());
        }

        return result;
    }

    public BigDecimal getTargetEnergy() {
        return targetEnergy;
    }
}
