// new interface ExpenseService

package com.example.CuddleCare.service.Impl;

import com.example.CuddleCare.dao.BottleFeedingDao;
import com.example.CuddleCare.dto.BottleFeedingDTO;
import com.example.CuddleCare.entity.BottleFeeding;
import com.example.CuddleCare.mapper.BottleFeedingMapper;
import com.example.CuddleCare.service.BottleFeedingService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;


@Service
@Transactional
public class BottleFeedingServiceimpl implements BottleFeedingService {

    private BottleFeedingMapper bottlefeedingMapper;
    private BottleFeedingDao bottlefeedingDao;
    public BottleFeedingServiceimpl(BottleFeedingDao bottlefeedingDao, BottleFeedingMapper bottlefeedingMapper) {
        this.bottlefeedingDao = bottlefeedingDao;
        this.bottlefeedingMapper = bottlefeedingMapper;
    }


    @Override
    public BottleFeedingDTO createBottleFeeding(BottleFeedingDTO bottlefeedingDto) {
        BottleFeeding bottlefeeding = bottlefeedingMapper.FromBottleFeedingDTO(bottlefeedingDto);
        BottleFeeding savedBottleFeeding= bottlefeedingDao.save(bottlefeeding);
        return bottlefeedingMapper.FromBottleFeeding(savedBottleFeeding);

    }

    @Override
    public Optional<BottleFeeding> getFeedingDetails(Long id) {
        return bottlefeedingDao.findById(id);
    }


}



