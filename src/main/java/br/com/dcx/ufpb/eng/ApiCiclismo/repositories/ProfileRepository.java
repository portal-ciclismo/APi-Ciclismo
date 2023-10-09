package br.com.dcx.ufpb.eng.ApiCiclismo.repositories;

import br.com.dcx.ufpb.eng.ApiCiclismo.entity.Profile;
import br.com.dcx.ufpb.eng.ApiCiclismo.enums.CyclingCategory;
import br.com.dcx.ufpb.eng.ApiCiclismo.service.ProfileService;
import org.hibernate.usertype.UserType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProfileRepository extends JpaRepository<Profile, Long> {


    List<ProfileService> getProfilesByLocation(String location);

    List<ProfileService> findByUserType(UserType userType);

    List<ProfileService> findByCyclingCategory(CyclingCategory cyclingCategory);

    List<ProfileService> getProfilesByNickname(String nickname);

    List<ProfileService> findByFullName(String fullName);
}

