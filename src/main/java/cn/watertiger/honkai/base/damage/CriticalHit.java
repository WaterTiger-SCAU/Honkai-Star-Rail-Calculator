package cn.watertiger.honkai.base.damage;

/**
 * @author water-tiger
 */
public class CriticalHit {
    /**
     * 暴击率
     */
    private double criticalRate;
    /**
     * 暴击伤害
     */
    private double criticalDamage;

    public CriticalHit(double criticalRate, double criticalDamage) {
        this.criticalRate = criticalRate;
        this.criticalDamage = criticalDamage;
    }

    public double getCriticalExpect() {
        return criticalRate * criticalDamage;
    }

    /* Getter & Setter */

    public double getCriticalRate() {
        return criticalRate;
    }

    public CriticalHit setCriticalRate(double criticalRate) {
        this.criticalRate = criticalRate;
        return this;
    }

    public double getCriticalDamage() {
        return criticalDamage;
    }

    public CriticalHit setCriticalDamage(double criticalDamage) {
        this.criticalDamage = criticalDamage;
        return this;
    }
}
