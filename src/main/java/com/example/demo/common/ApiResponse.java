package com.example.demo.common;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.NonNull;

@Builder(access = AccessLevel.PRIVATE)
public record ApiResponse(
	boolean success,
	@NonNull String message,
	Object data
) {

	public static ApiResponse success(String message, Object data) {
		return ApiResponse.builder()
			.success(true)
			.message(message)
			.data(data)
			.build();
	}

	public static ApiResponse fail(String message) {
		return ApiResponse.builder()
			.success(false)
			.message(message)
			.build();
	}
}
