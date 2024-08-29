package bit.couple.controller;

import bit.couple.dto.CoupleRequest;
import bit.couple.service.CoupleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(CoupleController.COUPLE_PATH)
public class CoupleController {

    public static final String COUPLE_PATH = "/api/v1/couple";

    private final CoupleService coupleService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createCouple(@RequestBody CoupleRequest coupleRequest) {
        coupleService.createCouple(coupleRequest.toCommand());
    }
}
