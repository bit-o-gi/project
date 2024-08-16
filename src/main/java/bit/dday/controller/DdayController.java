package bit.dday.controller;

import bit.dday.domain.Dday;
import bit.dday.dto.DdayRequest;
import bit.dday.dto.DdayResponse;
import bit.dday.service.DdayService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(DdayController.DDAY_PATH)
public class DdayController {

    public static final String DDAY_PATH = "/api/v1/dday";
    private final DdayService ddayService;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public DdayResponse getDday(@PathVariable Long id) {
        Dday dday = ddayService.getDday(id);
        return DdayResponse.from(dday);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public DdayResponse createDday(@Valid @RequestBody DdayRequest ddayRequest) {
        Dday dday = ddayService.createDday(ddayRequest);
        return DdayResponse.from(dday);
    }
}
