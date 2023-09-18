package cn.watertiger.honkai.base.damage.superpose;

import cn.watertiger.honkai.base.util.DoubleMathUtil;

/**
 * 减伤
 *
 * @author water-tiger
 */
public class ReduceInjury extends SuperposeModel<Double> {
    /**
     * 减伤值常量
     */
    public enum Constant {
        /**
         * 韧性击破
         */
        ENEMY_BROKEN(0),
        /**
         * 韧性未击破
         */
        ENEMY_UNBROKEN(0.1);

        private final double value;

        Constant(double value) {
            this.value = value;
        }

        public double getValue() {
            return value;
        }
    }

    @Override
    protected Double getBaseSuperposeValue() {
        return 1.0;
    }

    @Override
    protected Double superposeCalculate(Double sourceValue, Double superposeValue) {
        return DoubleMathUtil.subtract(sourceValue, superposeValue);
    }
}
