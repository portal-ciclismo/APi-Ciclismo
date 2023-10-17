package br.com.dcx.ufpb.eng.ApiCiclismo.repositories;

import br.com.dcx.ufpb.eng.ApiCiclismo.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GroupRepository extends JpaRepository<Group, Long>{

    List<Group> findByLocation(String location);
}
