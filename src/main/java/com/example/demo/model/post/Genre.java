package com.example.demo.model.post;

import lombok.Getter;

@Getter
public enum Genre {
	DANCE("댄스");

	final String name;

	Genre(String name) {
		this.name = name;
	}
}
