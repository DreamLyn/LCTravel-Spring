package com.lc.travel.service;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lc.travel.beans.PeerInfoWithCount;
import com.lc.travel.beans.PeerSimple;
import com.lc.travel.dao.PeerMapper;
import com.lc.travel.entity.Peer;

@Service
public class PeerService {
	@Autowired
	private PeerMapper peerMapper;

	/**
	 * 获取所有同行
	 * 
	 * @return
	 */
	public ArrayList<Peer> getPeers() {
		ArrayList<Peer> arrayList = peerMapper.getPeers();
		return arrayList;
	}

	/**
	 * 根据某次旅行，获取值
	 * 
	 * @param travelId
	 * @return
	 */
	public ArrayList<PeerSimple> getPeerSimplesWithTravelId(int travelId) {
		return peerMapper.getPeerSimplesWithTravelId(travelId);
	}

	/**
	 * 获取所有同行信息
	 * 
	 * @return
	 */
	public ArrayList<PeerSimple> getAllPeerSimples() {
		return peerMapper.getAllPeerSimples();
	}

	/**
	 * 
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public ArrayList<PeerInfoWithCount> getPeerInfosWithCount(String startDate, String endDate) {
		return peerMapper.getPeerInfosWithCount(startDate, endDate);
	}
	/**
	 * 更新
	 * @param record
	 * @return
	 */
	public int updateByPrimaryKeySelective(Peer record) {
		return peerMapper.updateByPrimaryKeySelective(record);
	}
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	public int deletePeer(Integer id) {
		return peerMapper.deleteByPrimaryKey(id);
	}
	/**
	 * 批量删除
	 * @param ids
	 */
	public void deletePeers(ArrayList<Integer> ids) {
		for(int id:ids) {
			deletePeer(id);
		}
	}
	/**
	 * 插入同行
	 * @param record
	 * @return
	 */
	public int insertPeer(Peer record) {
		return peerMapper.insertSelective(record);
	}
}
