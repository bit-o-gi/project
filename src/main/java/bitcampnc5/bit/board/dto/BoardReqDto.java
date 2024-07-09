package bitcampnc5.bit.board.dto;


import lombok.Builder;

@Builder
public class BoardReqDto {
    private Long id;

    private String title;

    private String content;
}
