package nutels.presuresimulator.be.service;

import nutels.presuresimulator.be.models.GeneratedPresure;

public interface GeneratedPresureService {
    public default GeneratedPresure generateNewPresure() {
        return null;
    }
}
