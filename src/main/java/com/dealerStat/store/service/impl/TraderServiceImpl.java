package com.dealerStat.store.service.impl;

import com.dealerStat.store.dto.GeneralUserDto;
import com.dealerStat.store.dto.TraderDto;
import com.dealerStat.store.exception.ConvertingException;
import com.dealerStat.store.exception.NoSuchEntityException;
import com.dealerStat.store.model.Trader;
import com.dealerStat.store.repository.TraderRepository;
import com.dealerStat.store.service.TraderService;
import com.dealerStat.store.service.converter.UserConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Transactional(readOnly = true)
public class TraderServiceImpl implements TraderService {
    private static final Logger logger = Logger.getLogger(String.valueOf(TraderServiceImpl.class));

    @Autowired
    private TraderRepository traderRepository;

    @Autowired
    private UserConverter userConverter;


    @Override
    public List<TraderDto> allTraders() {
        logger.info("Show traders");
        return StreamSupport.stream(traderRepository
                .findAll().spliterator(), false)
                .map(trader -> userConverter.convertToTraderInfoDto(trader))
                .sorted(Comparator.comparing(TraderDto::getId))
                .collect(Collectors.toList());
    }

    @Override
    public void add(TraderDto dto) throws ConvertingException {
        logger.info("Add trader id = " + dto.getId());
        Trader trader = userConverter.convertToTrader(dto);
        traderRepository.save(trader);
    }

    @Override
    public void edit(TraderDto dto) throws ConvertingException {
        logger.info("Edit trader id = " + dto.getId());
        Trader trader = userConverter.convertToTrader(dto);
        traderRepository.save(trader);
    }
    @Transactional
    @Override
    public void delete(TraderDto dto) throws ConvertingException {
        logger.info("Delete trader id = " + dto.getId());
        Trader trader = userConverter.convertToTrader(dto);
        traderRepository.delete(trader);
    }

    @Override
    public TraderDto getById(Long id) throws NoSuchEntityException {
        logger.info("Get trader by id: " + id);
        Trader trader = traderRepository.findById(id).orElseThrow(() -> new NoSuchEntityException(String.format("Can't find entity by id = %id", id)));
        return userConverter.convertToTraderInfoDto(trader);
    }

    @Override
    public List<GeneralUserDto> getGeneralTradersInfo(){
        logger.info("Get general traders info");
        return StreamSupport.stream(traderRepository
                .findAll().spliterator(), false)
                .map(trader -> userConverter.convertToGeneralUserInfoDto(trader))
                .sorted(Comparator.comparing(GeneralUserDto::getId))
                .collect(Collectors.toList());
    }
}
