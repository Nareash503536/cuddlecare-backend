// new interface ExpenseService

package com.example.CuddleCare.service.Impl;

import com.example.CuddleCare.dao.BabyDao;
import com.example.CuddleCare.dao.BottleFeedingDao;
import com.example.CuddleCare.dto.BottleFeedingDTO;
import com.example.CuddleCare.entity.Baby;
import com.example.CuddleCare.entity.BottleFeeding;
import com.example.CuddleCare.entity.BreastFeeding;
import com.example.CuddleCare.mapper.BottleFeedingMapper;
import com.example.CuddleCare.service.BottleFeedingService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class BottleFeedingServiceimpl implements BottleFeedingService {

    private BottleFeedingMapper bottlefeedingMapper;
    private BottleFeedingDao bottlefeedingDao;
    private BabyDao babyDao;


    public BottleFeedingServiceimpl(BabyDao babyDao, BottleFeedingDao bottlefeedingDao, BottleFeedingMapper bottlefeedingMapper) {
        this.bottlefeedingDao = bottlefeedingDao;
        this.bottlefeedingMapper = bottlefeedingMapper;
        this.babyDao = babyDao;

    }


    @Override
    public BottleFeedingDTO createBottleFeeding(BottleFeedingDTO bottlefeedingDto) {
        BottleFeeding bottlefeeding = bottlefeedingMapper.FromBottleFeedingDTO(bottlefeedingDto);
//        Baby baby = babyDao.findById(bottlefeedingDto.getBaby().getBabyID()).orElseThrow(() -> new RuntimeException("Baby with ID " + bottlefeedingDto.getBaby().getBabyID() + " Not Found"));
//        bottlefeeding.setBaby(baby);
        BottleFeeding savedBottleFeeding= bottlefeedingDao.save(bottlefeeding);
        return bottlefeedingMapper.FromBottleFeeding(savedBottleFeeding);

    }

    @Override
    public List<BottleFeeding> getFeedingDetails() {
        return bottlefeedingDao.findAll();
    }
    @Override
    public List<BottleFeeding> getlastthreeBFeeding() {
        LocalDate threeDaysAgo = LocalDate.now().minusDays(3);
        return bottlefeedingDao.AllFeedingsByDate(threeDaysAgo);
    }

}



