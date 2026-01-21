package com.backend.service;

import com.backend.dto.UpdateProfileDto;
import com.backend.dto.UserDto;


public interface UserService {
	UserDto getProfile();
	UserDto updateProfile(UpdateProfileDto dto);
}
