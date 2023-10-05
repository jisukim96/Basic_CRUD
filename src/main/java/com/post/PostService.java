package com.post;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.post.Domain.Post;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostService {

	private final PostRepository postRepository;
	
	//새 게시글 생성
	public void create(PostDTO postDTO) {
		Post post = new Post();
		post.setTitle(postDTO.getTitle());
		post.setContents(postDTO.getContents());
		postRepository.save(post);
	}
	
	//게시글 단건 조회
	public Post get(Integer id) {
		Optional<Post> _post = this.postRepository.findById(id);
		if(_post.isPresent()) {
			Post post = _post.get();
			return post;
		}else {
			throw new NullPointerException("존재하지 않는 게시글 입니다.");
		}
	}
	
	//게시글 리스트 조회
	public List<Post> getList(){
		List<Post> list = this.postRepository.findAll();
		return list;
	}
	
	
	//게시글 수정
	public void update(Integer Id,PostDTO postDTO) {
		Optional<Post> _post = this.postRepository.findById(Id);
		if(_post.isPresent()) {
			Post post = _post.get();
			post.setTitle(postDTO.getTitle());
			post.setContents(postDTO.getContents());
			this.postRepository.save(post);
		}else {
			throw new NullPointerException("존재하지 않는 게시글입니다.");
		}
	}
	
	//게시글 삭제
	public void delete(Integer Id) {
		Optional<Post> _post =	this.postRepository.findById(Id);
		if(_post.isPresent()) {
			this.postRepository.deleteById(Id);
		}else {
			throw new NullPointerException();
		}
		
	}
	
	
}
