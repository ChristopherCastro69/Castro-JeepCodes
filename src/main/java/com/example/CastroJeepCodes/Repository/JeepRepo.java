package com.example.CastroJeepCodes.Repository;

import com.example.CastroJeepCodes.Model.Jeep;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JeepRepo extends JpaRepository<Jeep, Integer> {
    //perform CRUD operations
    Jeep findByJeepId(int jeepId);

    List<Jeep> findByJeepCode(String jeepCode);
}
