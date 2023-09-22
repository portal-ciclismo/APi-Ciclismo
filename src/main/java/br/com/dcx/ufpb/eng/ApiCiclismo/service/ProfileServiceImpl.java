package br.com.dcx.ufpb.eng.ApiCiclismo.service;


import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;


    private final ProfileRepository profileRepository;

    @Autowired
    public ProfileServiceImpl(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @Override
    @Transactional
    public Profile createProfile(Profile profile) {
        return profileRepository.save(profile);
    }

    @Override
    public Profile getProfileById(Long id) {
        return profileRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Profile not found in DB"));
    }

    @Override
    @Transactional
    public void deleteProfile(Long id) {
        profileRepository.findById(id).ifPresentOrElse(
            userFind -> profileRepository.delete(userFind),
            () -> { throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Profile not found in DB"); }
        );
    }

    @Override
    public List<Profile> getProfilesByFullName(String fullName) {
        List<Profile> profiles = profileRepository.findByFullName(fullName);
        if (profiles.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Profile not found in DB");
        }
        return profiles;
    }

    @Override
    public List<Profile> getProfilesByNickname(String nickname) {
        List<Profile> profiles = profileRepository.getProfilesByNickname(nickname);
        if (profiles.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Profile not found in DB");
        }
        return profiles;
    }

    @Override
    public List<Profile> getProfilesByCyclingCategory(CyclingCategory cyclingCategory) {
        List<Profile> profiles = profileRepository.findByCyclingCategory(cyclingCategory);
        if (profiles.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Profile not found in DB");
        }
        return profiles;
    }

    @Override
    public List<Profile> getProfilesByUserType(UserType userType) {
        List<Profile> profiles = profileRepository.findByUserType(userType);
        if (profiles.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Profile not found in DB");
        }
        return profiles;
    }

    @Override
    public List<Profile> getProfilesByLocation(String location) {
        List<Profile> profiles = profileRepository.getProfilesByLocation(location);
        if (profiles.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Profile not found in DB");
        }
        return profiles;
    }

    @Override
    @Transactional
    public Profile updateProfile(Long id, Profile updatedProfile) {
        Optional<Profile> existingProfileOptional = profileRepository.findById(id);

        return existingProfileOptional.map(existingProfile ->{
            existingProfile.setFullName(updatedProfile.getFullName());
            existingProfile.setNickname(updatedProfile.getNickname());
            existingProfile.setCyclingCategory(updatedProfile.getCyclingCategory());
            existingProfile.setUserType(updatedProfile.getUserType());
            existingProfile.setLocation(updatedProfile.getLocation());
            return profileRepository.save(existingProfile);
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Profile not found in DB"));
    }

}
