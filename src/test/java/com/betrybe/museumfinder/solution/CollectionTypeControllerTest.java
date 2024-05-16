package com.betrybe.museumfinder.solution;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
@DisplayName("CollectionTypeController tests")
public class CollectionTypeControllerTest {
    @Autowired
    private MockMvc mockMvc;


    @Test
    @DisplayName("Should return 200")
    public void shouldReturnOk() throws Exception {
        mockMvc.perform(get("/collections/count/hist"))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Should return OK and a body with correct information")
    public void shouldReturnOkAndABody() throws Exception {
        mockMvc.perform(get("/collections/count/hist"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.collectionTypes[0]").value("hist"))
                .andExpect(jsonPath("$.count").value(387));
    }

    @Test
    @DisplayName("Should return 404 when not found")
    public void shouldReturnNotFound() throws Exception {
        mockMvc.perform(get("/collections/count/notFoundPage"))
                .andExpect(status().isNotFound());
    }
}
