package com.example.demo.controller;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.common.ApiResponse;
import com.example.demo.common.ResponseMessage;
import com.example.demo.dto.post.PostCreateRequestDTO;
import com.example.demo.service.PostService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/posts")
public class PostController {

	private final PostService postService;

	@PostMapping
	public ResponseEntity<ApiResponse> createPost(@RequestBody PostCreateRequestDTO postRequestDto) {
		Long postId = postService.createPost(postRequestDto);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
			.path("/api/v1/posts/{postId}")
			.buildAndExpand(postId)
			.toUri();

		ApiResponse apiResponse = ApiResponse.success(ResponseMessage.SUCCESS_CREATE_POST.getMessage());

		return ResponseEntity.created(location).body(apiResponse);
	}

}
