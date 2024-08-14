package nutels.presuresimulator.be.service;

import jakarta.transaction.Transactional;
import nutels.presuresimulator.be.models.Measurement;
import nutels.presuresimulator.be.repository.MeasurementRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeasurementServiceImpl implements MeasurementService {

    @Autowired
    private MeasurementRepo measurementRepo;

    @Override
    public List<Measurement> getMeasurements(Long personId) {
        try {
            return measurementRepo.findTop10ByPersonIdOrderByDateDesc(personId);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void createNewMeasurement(Measurement mesurement) {
        measurementRepo.save(mesurement);
    }

    @Override
    @Transactional
    public void clearMeasurements(Long personId) {
        measurementRepo.deleteAllByPersonId(personId);
    }

}