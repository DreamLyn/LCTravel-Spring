package com.lc.travel.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.lc.travel.beans.PeerInfoWithCount;
import com.lc.travel.beans.PeerSimple;
import com.lc.travel.entity.Peer;

public interface PeerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Peer record);

    int insertSelective(Peer record);

    Peer selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Peer record);

    int updateByPrimaryKey(Peer record);
    
    ArrayList<Peer> getPeers();
    
    ArrayList<PeerSimple> getPeerSimplesWithTravelId(int travelId);
    
    ArrayList<PeerSimple> getAllPeerSimples();
    
    ArrayList<PeerInfoWithCount> getPeerInfosWithCount(@Param("startDate")String startDate,@Param("endDate")String endDate);
}