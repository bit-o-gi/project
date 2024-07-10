package bitcampnc5.bit.api.controller.schedule;

import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import bitcampnc5.bit.api.dto.schedule.ScheduleRequest;
import bitcampnc5.bit.api.service.schedule.ScheduleService;
import bitcampnc5.bit.api.service.schedule.ScheduleServiceImpl;
import bitcampnc5.bit.domain.schedule.Schedule;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDateTime;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(controllers = ScheduleController.class)
class ScheduleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private ScheduleService scheduleService;

    @DisplayName("일정을 등록한다.")
    @Test
    void createScheduleTest() throws Exception {
        // given
        ScheduleRequest request = ScheduleRequest.builder()
                .userId("testId")
                .title("일정 제목")
                .content("일정 내용")
                .startDateTime(LocalDateTime.of(2024, 7, 10, 14, 47, 59))
                .endDateTime(LocalDateTime.of(2024, 7, 17, 14, 47, 59))
                .build();

        Schedule expectedSchedule = request.toEntity();
        when(scheduleService.save(any(ScheduleRequest.class))).thenReturn(expectedSchedule);

        // when // then
        mockMvc.perform(
                        post("/api/v1/schedules/new")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsBytes(request))
                ).andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.userId").value("testId"))
                .andExpect(jsonPath("$.endDateTime").value(String.valueOf(LocalDateTime.of(2024, 7, 17, 14, 47, 59))));
    }

    @DisplayName("일정을 등록할 때, 일정 제목은 필수값이다.")
    @Test
    void createScheduleWithoutTitleTest() throws Exception {
        // given
        ScheduleRequest request = ScheduleRequest.builder()
                .userId("testId")
                .content("일정 내용")
                .startDateTime(LocalDateTime.of(2024, 7, 10, 14, 47, 59))
                .endDateTime(LocalDateTime.of(2024, 7, 17, 14, 47, 59))
                .build();

        // when // then
        mockMvc.perform(
                        post("/api/v1/schedules/new")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsBytes(request))
                ).andDo(print())
                .andExpect(status().isBadRequest());
    }

    @DisplayName("일정을 등록할 때, 시작 일시는 필수값이다.")
    @Test
    void createScheduleWithoutStartDateTimeTest() throws Exception {
        // given
        ScheduleRequest request = ScheduleRequest.builder()
                .userId("testId")
                .title("일정 제목")
                .content("일정 내용")
                .endDateTime(LocalDateTime.of(2024, 7, 17, 14, 47, 59))
                .build();

        // when // then
        mockMvc.perform(
                        post("/api/v1/schedules/new")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsBytes(request))
                ).andDo(print())
                .andExpect(status().isBadRequest());
    }


}