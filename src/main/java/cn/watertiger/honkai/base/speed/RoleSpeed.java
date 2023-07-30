package cn.watertiger.honkai.base.speed;

import com.google.common.base.Preconditions;

/**
 * 速度计算类
 *
 * @author water-tiger
 */
public class RoleSpeed {
    /**
     * 速度白值
     */
    private final int baseSpeed;
    /**
     * 当前速度
     */
    private int currentSpeed;
    /**
     * 行动值（在设置中开启后对战时会显示在左上的角色行动线中）
     * 该值遵循以下规则
     * <ul type="disc">
     *     <li>当行动值为 0 时角色立即行动</li>
     *     <li>行动值初始值通过 {@link RoleSpeed#calculateActionValue} 计算得到</li>
     *     <li>行动完后会将角色行动值重置为初始值</li>
     * </ul>
     */
    private int actionValue;

    public RoleSpeed(int speed) {
        this.baseSpeed = speed;
        this.currentSpeed = speed;

        actionValue = calculateActionValue();
    }

    public int calculateActionValue() {
        Preconditions.checkArgument(currentSpeed != 0);
        actionValue = 10000 / currentSpeed;
        return actionValue;
    }

    public int improveSpeedByRate(double rate) {
        currentSpeed = (int) (baseSpeed * (1.0 + rate));
        return currentSpeed;
    }

    /* Getter */

    public int getBaseSpeed() {
        return baseSpeed;
    }

    public int getCurrentSpeed() {
        return currentSpeed;
    }

    public int getActionValue() {
        return actionValue;
    }

    @Override
    public String toString() {
        return "RoleSpeed{" +
                "baseSpeed=" + baseSpeed +
                ", currentSpeed=" + currentSpeed +
                ", actionValue=" + actionValue +
                '}';
    }
}
