package br.com.dcx.ufpb.eng.ApiCiclismo.service;

import br.com.dcx.ufpb.eng.ApiCiclismo.dto.ProfileDTO;
import br.com.dcx.ufpb.eng.ApiCiclismo.entity.Profile;
import br.com.dcx.ufpb.eng.ApiCiclismo.enums.CyclingCategory;
import br.com.dcx.ufpb.eng.ApiCiclismo.exception.ProfileNotFoudException;
import br.com.dcx.ufpb.eng.ApiCiclismo.repositories.ProfileRepository;
import org.hibernate.usertype.UserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfileServiceImpl implements ProfileService {


    private ProfileRepository profileRepository;

    @Autowired
    public ProfileServiceImpl(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    public List<Profile> getProfiles() {
        return profileRepository.findAll();
    }

    public Profile saveProfile(Profile profile) {
        return profileRepository.save(profile);
    }

    public Optional<Profile> getProfileById(Long id) throws ProfileNotFoudException {
        Optional<Profile> optionalProfile = profileRepository.findById(id);
        if (optionalProfile.isEmpty()) {
            throw new ProfileNotFoudException("Profile not found.");
        }
        return optionalProfile;
    }

    public void deleteProfile(Long id) throws ProfileNotFoudException {
        Optional<Profile> optionalProfile = profileRepository.findById(id);
        if (optionalProfile.isEmpty()) {
            throw new ProfileNotFoudException("Profile not found.");
        }
        profileRepository.deleteById(id);
    }

    public void updateProfile(Long id, ProfileDTO profileDTO) throws ProfileNotFoudException {
        Optional<Profile> optionalProfile = profileRepository.findById(id);
        if (optionalProfile.isEmpty()) {
            throw new ProfileNotFoudException("Profile not found.");
        }
        Profile profile = optionalProfile.get();

        CyclingCategory categoriaAtual = profile.getCyclingCategory();

        if (categoriaAtual == CyclingCategory.AMADOR) {
            profile.setCiclistaProfissional();
        } else if (categoriaAtual == CyclingCategory.PROFISSIONAL) {
            profile.setCiclistaAmador();
        }else {
            throw new ProfileNotFoudException("Categoria deve ser AMADOR ou PROFISSIONAL.");
        }

        profile.setFullName(profileDTO.getFullName());
        profile.setNickname(profileDTO.getNickname());
        profile.setSexo(profileDTO.getSexo());
        profile.setLocation(profileDTO.getLocation());
        //profile.setCiclistaAmador(profileDTO.ciclistaAmador());
        //profile.setCiclistaProfissional(profileDTO.ciclistaProfissional());


        profileRepository.save(profile);
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
}
