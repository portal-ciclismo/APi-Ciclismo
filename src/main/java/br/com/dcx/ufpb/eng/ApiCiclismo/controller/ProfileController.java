package br.com.dcx.ufpb.eng.ApiCiclismo.controller;

import br.com.dcx.ufpb.eng.ApiCiclismo.dto.ProfileDTO;
import br.com.dcx.ufpb.eng.ApiCiclismo.entity.Profile;
import br.com.dcx.ufpb.eng.ApiCiclismo.exception.ProfileNotFoudException;
import br.com.dcx.ufpb.eng.ApiCiclismo.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/profiles")
public class ProfileController {


    private ProfileService profileService;

    @Autowired
    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<Profile> getProfiles() {
        return profileService.getProfiles();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Profile saveProfile(@RequestBody Profile profile) {
        return profileService.saveProfile(profile);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Profile> getProfileById(@PathVariable Long id) throws ProfileNotFoudException {
        return profileService.getProfileById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProfile(@PathVariable Long id) throws ProfileNotFoudException {
        profileService.deleteProfile(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateProfile(@PathVariable Long id, @RequestBody ProfileDTO profileDTO) throws ProfileNotFoudException {
        profileService.updateProfile(id, profileDTO);
    }

}
