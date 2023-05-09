package com.meds.service;

import com.meds.errors.RecordNotFoundException;
import com.meds.model.User;
import com.meds.repository.UserRepository;
import com.sun.tools.javac.Main;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService extends MainService<User, Long> {
    @Autowired
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        super(userRepository);
    }

    @Override
    public <T> void checksBeforeInsert(T check) {
        User user = (User) check;
        alreadyExists(user.getEmail());
    }

    @Override
    public <T> void checksBeforeUpdate(T check) {
        notFound((Long) check);
    }

    @Override
    public <T> void checksBeforeDelete(T check) {
        notFound((long) check);
    }

    @Override
    public <T> User prepareRecordForUpdate(User userFromBody, T userId) {
        userFromBody.setId((Long) userId);
        return userFromBody;
    }

    public void notFound(long id) {
        if(!userRepository.existsUserById(id)){
            throw new RecordNotFoundException("This User not found");
        }
    }

    public void alreadyExists(String email) {
        if(userRepository.existsUserByEmail(email)){
            throw new RuntimeException("the email of this user already exists");
        };
    }
}



