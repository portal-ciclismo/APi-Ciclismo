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
        return profileRepository.getReferenceById(id);
    }

    public void deleteProfile(Long id) {
        profileRepository.deleteById(id);
    }

    public List<Profile> getProfilesByFullName(String fullName) {
        return profileRepository.findByFullName(fullName);
    }

    public List<Profile> getProfilesByNickname(String nickname) {
        return profileRepository.findByNickname(nickname);
    }

    public List<Profile> getProfilesByCyclingCategory(CyclingCategory cyclingCategory) {
        return profileRepository.findByCyclingCategory(cyclingCategory);
    }

    public List<Profile> getProfilesByUserType(UserType userType) {
        return null;
    }


    public List<Profile> getProfilesByLocation(String location) {
        return profileRepository.findByLocation(location);
    }

    public Profile updateProfile(Long id, ProfileService updatedProfile) {
        return null;
    }

    public Profile readProfile(Long id) {
        return profileRepository.getReferenceById(id);
    }

    public Profile createProfile(Profile profile) {
        return profileRepository.save(profile);
    }

}
