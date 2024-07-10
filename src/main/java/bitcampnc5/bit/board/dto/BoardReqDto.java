package bitcampnc5.bit.board.dto;


import lombok.*;
import org.modelmapper.ModelMapper;

@Builder
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BoardReqDto {
    private Long id;

    private String title;

    private String content;

    private static ModelMapper modelMapper = new ModelMapper();

    public static BoardReqDto of(BoardDto boardDto){
        return modelMapper.map(boardDto,BoardReqDto.class);
    }
}
