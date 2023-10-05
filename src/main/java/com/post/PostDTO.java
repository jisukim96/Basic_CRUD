package com.post;


import java.time.LocalDateTime;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PostDTO {
	public Integer id;
	
	@NotNull(message = "빈칸입니다! 제목을 입력해주세요")
	public String title;
	
	@NotNull(message = "빈칸입니다! 내용을 입력해주세요")
	public String contents;
	
	public LocalDateTime createdDate;
}
