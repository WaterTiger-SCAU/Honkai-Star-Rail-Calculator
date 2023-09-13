package cn.watertiger.honkai.base.damage.superpose;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * 叠加区抽象类
 *
 * @param <T> 叠加数据类型
 * @author water-tiger
 */
public abstract class SuperposeModel<T> {
    private final List<T> superposeList = Lists.newArrayList();

    public T calculateTotal() {
        T result = getBaseSuperposeValue();
        for (T value : superposeList) {
            result = superposeCalculate(result, value);
        }

        return result;
    }

    /**
     * 叠加基准值
     *
     * @return 叠加基准值
     */
    protected abstract T getBaseSuperposeValue();

    /**
     * 叠加的计算方式
     *
     * @param sourceValue    原值
     * @param superposeValue 叠加值
     * @return 叠加后的值
     */
    protected abstract T superposeCalculate(T sourceValue, T superposeValue);

    public void superpose(T value) {
        superposeList.add(value);
    }
}
