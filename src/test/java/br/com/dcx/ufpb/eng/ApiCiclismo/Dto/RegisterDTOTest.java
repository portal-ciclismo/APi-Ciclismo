package br.com.dcx.ufpb.eng.ApiCiclismo.Dto;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import br.com.dcx.ufpb.eng.ApiCiclismo.dto.RegisterDTO;

public class RegisterDTOTest {

    @Test
    public void testDto01() {
    	
        // Primeiro caso de teste
        String login = "User01";
        String email = "User1@gmail.com";
        String password = "User456";
        String role = "User";

        RegisterDTO user = new RegisterDTO(login, email, password, role);

        // Realizando as asserções para verificar se os campos estão corretos
        assertTrue(user.getLogin().equals(login));
        assertTrue(user.getEmail().equals(email));
        assertTrue(user.getPassword().equals(password));
        assertTrue(user.getRole().equals(role));

        // Testando os Setters
        user.setLogin("User_User");
        user.setEmail("UserOne@Outlook.com");
        user.setPassword("111111M");
        user.setRole("User");

        // Imprimindo informações para inspeção
        System.out.println("Login: " + user.getLogin());
        System.out.println("Email: " + user.getEmail());
        System.out.println("Password: " + user.getPassword());
        System.out.println("Role: " + user.getRole());
    }

    @Test
    public void testDto02() {
    	
        // Segundo caso de teste
        String login = "User02";
        String email = "User2@gmail.com";
        String password = "User123";
        String role = "User";

        RegisterDTO user = new RegisterDTO(login, email, password, role);

        // Realizando as asserções para verificar se os campos estão corretos
        assertEquals(login, user.getLogin());
        assertEquals(email, user.getEmail());
        assertEquals(password, user.getPassword());
        assertEquals(role, user.getRole());
    }
}
