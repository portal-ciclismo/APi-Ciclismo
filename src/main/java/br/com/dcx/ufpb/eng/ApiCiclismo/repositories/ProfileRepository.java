package br.com.dcx.ufpb.eng.ApiCiclismo.repositories;

import br.com.dcx.ufpb.eng.ApiCiclismo.entity.Profile;
import br.com.dcx.ufpb.eng.ApiCiclismo.enums.CyclingCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfileRepository extends JpaRepository<Profile,Long> {

    List<Profile> findByFullName(String fullName);

    List<Profile> findByNickname(String nickname);

    List<Profile> findByCyclingCategory(CyclingCategory cyclingCategory);

    List<Profile> findByLocation(String location);
}
