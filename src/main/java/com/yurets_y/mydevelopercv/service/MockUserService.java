package com.yurets_y.mydevelopercv.service;

import com.yurets_y.mydevelopercv.entities.User;
import org.springframework.stereotype.Service;

import java.util.GregorianCalendar;

@Service("mockedUserService")
public class MockUserService implements UserService {
    @Override
    public User getUser() {
        User user = new User();
        user.setName("Yuriy");
        user.setMiddleName("Yakhnitsa");
        user.setBirthDay(new GregorianCalendar(1989,07,28).getTime());
        user.seteMail("transpmailbox@gmail.com");
        user.setPhone("+38(096)135-09-50");
        return user;
    }
}
