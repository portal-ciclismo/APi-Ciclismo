package br.com.dcx.ufpb.eng.ApiCiclismo.service;

import br.com.dcx.ufpb.eng.ApiCiclismo.entity.Profile;
import br.com.dcx.ufpb.eng.ApiCiclismo.enums.CyclingCategory;
import br.com.dcx.ufpb.eng.ApiCiclismo.repositories.ProfileRepository;
import org.hibernate.usertype.UserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProfileServiceImpl implements ProfileService {


    // falta implementar





    private ProfileRepository profileRepository;

    @Autowired
    public ProfileServiceImpl(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    public Profile saveProfile(Profile profile) {
        return profileRepository.save(profile);
    }

    public Profile getProfileById(Long id) {
        return null;
    }


    public void deleteProfile(Long id) {

    }


    public List<Profile> getProfilesByFullName(String fullName) {
        return null;
    }


    public List<Profile> getProfilesByNickname(String nickname) {
        return null;
    }


    public List<Profile> getProfilesByCyclingCategory(CyclingCategory cyclingCategory) {
        return null;
    }

    public List<Profile> getProfilesByUserType(UserType userType) {
        return null;
    }


    public List<Profile> getProfilesByLocation(String location) {
        return null;
    }

    public Profile updateProfile(Long id, ProfileService updatedProfile) {
        return null;
    }

}
