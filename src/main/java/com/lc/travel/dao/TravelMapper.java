package com.lc.travel.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.lc.travel.entity.Travel;

public interface TravelMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Travel record);

    int insertSelective(Travel record);

    Travel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Travel record);

    int updateByPrimaryKey(Travel record);
    
    ArrayList<Travel> getTravelsNotCompleted();

    ArrayList<Travel> getTravelsNotCompletedWithNull();

    ArrayList<Travel> getTravelsWithFilter(@Param("startDate") String startDate, @Param("endDate") String endDate);

    ArrayList<Travel> getTravelsWithFilterAndPeer(@Param("startDate") String startDate,
    		@Param("endDate") String endDate, @Param("destination") String destination);

    int getTravelCountWithFilter(@Param("startDate") String startDate, @Param("endDate") String endDate);

    int getTravelCountWithFilterAndPeer(@Param("startDate") String startDate,
    		@Param("endDate") String endDate, @Param("destination") String destination);

}