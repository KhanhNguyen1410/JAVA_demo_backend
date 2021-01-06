package com.musicapp.service.user;

import com.musicapp.model.User;
import com.musicapp.repository.user.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class IUserServiceIPL implements IUserService {

    @Autowired
    private IUserRepository iUserRepository;

    @Override
    public Iterable<User> findAll() {
        return iUserRepository.findAll();
    }

    @Override
    public User save(User user) {
        return iUserRepository.save(user);
    }

    @Override
    public Optional<User> findById(Long id) {
        return iUserRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
        iUserRepository.deleteById(id);
    }
}
