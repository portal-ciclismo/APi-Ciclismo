package br.com.dcx.ufpb.eng.ApiCiclismo.repositories;
import br.com.dcx.ufpb.eng.ApiCiclismo.entity.EmailModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailRepository  extends JpaRepository<EmailModel,Long> {
}
