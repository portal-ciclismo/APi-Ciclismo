package br.com.dcx.ufpb.eng.ApiCiclismo.service;

import br.com.dcx.ufpb.eng.ApiCiclismo.dto.ProfileDTO;
import br.com.dcx.ufpb.eng.ApiCiclismo.entity.Profile;
import br.com.dcx.ufpb.eng.ApiCiclismo.exception.ProfileNotFoundException;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;
import java.util.Optional;

public interface ProfileService {

    public Profile saveProfile(Profile profile);

    List<Profile> getProfiles();
    Optional<Profile> getProfileById(Long id) throws ProfileNotFoundException;

    void updateProfile (Long id, ProfileDTO profileDTO)throws ProfileNotFoundException;

    void deleteProfile(Long id) throws ProfileNotFoundException;

    Optional<Profile> getProfileByFullName(String fullName) throws ProfileNotFoundException;

    void uploadProfilePicture(Long id, MultipartFile file) throws ProfileNotFoundException;

    byte[] getProfilePicture(Long id) throws ProfileNotFoundException;
}
