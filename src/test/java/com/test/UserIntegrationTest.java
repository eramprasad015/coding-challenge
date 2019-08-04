package com.test;

import com.Name;
import com.User;
import com.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.runner.RunWith;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserIntegrationTest {

    @Autowired
    UserRepository userRepository;

    @Test
    public void assertUsername() {
        Name name = new Name();
        name.setFirst("Eric");
        name.setLast("Sarvey");
        name.setTitle("Mr.");
        User user = new User();
        user.setName(name);
        user.setGender("male");
        User savedUser = userRepository.save(user);
        System.out.println("Saved User Primary Key = " + savedUser.getPrimarykey());
        Assert.assertEquals(savedUser.getName(), user.getName());
    }

    @Test
    public void assertUserObject() {
        Name name = new Name();
        name.setFirst("Bascomb");
        name.setLast("Arnette");
        name.setTitle("Mr.");
        User user = new User();
        user.setName(name);
        user.setGender("male");
        User savedUser = userRepository.save(user);
        System.out.println("Saved User Primary Key = " + savedUser.getPrimarykey());
        Assert.assertEquals(savedUser, user);
    }
}
