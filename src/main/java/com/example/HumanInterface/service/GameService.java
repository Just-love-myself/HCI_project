package com.example.HumanInterface.service;

import com.example.HumanInterface.domain.GameResult;
import com.example.HumanInterface.domain.Member;
import com.example.HumanInterface.dto.GameResultRequestDTO;
import com.example.HumanInterface.repository.GameResultRepository;
import com.example.HumanInterface.repository.MemberRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class GameService {

    private final GameResultRepository gameResultRepository;
    private final MemberRepository memberRepository;    // 추가

    @Autowired
    public GameService(GameResultRepository gameResultRepository,
                       MemberRepository memberRepository) {
        this.gameResultRepository = gameResultRepository;
        this.memberRepository = memberRepository;
    }

    public void saveGameResult(Long memberId, GameResultRequestDTO request) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new RuntimeException("Member not found"));

        GameResult gameResult = new GameResult(
                member,
                request.getCardCount(),
                request.getCardType(),
                request.getSolvedTime(),
                request.getUserAnswer(),
                request.getWrongCount()
        );

        gameResultRepository.save(gameResult);
    }

    /*public void saveGameResult(GameResultRequestDTO request) {
        Member member = memberRepository.findById(request.getUserAnswer())
                .orElseThrow(() -> new RuntimeException("Member not found"));

        GameResult gameResult = new GameResult(
                member,
                request.getCardCount(),
                request.getCardType(),
                request.getSolvedTime(),
                request.getUserAnswer(),
                request.getWrongCount()
        );

        gameResult.setMember(member);
        gameResultRepository.save(gameResult);
    }*/
}
