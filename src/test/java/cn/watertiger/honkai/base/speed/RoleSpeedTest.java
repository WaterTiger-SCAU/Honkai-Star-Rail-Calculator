package cn.watertiger.honkai.base.speed;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class RoleSpeedTest {
    public static Stream<Arguments> speedAndActionValuePairProvider() {
        return Stream.of(
                Arguments.of(150, 66),
                Arguments.of(153, 65)
        );
    }

    @DisplayName("速度计算行动值")
    @ParameterizedTest
    @MethodSource("speedAndActionValuePairProvider")
    void calculateActionValueTest(int speed, int expectActionValue) {
        RoleSpeed roleSpeed = new RoleSpeed(speed);

        Assertions.assertEquals(roleSpeed.getActionValue(), expectActionValue);
    }
}