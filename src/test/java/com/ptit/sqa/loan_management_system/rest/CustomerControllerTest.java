package com.ptit.sqa.loan_management_system.rest;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@ActiveProfiles("test")
@Sql({"/test-data.sql"})
public class CustomerControllerTest {

	private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }
    
    @Test
    public void findAll() throws Exception {
    	this.mockMvc.perform(MockMvcRequestBuilders.get("/customer")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(jsonPath("$", hasSize(2)))
                .andReturn();
    }
    
    @Test
    public void findById() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/customer/1")
        		.accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.address").value("Van Duc"))
                .andExpect(jsonPath("$.birthday").value("2021-05-04"))
                .andExpect(jsonPath("$.email").value("test1@gmail.com"))
                .andExpect(jsonPath("$.gender").value("Nam"))
                .andExpect(jsonPath("$.idCard").value("1225132541643"))
                .andExpect(jsonPath("$.maritalStatus").value("Đã có gia đình"))
                .andExpect(jsonPath("$.name").value("Nguyễn Cầm Cố"))
                .andExpect(jsonPath("$.nationality").value("USA"))
                .andExpect(jsonPath("$.phoneNumber").value("0123456789"))
                .andExpect(jsonPath("$.username").value("canh@gmail.com"))
                .andExpect(jsonPath("$.*", hasSize(11)))
                .andReturn();
    }

    @Test
    public void updateCustomer() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.put("/customer")
        		.contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\": 2, \"address\": \"Van Duc1\", \"birthday\": \"2021-05-14\", \"email\": \"test2@gmail.com\", \"gender\": \"Nam\", \"idCard\": \"1225132541643\", \"maritalStatus\": \"Đã có gia đình\", \"name\": \"Nguyễn Cầm Cự\", \"nationality\": \"USA\", \"phoneNumber\": \"0123456789\", \"username\": \"canh1@gmail.com\"}")
        		.accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.id").value(2))
                .andExpect(jsonPath("$.address").value("Van Duc1"))
                .andExpect(jsonPath("$.birthday").value("2021-05-14"))
                .andExpect(jsonPath("$.email").value("test2@gmail.com"))
                .andExpect(jsonPath("$.gender").value("Nam"))
                .andExpect(jsonPath("$.idCard").value("1225132541643"))
                .andExpect(jsonPath("$.maritalStatus").value("Đã có gia đình"))
                .andExpect(jsonPath("$.name").value("Nguyễn Cầm Cự"))
                .andExpect(jsonPath("$.nationality").value("USA"))
                .andExpect(jsonPath("$.phoneNumber").value("0123456789"))
                .andExpect(jsonPath("$.username").value("canh1@gmail.com"))
                .andExpect(jsonPath("$.*", hasSize(11)))
                .andReturn();
    }
    
    @Test
    public void getCustomerByUserName() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/customer/user/canh@gmail.com")
        		.accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.address").value("Van Duc"))
                .andExpect(jsonPath("$.birthday").value("2021-05-04"))
                .andExpect(jsonPath("$.email").value("test1@gmail.com"))
                .andExpect(jsonPath("$.gender").value("Nam"))
                .andExpect(jsonPath("$.idCard").value("1225132541643"))
                .andExpect(jsonPath("$.maritalStatus").value("Đã có gia đình"))
                .andExpect(jsonPath("$.name").value("Nguyễn Cầm Cố"))
                .andExpect(jsonPath("$.nationality").value("USA"))
                .andExpect(jsonPath("$.phoneNumber").value("0123456789"))
                .andExpect(jsonPath("$.username").value("canh@gmail.com"))
                .andExpect(jsonPath("$.*", hasSize(11)))
                .andReturn();
    }
}
