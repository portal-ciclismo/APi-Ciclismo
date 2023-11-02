package br.com.dcx.ufpb.eng.ApiCiclismo.controller;

import br.com.dcx.ufpb.eng.ApiCiclismo.dto.ProfileDTO;
import br.com.dcx.ufpb.eng.ApiCiclismo.entity.Profile;
import br.com.dcx.ufpb.eng.ApiCiclismo.exception.ProfileNotFoundException;
import br.com.dcx.ufpb.eng.ApiCiclismo.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/profiles")
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @GetMapping
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
    public Optional<Profile> getProfileById(@PathVariable Long id) throws ProfileNotFoundException {
        return profileService.getProfileById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProfile(@PathVariable Long id) throws ProfileNotFoundException {
        profileService.deleteProfile(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateProfile(@PathVariable Long id, @RequestBody ProfileDTO profileDTO) throws ProfileNotFoundException {
        profileService.updateProfile(id, profileDTO);
    }

    @GetMapping("/byName/{fullName}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Profile> getProfileByFullName(@PathVariable String fullName) throws ProfileNotFoundException {
        return profileService.getProfileByFullName(fullName);
    }

    @PostMapping("/uploadProfilePicture/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> uploadProfilePicture(@PathVariable Long id, @RequestParam("file") MultipartFile file) throws ProfileNotFoundException {
        Optional<Profile> profileOptional = profileService.getProfileById(id);
        if (profileOptional.isPresent()) {
            profileService.uploadProfilePicture(id, file);
            return ResponseEntity.ok("Profile picture uploaded successfully");
        } else {
            throw new ProfileNotFoundException("Profile Not found");
        }
    }


    @GetMapping("/profilePicture/{id}")
    public ResponseEntity<byte[]> getProfilePicture(@PathVariable Long id) throws ProfileNotFoundException {
        byte[] profilePicture = profileService.getProfilePicture(id);
        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(profilePicture);
    }


}
