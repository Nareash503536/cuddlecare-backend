// new interface ExpenseService

package com.example.CuddleCare.service.Impl;

import com.example.CuddleCare.dao.BreastFeedingDao;

import com.example.CuddleCare.dto.BreastFeedingDTO;

import com.example.CuddleCare.entity.BreastFeeding;

import com.example.CuddleCare.mapper.BreastFeedingMapper;

import com.example.CuddleCare.service.BFeedService;

import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;


@Service
@Transactional
public class BFeedServiceImpl implements BFeedService {

    private BreastFeedingMapper breastFeedingMapper;
    private BreastFeedingDao breastFeedingDao;
    public BFeedServiceImpl(BreastFeedingDao breastFeedingDao, BreastFeedingMapper breastFeedingMapper) {
        this.breastFeedingDao = breastFeedingDao;
        this.breastFeedingMapper = breastFeedingMapper;
    }


    @Override
    public BreastFeedingDTO createBfeeding(BreastFeedingDTO breastFeedingDTO) {
        BreastFeeding breastFeeding = breastFeedingMapper.FromBreastFeedingDTO(breastFeedingDTO);
        BreastFeeding savedBreastFeeding= breastFeedingDao.save(breastFeeding);
        return breastFeedingMapper.FromBreastFeeding(savedBreastFeeding);

    }

    @Override
    public List<BreastFeeding> getAllBFeeding() {
        return breastFeedingDao.findAll();
    }

    @Override
    public List<BreastFeeding> getlastthreeBFeeding() {
        LocalDate threeDaysAgo = LocalDate.now().minusDays(3);
        return breastFeedingDao.AllFeedingsByDate(threeDaysAgo);
    }


}



