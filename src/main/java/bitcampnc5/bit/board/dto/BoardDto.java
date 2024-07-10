package bitcampnc5.bit.board.dto;

import bitcampnc5.bit.User.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BoardDto{
	private Long id;

	private String title;

	private String content;

	private UserDto userDto;
}
