package com.post;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PostPracticeApplicationTests {

	@Autowired
	private PostRepository postRepository;
	private PostService postService;
	
	@Test
	void contextLoads() {
		Post post = new Post();
		post.setTitle("쥬라기공원 파트2");
		post.setContents("티라노사우르스가 어쩌구 뭘 안먹고 복종하고 저쩌구");
		postRepository.save(post);
		
	}
	
	@Test
	void edit() {
		String title = "게시글 제목003";
		String contents = "게시글 내용003";
		
		Post post = new Post();
		post.setTitle(title);
		post.setContents(contents);
		
		postRepository.save(post);
		
		List<Post> postList = postRepository.findAll();
		
		Post post2 = postList.get(1);
		assertThat(post2.getTitle()).isEqualTo(title);
		assertThat(post2.getContents()).isEqualTo(contents);
		
	}
	
//	@Test
//	void delete(){
//		this.postRepository.deleteAll();
//	}

}
