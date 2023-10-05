package com.example.springapp;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class SpringappApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testAddMenuItemApi() throws Exception {
        // Create a JSON representation of the MenuItem
        String menuItemJson = "{\"id\": 1, \"name\": \"Item 1\", \"price\": 10.0, \"quantity\": 5, \"description\": \"Description 1\"}";

        mockMvc.perform(MockMvcRequestBuilders.post("/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(menuItemJson))  // Send the JSON representation as content
                .andExpect(status().isOk())
                .andExpect(content().string("true"));
    }

    @Test
    public void testDeleteMenuItemApi() throws Exception {
        // Uncomment the lines below and add your test logic:
        int menuItemId = 1;
        mockMvc.perform(MockMvcRequestBuilders.delete("/{id}", menuItemId))
                .andExpect(status().isOk());
    }
}
