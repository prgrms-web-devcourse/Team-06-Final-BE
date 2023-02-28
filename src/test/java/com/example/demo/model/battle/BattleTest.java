package com.example.demo.model.battle;

import static org.assertj.core.api.AssertionsForClassTypes.*;
import static org.mockito.Mockito.*;

import java.util.stream.Stream;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demo.model.post.Genre;
import com.example.demo.model.post.Post;

@ExtendWith(MockitoExtension.class)
class BattleTest {
	@Mock
	private Post challengingPost;
	@Mock
	private Post challengedPost;

	@Test
	public void 성공_Battle생성_Post가_성공적으로들어오면_Battle이만들어진다() {
		Battle battle = createBattle(challengingPost, challengedPost);

		assertThat(battle.getChallengedPost().getVoteCount()).isEqualTo(0);
		assertThat(battle.getChallengingPost().getVoteCount()).isEqualTo(0);

	}

	@ParameterizedTest
	@MethodSource("testFailDataProviderForCreateBattle")
	public void 실패_Battle생성_Post가Null이면_IllegalArgumentException이_발생한다(Post challengingPost, Post challengedPost) {

		IllegalArgumentException exception = Assert.assertThrows(IllegalArgumentException.class, () ->
			createBattle(challengingPost, challengedPost)
		);
	}

	@ParameterizedTest
	@NullSource
	public void 실패_Battle생성_장르가_null인_경우_게시글을_생성할_수_없다(Genre nullGenre) {
		assertThatThrownBy(() -> {
			Battle.builder()
				.genre(nullGenre)
				.challengedPost(challengedPost)
				.challengingPost(challengingPost)
				.build();
		})
			.isExactlyInstanceOf(IllegalArgumentException.class);
	}

	static Stream<Arguments> testFailDataProviderForCreateBattle() {
		Post challengingPost = mock(Post.class);
		Post challengedPost = mock(Post.class);
		return Stream.of(
			Arguments.arguments(null, challengedPost),
			Arguments.arguments(challengingPost, null),
			Arguments.arguments(null, null)
		);
	}

	private Battle createBattle(Post challengingPost, Post challengedPost) {
		return Battle.builder()
			.genre(Genre.CLASSIC)
			.challengedPost(challengedPost)
			.challengingPost(challengingPost)
			.build();
	}
}
