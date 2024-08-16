package bit.dday.dto;

import bit.dday.domain.Dday;
import lombok.Getter;

@Getter
public class DdayRequest implements BaseRequest<Dday> {

    private Long id;

    private String userId;

    private String title;

    @Override
    public Dday toEntity() {
        return Dday.builder()
                .id(id)
                .userId(userId)
                .title(title)
                .build();
    }
}
