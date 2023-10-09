package br.com.dcx.ufpb.eng.ApiCiclismo.repositories;

import br.com.dcx.ufpb.eng.ApiCiclismo.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Long> {}

