package br.com.dcx.ufpb.eng.ApiCiclismo.Dto;
import org.junit.jupiter.api.Test;
import br.com.dcx.ufpb.eng.ApiCiclismo.dto.ProfileDTO;
import br.com.dcx.ufpb.eng.ApiCiclismo.enums.CyclingCategory;
import br.com.dcx.ufpb.eng.ApiCiclismo.enums.UserType;
import static org.junit.jupiter.api.Assertions.*;


public class ProfileDTOTest {

    @Test
    public void testProfileDTO() {
        ProfileDTO profile = new ProfileDTO("User", "123User", "Female", UserType.COMPANY, CyclingCategory.AMATEUR, "Brazil", new byte[]{(byte) 1,(byte) 2,(byte) 3});

        assertEquals("User", profile.getFullName());
        assertEquals("123User", profile.getNickname());
        assertEquals("Female", profile.getSexo());
        assertEquals(UserType.COMPANY, profile.getUserType());
        assertEquals(CyclingCategory.AMATEUR, profile.getCyclingCategory());
        assertEquals("Brazil", profile.getLocation());
        assertArrayEquals(new byte[]{1, 2, 3}, profile.getProfilePicture());
    }

    @Test
    public void testProfileDTO2() {
        ProfileDTO profile = new ProfileDTO("User2", "345User", "Male", UserType.CYCLIST, CyclingCategory.PROFESSIONAL, "France", new byte[]{(byte) 1,(byte) 2,(byte) 3});

        assertTrue("User2".equals(profile.getFullName()));
        assertTrue("345User".equals(profile.getNickname()));
        assertTrue("Male".equals(profile.getSexo()));
        assertTrue(UserType.CYCLIST.equals(profile.getUserType()));
        assertTrue(CyclingCategory.PROFESSIONAL.equals(profile.getCyclingCategory()));
        assertTrue("France".equals(profile.getLocation()));
        assertArrayEquals(new byte[]{1, 2, 3}, profile.getProfilePicture());

        // Imprimindo informações para inspeção
        System.out.println("FullName: " + profile.getFullName());
        System.out.println("Nickname: " + profile.getNickname());
        System.out.println("Sex: " + profile.getSexo());
        System.out.println("UserType: " + profile.getUserType());
        System.out.println("CyclingCategory: " + profile.getCyclingCategory());
        System.out.println("Location: " + profile.getLocation());
        System.out.println("ProfilePicture: " + profile.getProfilePicture());
    }
}