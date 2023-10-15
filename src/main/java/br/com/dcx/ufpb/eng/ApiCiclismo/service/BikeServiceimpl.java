package br.com.dcx.ufpb.eng.ApiCiclismo.service;

import br.com.dcx.ufpb.eng.ApiCiclismo.entity.Bike;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class BikeServiceimpl implements BikeService {

    private final BikeRepository bikeRepository;

    @Autowired
    public BikeService(BikeRepository bikeRepository) {
        this.bikeRepository = bikeRepository;
    }

    public List<Bike> getBikes() {
        return bikeRepository.findAll();
    }

    public Bike saveBike(Bike bike) {
        return bikeRepository.save(bike);
    }

    public Optional<Bike> getBikeById(Long id) throws BikeNotFoundException {
        Optional<Bike> optionalBike = bikeRepository.findById(id);
        if (optionalBike.isEmpty()) {
            throw new BikeNotFoundException("Bike not found.");
        }
        return optionalBike;
    }

    public void deleteBike(Long id) throws BikeNotFoundException {
        Optional<Bike> optionalBike = bikeRepository.findById(id);
        if (optionalBike.isEmpty()) {
            throw new BikeNotFoundException("Bike not found.");
        }
        bikeRepository.deleteById(id);
    }

    public void updateBike(Long id, BikeDTO bikeDTO) throws BikeNotFoundException {
        Optional<Bike> optionalBike = bikeRepository.findById(id);
        if (optionalBike.isEmpty()) {
            throw new BikeNotFoundException("Bike not found.");
        }
        Bike bike = optionalBike.get();
        bike.setWheelSize(bikeDTO.getWheelSize());
        bike.setFrameBrand(bikeDTO.getFrameBrand());
        bike.setFrameMaterial(bikeDTO.getFrameMaterial());
        bikeRepository.save(bike);
    }

    public FrameMaterial getFrameMaterial(Long id) throws BikeNotFoundException {
        Optional<Bike> optionalBike = bikeRepository.findById(id);
        if (optionalBike.isPresent()) {
            return optionalBike.get().getFrameMaterial();
        } else {
            throw new BikeNotFoundException("Bike not found.");
        }
    }

    public FrameBrand getFrameBrand(Long id) throws BikeNotFoundException {
        Optional<Bike> optionalBike = bikeRepository.findById(id);
        if (optionalBike.isPresent()) {
            return optionalBike.get().getFrameBrand();
        } else {
            throw new BikeNotFoundException("Bike not found.");
        }
    }

    public WheelSize getWheelSize(Long id) throws BikeNotFoundException {
        Optional<Bike> optionalBike = bikeRepository.findById(id);
        if (optionalBike.isPresent()) {
            return optionalBike.get().getWheelSize();
        } else {
            throw new BikeNotFoundException("Bike not found.");
        }
    }
}

