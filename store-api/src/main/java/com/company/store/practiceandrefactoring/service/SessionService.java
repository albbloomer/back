package com.company.store.practiceandrefactoring.service;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Service;

@Service
public class SessionService {

    private final HttpSession httpSession;

    public SessionService(
            HttpSession httpSession
    ) {
        this.httpSession = httpSession;
    }

    public void userSession(final String zuid) {
        httpSession.setAttribute(SessionConstant.userKey(zuid), "value");
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
