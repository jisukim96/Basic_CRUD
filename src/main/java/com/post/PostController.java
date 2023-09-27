package com.post;


import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {
	
	private final PostService postService;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	//단건 게시글 조회
	@GetMapping("/detail/{Id}")
	public String getPost(@PathVariable Integer Id, Model model) {
		try {
		Post post = this.postService.get(Id);
		model.addAttribute("post", post);
		}catch(NullPointerException e ) {
			e.printStackTrace();
		}
		return "post";
	}
	
	//게시글 리스트 조회
	@GetMapping("/list")
	public String getList(Model model) {
		List<Post> list = this.postService.getList();
		model.addAttribute("postList",list);
		return "list";
	}
	@GetMapping(value = "/create")
	public String create () {
		return "form";
	}
	
	//게시글 생성
	@PostMapping(value =  "/create")
	public String create (@Valid PostDTO postDTO,
			BindingResult bindingResult) {
		if(bindingResult.hasErrors()) { return "form";};
		
		this.postService.create(postDTO);
		return "list";
	}
	
	//게시글 수정
	@PostMapping("/update/{Id}")
	public String update(@PathVariable Integer Id,PostDTO postDTO,BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {return "edit";};
		try {
		this.postService.update(Id, postDTO);
		}catch(NullPointerException e ) {
			e.printStackTrace();
		}
		return String.format("Redirect:/post/{Id}",Id);
	}
	
	//게시글 삭제
	@GetMapping("/delete/{Id}")
	public String delete(@PathVariable Integer Id) {
		try {
		this.postService.delete(Id);
		}catch(NullPointerException e) {
			e.printStackTrace();
		}
		return "list";
	}
	
	
}
