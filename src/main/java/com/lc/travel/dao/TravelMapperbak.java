package com.lc.travel.dao;

import java.util.ArrayList;

import com.lc.travel.entity.Travel;

public interface TravelMapperbak {
	int deleteByPrimaryKey(Integer id);

	int insert(Travel record);

	int insertSelective(Travel record);

	Travel selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(Travel record);

	int updateByPrimaryKey(Travel record);

	ArrayList<Travel> getTravelsNotCompleted();

	ArrayList<Travel> getTravelsNotCompletedWithNull();
	
	ArrayList<Travel> getTravelsWithFilter(String startDate,String endDate);
	
	ArrayList<Travel> getTravelsWithFilterAndPeer(String startDate,String endDate,String peer);
}