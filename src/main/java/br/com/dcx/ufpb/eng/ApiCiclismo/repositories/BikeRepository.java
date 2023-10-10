package br.com.dcx.ufpb.eng.ApiCiclismo.repositories;

import br.com.dcx.ufpb.eng.ApiCiclismo.entity.Bike;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BikeRepository extends JpaRepository<Bike, Long> {
}
