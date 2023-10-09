package br.com.dcx.ufpb.eng.ApiCiclismo.repositories;

import br.com.dcx.ufpb.eng.ApiCiclismo.entity.Profile;
import br.com.dcx.ufpb.eng.ApiCiclismo.enums.CyclingCategory;
import br.com.dcx.ufpb.eng.ApiCiclismo.service.ProfileService;
import org.hibernate.usertype.UserType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProfileRepository extends JpaRepository<Profile, Long> {


    List<Profile> getProfilesByLocation(String location);

    List<Profile> findByUserType(UserType userType);

    List<Profile> findByCyclingCategory(CyclingCategory cyclingCategory);

    List<Profile> getProfilesByNickname(String nickname);

    List<Profile> findByFullName(String fullName);
}

