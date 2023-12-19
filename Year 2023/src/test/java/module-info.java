module year_2023_main_test {
    // libs
    requires org.junit.jupiter.api;
    // app
    requires year_2023_main;

    // app
    exports com.github.silviuburceadev.aoc.test.engine;
    exports com.github.silviuburceadev.aoc.test.gamecube;
    exports com.github.silviuburceadev.aoc.test.calibration;
}