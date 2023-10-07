package com.post;


import java.lang.ProcessHandle.Info;
import java.util.List;

import org.hibernate.validator.internal.util.logging.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.post.Domain.Post;

import ch.qos.logback.classic.Logger;
import groovy.util.logging.Slf4j;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {
	
//	private final Logger log = LoggerFactory.getLogger(getClass());
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
	//게시글 생성
	//model에 form에 들어온 정보를 담아서 템플릿으로 전달해야함 빈 객체가 필요함
	@GetMapping(value = "/create")
	public String create (Model model) {
		model.addAttribute("postDTO", new PostDTO());
		return "form";
	}
	

	@PostMapping(value =  "/create")
	public String create (@Valid PostDTO postDTO, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) { return "form";};
		this.postService.create(postDTO);
		return "redirect:/post/list";
	}
	
	
	//게시글 수정
	
	
	@PostMapping("/update/{Id}")
	public String update(@PathVariable Integer Id, PostDTO postDTO, BindingResult bindingResult, Model model) {
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
		return "redirect:/post/list";
	}
	
	
}
