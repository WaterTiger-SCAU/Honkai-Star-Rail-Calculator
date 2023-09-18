package cn.watertiger.honkai.base.damage;

import cn.watertiger.honkai.base.util.DoubleMathUtil;

/**
 * @author water-tiger
 */
public class BaseDamage {
    /**
     * 攻击力
     */
    private int attack;
    /**
     * 倍率
     */
    private double damageMultiplier;

    public BaseDamage(int attack, double damageMultiplier) {
        this.attack = attack;
        this.damageMultiplier = damageMultiplier;
    }

    public int calculateDamageValue() {
        return (int) (DoubleMathUtil.multiply(attack, damageMultiplier));
    }

    /* Getter & Setter */

    public int getAttack() {
        return attack;
    }

    public BaseDamage setAttack(int attack) {
        this.attack = attack;
        return this;
    }

    public double getDamageMultiplier() {
        return damageMultiplier;
    }

    public BaseDamage setDamageMultiplier(double damageMultiplier) {
        this.damageMultiplier = damageMultiplier;
        return this;
    }
}
