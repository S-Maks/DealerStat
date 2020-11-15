package com.dealerStat.store.repository;

import com.dealerStat.store.dto.UserDto;
import com.dealerStat.store.model.AbstractUser;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<AbstractUser, Long> {
    UserDto getByEmail(String email);
}
