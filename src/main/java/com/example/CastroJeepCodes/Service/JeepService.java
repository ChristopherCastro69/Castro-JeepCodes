package com.example.CastroJeepCodes.Service;

import com.example.CastroJeepCodes.Model.Jeep;
import com.example.CastroJeepCodes.Repository.JeepRepo;
import org.springframework.stereotype.Service;

import java.util.List;

//POSTMAN METHODS
@Service
public class JeepService {
    private final JeepRepo jeepRepo;

    public JeepService(JeepRepo jeepRepo) {
        this.jeepRepo = jeepRepo;
    }

    public Jeep saveDetails(Jeep jeep){
        return jeepRepo.save(jeep);
    }

    public Jeep getJeepById(int jeepId) {
        return jeepRepo.findById(jeepId).orElseThrow(() -> new RuntimeException("Jeep not found with id: " + jeepId));
    }


    // New method to find jeeps by jeep_codes name
    public List<Jeep> getByJeepCode(String jeepCodeName) {
        return jeepRepo.findByJeepCode(jeepCodeName);
    }
}
