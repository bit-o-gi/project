package bit.dday.controller;

import bit.dday.dto.CoupleDdayDto;
import bit.dday.service.CoupleDdayService;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@WebMvcTest(CoupleDdayController.class)
public class CoupleDdayControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CoupleDdayService coupleDdayService;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testRegisterDday() throws Exception {
        // Given
        CoupleDdayDto dto = new CoupleDdayDto();
        dto.setPartner1("마리오");
        dto.setPartner2("버섯");
        dto.setDdayDate(LocalDate.of(2024, 8, 15));

        when(coupleDdayService.registerDday(any(CoupleDdayDto.class))).thenReturn(dto);

        // When & Then
        mockMvc.perform(MockMvcRequestBuilders.post("/api/dday/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.partner1").value("마리오"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.partner2").value("버섯"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.ddayDate").value("2024-08-15"));
    }
}
