package bit.anniversary.dto;

import lombok.Builder;

@Builder
public class AnReqDto {

	private final Long id;

	private final String writetime;

	private final String title;

	private final String withpeople;

	private final String content;

}
