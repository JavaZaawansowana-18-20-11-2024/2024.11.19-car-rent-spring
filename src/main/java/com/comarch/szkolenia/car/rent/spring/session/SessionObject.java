package com.comarch.szkolenia.car.rent.spring.session;

import com.comarch.szkolenia.car.rent.spring.model.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
@Getter
@Setter
public class SessionObject {
    private User loggedUser;
    private String lastLoginDate;
    private String lastURL;
}
