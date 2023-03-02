package com.example.demo.service;

import static com.example.demo.common.ExceptionMessage.*;

import java.security.Principal;
import java.text.MessageFormat;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.controller.battle.BattleCreateRequestDto;
import com.example.demo.model.battle.Battle;
import com.example.demo.model.battle.BattleStatus;
import com.example.demo.model.member.Member;
import com.example.demo.model.post.Genre;
import com.example.demo.model.post.Post;
import com.example.demo.repository.BattleRepository;
import com.example.demo.repository.PostRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BattleService {

	private PrincipalService principalService;
	private BattleRepository battleRepository;
	private PostRepository postRepository;

	@Transactional
	public Long createBattle(Principal principal, BattleCreateRequestDto battleCreateRequestDto) {
		long challengedPostId = battleCreateRequestDto.challengedPostId();
		long challengingPostId = battleCreateRequestDto.challengingPostId();

		Post challengedPost = postRepository.findPostByIdAndIsPossibleBattle(challengedPostId, true)
			.orElseThrow(() -> new EntityNotFoundException(
				MessageFormat.format("postId {0}: {1}",
					challengedPostId, CANNOT_MAKE_BATTLE_WRONG_POST_ID.getMessage()
				)
			));

		Post challengingPost = postRepository.findPostByIdAndIsPossibleBattle(challengingPostId, true)
			.orElseThrow(() -> new EntityNotFoundException(
				MessageFormat.format("postId{0}: {1}",
					challengingPostId, CANNOT_MAKE_BATTLE_WRONG_POST_ID.getMessage()
				)
			));

		Member memberByPrincipal = principalService.getMemberByPrincipal(principal);

		validMemberHasChallengingPost(challengingPost, memberByPrincipal);
		validMemberHasNotChallengedPost(challengedPost, memberByPrincipal);
		validMemberChallengeTicket(memberByPrincipal);
		Genre targetGenre = validGenre(challengingPost, challengedPost);
		Battle newBattle = Battle.builder()
			.challengingPost(challengingPost)
			.challengedPost(challengedPost)
			.genre(targetGenre)
			.status(BattleStatus.PROGRESS)
			.build();
		battleRepository.save(newBattle);
		memberByPrincipal.subtractCountOfChallengeTicket();
		return newBattle.getId();
	}

	private Genre validGenre(Post challengingPost, Post challengedPost) {
		if (challengingPost.getMusic().getGenre() != challengedPost.getMusic().getGenre()) {
			throw new IllegalArgumentException(CANNOT_MAKE_BATTLE_DIFFERENT_GENRE.getMessage());
		} else {
			return challengedPost.getMusic().getGenre();
		}
	}

	private void validMemberChallengeTicket(Member memberByPrincipal) {
		if (memberByPrincipal.getCountOfChallengeTicket() == 0) {
			throw new IllegalStateException(CANNOT_MAKE_BATTLE_NOT_ENOUGH_CHALLENGE_TICKET.getMessage());
		}
	}

	private void validMemberHasNotChallengedPost(Post challengedPost, Member memberByPrincipal) {
		Long memberByPrincipalId = memberByPrincipal.getId();
		Long challengedMemberId = challengedPost.getMember().getId();
		if (memberByPrincipalId == challengedMemberId) {
			throw new IllegalArgumentException(CANNOT_MAKE_BATTLE_OWN_CHALLENED_POST.getMessage());
		}
	}

	private void validMemberHasChallengingPost(Post challengingPost, Member memberByPrincipal) {
		Long memberByPrincipalId = memberByPrincipal.getId();
		Long challengingMemberId = challengingPost.getMember().getId();
		if (memberByPrincipalId != challengingMemberId) {
			throw new IllegalArgumentException(CANNOT_MAKE_BATTLE_NOT_MEMBERS_POST.getMessage());
		}
	}
}
