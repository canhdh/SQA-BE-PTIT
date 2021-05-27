package com.example.demo.api;

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

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@ActiveProfiles("test")
@Sql({"/test-data.sql"})
public class LoanControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void getLoanById() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/loan/2").accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.id").value(2))
                .andExpect(jsonPath("$.collateral").value("Nhà cửa"))
                .andExpect(jsonPath("$.income").value(10000000))
                .andReturn();
    }
    @Test
    public void getAllLoan() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/loan")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andReturn();
    }
    @Test
    public void getLoanByStatus() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/loan/status").accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.id").value(2))
                .andExpect(jsonPath("$.collateral").value("Nhà cửa"))
                .andExpect(jsonPath("$.income").value(10000000))
                .andExpect(jsonPath("$", hasSize(16)))
                .andReturn();
    }
//INSERT INTO loan (collateral, created_date, date_begin, id_customer, income, loan_amount, proof_of_collateral_document, proof_of_income_document, purpose, status, expected_payment_date, disbursed_amount, disbursement_date, paid_amount) VALUES ('Nhà cửa', '2021-05-23', '2021-05-05', 1, 10000000, 100000000, null, null, 'Dau tu chung khoan', 2, '2021-05-23', 0, null, 0);
        public void getLoanByIdCustomer() throws Exception {
            this.mockMvc.perform(MockMvcRequestBuilders.get("/loan/customer/2").accept(MediaType.APPLICATION_JSON))
                    .andDo(print())
                    .andExpect(jsonPath("$.id").exists())
                    .andExpect(jsonPath("$.id").value(2))
                    .andExpect(jsonPath("$.collateral").value("Nhà cửa"))
                    .andExpect(jsonPath("$.created_date").value("2021-05-23"))
                    .andExpect(jsonPath("$.date_begin").value("2021-05-05"))
                    .andExpect(jsonPath("$.id_customer").value(1))
                    .andExpect(jsonPath("$.income").value(10000000))
                    .andExpect(jsonPath("$.loan_amount").value(1000000000))
                    .andExpect(jsonPath("$.proof_of_collateral_document").value(null))
                    .andExpect(jsonPath("$.proof_of_income_document").value(null))
                    .andExpect(jsonPath("$.purpose").value("Dau tu chung khoan"))
                    .andExpect(jsonPath("$.status").value(2))
                    .andExpect(jsonPath("$.expected_payment_date").value("2021-05-23"))
                    .andExpect(jsonPath("$.disbursed_amount").value(0))
                    .andExpect(jsonPath("$.disbursement_date").value(null))
                    .andExpect(jsonPath("$.paid_amount").value(0))
                    .andExpect(jsonPath("$.*", hasSize(16)))
                    .andReturn();
        }
}
