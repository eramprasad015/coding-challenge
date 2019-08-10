package com.test;


import com.entity.Name;
import com.entity.User;
import com.repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Test
    public void assertUserPrimaryKey() {
        User input = new User();
        input.setPrimarykey(10L);
        User response = new User();
        response.setPrimarykey(10L);

        Assert.assertEquals((long) input.getPrimarykey(), 10L);
        Assert.assertEquals(input.getPrimarykey(), response.getPrimarykey());
    }

    @Test
    public void createUserAssertName() {
        User input = new User();
        input.setGender("Male");
        Name inputName = new Name();
        inputName.setTitle("title");
        inputName.setFirst("first");
        inputName.setLast("last");
        input.setName(inputName);
        User response = userRepository.save(input);

        Assert.assertEquals(response.getName(), input.getName());
    }

    @Test
    public void createUserAssertNameFirstOrganic() {
        User input = new User();
        input.setGender("Male");
        Name inputName = new Name();
        inputName.setTitle("title");
        inputName.setFirst("first");
        inputName.setLast("last");
        input.setName(inputName);
        User response = userRepository.save(input);

        Assert.assertEquals(response.getName().getFirst(), input.getName().getFirst());
    }

    @Test
    public void createUserAssertNameOrganic() {
        User input = new User();
        input.setGender("Male");
        Name inputName = new Name();
        inputName.setTitle("title");
        inputName.setFirst("first");
        inputName.setLast("last");
        input.setName(inputName);
        User response = userRepository.save(input);

        Assert.assertEquals(response.getName().getFirst(), input.getName().getFirst());
        Assert.assertEquals(response.getName().getLast(), input.getName().getLast());
    }

    @Test
    public void createUserAssertId() {
        User input = new User();
        input.setGender("Male");
        Name inputName = new Name();
        inputName.setTitle("title");
        inputName.setFirst("first");
        inputName.setLast("last");
        input.setName(inputName);
        User response = userRepository.save(input);

        Assert.assertEquals(response.getPrimarykey(), input.getPrimarykey());
    }

    @Test
    public void creatUserAssertGender() {
        User input = new User();
        input.setGender("Male");
        Name inputName = new Name();
        inputName.setTitle("title");
        inputName.setFirst("first");
        inputName.setLast("last");
        input.setName(inputName);
        User response = userRepository.save(input);

        Assert.assertEquals(response.getGender(), input.getGender());
    }
}
