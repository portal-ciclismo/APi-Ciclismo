//package br.com.dcx.ufpb.eng.ApiCiclismo.controllers;
//
//import br.com.dcx.ufpb.eng.ApiCiclismo.controller.AuthenticationController;
//import br.com.dcx.ufpb.eng.ApiCiclismo.controller.UserController;
//import br.com.dcx.ufpb.eng.ApiCiclismo.dto.AuthenticationDTO;
//import br.com.dcx.ufpb.eng.ApiCiclismo.dto.RegisterDTO;
//import br.com.dcx.ufpb.eng.ApiCiclismo.entity.User;
//import br.com.dcx.ufpb.eng.ApiCiclismo.enums.UserRole;
//import br.com.dcx.ufpb.eng.ApiCiclismo.repositories.UserRepository;
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import java.util.Optional;
//
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.BDDMockito.given;
//import static org.mockito.Mockito.verify;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@WebMvcTest(UserController.class)
//public class UserControllerTest {
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private UserRepository userRepository;
//
//    @MockBean
//    private AuthenticationController authController;
//
//    @Test
//    void getAllUsers_shouldReturnAllUsers() throws Exception {
//        String url = "/api/users";
//        mockMvc.perform(get(url))
//                .andExpect(status().isOk())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//                .andExpect(content().json("[]"));
//    }
//
//    @Test
//    void getUserById_shouldReturnNotFound() throws Exception {
//        String invalidId = "1";
//        String url = String.format("/api/users/%s", invalidId);
//        mockMvc.perform(get(url)).andExpect(status().isNotFound());
//    }
//
//    @Test
//    void getUserById_shouldReturnExistingUSer() throws Exception {
//        String url = "/api/users/1";
//        RegisterDTO dto = new RegisterDTO("example", "examplePw", "example@gmail.com", "USER");
//        User user = authController.register(dto);
//        authController.login(new AuthenticationDTO("example", "examplePw"));
//        user.setId(1l);
//        ObjectMapper mapper = new ObjectMapper();
//        String userJson = mapper.writeValueAsString(user);
//
//        given(userRepository.findById(1L)).willReturn(Optional.of(user));
//
//        mockMvc.perform(get(url))
//                .andExpect(content().string((userJson)))
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk());
//
//        verify(userRepository).findById(1L);
//    }
//
//    @Test
//    void createUserWithNoAttribute_shouldReturn400Error() throws Exception {
//        String url = "/api/users";
//
//        User user = new User();
//        ObjectMapper mapper = new ObjectMapper();
//        String userJson = mapper.writeValueAsString(user);
//
//        mockMvc.perform(post(url).contentType(MediaType.APPLICATION_JSON)
//                .accept(MediaType.APPLICATION_JSON)
//                .content(userJson))
//                .andExpect(status().is4xxClientError());
//
//        }
//
//    @Test
//    void createUserOnlyWithId_shouldReturn400Error() throws Exception {
//        String url = "/api/users";
//        String userJson = "{\"id\":1231232231,\"name\":null,\"password\":null,\"email\":null}";
//
//        mockMvc.perform(post(url).contentType(MediaType.APPLICATION_JSON)
//                .accept(MediaType.APPLICATION_JSON)
//                .content(userJson))
//                .andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    void createUserWithIdAndName_shouldReturn400Error() throws Exception {
//        String url = "/api/users";
//        String userJson = "{\"id\":1231232231,\"name\":Fulano,\"password\":null,\"email\":null}";
//
//        mockMvc.perform(post(url).contentType(MediaType.APPLICATION_JSON)
//                        .accept(MediaType.APPLICATION_JSON)
//                        .content(userJson))
//                .andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    void createUserWithNoEmail_shouldReturn400Error() throws Exception {
//        String url = "/api/users";
//        String userJson = "{\"id\":1231232231,\"name\":Fulano,\"password\":123456,\"email\":null}";
//
//        mockMvc.perform(post(url).contentType(MediaType.APPLICATION_JSON)
//                        .accept(MediaType.APPLICATION_JSON)
//                        .content(userJson))
//                .andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    void createUserWithNoValidEmail_shouldReturn400Error() throws Exception {
//        String url = "/api/users";
//        String userJson = "{\"id\":1231232231,\"name\":\"Fulano\",\"password\":123456,\"email\":\"fulano.com\"}";
//        mockMvc.perform(post(url).contentType(MediaType.APPLICATION_JSON)
//                        .accept(MediaType.APPLICATION_JSON)
//                        .content(userJson))
//                .andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    void correctUserCreation_shouldReturnOk() throws Exception {
//        String url = "/api/users";
//        String userJson = "{\"id\":1231232231,\"name\":\"Fulano\",\"password\":123456,\"email\":\"fulano@gmail.com\"}";
//        mockMvc.perform(post(url).contentType(MediaType.APPLICATION_JSON)
//                        .accept(MediaType.APPLICATION_JSON)
//                        .content(userJson))
//                .andExpect(status().isOk());
//    }
//
//    @Test
//    void deleteUser_shoudlReturnNotFound() throws Exception {
//        String url = "/api/users/1";
//        mockMvc.perform(MockMvcRequestBuilders.delete(url))
//                .andExpect(status().isNotFound());
//    }
//
//    @Test
//    void deleteUser_shouldDeleteUser() throws Exception {
//        String url = "/api/users";
//        String userJson = "{\"id\":1231232231,\"name\":\"Fulano\",\"password\":123456,\"email\":\"fulano@gmail.com\"}";
//        mockMvc.perform(post(url)
//                .contentType(MediaType.APPLICATION_JSON)
//                .accept(MediaType.APPLICATION_JSON)
//                .content(userJson))
//                .andExpect(status().isOk());
//
//        verify(userRepository).save(any(User.class));
//
//        mockMvc.perform(MockMvcRequestBuilders.delete(url + "/" + "1231232231"))
//                .andExpect(status().isNoContent());
//
//        verify(userRepository).deleteById(1231232231L);
//    }
//}
