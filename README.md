### 崩坏-星穹铁道数值计算器

##### 伤害公式

```
DMG = 攻击力*伤害倍率*增伤区*暴击区
      *(1-敌方减伤)
      *(1+敌方易伤)
      *(1-(抗性-穿透))
      *防御力减伤
```

- [x] 攻击力 & 伤害倍率
- [x] 增伤区
- [x] 暴击区
- [x] 敌方减伤区
- [x] 易伤区
- [x] 抗性 & 穿透区
- [ ] 防御力减伤

##### 速度计算

```
行动值 = 10000 / 速度
```

- [x] 行动值

##### 能量循环

```
能量获取量 = 基础回能 * (1 + 能量恢复效率)
```

回能手段：

| 方式   | 数值   | 备注                               |
|------|------|----------------------------------|
| 普攻   | 20   |                                  |
| 战技   | 30   | 镜流非转魄状态的战技恢复能量为20                |
| 终结技  | 5    |                                  |
| 击杀   | 10   |                                  |
| 受击   | 5～36 | 不同敌方攻击恢复的能量值不同                   |
| 追加攻击 | 5/10 | 黑塔 & 克拉拉 5 <br> 姬子 & 彦卿 & 三月七 10 |
