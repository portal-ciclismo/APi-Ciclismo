package br.com.dcx.ufpb.eng.ApiCiclismo.service;


import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class ProfileServiceImpl implements ProfileService {

    private final ProfileService profileRepository;

    @Autowired
    public ProfileServiceImpl(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @Transactional
    public Profile createProfile(Profile profile) {
        return profileRepository.save(profile);
    }


    public Profile getProfileById(Long id) {
        return profileRepository.findById(id).
                orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Profile not Find in DB"));;
    }

    @Transactional
    public void deleteProfile(Long id) {
        profileRepository.findById(userId).map(userFind -> {
            profileRepository.delete(userFind);
            return userFind;
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Profile not Find in DB"));
    }

    public List<Profile> getProfilesByFullName(String fullName) {
        List<Profile> profiles = profileRepository.findByFullName(fullName);
        if (profiles.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Profile not found in DB");
        }
        return profiles;
    }


    public List<Profile> getProfilesByNickname(String nickname) {
        List<Profile> profiles = profileRepository.getProfilesByNickname(nickname);
        if (profiles.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Profile not found in DB");
        }
        return profiles;
    }


    public List<Profile> getProfilesByCyclingCategory(CyclingCategory cyclingCategory) {
        List<Profile> profiles = profileRepository.getProfilesByNickname(nickname);
        if (profiles.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Profile not found in DB");
        }
        return profileRepository.findByCyclingCategory(cyclingCategory);
    }


    public List<Profile> getProfilesByUserType(UserType userType) {
        List<Profile> profiles = profileRepository.findByUserType(userType);
        if (profiles.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Profile not found in DB");
        }
        return profiles;
    }


    public List<Profile> getProfilesByLocation(String location) {
        List<Profile> profiles = profileRepository.getProfilesByLocation(location);
        if (profiles.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Profile not found in DB");
        }
        return profiles;
    }

    @Transactional
    public Profile updateProfile(Long id, Profile updatedProfile) {
        Optional existingProfileOptional = profileRepository.findById(id);

        return existingProfileOptional.map(existingProfile ->{
            existingProfile.setFullName(updatedProfile.getFullName());
            existingProfile.setNickname(updatedProfile.getNickname());
            existingProfile.setCyclingCategory(updatedProfile.getCyclingCategory());
            existingProfile.setUserType(updatedProfile.getUserType());
            existingProfile.setLocation(updatedProfile.getLocation());
            return profileRepository.save(existingProfile);
        }).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Profile not Find in DB"));

    }

}
