package bit.dday.controller;

import static bit.dday.controller.DdayController.DDAY_PATH;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import bit.dday.domain.Dday;
import bit.dday.domain.DdayFixtures;
import bit.dday.dto.DdayRequest;
import bit.dday.dto.DdayRequestFixtures;
import bit.dday.service.DdayService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

@WebMvcTest(controllers = DdayController.class)
class DdayControllerTest {

    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private DdayService ddayService;

    @DisplayName("디데이 조회 성공")
    @Test
    void getDdaySuccessTest() throws Exception {
        // given
        Dday initialDday = DdayFixtures.initialDday();
        when(ddayService.getDday(any())).thenReturn(initialDday);

        // when
        ResultActions result = mockMvc.perform(get(DDAY_PATH + "/" + initialDday.getId()));

        // then
        result.andDo(print())
                .andExpect(status().isOk()).andExpect(jsonPath("$.id").value(initialDday.getId()))
                .andExpect(jsonPath("$.userId").value(initialDday.getUserId()))
                .andExpect(jsonPath("$.title").value(initialDday.getTitle()))
                .andExpect(jsonPath("$.targetDate").value(initialDday.getTargetDate().toString()));
    }

    @DisplayName("디데이 생성 성공")
    @Test
    void createDdaySuccessTest() throws Exception {
        // given
        Dday newDday = DdayFixtures.newDday();
        DdayRequest ddayRequest = DdayRequestFixtures.from(newDday);
        when(ddayService.createDday(any())).thenReturn(newDday);

        // when
        ResultActions result = mockMvc.perform(post(DDAY_PATH + "/new").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsBytes(ddayRequest)));

        // then
        result.andDo(print())
                .andExpect(status().isCreated()).andExpect(jsonPath("$.id").value(newDday.getId()))
                .andExpect(jsonPath("$.userId").value(newDday.getUserId()))
                .andExpect(jsonPath("$.title").value(newDday.getTitle()))
                .andExpect(jsonPath("$.targetDate").value(newDday.getTargetDate().toString()));
    }

    @DisplayName("디데이 수정 성공")
    @Test
    void updateDdaySuccessTest() throws Exception {
        // given
        Dday initialDday = DdayFixtures.initialDday();
        Dday updatedDday = DdayFixtures.updatedDday();
        DdayRequest ddayRequest = DdayRequestFixtures.from(updatedDday);
        when(ddayService.updateDday(any(), any())).thenReturn(updatedDday);

        // when
        ResultActions result = mockMvc.perform(
                put(DDAY_PATH + "/" + initialDday.getId()).contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsBytes(ddayRequest)));

        // then
        result.andDo(print()).andExpect(status().isOk()).andExpect(jsonPath("$.id").value(updatedDday.getId()))
                .andExpect(jsonPath("$.userId").value(updatedDday.getUserId()))
                .andExpect(jsonPath("$.title").value(updatedDday.getTitle()))
                .andExpect(jsonPath("$.targetDate").value(updatedDday.getTargetDate().toString()));
    }

    @Test
    @DisplayName("디데이 삭제 성공")
    void deleteDdaySuccessTest() throws Exception {
        // given
        doNothing().when(ddayService).deleteDday(any());

        // when
        ResultActions result = mockMvc.perform(delete(DDAY_PATH + "/" + 1L));

        // then
        result.andDo(print()).andExpect(status().isOk());
    }
}
