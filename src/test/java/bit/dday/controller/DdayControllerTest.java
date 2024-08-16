package bit.dday.controller;

import static bit.dday.controller.DdayController.DDAY_PATH;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import bit.dday.domain.Dday;
import bit.dday.domain.MockDday;
import bit.dday.dto.DdayRequest;
import bit.dday.dto.MockDdayRequest;
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
        Dday dday = MockDday.mock1();
        when(ddayService.getDday(any())).thenReturn(dday);

        // when
        ResultActions result = mockMvc.perform(get(DDAY_PATH + "/" + dday.getId()));

        // then
        result.andDo(print()).andExpect(status().isOk()).andExpect(jsonPath("$.id").value(dday.getId()))
                .andExpect(jsonPath("$.userId").value(dday.getUserId()))
                .andExpect(jsonPath("$.title").value(dday.getTitle()))
                .andExpect(jsonPath("$.targetDate").value(dday.getTargetDate().toString()));
    }

    @DisplayName("디데이 생성 성공")
    @Test
    void createDdaySuccessTest() throws Exception {
        // given
        Dday dday = MockDday.mock1();
        DdayRequest ddayRequest = MockDdayRequest.mockWith(dday);
        when(ddayService.createDday(any())).thenReturn(dday);

        // when
        ResultActions result = mockMvc.perform(
                post(DDAY_PATH + "/new")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsBytes(ddayRequest))
        );

        // then
        result.andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(dday.getId()))
                .andExpect(jsonPath("$.userId").value(dday.getUserId()))
                .andExpect(jsonPath("$.title").value(dday.getTitle()))
                .andExpect(jsonPath("$.targetDate").value(dday.getTargetDate().toString()));
    }

    @DisplayName("디데이 수정 성공")
    @Test
    void updateDdaySuccessTest() throws Exception {
        // given
        Dday dday1 = MockDday.mock1();
        Dday dday2 = MockDday.mock2();
        DdayRequest ddayRequest = MockDdayRequest.mockWith(dday2);
        when(ddayService.updateDday(any(), any())).thenReturn(dday2);

        // when
        ResultActions result = mockMvc.perform(
                patch(DDAY_PATH + "/" + dday1.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsBytes(ddayRequest))
        );

        // then
        result.andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(dday2.getId()))
                .andExpect(jsonPath("$.userId").value(dday2.getUserId()))
                .andExpect(jsonPath("$.title").value(dday2.getTitle()))
                .andExpect(jsonPath("$.targetDate").value(dday2.getTargetDate().toString()));
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
