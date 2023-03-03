package com.example.demo.dto.post;

import java.util.ArrayList;
import java.util.List;

import lombok.AccessLevel;
import lombok.Builder;

@Builder(access = AccessLevel.PRIVATE)
public record PostsFindResponseDto(
	List<PostFindResponseDto> posts
) {
	public static PostsFindResponseDto of(List<PostFindResponseDto> posts) {
		return PostsFindResponseDto.builder()
			.posts(posts)
			.build();
	}

	public static PostsFindResponseDto create() {
		return PostsFindResponseDto.builder()
			.posts(new ArrayList<>())
			.build();
	}
}
