package br.com.dcx.ufpb.eng.ApiCiclismo.repositories;

import br.com.dcx.ufpb.eng.ApiCiclismo.entity.Bike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BikeRepository extends JpaRepository<Bike, Long> {

    List<Bike> findByWheelSize(Integer wheelsize);

    List<Bike> findByFrameMaterial (String frameMaterial);

    List<Bike> findByFrameBrand (String frameBrand);
}
