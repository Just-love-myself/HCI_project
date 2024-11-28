package com.example.HumanInterface.controller;


import com.example.HumanInterface.dto.MemberRequestDTO;
import com.example.HumanInterface.dto.MemberResponseDTO;
import com.example.HumanInterface.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }


    @PostMapping("/members")
//    @CrossOrigin(origins = "https://memory-game-him.netlify.app")
    @CrossOrigin(origins = {"https://memory-game-him.netlify.app", "http://localhost:3000"})
    public ResponseEntity<MemberResponseDTO> registerMember(@RequestBody @Valid MemberRequestDTO request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(memberService.registerMember(request));
    }
}
