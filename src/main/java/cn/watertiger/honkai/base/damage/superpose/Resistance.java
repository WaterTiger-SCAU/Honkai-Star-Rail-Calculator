package cn.watertiger.honkai.base.damage.superpose;

import cn.watertiger.honkai.base.util.DoubleMathUtil;

/**
 * 抗性区
 *
 * @author water-tiger
 */
public class Resistance extends SuperposeModel<Double> {

    /**
     * default = {@link Constant#ENEMY_EFFECTIVE}
     */
    private Constant constant = Constant.ENEMY_EFFECTIVE;

    /**
     * 减伤值常量
     */
    public enum Constant {
        /**
         * 弱点
         */
        ENEMY_EFFECTIVE(0),
        /**
         * 非弱点
         */
        ENEMY_INEFFECTIVE(0.2),
        /**
         * 属性抵抗
         */
        ENEMY_RESISTANCE(0.4);

        private final double value;

        Constant(double value) {
            this.value = value;
        }

        public double getValue() {
            return value;
        }
    }

    public void setConstant(Constant constant) {
        this.constant = constant;
    }

    /**
     * 抗性区 = (1-(抗性-穿透)) = 1-抗性+穿透
     *
     * @return 1-抗性
     */
    @Override
    protected Double getBaseSuperposeValue() {
        return DoubleMathUtil.subtract(1, constant.getValue());
    }

    @Override
    protected Double superposeCalculate(Double sourceValue, Double superposeValue) {
        return DoubleMathUtil.add(sourceValue, superposeValue);
    }
}
