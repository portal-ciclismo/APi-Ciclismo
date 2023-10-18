package br.com.dcx.ufpb.eng.ApiCiclismo.service;

import br.com.dcx.ufpb.eng.ApiCiclismo.entity.Bike;

import java.util.List;
import java.util.Optional;

public interface BikeService {
    Bike saveBike(Bike bike);
    Optional<Bike> getBikeById(Long id);
    List<Bike> getAllBikes();
    void updateBike(Long id, Bike updatedBike);
    void deleteBike(Long id);
    Integer getWheelSize(Long id);
    String getFrameBrand(Long id);
    String getFrameMaterial(Long id);
}
