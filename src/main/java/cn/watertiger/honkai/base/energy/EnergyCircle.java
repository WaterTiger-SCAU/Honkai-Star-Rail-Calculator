package cn.watertiger.honkai.base.energy;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.tuple.Pair;

import java.math.BigDecimal;
import java.util.List;

/**
 * 能量循环计算
 *
 * @author water-tiger
 */
public class EnergyCircle {
    /**
     * 能量恢复效率提升
     */
    public enum Improve {
        /**
         * 无加成
         */
        NONE(0.00),
        /**
         * 内圈
         */
        SMALL(0.05),
        /**
         * 充能绳
         */
        ROPE(0.194);

        final BigDecimal value;

        Improve(double value) {
            this.value = BigDecimal.valueOf(value);
        }

        public BigDecimal getValue() {
            return value;
        }
    }

    /**
     * 行动回能数值
     */
    public enum Action {
        /**
         * 平A
         */
        A(20),
        /**
         * 战技
         */
        E(30),
        /**
         * 大招
         */
        Q(5);

        final BigDecimal value;

        Action(double value) {
            this.value = BigDecimal.valueOf(value);
        }

        public BigDecimal getValue() {
            return value;
        }
    }

    private List<Action> circle = Lists.newArrayList();

    private BigDecimal energyImprove;

    private BigDecimal targetEnergy;

    public EnergyCircle buildCircle(List<Action> actionList) {
        if (CollectionUtils.isEmpty(actionList)) {
            actionList = Lists.newArrayList();
        }

        circle = actionList;
        return this;
    }

    public EnergyCircle buildImprove(List<Improve> improveList) {
        if (CollectionUtils.isEmpty(improveList)) {
            improveList = Lists.newArrayList(Improve.NONE);
        }

        BigDecimal result = BigDecimal.ONE;
        for (Improve improve : improveList) {
            result = result.add(improve.getValue());
        }
        energyImprove = result;
        return this;
    }

    public EnergyCircle buildTarget(double value) {
        targetEnergy = BigDecimal.valueOf(value);
        return this;
    }

    public List<Pair<Action, BigDecimal>> generateStep() {
        Preconditions.checkArgument(CollectionUtils.isNotEmpty(circle));

        List<Pair<Action, BigDecimal>> res = Lists.newArrayList();
        for (Action action : circle) {
            BigDecimal actionEnergyValue = action.getValue().multiply(energyImprove);
            res.add(Pair.of(action, actionEnergyValue));
        }
        return res;
    }

    public BigDecimal generateTotal() {
        BigDecimal result = BigDecimal.ZERO;
        for (Pair<Action, BigDecimal> pair : generateStep()) {
            result = result.add(pair.getValue());
        }

        return result;
    }

    public BigDecimal getTargetEnergy() {
        return targetEnergy;
    }
}
