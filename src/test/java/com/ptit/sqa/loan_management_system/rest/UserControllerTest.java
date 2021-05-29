package com.ptit.sqa.loan_management_system.rest;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@ActiveProfiles("test")
@Sql({"/test-data.sql"})
public class UserControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void findAll() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/user")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(jsonPath("$", hasSize(2)))
                .andReturn();
    }

    @Test
    public void findById() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/user/2").accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.id").value(2))
                .andExpect(jsonPath("$.username").value("staff1@gmail.com"))
                .andExpect(jsonPath("$.password").value("123"))
                .andExpect(jsonPath("$.position").value("staff"))
                .andExpect(jsonPath("$.*", hasSize(4)))
                .andReturn();
    }

    @Test
    public void getUserByUsername() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/user/name/canh@gmail.com").accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.username").value("canh@gmail.com"))
                .andExpect(jsonPath("$.password").value("123"))
                .andExpect(jsonPath("$.position").value("customer"))
                .andExpect(jsonPath("$.*", hasSize(4)))
                .andReturn();
    }

    @Test
    @DirtiesContext
    public void VerifyInvalidUserId() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/user/" + 0).accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andReturn();
    }

    @Test
    @DirtiesContext
    public void VerifyNotExistUsername() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/user/name/" + "user@gmail.com")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andReturn();
    }
}