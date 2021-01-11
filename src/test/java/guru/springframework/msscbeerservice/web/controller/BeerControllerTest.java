package guru.springframework.msscbeerservice.web.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import guru.springframework.msscbeerservice.web.model.BeerDTO;
import guru.springframework.msscbeerservice.web.model.BeerStyleEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BeerController.class)
class BeerControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    private static final BeerDTO BEER_DTO = new BeerDTO().builder()
            .beerName("GLARUS")
            .beerStyle(BeerStyleEnum.EPA)
            .upc(123L)
            .price(new BigDecimal("12.99"))
            .build();

    @BeforeEach
    void setUp() {
    }

    @Test
    void getBeerById() throws Exception {
        mockMvc.perform(get(BeerController.BEER_BASE_URL + "/" + UUID.randomUUID()))
                .andExpect(status().isOk());
    }

    @Test
    void saveBeer() throws Exception {

        String jsonBeerDto = objectMapper.writeValueAsString(BEER_DTO);

        mockMvc.perform(post(BeerController.BEER_BASE_URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonBeerDto))
                .andExpect(status().isCreated());
    }

    @Test
    void updateBeer() throws Exception {

        String jsonBeerDto = objectMapper.writeValueAsString(BEER_DTO);

        mockMvc.perform(put(BeerController.BEER_BASE_URL + "/" + UUID.randomUUID())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonBeerDto))
                .andExpect(status().isNoContent());
    }
}