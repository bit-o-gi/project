package bit.anniversary.entity;

import java.time.LocalDateTime;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bit.anniversary.dto.AnDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Component
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Anniversary {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String writeTime;

	private String title;

	private String writer;

	private String withPeople;

	private String updateTime;

	private String content;

	private LocalDateTime anniversaryDate;


	private static ModelMapper modelMapper;

	@Autowired
	public Anniversary(ModelMapper modelMapper) {
		Anniversary.modelMapper = modelMapper;
	}

	public AnDto creatAnniversary() {
		return modelMapper.map(this, AnDto.class);
	}

	public void update(AnDto anDto) {
		this.writer = anDto.getWriter();
		this.title = anDto.getTitle();
		this.withPeople = anDto.getWithPeople();
		this.content = anDto.getContent();
	}

}


