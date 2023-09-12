package cn.watertiger.honkai.base.damage;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * 增伤区
 *
 * @author water-tiger
 */
public class DamageIncrease {
    private final List<Double> increaseList;

    DamageIncrease() {
        increaseList = Lists.newArrayList();
    }

    /**
     * 计算增伤区
     * 增伤区 = 1 + 总增伤
     *
     * @return 总增伤
     */
    public double calculateTotal() {
        double total = 1;
        for (Double increase : increaseList) {
            total += increase;
        }
        return total;
    }

    public void addDamageIncrease(double increase) {
        increaseList.add(increase);
    }
}
