package com.lc.travel.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.lc.travel.entity.Tourist;
import com.lc.travel.entity.Travel;

public interface TouristMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Tourist record);

    int insertSelective(Tourist record);

    Tourist selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Tourist record);

    int updateByPrimaryKey(Tourist record);
    
    int deleteByTravelId(int travelId);
    
    int deleteByName(@Param("travelId")int travelId,@Param("name")String name);
    /**
     * 更新同行状态
     * @param travelId
     * @param peer
     * @param peerState
     * @return
     */
    int updatePeerState(@Param("travelId")int travelId,@Param("peer")int peer,@Param("peerState")int peerState);
    /**
     * 批量删除
     * @param touristIds
     * @return
     */
    int deleteTourists(@Param("touristIds")ArrayList<Integer> touristIds);
    
    
    /**
     * 获取有个数量
     * @param travelId
     * @return
     */
    int getTouristCountWithTravelNotPay(@Param("travelId")int travelId);
    
    /**
     * 获取有个数量
     * @param travelId
     * @return
     */
    int getTouristCountWithTravelNotRebate(@Param("travelId")int travelId);
    
    /**
     * 获取有个数量
     * @param travelId
     * @return
     */
    int getTouristCountWithTravel(@Param("travelId")int travelId);
    /**
     * 获取游客信息
     * @param travelId
     * @param peerList
     * @param peerStateList
     * @param seatSort
     * @return
     */
    ArrayList<Tourist> getTouristsWithTravelId(@Param("travelId")int travelId, @Param("peerList")ArrayList<Integer> peerList,
    		@Param("peerStateList")ArrayList<Integer> peerStateList, @Param("seatSort")boolean seatSort);
    
}