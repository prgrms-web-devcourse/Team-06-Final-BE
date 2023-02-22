package com.example.demo.common;

import lombok.Getter;

@Getter
public enum ResponseMessage {
	// Post
	SUCCESS_CREATE_POST("음악 공유 게시글 등록 성공");

	final String message;

	ResponseMessage(String message) {
		this.message = message;
	}
}
