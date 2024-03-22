package com.company.store.practiceandrefactoring.service;

import com.company.store.practiceandrefactoring.dto.UserSession;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SessionService {

    private final HttpSession httpSession;

    public SessionService(
            HttpSession httpSession
    ) {
        this.httpSession = httpSession;
    }

    // Todo : hashMap 으로
    public void userSession(final String zuid) {

        Map<String, Object> userHashData = new HashMap<>();

        List<String> cart = new ArrayList<>();
        cart.add("item1");
        cart.add("item2");
        cart.add("item3");
        userHashData.put("cart", cart);

        // 최근 활동 정보 세션에 저장
        Map<String, String> activity = new HashMap<>();
        activity.put("last_login", "2024-03-25T10:00:00");
        activity.put("last_page_visited", "/products");
        userHashData.put("activity", activity);
        httpSession.setAttribute(SessionConstant.userKey(zuid), userHashData);
    }

    // Todo : Dto 로
    public void userSessionByDto(final String zuid) {

        List<UserSession.Cart> cart = new ArrayList<>();
        cart.add(new UserSession.Cart(1L,"minyul_1"));
        cart.add(new UserSession.Cart(2L,"minyul_2"));
        UserSession userSession = new UserSession("zuid", LocalDateTime.now(), cart);

        httpSession.setAttribute(SessionConstant.userKey(zuid) + "dto", userSession);
    }

    /**
     * 따로 클래스 만들기 귀찮아서
     */
    public static class SessionConstant {

        public static final String USER_SESSION_PRIFIX = "USER_SESSION";

        public static String userKey(final String zuid) {
            return String.format(USER_SESSION_PRIFIX + "_%s",zuid);
        }
    }
}
