package br.com.dcx.ufpb.eng.ApiCiclismo.repositories;
import br.com.dcx.ufpb.eng.ApiCiclismo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

   UserDetails findByLogin(String userName);
    UserDetails findByEmail(String email);
}
