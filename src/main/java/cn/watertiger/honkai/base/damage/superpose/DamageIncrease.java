package cn.watertiger.honkai.base.damage.superpose;

import cn.watertiger.honkai.base.util.DoubleMathUtil;

/**
 * 增伤区
 *
 * @author water-tiger
 */
public class DamageIncrease extends SuperposeModel<Double> {

    @Override
    protected Double getBaseSuperposeValue() {
        return 1.0;
    }

    @Override
    protected Double superposeCalculate(Double sourceValue, Double superposeValue) {
        return DoubleMathUtil.add(sourceValue, superposeValue);
    }
}
