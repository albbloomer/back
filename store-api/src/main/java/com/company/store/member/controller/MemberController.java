package com.company.store.member.controller;

import com.company.store.common.ResponseDto;
import com.company.store.member.dto.MemberSignupRequest;
import com.company.store.member.dto.MemberSignupResponse;
import com.company.store.member.facade.MemberFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/member")
@RequiredArgsConstructor
@RestController
public class MemberController {

    private final MemberFacade memberFacade;

    @PostMapping("/signup")
    public ResponseDto<MemberSignupResponse> signupMember(@RequestBody final MemberSignupRequest memberSignupRequest) {
        MemberSignupResponse memberSignupResponse = memberFacade.signupMember(memberSignupRequest);

        return ResponseDto.ok(memberSignupResponse);
    }
}