package cn.watertiger.honkai.base.damage;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BaseDamageTest {
    @Test
    void calculateBaseDamageValue() {
        // 攻击力
        int attack = 2000;
        // 普通攻击倍率
        double normalAttackDamageMultiplier = 1.0;
        // 技能攻击倍率
        double specialAttackDamageMultiplier = 3.0;

        BaseDamage normalAttack = new BaseDamage(attack, normalAttackDamageMultiplier);
        BaseDamage specialAttack = new BaseDamage(attack, specialAttackDamageMultiplier);

        System.out.println("普通攻击伤害 : " + normalAttack.calculateDamageValue());
        System.out.println("技能攻击伤害 : " + specialAttack.calculateDamageValue());

        Assertions.assertEquals(
                normalAttack.calculateDamageValue() / normalAttack.getDamageMultiplier(),
                specialAttack.calculateDamageValue() / specialAttack.getDamageMultiplier()
        );
    }
}