package br.com.dcx.ufpb.eng.ApiCiclismo.service;

import br.com.dcx.ufpb.eng.ApiCiclismo.dto.ProfileDTO;
import br.com.dcx.ufpb.eng.ApiCiclismo.dto.UserDTO;
import br.com.dcx.ufpb.eng.ApiCiclismo.entity.Profile;
import br.com.dcx.ufpb.eng.ApiCiclismo.enums.CyclingCategory;
import br.com.dcx.ufpb.eng.ApiCiclismo.exception.ProfileNotFoundException;
import br.com.dcx.ufpb.eng.ApiCiclismo.repositories.ProfileRepository;
import br.com.dcx.ufpb.eng.ApiCiclismo.service.serviceIMPL.ProfileServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@SpringBootTest
public class ProfileServiceImplTest {

    @InjectMocks
    private ProfileServiceImpl profileService;

    @Mock
    private ProfileRepository profileRepository;

    @BeforeEach
    void setUp() {

        ProfileDTO profile = new ProfileDTO(
                1L,
                new UserDTO("ryan@gmail.com", "12345"),
                "Ryan",
                "Pereira",
                "M",
                CyclingCategory.PROFISSIONAL,
                "Guarabira-PB",
                true,
                false
        );

    }

    @Test
    void testGetProfiles() {

        List<Profile> profiles = new ArrayList<>();
        Mockito.when(profileRepository.findAll()).thenReturn(profiles);

        List<Profile> result = profileService.getProfiles();

        assertEquals(profiles, result);
    }

    @Test
    void testSaveProfile() {

        Profile profile = new Profile();
        Mockito.when(profileRepository.save(profile)).thenReturn(profile);

        Profile result = profileService.saveProfile(profile);

        assertEquals(profile, result);
    }

    @Test
    void testGetProfileById() throws ProfileNotFoundException {

        Long profileId = 1L;

        Profile profile = new Profile();
        profile.setId(profileId);

        Mockito.when(profileRepository.findById(profileId)).thenReturn(Optional.of(profile));

        Optional<Profile> result = profileService.getProfileById(profileId);

        assertEquals(Optional.of(profile), result);
    }

    @Test
    void testGetProfileByIdNotFound() {

        Long profileId = 1L;

        Mockito.when(profileRepository.findById(profileId)).thenReturn(Optional.empty());

        assertThrows(ProfileNotFoundException.class, () -> profileService.getProfileById(profileId));
    }

    @Test
    void testDeleteProfile() {

        Long profileId = 1L;

        Mockito.when(profileRepository.findById(profileId)).thenReturn(Optional.of(new Profile()));

        assertDoesNotThrow(() -> profileService.deleteProfile(profileId));
    }

    @Test
    void testDeleteProfileNotFound() {

        Long profileId = 1L;

        Mockito.when(profileRepository.findById(profileId)).thenReturn(Optional.empty());

        assertThrows(ProfileNotFoundException.class, () -> profileService.deleteProfile(profileId));
    }

//    @Test
//    void testUpdateProfile() throws ProfileNotFoundException {
//
//        Long profileId = 1L;
//
//        ProfileDTO profile = new ProfileDTO(
//                1L,
//                new UserDTO("ryan@gmail.com", "12345"),
//                "Ryan",
//                "Pereira",
//                "M",
//                CyclingCategory.AMADOR,
//                "Guarabira-PB",
//                false,
//                false
//        );
//        profile.setFullName("José Ryan");
//
//        Profile existingProfile = new Profile();
//        existingProfile.setId(profileId);
//
//        Mockito.when(profileRepository.findById(profileId)).thenReturn(Optional.of(existingProfile));
//        Mockito.when(profileRepository.save(existingProfile)).thenReturn(existingProfile);
//
//        assertDoesNotThrow(() -> profileService.updateProfile(profileId, profile));
//
//        assertEquals("José Ryan", existingProfile.getFullName());
//    }

    @Test
    void testUpdateProfileNotFound() {

        Long profileId = 1L;

        Mockito.when(profileRepository.findById(profileId)).thenReturn(Optional.empty());

        ProfileDTO profile = new ProfileDTO(
                1L,
                new UserDTO("ryan@gmail.com", "12345"),
                "Ryan",
                "Pereira",
                "M",
                CyclingCategory.PROFISSIONAL,
                "Guarabira-PB",
                true,
                false
        );
        profile.setFullName("José Ryan");

        assertThrows(ProfileNotFoundException.class, () -> profileService.updateProfile(profileId, profile));
    }

}