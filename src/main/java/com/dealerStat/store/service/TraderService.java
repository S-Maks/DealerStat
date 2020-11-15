package com.dealerStat.store.service;

import com.dealerStat.store.dto.GeneralUserDto;
import com.dealerStat.store.dto.TraderDto;
import com.dealerStat.store.exception.ConvertingException;
import com.dealerStat.store.exception.NoSuchEntityException;

import java.util.List;

public interface TraderService {

    List<TraderDto> allTraders();

    void add(TraderDto dto) throws ConvertingException;

    void edit(TraderDto dto) throws ConvertingException;

    void delete(TraderDto dto) throws ConvertingException;

    TraderDto getById(Long id) throws NoSuchEntityException;

    List<GeneralUserDto> getGeneralTradersInfo();
}
