package bit.dday.controller;

import bit.dday.domain.Dday;
import bit.dday.dto.DdayRequest;
import bit.dday.service.DdayService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/dday")
public class DdayController {
    private final DdayService ddayService;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Dday getDday(@PathVariable Long id) {
        return ddayService.getDday(id);

    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Dday createDday(@Valid @RequestBody DdayRequest ddayRequest) {
        return ddayService.createDday(ddayRequest);
    }
}
