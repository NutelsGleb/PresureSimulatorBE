package nutels.presuresimulator.be.features;

import java.util.Random;

public class HealthMetricsGenerator {

    private static final double MIN_SYSTOLIC_PRESSURE = 80.0; //90.0 -ok
    private static final double MAX_SYSTOLIC_PRESSURE = 140.0;//120.0 -ok
    private static final double MIN_DIASTOLIC_PRESSURE = 50.0;//60.0 -ok
    private static final double MAX_DIASTOLIC_PRESSURE = 90.0;//80 -ok
    private static final double MIN_HEART_RATE = 50.0;//60.0 -ok
    private static final double MAX_HEART_RATE = 120.0;//100 -ok

    private Random random;

    public HealthMetricsGenerator() {
        this.random = new Random();
    }

    public double generateSystolicPressure() {
        return round(random.nextDouble() * (MAX_SYSTOLIC_PRESSURE - MIN_SYSTOLIC_PRESSURE) + MIN_SYSTOLIC_PRESSURE);
    }

    public double generateDiastolicPressure() {
        return round(random.nextDouble() * (MAX_DIASTOLIC_PRESSURE - MIN_DIASTOLIC_PRESSURE) + MIN_DIASTOLIC_PRESSURE);
    }

    public double generateHeartRate() {
        return round(random.nextDouble() * (MAX_HEART_RATE - MIN_HEART_RATE) + MIN_HEART_RATE);
    }

    private double round(double value) {
        return Math.round(value * 100.0) / 100.0;
    }
}
