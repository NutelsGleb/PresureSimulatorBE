package nutels.presuresimulator.be.repository;

import nutels.presuresimulator.be.models.Measurement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MeasurementRepo extends JpaRepository<Measurement, Long> {
    void deleteAllByPersonId(Long personId);
    List<Measurement> findTop10ByPersonIdOrderByDateDesc(Long personId);
}
