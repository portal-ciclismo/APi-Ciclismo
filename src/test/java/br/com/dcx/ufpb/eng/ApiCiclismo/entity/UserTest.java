package br.com.dcx.ufpb.eng.ApiCiclismo.entity;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class UserTest {

    private User userVazio = new User();
    private User userIniciado = new User(null, "Ana", "senha", "ric@gmail.com");

    @Test
    void construtorTest(){
        assertNull(userIniciado.getId());
        assertEquals(userIniciado.getName(), "Ana");
        assertEquals(userIniciado.getPassword(), "senha");
        assertEquals(userIniciado.getEmail(), "ric@gmail.com");
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
        userVazio.setName("Ana");
        assertEquals(userVazio.getName(), "Ana");
    }

    @Test
    void getUserIdTest(){
        assertNull(userVazio.getId());
    }
}
