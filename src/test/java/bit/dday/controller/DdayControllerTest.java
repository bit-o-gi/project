package bit.dday.controller;

import static org.junit.jupiter.api.Assertions.*;

import bit.dday.dto.DdayRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

@WebMvcTest(controllers = DdayController.class)
class DdayControllerTest {


    @DisplayName("디데이 불러오기 성공")
    @Test
    void getDdaySuccessTest() {
    }

    @Test
    void createDday() {
    }
}
