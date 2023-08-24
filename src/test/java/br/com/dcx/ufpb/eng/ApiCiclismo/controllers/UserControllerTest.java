package br.com.dcx.ufpb.eng.ApiCiclismo.controllers;

import br.com.dcx.ufpb.eng.ApiCiclismo.controller.UserController;
import br.com.dcx.ufpb.eng.ApiCiclismo.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
public class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserRepository userRepository;

    @Test
    void getDefaultUserUrlReturnAllUsers() throws Exception {
        String url = "/api/users";
        mockMvc.perform(get(url)
                .contentType("application/json"))
        .andExpect(status().isOk());
    }
}
