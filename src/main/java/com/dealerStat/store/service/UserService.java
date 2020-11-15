package com.dealerStat.store.service;

import com.dealerStat.store.dto.GeneralUserDto;
import com.dealerStat.store.dto.UserDto;
import com.dealerStat.store.exception.ConvertingException;
import com.dealerStat.store.exception.NoSuchEntityException;

import java.util.List;

public interface UserService {

    List<UserDto> allUsers();

    List<GeneralUserDto> allUserGeneralInfo();

    void add(UserDto dto) throws Exception;

    UserDto getByEmail(String username) throws ConvertingException;

    void edit(UserDto dto) throws ConvertingException;

    UserDto getById(Long id) throws NoSuchEntityException;
}
