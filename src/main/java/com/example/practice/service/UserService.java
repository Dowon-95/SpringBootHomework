package com.example.practice.service;

import com.example.practice.entity.Users;
import com.example.practice.dto.UserDTO;
import com.example.practice.respository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void save(UserDTO dto) {
        Users users = dto.toEntity();
        userRepository.save(users);
    }

    @Transactional
    public List<Users> show() {
       return userRepository.findAll();
    }


    @Transactional
    public void delete(Long id){
        userRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("없어")
        );
        userRepository.deleteById(id);
    }

    @Transactional
    public void update(Long id, UserDTO dto){
        Users target = userRepository.findById(id).orElse(null);
        if ( target != null){
            target.setName(dto.getName());
            target.setEmail(dto.getEmail());
            target.setNumber(dto.getNumber());
        }
    }
}
