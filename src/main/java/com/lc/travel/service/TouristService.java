package com.lc.travel.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lc.travel.beans.TouristDisplay;
import com.lc.travel.dao.PeerMapper;
import com.lc.travel.dao.TouristMapper;
import com.lc.travel.dao.TravelMapperbak;
import com.lc.travel.entity.Peer;
import com.lc.travel.entity.Tourist;
import com.lc.travel.entity.Travel;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

@Service
public class TouristService {
	@Autowired
	private TouristMapper touristMapper;

	/**
	 * 
	 * @param travelId
	 * @return
	 */
	public int getTouristCountWithTravelIdNotPay(int travelId) {
		return touristMapper.getTouristCountWithTravelNotPay(travelId);
	}

	public int getTouristCountWithTravelIdNotRebate(int travelId) {
		return touristMapper.getTouristCountWithTravelNotRebate(travelId);
	}

	public int getTouristCountWithTravelId(int travelId) {
		return touristMapper.getTouristCountWithTravel(travelId);
	}

	/**
	 * 获取某次旅行的所有信息
	 * 
	 * @return
	 */
	public ArrayList<Tourist> getTouristsWithTravelId(int travelId, ArrayList<Integer> peerList,
			ArrayList<Integer> peerStateList, boolean seatSort) {
		if ((peerList.size() > 0) && (peerStateList.size() > 0)) {
			ArrayList<Tourist> arrayList = touristMapper.getTouristsWithTravelId(travelId, peerList, peerStateList,
					seatSort);
			return arrayList;
		} else {
			return new ArrayList<Tourist>();
		}

	}

	/**
	 * 
	 * @param travelId
	 * @param peerList
	 * @param peerStateList
	 * @param seatSort
	 * @return
	 * @throws JsonProcessingException
	 */
	public ArrayList<TouristDisplay> getTouristsDisWithTravelId(int travelId, ArrayList<Integer> peerList,
			ArrayList<Integer> peerStateList, boolean seatSort) throws JsonProcessingException {
		if ((peerList.size() > 0) && (peerStateList.size() > 0)) {
			ArrayList<TouristDisplay> touristDisplays = new ArrayList<TouristDisplay>();
			ArrayList<Tourist> arrayList = touristMapper.getTouristsWithTravelId(travelId, peerList, peerStateList,
					seatSort);
			HashSet<String> nameSet = new HashSet<String>();
			for (Tourist tourist : arrayList) {
				if (!nameSet.contains(tourist.getName())) {
					nameSet.add(tourist.getName());
				}
			}

			for (String name : nameSet) {
				TouristDisplay touristDisplay = new TouristDisplay();
				ArrayList<Integer> seatNums = new ArrayList<Integer>();
				int seatTypes[] = new int[3];
				for (Tourist tourist : arrayList) {
					if (tourist.getName().equals(name)) {
						touristDisplay.setName(tourist.getName());
						touristDisplay.setPeer(tourist.getPeer());
						touristDisplay.setPeerState(tourist.getPeerState());
						touristDisplay.setPhone(tourist.getPhone());
						touristDisplay.setRemark(tourist.getRemark());
						touristDisplay.setTravelId(tourist.getTravelId());
						seatNums.add(tourist.getSeat());
						switch (tourist.getType()) {
						case 0:
							seatTypes[0]++;
							break;
						case 1:
							seatTypes[1]++;
							break;
						case 2:
							seatTypes[2]++;
							break;
						default:
							break;
						}
					}
				}
				ObjectMapper mapper = new ObjectMapper();
				String seatNumsStr = mapper.writeValueAsString(seatNums);
				touristDisplay.setSeats(seatNumsStr);
				String seatTypesStr = seatTypes[0] + "成" + seatTypes[1] + "儿" + seatTypes[2] + "占";
				touristDisplay.setSeatsdesc(seatTypesStr);
				touristDisplays.add(touristDisplay);
			}
			return touristDisplays;
		} else {
			return new ArrayList<TouristDisplay>();
		}

	}

	/**
	 * 更新
	 * 
	 * @param record
	 * @return
	 */
	public int updateByPrimaryKeySelective(Tourist record) {
		int travelId = record.getTravelId();
		record.setTravelId(null);
		if (touristMapper.updateByPrimaryKeySelective(record) > 0) {
			return touristMapper.updatePeerState(travelId, record.getPeer(), record.getPeerState());
		} else {
			return -1;
		}
	}

	public int deleteByName(int travelId, String name) {
		return touristMapper.deleteByName(travelId, name);
	}

	/**
	 * 删除游客信息
	 * 
	 * @param id
	 * @return
	 */
	public int deleteByPrimaryKey(Integer id) {
		return touristMapper.deleteByPrimaryKey(id);
	}

	/**
	 * 批量删除游客信息
	 * 
	 * @param id
	 * @return
	 */
	public void deleteSomeByPrimaryKey(ArrayList<Integer> ids) {
		for (Integer id : ids) {
			touristMapper.deleteByPrimaryKey(id);
		}
	}
	/**
	 * 
	 * @param travelId
	 * @param names
	 */
	public void deleteSomeByName(int travelId,ArrayList<String> names) {
		for (String name : names) {
			touristMapper.deleteByName(travelId, name);
		}
	}

	/**
	 * 批量删除
	 * 
	 * @param touristIds
	 * @return
	 */
	public int deleteTourists(@Param("touristIds") ArrayList<Integer> touristIds) {
		return touristMapper.deleteTourists(touristIds);
	}

	/**
	 * 插入
	 * 
	 * @param record
	 * @return
	 */
	public int insertSelective(Tourist record) {
		return touristMapper.insertSelective(record);
	}

	public void insertSelectives(ArrayList<Tourist> records) {
		for (Tourist tourist : records) {
			touristMapper.insertSelective(tourist);
		}
	}
	
	
	public void editTourists(ArrayList<Tourist> records) {
		Tourist touristR=records.get(0);
		String name=touristR.getName();
		touristMapper.deleteByName(touristR.getTravelId(), touristR.getName());
		for (Tourist tourist : records) {
			touristMapper.insertSelective(tourist);
		}
	}
}
