package nutels.presuresimulator.be.models;

import nutels.presuresimulator.be.features.HealthMetricsGenerator;
import nutels.presuresimulator.be.service.GeneratedPresureService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class GeneratedPresure implements GeneratedPresureService {
    private double systolicPressure;
    private double diastolicPressure;
    private double heartRate;

    public double getSystolicPressure() {
        return systolicPressure;
    }

    public double getDiastolicPressure() {
        return diastolicPressure;
    }

    public double getHeartRate() {
        return heartRate;
    }

    public GeneratedPresure() {
        HealthMetricsGenerator generator = new HealthMetricsGenerator();

        this.systolicPressure = generator.generateSystolicPressure();
        this.diastolicPressure = generator.generateDiastolicPressure();
        this.heartRate = generator.generateHeartRate();
    }
}
