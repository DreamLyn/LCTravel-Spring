package com.lc.travel.service;

import java.sql.Date;
import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lc.travel.dao.PeerMapper;
import com.lc.travel.dao.TouristMapper;
import com.lc.travel.dao.TravelMapper;
import com.lc.travel.entity.Peer;
import com.lc.travel.entity.Tourist;
import com.lc.travel.entity.Travel;

@Service
public class TravelService {

	@Autowired
	private TravelMapper travelMapper;
	@Autowired
	private TouristMapper touristMapper;
	
	/**
	 * 
	 * @return
	 */
	public ArrayList<Travel> getAllTravels() {
//		ArrayList<Travel> arrayList = travelMapper.getTravels();
//		return arrayList;
		return null;
	}
	/**
	 * 获取某个日期的旅行信息
	 * @return
	 */
	public ArrayList<Travel> getTravelsWithDate(String date) {
//		ArrayList<Travel> arrayList = travelMapper.getTravelsWithDate(date);
//		return arrayList;
		return null;

	}
	
	public int getTravelCountWithFilter(String startDate,String endDate,String destination) {
		if(startDate==null) {
			startDate="1990-01-01";
		}else if(startDate.equals("")) {
			startDate="1990-01-01";
		}
		if(endDate==null) {
			endDate="2990-01-01";
		}else if(endDate.equals("")) {
			endDate="2990-01-01";
		}
		if(destination.equals("全部")) {
			return travelMapper.getTravelCountWithFilter(startDate, endDate);
		}else {
			return travelMapper.getTravelCountWithFilterAndPeer(startDate, endDate, destination);
		}
	}
	
	public ArrayList<Travel> getTravelsWithFilter(String startDate,String endDate,String destination,int pageNow,int pageSize) {
//		ArrayList<Travel> arrayList = travelMapper.getTravelsWithDate(date);
//		return arrayList;
		
		if(startDate==null) {
			startDate="1990-01-01";
		}else if(startDate.equals("")) {
			startDate="1990-01-01";
		}
		if(endDate==null) {
			endDate="2990-01-01";
		}else if(endDate.equals("")) {
			endDate="2990-01-01";
		}
		if(destination.equals("全部")) {
			return travelMapper.getTravelsWithFilter(startDate, endDate,pageSize*(pageNow-1),pageSize);
		}else {
			return travelMapper.getTravelsWithFilterAndPeer(startDate, endDate, destination,pageSize*(pageNow-1),pageSize);
		}
	}
	
	/**
	 * 获取所有旅行信息
	 * @return
	 */
	public ArrayList<Travel> getTravels() {
//		ArrayList<Travel> arrayList = travelMapper.getTravels();
//		return arrayList;
		return null;
	}
	/**
	 * 插入
	 * @param record
	 * @return
	 */
	public int insertSelective(Travel record) {
		return travelMapper.insertSelective(record);
	}
	/**
	 * 更新
	 * @param record
	 * @return
	 */
	public int updateSelective(Travel record) {
		return travelMapper.updateByPrimaryKeySelective(record);
	}
	/**
	 * 删除团
	 * @param id
	 * @return
	 */
	public int deleteTravel(int id) {
		if(travelMapper.deleteByPrimaryKey(id)>0) {
			return touristMapper.deleteByTravelId(id);
		}else {
			return -1;
		}
	}
	
	/**
	 * 获取未完成的旅行信息
	 * @param withNull
	 * @return
	 */
	public ArrayList<Travel> getTravelsNotComplete(boolean withNull){
		if(withNull) {
			return travelMapper.getTravelsNotCompletedWithNull();
		}else {
			return travelMapper.getTravelsNotCompleted();
		}
	}
}
