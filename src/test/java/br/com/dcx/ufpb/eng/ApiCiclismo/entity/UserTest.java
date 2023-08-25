package br.com.dcx.ufpb.eng.ApiCiclismo.entity;


import br.com.dcx.ufpb.eng.ApiCiclismo.enums.UserRole;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class UserTest {

    private User userVazio = new User();
    private User userIniciadoAdmin = new User("Ana", "senha", "ric@gmail.com", UserRole.ADMIN);


    @Test
    void construtorTest(){
        assertNull(userIniciadoAdmin.getId());
        assertEquals(userIniciadoAdmin.getLogin(), "Ana");
        assertEquals(userIniciadoAdmin.getPassword(), "senha");
        assertEquals(userIniciadoAdmin.getEmail(), "ric@gmail.com");
    }

    @Test
    void getUserEmailTest(){
        userVazio.setEmail("email@gmail.com");
        assertEquals(userVazio.getEmail(),"email@gmail.com");
    }

    @Test
    void getUserPasswordTest(){
        userVazio.setPassword("senha");
        assertEquals(userVazio.getPassword(), "senha");
    }

    @Test
    void getUserNameTest(){
        userVazio.setLogin("Ana");
        assertEquals(userVazio.getLogin(), "Ana");
    }

    @Test
    void getUserIdTest(){
        assertNull(userVazio.getId());
    }
}

