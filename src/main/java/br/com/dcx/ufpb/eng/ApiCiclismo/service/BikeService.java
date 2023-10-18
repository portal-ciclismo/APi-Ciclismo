package br.com.dcx.ufpb.eng.ApiCiclismo.service;

import br.com.dcx.ufpb.eng.ApiCiclismo.dto.BikeDTO;
import br.com.dcx.ufpb.eng.ApiCiclismo.entity.Bike;
import br.com.dcx.ufpb.eng.ApiCiclismo.exception.BikeNotFoundException;

import java.util.List;
import java.util.Optional;

public interface BikeService {
    Bike saveBike(Bike bike);
    Optional<Bike> getBikeById(Long id) throws BikeNotFoundException;
    List<Bike> getAllBikes();
    void updateBike(Long id, BikeDTO bikeDTO) throws BikeNotFoundException;
    void deleteBike(Long id) throws BikeNotFoundException;
    Integer getWheelSize(Long id) throws BikeNotFoundException;
    String getFrameBrand(Long id) throws BikeNotFoundException;
    String getFrameMaterial(Long id) throws BikeNotFoundException;
}
