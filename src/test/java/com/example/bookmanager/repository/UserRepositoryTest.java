package com.example.bookmanager.repository;

import com.example.bookmanager.domain.User;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;

import java.util.List;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.endsWith;

@SpringBootTest
class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    void crud(){
        /*
        userRepository.save(new User(1L, "sjs", "test@test.com", null,null));
        userRepository.save(new User(2L, "denis", "test@test.com", null,null));
        userRepository.save(new User(3L, "steve", "test@test.com", null,null));
        userRepository.save(new User(4L, "sjs", "test@test.com", null,null));
        userRepository.save(new User(5L, "jesi", "test@test.com", null,null));
        userRepository.findAll().forEach(System.out::println);
        */

        //List<User> users = userRepository.findAll(Sort.by(Sort.Direction.DESC, "name"));
        //List<User> users = userRepository.findAllById(Lists.newArrayList(1L,2L,5L));
        //User user = userRepository.findById(1L).orElse(null);
        //System.out.println(user);;
//        users.forEach(System.out::println);
    }

    @Test
    @Ignore
    void count(){
        long count = userRepository.count();
        System.out.println(count);
    }

    @Test
    @Ignore
    void exist(){
        boolean exist = userRepository.existsById(1L);
        System.out.println(exist);
    }

    @Test
    void page(){
        Page<User> users = userRepository.findAll(PageRequest.of(1,3));

        System.out.println("page =" + users);
        System.out.println("totalElements =" + users.getTotalElements());
        System.out.println("totalpages =" + users.getTotalPages());
        System.out.println("numverofElemts =" + users.getNumberOfElements());
        System.out.println("sot =" + users.getSort());
        System.out.println("sizr =" + users.getSize());

        users.getContent().forEach(System.out::println);

    }

    @Test
    void example(){
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnorePaths("name")
                .withMatcher("email", endsWith());

        Example<User> exam = Example.of(new User("ma", "@test.com"), matcher);

        userRepository.findAll(exam).forEach(System.out::println);

    }
}