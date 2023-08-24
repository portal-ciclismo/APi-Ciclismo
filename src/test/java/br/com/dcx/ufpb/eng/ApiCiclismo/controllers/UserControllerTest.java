package br.com.dcx.ufpb.eng.ApiCiclismo.controllers;

import br.com.dcx.ufpb.eng.ApiCiclismo.controller.UserController;
import br.com.dcx.ufpb.eng.ApiCiclismo.entity.User;
import br.com.dcx.ufpb.eng.ApiCiclismo.repositories.UserRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.minidev.json.JSONUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
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
        mockMvc.perform(get(url))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void getNonExistingUserById() throws Exception {
        String invalidId = "1";
        String url = String.format("/api/users/%s", invalidId);
        mockMvc.perform(get(url)).andExpect(status().isNotFound());
    }

    @Test
    void createUserWithNoAttribute() throws Exception {
        String url = "/api/users";

        User user = new User();
        ObjectMapper mapper = new ObjectMapper();
        String userJson = mapper.writeValueAsString(user);

        mockMvc.perform(post(url).contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(userJson))
                .andExpect(status().is4xxClientError());
    }

    @Test
    void createUserOnlyWithId() throws Exception {
        String url = "/api/users";
        String userJson = "{\"id\":1231232231,\"name\":null,\"password\":null,\"email\":null}";

        mockMvc.perform(post(url).contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(userJson))
                .andExpect(status().is4xxClientError());
    }

    @Test
    void createUserWithIdAndName() throws Exception {
        String url = "/api/users";
        String userJson = "{\"id\":1231232231,\"name\":Fulano,\"password\":null,\"email\":null}";

        mockMvc.perform(post(url).contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(userJson))
                .andExpect(status().is4xxClientError());
    }

    @Test
    void createUserWithNoEmail() throws Exception {
        String url = "/api/users";
        String userJson = "{\"id\":1231232231,\"name\":Fulano,\"password\":123456,\"email\":null}";

        mockMvc.perform(post(url).contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(userJson))
                .andExpect(status().is4xxClientError());
    }

    @Test
    void createUserWithNoValidEmail() throws Exception {
        String url = "/api/users";
        String userJson = "{\"id\":1231232231,\"name\":Fulano,\"password\":123456,\"email\":fulano.com}";

        mockMvc.perform(post(url).contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(userJson))
                .andExpect(status().is4xxClientError());
    }

    @Test
    void correctUserCreation() throws Exception {
        String url = "/api/users";
        String userJson = "{\"id\":1231232231,\"name\":Fulano,\"password\":123456,\"email\":fulano@gmail.com}";

        mockMvc.perform(post(url).contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(userJson))
                .andExpect(status().isOk());
    }
}
