package br.com.dcx.ufpb.eng.ApiCiclismo.service;


import br.com.dcx.ufpb.eng.ApiCiclismo.entity.Profile;
import br.com.dcx.ufpb.eng.ApiCiclismo.enums.CyclingCategory;
import br.com.dcx.ufpb.eng.ApiCiclismo.repositories.ProfileRepository;
import org.hibernate.usertype.UserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ProfileServiceImpl implements ProfileService {

    private final ProfileRepository profileRepository;

    @Autowired
    public ProfileServiceImpl(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @Transactional
    public ProfileService createProfile(ProfileService profile) {
        return profileRepository.save(profile);
    }

    @Override
    public ProfileService saveProfile(ProfileService profile) {
        return null;
    }

    public Profile getProfileById(Long id) {
        return profileRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Profile not found in DB"));
    }

    
    @Transactional
    public void deleteProfile(Long id) {
        profileRepository.findById(id).ifPresentOrElse(
            userFind -> profileRepository.delete(userFind),
            () -> { throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Profile not found in DB"); }
        );
    }

    public List<ProfileService> getProfilesByFullName(String fullName) {
        List<ProfileService> profiles = profileRepository.findByFullName(fullName);
        if (profiles.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Profile not found in DB");
        }
        return profiles;
    }

    public List<ProfileService> getProfilesByNickname(String nickname) {
        List<ProfileService> profiles = profileRepository.getProfilesByNickname(nickname);
        if (profiles.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Profile not found in DB");
        }
        return profiles;
    }

    @Override
    public List<ProfileService> getProfilesByCyclingCategory(CyclingCategory cyclingCategory) {
        List<ProfileService> profiles = profileRepository.findByCyclingCategory(cyclingCategory);
        if (profiles.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nenhum perfil encontrado na categoria de ciclismo especificada");
        } else {
            return profiles;
        }
    }

    @Override
    public List<ProfileService> getProfilesByUserType(UserType userType) {
        List<ProfileService> profiles = profileRepository.findByUserType(userType);
        if (profiles.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nenhum perfil encontrado para o tipo de usuário especificado");
        }
        return profiles;
    }

    public List<ProfileService> getProfilesByCyclingCategory(CyclingCategory cyclingCategory) {
        List<ProfileService> profiles = profileRepository.findByCyclingCategory(cyclingCategory);
        if (profiles.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Profile not found in DB");
        }
        return profiles;
    }

    public List<ProfileService> getProfilesByUserType(UserType userType) {
        List<ProfileService> profiles = profileRepository.findByUserType(userType);
        if (profiles.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Profile not found in DB");
        }
        return profiles;
    }

    public List<ProfileService> getProfilesByLocation(String location) {
        List<ProfileService> profiles = profileRepository.getProfilesByLocation(location);
        if (profiles.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Profile not found in DB");
        }
        return profiles;
    }

    @Transactional
    public ProfileService updateProfile(Long id, ProfileService updatedProfile) {
        return profileRepository.findById(id)
                .map(existingProfile -> {
                    existingProfile.setFullName(updatedProfile.getFullName());
                    existingProfile.setNickname(updatedProfile.getNickname());
                    existingProfile.setCyclingCategory(updatedProfile.getCyclingCategory());
                    existingProfile.setUserType(updatedProfile.getUserType());
                    existingProfile.setLocation(updatedProfile.getLocation());
                    return profileRepository.save(existingProfile);
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Perfil não encontrado no banco de dados"));
    }
}
