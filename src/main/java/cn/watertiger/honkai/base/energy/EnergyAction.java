package cn.watertiger.honkai.base.energy;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


/**
 * 行动能量
 *
 * @author water-tiger
 */
public class EnergyAction {
    public static final int Q = 5;
    public static final int A = 20;
    public static final int E = 30;

    private final int energyValue;

    public EnergyAction(int energyValue) {
        this.energyValue = energyValue;
    }

    public static List<EnergyAction> buildActionEnergyList(int... energyList) {
        if (ArrayUtils.isEmpty(energyList)) {
            return Lists.newArrayList();
        }

        return Arrays.stream(energyList)
                .boxed()
                .map(EnergyAction::new)
                .collect(Collectors.toList());
    }

    public int getEnergyValue() {
        return energyValue;
    }
}
