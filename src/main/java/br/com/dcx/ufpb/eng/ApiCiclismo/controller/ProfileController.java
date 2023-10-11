package br.com.dcx.ufpb.eng.ApiCiclismo.controller;

import br.com.dcx.ufpb.eng.ApiCiclismo.entity.Profile;
import br.com.dcx.ufpb.eng.ApiCiclismo.service.ProfileService;
import br.com.dcx.ufpb.eng.ApiCiclismo.service.ProfileServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/profiles")
public class ProfileController {

    // adicione todos os medotos do controller aq, abaado no service

    @Autowired
    private ProfileService profileService;

    @PostMapping
    public ResponseEntity<Profile> createProfile(@RequestBody Profile profile) {
        Profile createdProfile = profileService.createProfile(profile);
        return new ResponseEntity<>(createdProfile, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Profile> readProfile(@PathVariable Long id) {
        Profile profile = profileService.readProfile(id);
        if (profile != null) {
            return new ResponseEntity<>(profile, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Profile> updateProfile(@PathVariable Long id, @RequestBody ProfileServiceImpl profile) {
        Profile updatedProfile = profileService.updateProfile(id, profile);
        if (updatedProfile != null) {
            return new ResponseEntity<>(updatedProfile, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProfile(@PathVariable Long id) {
        profileService.deleteProfile(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
