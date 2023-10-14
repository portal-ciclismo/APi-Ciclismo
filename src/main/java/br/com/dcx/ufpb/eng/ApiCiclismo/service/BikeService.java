package br.com.dcx.ufpb.eng.ApiCiclismo.service;

public interface BikeService {
    Bike saveBike(Bike bike);
    Optional<Bike> getBikeById(Long id);
   List<Bike> getAllBikes();
   void updateBike(Long id, Bike updatedBike);
   void deleteBike(Long id);
   WheelSize getWheelSize(Long id);
   FrameBrand getFrameBrand(Long id);
   FrameMaterial getFrameMaterial(Long id);

}
