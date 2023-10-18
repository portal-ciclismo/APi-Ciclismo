package br.com.dcx.ufpb.eng.ApiCiclismo.service.serviceIMPL;

import br.com.dcx.ufpb.eng.ApiCiclismo.dto.BikeDTO;
import br.com.dcx.ufpb.eng.ApiCiclismo.entity.Bike;
import br.com.dcx.ufpb.eng.ApiCiclismo.exception.BikeNotFoundException;
import br.com.dcx.ufpb.eng.ApiCiclismo.repositories.BikeRepository;
import br.com.dcx.ufpb.eng.ApiCiclismo.service.BikeService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class BikeServiceimpl implements BikeService {

    private BikeRepository bikeRepository;

    public BikeServiceimpl(BikeRepository bikeRepository) {
        this.bikeRepository = bikeRepository;
    }

    @Autowired
    public void BikeService(BikeRepository bikeRepository) {
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

    @Override
    public List<Bike> getAllBikes() {
        return null;
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

    public String getFrameMaterial(Long id) throws BikeNotFoundException {
        Optional<Bike> optionalBike = bikeRepository.findById(id);
        if (optionalBike.isPresent()) {
            return optionalBike.get().getFrameMaterial();
        } else {
            throw new BikeNotFoundException("Bike not found.");
        }
    }

    public String getFrameBrand(Long id) throws BikeNotFoundException {
        Optional<Bike> optionalBike = bikeRepository.findById(id);
        if (optionalBike.isPresent()) {
            return optionalBike.get().getFrameBrand();
        } else {
            throw new BikeNotFoundException("Bike not found.");
        }
    }

    public Integer getWheelSize(Long id) throws BikeNotFoundException {
        Optional<Bike> optionalBike = bikeRepository.findById(id);
        if (optionalBike.isPresent()) {
            return optionalBike.get().getWheelSize();
        } else {
            throw new BikeNotFoundException("Bike not found.");
        }
    }
}

