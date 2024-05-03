package com.project.ApartmentComplexServer.components;

import com.project.ApartmentComplexServer.models.User;
import com.project.ApartmentComplexServer.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    UserRepository userRepository;

    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception
    {
        //Users
        //User 1
        User userOne = new User(
                "Alpha",
                12341,
                "Alpha@mail.com",
                "0000"
        );

        userRepository.save(userOne);


    }

} //last
