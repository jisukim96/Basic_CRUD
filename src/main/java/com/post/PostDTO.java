package com.post;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PostDTO {
	public Integer id;
	
	public String title;
	
	public String contents;
}
