package br.com.dcx.ufpb.eng.ApiCiclismo.controller;

import br.com.dcx.ufpb.eng.ApiCiclismo.dto.BikeDTO;
import br.com.dcx.ufpb.eng.ApiCiclismo.entity.Bike;
import br.com.dcx.ufpb.eng.ApiCiclismo.exception.BikeNotFoundException;
import br.com.dcx.ufpb.eng.ApiCiclismo.service.BikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bike")
public class BikeController {

    private BikeService bikeService;

    @Autowired
    public BikeController(BikeService bikeService){
        this.bikeService = bikeService;
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<Bike>getBikes(){
        return bikeService.getAllBikes();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Bike saveBike(@RequestBody Bike bike){
        return bikeService.saveBike(bike);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Optional<Bike> getBikeById(@PathVariable Long id) throws BikeNotFoundException {
        return bikeService.getBikeById(id);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Integer getWheelSize(@PathVariable Long id) throws BikeNotFoundException {
        return bikeService.getWheelSize(id);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String getFrameBrand(@PathVariable Long id) throws BikeNotFoundException {
        return bikeService.getFrameBrand(id);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String getFrameMaterial(@PathVariable Long id) throws BikeNotFoundException {
        return bikeService.getFrameMaterial(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateBike(@PathVariable Long id, @RequestBody BikeDTO bikeDTO) throws BikeNotFoundException{
        bikeService.updateBike(id, bikeDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBike(@PathVariable Long id, @RequestBody BikeDTO bikeDTO)throws BikeNotFoundException {
        bikeService.updateBike(id, bikeDTO);
    }
//
}
