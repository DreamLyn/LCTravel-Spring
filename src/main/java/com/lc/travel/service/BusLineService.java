package com.lc.travel.service;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scripting.bsh.BshScriptUtils.BshExecutionException;
import org.springframework.stereotype.Service;

import com.lc.travel.beans.PeerInfoWithCount;
import com.lc.travel.beans.PeerSimple;
import com.lc.travel.dao.BusLineMapper;
import com.lc.travel.dao.PeerMapper;
import com.lc.travel.entity.BusLine;
import com.lc.travel.entity.Peer;

@Service
public class BusLineService {
	@Autowired
	private BusLineMapper busLineMapper;

	public ArrayList<BusLine> getBusLines() {
		ArrayList<BusLine> arrayList = busLineMapper.getBusLines();
		return arrayList;
	}

//	/**
//	 * 根据某次旅行，获取值
//	 * 
//	 * @param travelId
//	 * @return
//	 */
//	public ArrayList<PeerSimple> getPeerSimplesWithTravelId(int travelId) {
//		return peerMapper.getPeerSimplesWithTravelId(travelId);
//	}
//
//	/**
//	 * 获取所有同行信息
//	 * 
//	 * @return
//	 */
//	public ArrayList<PeerSimple> getAllPeerSimples() {
//		return peerMapper.getAllPeerSimples();
//	}
//
//	/**
//	 * 
//	 * @param startDate
//	 * @param endDate
//	 * @return
//	 */
//	public ArrayList<PeerInfoWithCount> getPeerInfosWithCount(String startDate, String endDate) {
//		return peerMapper.getPeerInfosWithCount(startDate, endDate);
//	}
	/**
	 * 更新
	 * @param record
	 * @return
	 */
	public int updateByPrimaryKeySelective(BusLine record) {
		return busLineMapper.updateByPrimaryKeySelective(record);
	}
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	public int deleteBusLine(Integer id) {
		return busLineMapper.deleteByPrimaryKey(id);
	}
	/**
	 * 批量删除
	 * @param ids
	 */
	public void deleteBusLines(ArrayList<Integer> ids) {
		for(int id:ids) {
			deleteBusLine(id);
		}
	}
	/**
	 * 插入路线
	 * @param record
	 * @return
	 */
	public int insertBusLine(BusLine record) {
		return busLineMapper.insertSelective(record);
	}
}
