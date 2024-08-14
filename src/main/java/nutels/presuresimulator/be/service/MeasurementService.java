package nutels.presuresimulator.be.service;

import nutels.presuresimulator.be.models.Measurement;
import java.util.List;

public interface MeasurementService {
    List<Measurement> getMeasurements(Long personId);
    void createNewMeasurement(Measurement mesurement);
    void clearMeasurements(Long personId);
}
