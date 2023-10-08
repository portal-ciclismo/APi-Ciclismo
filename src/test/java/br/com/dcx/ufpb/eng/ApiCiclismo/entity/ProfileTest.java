package br.com.dcx.ufpb.eng.ApiCiclismo.entity;

import br.com.dcx.ufpb.eng.ApiCiclismo.enums.CyclingCategory;
import br.com.dcx.ufpb.eng.ApiCiclismo.enums.UserType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class ProfileTest {

    private Profile perfilVazio = new Profile();
    byte[] byteTest = {1,2,3};
    private Profile perfilIniciado = new Profile("Joao", "J", "M", CyclingCategory.AMATEUR, UserType.CYCLIST, "JP", byteTest);


    @Test
    void constructorTest(){
        assertEquals(perfilIniciado.getFullName(), "Joao");
        assertEquals(perfilIniciado.getNickname(), "J");
        assertEquals(perfilIniciado.getSexo(), "M");
        assertEquals(perfilIniciado.getCyclingCategory(), CyclingCategory.AMATEUR);
        assertEquals(perfilIniciado.getUserType(), UserType.CYCLIST);
        assertEquals(perfilIniciado.getLocation(), "JP");
        assertEquals(perfilIniciado.getProfilePicture(), byteTest);
    }

    @Test
    void getFullNameTest(){
        perfilVazio.setFullName("Joao");
        assertEquals(perfilVazio.getFullName(), "Joao");
    }

    @Test
    void getNickNameTest(){
        perfilVazio.setNickname("J");
        assertEquals(perfilVazio.getNickname(),"Joao");
    }

    @Test
    void getSexoTest(){
        perfilVazio.setSexo("M");
        assertEquals(perfilVazio.getSexo(), "M");
    }

    @Test
    void getCyclingCategoryTest(){
        perfilVazio.setCyclingCategory(CyclingCategory.AMATEUR);
        assertEquals(perfilVazio.getCyclingCategory(), CyclingCategory.AMATEUR);
    }

    @Test
    void getUserType(){
        perfilVazio.setUserType(UserType.CYCLIST);
        assertEquals(perfilVazio.getUserType(), UserType.CYCLIST);
    }

    @Test
    void getLocation(){
        perfilVazio.setLocation("JP");
        assertEquals(perfilVazio.getLocation(), "JP");
    }

}
