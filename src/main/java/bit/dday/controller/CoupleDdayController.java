package bit.dday.controller;

import bit.dday.dto.CoupleDdayDto;
import bit.dday.service.CoupleDdayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/dday")
public class CoupleDdayController {

    @Autowired
    private CoupleDdayService coupleDdayService;

    @PostMapping("/register")
    public ResponseEntity<CoupleDdayDto> registerDday(@RequestBody CoupleDdayDto dto) {
        CoupleDdayDto savedDto = coupleDdayService.registerDday(dto);
        return ResponseEntity.ok(savedDto);
    }
}