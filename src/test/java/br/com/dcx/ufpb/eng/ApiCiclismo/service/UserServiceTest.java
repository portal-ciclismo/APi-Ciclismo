package br.com.dcx.ufpb.eng.ApiCiclismo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
public class UserServiceTest {

    @Autowired
    private UserService userService;

   /* @Test
    @Transactional
    public void testCreateUser() {
        User user = new User(null, "username1", "password123", "email1@example.com");
        User createdUser = userService.createUser(user);

        assertNotNull(createdUser.getId());
    }

    @Test
    @Transactional
    public void testUpdateUser() {
        User user = new User(null, "username2", "password123", "email2@example.com");
        User createdUser = userService.createUser(user);

        assertNotNull(createdUser.getId());

        User updatedUser = userService.updateUser(createdUser.getId(), new User(null, "Updated Name", "newpassword", "updated@example.com"));
        assertEquals("Updated Name", updatedUser.getLogin());
        assertEquals("newpassword", updatedUser.getPassword());
        assertEquals("updated@example.com", updatedUser.getEmail());
    }

    @Test
    @Transactional
    public void testDeleteUser() {
        User user = new User(null, "username3", "password123", "email3@example.com");
        User createdUser = userService.createUser(user);

        assertNotNull(createdUser.getId());

        userService.deleteUser(createdUser.getId());

        assertThrows(ResponseStatusException.class, () -> userService.getUserById(createdUser.getId()));
    }

    @Test
    public void testGetUserById() {
        User user = new User(null, "username4", "password987", "email4@example.com");
        User createdUser = userService.createUser(user);

        assertNotNull(createdUser.getId());

        User retrievedUser = userService.getUserById(createdUser.getId());
        assertEquals("username4", retrievedUser.getName());
        assertEquals("password987", retrievedUser.getPassword());
        assertEquals("email4@example.com", retrievedUser.getEmail());
    }

    @Test
    @Transactional
    public void testGetAllUsers() {
        User user1 = new User(null, "user1", "pass1", "user1@example.com");
        User user2 = new User(null, "user2", "pass2", "user2@example.com");

        userService.createUser(user1);
        userService.createUser(user2);

        TestTransaction.flagForCommit();
        TestTransaction.end();

        TestTransaction.start();

        assertEquals(2, userService.getAllUsers().size());
    }*/
}