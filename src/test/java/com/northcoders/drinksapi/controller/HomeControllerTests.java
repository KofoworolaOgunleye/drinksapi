package com.northcoders.drinksapi.controller;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

//It tells the test class to enable and configure auto-configuration of MockMvc.
@AutoConfigureMockMvc
@SpringBootTest
public class HomeControllerTests {

    //It enables objects(beans) to be injected at runtime by Spring Dependency Injection mechanism
    @Autowired
    private MockMvc mockMvcController; //MockMvc is the Main entry point for server-side Spring MVC testing, It is useful because you can test the controller without running the controller within a server

    @Test
    public void testGetHome() throws Exception {
        //Arrange, Act and Assert
        String expectedContent = "Welcome to the Drinks API!";

        this.mockMvcController.perform( //Make a GET request to the '/' endpoint
                        MockMvcRequestBuilders.get("/")) //Matchers are helpful methods that help you write your assertions
                .andExpect(MockMvcResultMatchers.status().isOk()) //According to the requirement, we expect 200 OK Status Code as a Response
                .andExpect(MockMvcResultMatchers.content().string(expectedContent)); //According to the requirement, we expect the string as a Response

    }
}