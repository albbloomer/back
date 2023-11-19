package com.company.store.programers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("CotePlayground 알고리즘 테스트")
class CotePlayground1Test {

    @DisplayName("문제 제목 : -, 문제 유형 : -")
    @Test
    void 문제_제목() {
        Integer result = CotePlayground1.problem_1_result();
        assertThat(result).isEqualTo(3);
    }
}