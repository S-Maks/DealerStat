package com.dealerStat.store.service.converter;

import com.dealerStat.store.dto.GeneralUserDto;
import com.dealerStat.store.dto.TraderDto;
import com.dealerStat.store.dto.UserDto;
import com.dealerStat.store.exception.ConvertingException;
import com.dealerStat.store.model.AbstractUser;
import com.dealerStat.store.model.Trader;
import org.springframework.stereotype.Service;

@Service
public class UserConverter {

    public GeneralUserDto convertToGeneralUserInfoDto(AbstractUser user){
        GeneralUserDto dto = new GeneralUserDto();
        dto.setId(user.getId());
        dto.setRoleName(user.getUserRole().getValue());
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setEmail(user.getEmail());
        return dto;
    }

    public UserDto convertToAllUserInfoDto(AbstractUser user){
        UserDto dto = new UserDto();
        dto.setId(user.getId());
        dto.setRoleName(user.getUserRole());
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setEmail(user.getEmail());
        dto.setUserPassword(user.getUserPassword());
        dto.setCreatedAt(user.getCreatedAt());
        return dto;
    }

    public AbstractUser convertToUser(UserDto dto){
        AbstractUser user = new AbstractUser();
        user = getBaseUser(user, dto);
        return user;
    }

    public TraderDto convertToTraderInfoDto(Trader trader){
        TraderDto dto = new TraderDto();
        dto.setId(trader.getId());
        dto.setRoleName(trader.getUserRole());
        dto.setFirstName(trader.getFirstName());
        dto.setLastName(trader.getLastName());
        dto.setEmail(trader.getEmail());
        dto.setUserPassword(trader.getUserPassword());
        dto.setCreatedAt(trader.getCreatedAt());
        return dto;
    }

    private AbstractUser getBaseUser(AbstractUser user, UserDto dto){
        user.setId(dto.getId());
        user.setUserRole(dto.getRoleName());
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setEmail(dto.getEmail());
        user.setUserPassword(dto.getUserPassword());
        user.setCreatedAt(dto.getCreatedAt());
        return user;
    }

    public Trader convertToTrader(TraderDto dto) throws ConvertingException {
        throwExceptionIfDtoIsNotValid(dto);

        Trader trader = new Trader();
        trader = (Trader)getBaseUser(trader, dto);
        return trader;
    }

    private void throwExceptionIfDtoIsNotValid(UserDto dto) throws ConvertingException {
        if (dto == null)
            throw new ConvertingException("Must be not null.");
        if (dto.getRoleName() == null)
            throw new ConvertingException("Role must be not null.");
        if (dto.getFirstName() == null || dto.getLastName() == null)
            throw new ConvertingException("Name must be not null.");

    }
}
