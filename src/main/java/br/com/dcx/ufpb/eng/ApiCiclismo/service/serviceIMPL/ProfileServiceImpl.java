package br.com.dcx.ufpb.eng.ApiCiclismo.service.serviceIMPL;

import br.com.dcx.ufpb.eng.ApiCiclismo.dto.ProfileDTO;
import br.com.dcx.ufpb.eng.ApiCiclismo.entity.Profile;
import br.com.dcx.ufpb.eng.ApiCiclismo.enums.CyclingCategory;
import br.com.dcx.ufpb.eng.ApiCiclismo.exception.ProfileNotFoundException;
import br.com.dcx.ufpb.eng.ApiCiclismo.repositories.ProfileRepository;
import br.com.dcx.ufpb.eng.ApiCiclismo.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class ProfileServiceImpl implements ProfileService {

    private final ProfileRepository profileRepository;

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

        if (categoriaAtual != novaCategoria) {
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

    public Optional<Profile> getProfileByFullName(String fullName) throws ProfileNotFoundException {
        Optional<Profile> profile = profileRepository.findByFullName(fullName);
        if (profile.isEmpty()) {
            throw new ProfileNotFoundException("Profile not found.");
        }
        return profile;
    }

    public void uploadProfilePicture(Long id, MultipartFile file) throws ProfileNotFoundException {
        Optional<Profile> optionalProfile = profileRepository.findById(id);
        if (optionalProfile.isPresent()) {
            Profile profile = optionalProfile.get();
            try {
                profile.setProfilePicture(file.getBytes());
                profileRepository.save(profile);
            } catch (IOException e) {
                throw new ProfileNotFoundException("Profile Not found");
            }
        }
    }

    public byte[] getProfilePicture(Long id) throws ProfileNotFoundException {
        Optional<Profile> optionalProfile = profileRepository.findById(id);
        if (optionalProfile.isPresent()) {
            Profile profile = optionalProfile.get();
            byte[] profilePicture = profile.getProfilePicture();
            if (profilePicture != null) {
                return profilePicture;
            }
        }
        throw new ProfileNotFoundException("Profile picture not found for ID: " + id);
    }
}

