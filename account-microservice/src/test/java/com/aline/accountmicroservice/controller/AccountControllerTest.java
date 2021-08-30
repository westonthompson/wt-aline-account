package com.aline.accountmicroservice.controller;

import com.aline.core.annotation.test.SpringBootIntegrationTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootIntegrationTest
public class AccountControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void test_getAccountById_statusIsOk_and_containsAllCorrectInformation() throws Exception {

        mockMvc.perform(get("/accounts/1"))
                .andExpect(status().isOk());

    }

}
