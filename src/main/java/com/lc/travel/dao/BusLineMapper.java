package com.lc.travel.dao;

import java.util.ArrayList;

import com.lc.travel.beans.PeerSimple;
import com.lc.travel.entity.BusLine;
import com.lc.travel.entity.Peer;

public interface BusLineMapper {

	int deleteByPrimaryKey(Integer id);

	int insert(BusLine record);

	int insertSelective(BusLine record);

	BusLine selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(BusLine record);

	int updateByPrimaryKey(BusLine record);

	ArrayList<BusLine> getBusLines();

//	ArrayList<PeerSimple> getPeerSimplesWithTravelId(int travelId);
//
//	ArrayList<PeerSimple> getAllPeerSimples();
}