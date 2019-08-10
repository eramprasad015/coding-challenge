package com.test;

import com.entity.Name;
import com.entity.User;
import com.repository.UserRepository;
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

//    @Test
//    public void putTest() {
//        Name name = new Name();
//        name.setFirst("Annelise");
//        name.setLast("Arnette");
//        name.setTitle("Mrs.");
//        User user = new User();
//        user.setName(name);
//        user.setGender("male");
//        user = userRepository.save(user);
//
//        System.out.println("Saved User Primary Key = " + user.getPrimarykey());
//
//        user = userRepository.getOne(user.getPrimarykey());
//        user.setGender("Female");
//        userRepository.save(user);
//        User updatedUser = userRepository.getOne(user.getPrimarykey());
//        Assert.assertTrue(updatedUser.getGender().equals("Female"));
//    }

    @Test
    public void updateTest() {
        //create new user
        Name name = new Name();
        name.setFirst("Annelise");
        name.setLast("Arnette");
        name.setTitle("Mrs.");
        User user = new User();
        user.setName(name);
        user.setGender("male");

        //save new user
        User before = userRepository.save(user);
        long beforeId = before.getPrimarykey();

        System.out.println("Before Id = " + before.getPrimarykey());

        //set gender on saved user
        before.setGender("Female");

        //update user
        userRepository.save(before);

        Assert.assertEquals(before,userRepository.getOne(beforeId));
    }
}
