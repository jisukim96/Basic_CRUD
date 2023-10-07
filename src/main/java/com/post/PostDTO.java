package com.post;


import java.time.LocalDateTime;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostDTO {
	public Integer id;
	
	@NotEmpty(message = "빈칸입니다! 제목을 입력해주세요")
	private String title;
	
	@NotEmpty(message = "빈칸입니다! 내용을 입력해주세요")
	private String contents;
	
	private LocalDateTime createdDate;
}
