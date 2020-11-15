package com.dealerStat.store.service.impl;

import com.dealerStat.store.dto.GeneralUserDto;
import com.dealerStat.store.dto.TraderDto;
import com.dealerStat.store.dto.UserDto;
import com.dealerStat.store.exception.ConvertingException;
import com.dealerStat.store.exception.NoSuchEntityException;
import com.dealerStat.store.model.AbstractUser;
import com.dealerStat.store.repository.UserRepository;
import com.dealerStat.store.service.UserService;
import com.dealerStat.store.service.converter.UserConverter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Transactional(readOnly = false)
public class UserServiceImpl implements UserService {
    private static final Logger logger = Logger.getLogger(String.valueOf(TraderServiceImpl.class));

    private UserRepository userRepository;
    private UserConverter userConverter;

    public UserServiceImpl (UserRepository userRepository, UserConverter userConverter){
        this.userRepository = userRepository;
        this.userConverter = userConverter;
    }

    @Override
    public List<UserDto> allUsers() {
        logger.info("Show users");
        return StreamSupport.stream(userRepository
                .findAll().spliterator(), false)
                .map(user->userConverter.convertToAllUserInfoDto(user))
                .collect(Collectors.toList());
    }

    @Override
    public List<GeneralUserDto> allUserGeneralInfo() {
        logger.info("Show users general info");
        return StreamSupport.stream(userRepository
                .findAll().spliterator(), false)
                .map((user)->userConverter.convertToGeneralUserInfoDto(user))
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public void add(UserDto dto) throws Exception {
        logger.info("Add user id = " + dto.getId());
        AbstractUser user = userConverter.convertToUser(dto);
        userRepository.save(user);
    }

    @Override
    public UserDto getByEmail(String email) throws ConvertingException {
        logger.info("Get user by name: " + email);
        return userRepository.getByEmail(email);
    }

    @Transactional
    @Override
    public void edit(UserDto dto) throws ConvertingException {
        logger.info("Edit user id: " + dto.getId());
        AbstractUser user = userConverter.convertToUser(dto);
        userRepository.save(user);
    }

    public void add(TraderDto dto) throws ConvertingException {
        logger.info("Add trader id = " + dto.getId());
        AbstractUser trader = userConverter.convertToTrader(dto);
        userRepository.save(trader);
    }

    @Override
    public UserDto getById(Long id) throws NoSuchEntityException {
        logger.info("Edit user id: " + id);
        AbstractUser user = userRepository.findById(id).orElseThrow(() -> new NoSuchEntityException(String.format("Can't find entity by id = %id", id)));
        return userConverter.convertToAllUserInfoDto(user);
    }

}
