package br.com.dcx.ufpb.eng.ApiCiclismo.service;

import br.com.dcx.ufpb.eng.ApiCiclismo.dto.ProfileDTO;
import br.com.dcx.ufpb.eng.ApiCiclismo.entity.Profile;
import br.com.dcx.ufpb.eng.ApiCiclismo.enums.CyclingCategory;
import br.com.dcx.ufpb.eng.ApiCiclismo.exception.ProfileNotFoudException;
import org.hibernate.usertype.UserType;

import java.util.List;
import java.util.Optional;

public interface ProfileService {

    public Profile saveProfile(Profile profile);

    public List<Profile> getProfiles();

    public Optional<Profile> getProfileById(Long id) throws ProfileNotFoudException;

    public void updateProfile (Long id, ProfileDTO profileDTO)throws ProfileNotFoudException;

    public void deleteProfile(Long id) throws ProfileNotFoudException;

    public List<Profile> getProfilesByFullName(String fullName);

    public List<Profile> getProfilesByNickname(String nickname);

    public List<Profile> getProfilesByCyclingCategory(CyclingCategory cyclingCategory);

    public List<Profile> getProfilesByUserType(UserType userType);

    public List<Profile> getProfilesByLocation(String location);

}
