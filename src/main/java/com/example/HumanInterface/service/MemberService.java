package com.example.HumanInterface.service;

import com.example.HumanInterface.domain.Member;
import com.example.HumanInterface.dto.MemberRequestDTO;
import com.example.HumanInterface.dto.MemberResponseDTO;
import com.example.HumanInterface.repository.MemberRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class MemberService {

    @Autowired
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    public MemberResponseDTO registerMember(MemberRequestDTO request) {
        Member savedMember = memberRepository.save(request.toEntity());
        return savedMember.of();
    }
}
