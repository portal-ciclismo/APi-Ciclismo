package br.com.dcx.ufpb.eng.ApiCiclismo.repositories;

import br.com.dcx.ufpb.eng.ApiCiclismo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
