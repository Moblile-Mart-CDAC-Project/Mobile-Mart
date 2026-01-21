package com.backend.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.backend.dto.UpdateProfileDto;
import com.backend.dto.UserDto;
import com.backend.entitys.User;
import com.backend.repository.UserRepository;
import com.backend.security.SecurityUtil;
import com.backend.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Override
    public UserDto getProfile() {

        User user = userRepository
                .findByEmail(SecurityUtil.getCurrentUserEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        return modelMapper.map(user, UserDto.class);
    }

    @Override
    public UserDto updateProfile(UpdateProfileDto dto) {

        User user = userRepository.findByEmail(
                SecurityUtil.getCurrentUserEmail()
        ).orElseThrow(() -> new RuntimeException("User not found"));

        user.setName(dto.getName());
        user.setMobile(dto.getMobile());

        User saved = userRepository.save(user);

        return modelMapper.map(saved, UserDto.class);
    }
}
