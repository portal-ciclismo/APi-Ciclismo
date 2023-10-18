package br.com.dcx.ufpb.eng.ApiCiclismo.service.serviceIMPL;

import br.com.dcx.ufpb.eng.ApiCiclismo.dto.ProfileDTO;
import br.com.dcx.ufpb.eng.ApiCiclismo.entity.Profile;
import br.com.dcx.ufpb.eng.ApiCiclismo.enums.CyclingCategory;
import br.com.dcx.ufpb.eng.ApiCiclismo.exception.ProfileNotFoundException;
import br.com.dcx.ufpb.eng.ApiCiclismo.repositories.ProfileRepository;
import br.com.dcx.ufpb.eng.ApiCiclismo.service.ProfileService;
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

    public Optional<Profile> getProfileById(Long id) throws ProfileNotFoundException {
        Optional<Profile> optionalProfile = profileRepository.findById(id);
        if (optionalProfile.isEmpty()) {
            throw new ProfileNotFoundException("Profile not found.");
        }
        return optionalProfile;
    }

    public void deleteProfile(Long id) throws ProfileNotFoundException {
        Optional<Profile> optionalProfile = profileRepository.findById(id);
        if (optionalProfile.isEmpty()) {
            throw new ProfileNotFoundException("Profile not found.");
        }
        profileRepository.deleteById(id);
    }
  
    public void updateProfile(Long id, ProfileDTO profileDTO) throws ProfileNotFoundException {
        Optional<Profile> optionalProfile = profileRepository.findById(id);
        if (optionalProfile.isEmpty()) {
            throw new ProfileNotFoundException("Profile not found.");
        }
        Profile profile = optionalProfile.get();

        CyclingCategory categoriaAtual = profile.getCyclingCategory();
        CyclingCategory novaCategoria = profileDTO.getCyclingCategory();

        if (categoriaAtual != novaCategoria){
            if (novaCategoria == CyclingCategory.AMADOR) {
                profile.setCiclistaAmador();
            } else if (novaCategoria == CyclingCategory.PROFISSIONAL) {
                profile.setCiclistaProfissional();
            }
        }

        profile.setFullName(profileDTO.getFullName());
        profile.setNickname(profileDTO.getNickname());
        profile.setSexo(profileDTO.getSexo());
        profile.setLocation(profileDTO.getLocation());
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
