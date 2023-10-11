package br.com.dcx.ufpb.eng.ApiCiclismo.service;

import br.com.dcx.ufpb.eng.ApiCiclismo.entity.Profile;
import br.com.dcx.ufpb.eng.ApiCiclismo.enums.CyclingCategory;
import org.hibernate.usertype.UserType;

import java.util.List;

public interface ProfileService {

    public Profile saveProfile(Profile profile);

    public Profile getProfileById(Long id);

    public void deleteProfile(Long id);

    public List<Profile> getProfilesByFullName(String fullName);

    public List<Profile> getProfilesByNickname(String nickname);

    public List<Profile> getProfilesByCyclingCategory(CyclingCategory cyclingCategory);

    public List<Profile> getProfilesByUserType(UserType userType);

    public List<Profile> getProfilesByLocation(String location);

    public Profile updateProfile(Long id, ProfileService updatedProfile);

}
