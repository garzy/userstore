package com.tangorabox.userstore.controller;

import com.tangorabox.userstore.entity.User;
import com.tangorabox.userstore.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebMvcTest
@AutoConfigureMockMvc
public class UsersApiControllerIntegrationTest {

    @MockBean
    private UserRepository userRepository;
    
    @Autowired
    private MockMvc mockMvc;


    @Before
    public void beforeTest() {
        when(userRepository.save(any(User.class)))
                .thenAnswer(invocationOnMock -> invocationOnMock.getArgument(0, User.class));
    }


    @Test
    public void whenPostRequestToUsersAndValidUser_thenCorrectResponse() throws Exception {
        String user = "{\"name\": \"bob\", \"birthdate\" : \"1990-01-01\"}";
        mockMvc.perform(MockMvcRequestBuilders.post("/users")
                .content(user)
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .contentType(MediaType.APPLICATION_JSON_VALUE));
    }

    @Test
    public void whenPostRequestToUsersAndInValidUser_thenCorrectResponse() throws Exception {
        String user = "{\"name\": \"\", \"birthdate\" : \"1990-01-01\"}";
        mockMvc.perform(MockMvcRequestBuilders.post("/users")
                .content(user)
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.content()
                        .contentType(MediaType.APPLICATION_JSON_VALUE));
    }
}
