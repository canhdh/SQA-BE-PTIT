package com.example.demo.service.impl;

import com.example.demo.entities.User;
import com.example.demo.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest
@ActiveProfiles("test")
@Sql("/test-data.sql")
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    private User user1 = new User(1, "canh@gmail.com", "123", "customer");
    private User user2 = new User(2, "staff1@gmail.com", "123", "staff");

    @InjectMocks
    private UserServiceImpl userService;

    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getAllUser() {
        given(userRepository.findAll()).willReturn(Arrays.asList(user1, user2));

        List<User> results = userService.getAllUser();

        assertThat(results).hasSize(2);

        assertUserFields(results.get(0));


    }

    @Test
    public void getUserById() {
        given(userRepository.findById(1)).willReturn(Optional.of(user1));

        User result = userService.getUserById(1);

        //assert
        assertThat(result).isEqualTo(user1);

        //assert
        assertUserFields(result);

        //verify that repository was called
        verify(userRepository, times(1)).findById(1);
    }

    @Test
    public void getUserByUsername() {
        given(userRepository.findDistinctFirstByUsername("canh@gmail.com")).willReturn(user1);

        User result = userService.getUserByUsername("canh@gmail.com");

        assertThat(result).isEqualTo(user1);

        assertUserFields(result);

        verify(userRepository, times(1)).findDistinctFirstByUsername("canh@gmail.com");
    }

    @Test
    public void createUser() {
        given(userRepository.save(user1)).willReturn(user1);

        User result = userService.createUser(user1);

        assertUserFields(result);

        verify(userRepository, times(1)).save(user1);
    }

    private void assertUserFields(User user) {
        assertThat(user.getId()).isInstanceOf(Integer.class);
        assertThat(user.getId()).isEqualTo(1);
        assertThat(user.getUsername()).isEqualTo("canh@gmail.com");
        assertThat(user.getPassword()).isEqualTo("123");
        assertThat(user.getPosition()).isEqualTo("customer");
    }

}