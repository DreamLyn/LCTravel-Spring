package com.lc.travel.control;

import java.io.IOException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lc.travel.beans.PeerInfoWithCount;
import com.lc.travel.beans.PeerSimple;
import com.lc.travel.beans.PeerSta;
import com.lc.travel.beans.SeatInfo;
import com.lc.travel.beans.TouristDisplay;
import com.lc.travel.entity.Peer;
import com.lc.travel.entity.Tourist;
import com.lc.travel.entity.Travel;
import com.lc.travel.service.PeerService;
import com.lc.travel.service.TouristService;
import com.lc.travel.service.TravelService;

/**
 * 旅行社信息控制器
 */
@Controller
@RequestMapping("/handlework")
public class HandleWorkController {
	@Autowired
	private PeerService peerService;
	@Autowired
	private TravelService travelService;
	@Autowired
	private TouristService touristService;

	/**
	 * 根据日期获取旅行信息
	 * 
	 * @return
	 */
	@RequestMapping(value = "/getalltravels")
	@ResponseBody
	public HashMap<String, Object> getAllTravels() {
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		ArrayList<Travel> arrayList = travelService.getAllTravels();
		hashMap.put("status", "success");
		hashMap.put("content", arrayList);
		return hashMap;
	}

	/**
	 * 根据日期获取旅行信息
	 * 
	 * @return
	 */
	@RequestMapping(value = "/gettravelswithdate")
	@ResponseBody
	public HashMap<String, Object> getTravelsWithDate(String date) {
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		ArrayList<Travel> arrayList = travelService.getTravelsWithDate(date);
		hashMap.put("status", "success");
		hashMap.put("content", arrayList);
		return hashMap;
	}

	@RequestMapping(value = "/gettravelswithfilter")
	@ResponseBody
	public HashMap<String, Object> getTravelsWithFilter(String startDate, String endDate, String destination,int pageNow,int pageSize) {
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		ArrayList<Travel> arrayList = travelService.getTravelsWithFilter(startDate, endDate, destination,pageNow,pageSize);
		hashMap.put("status", "success");
		hashMap.put("content", arrayList);
		return hashMap;
		
	}

	/**
	 * 
	 * @param startDate
	 * @param endDate
	 * @param destination
	 * @return
	 */
	@RequestMapping(value = "/gettravelcountwithfilter")
	@ResponseBody
	public HashMap<String, Object> getTravelCountWithFilter(String startDate, String endDate, String destination) {
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		int count = travelService.getTravelCountWithFilter(startDate, endDate, destination);
		hashMap.put("status", "success");
		hashMap.put("content", count);
		return hashMap;
	}

	/**
	 * 添加团
	 * 
	 * @return
	 */
	@RequestMapping(value = "/inserttravel")
	@ResponseBody
	public HashMap<String, Object> insertTravel(Travel travel) {
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		int result = travelService.insertSelective(travel);
		hashMap.put("status", "success");
		if (result >= 0) {
			hashMap.put("content", "success");
		} else {
			hashMap.put("content", "error");
		}

		return hashMap;
	}

	/**
	 * 更新团信息
	 * 
	 * @return
	 */
	@RequestMapping(value = "/updatetravel")
	@ResponseBody
	public HashMap<String, Object> updateTravel(Travel travel) {
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		int result = travelService.updateSelective(travel);
		hashMap.put("status", "success");
		if (result >= 0) {
			hashMap.put("content", "success");
		} else {
			hashMap.put("content", "error");
		}
		hashMap.put("status", "success");
		return hashMap;
	}

	/**
	 * 删除团
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/deletetravel")
	@ResponseBody
	public HashMap<String, Object> deleteTravel(int id) {
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		int result = travelService.deleteTravel(id);
		hashMap.put("status", "success");
		if (result >= 0) {
			hashMap.put("content", "success");
		} else {
			hashMap.put("content", "error");
		}
		hashMap.put("status", "success");
		return hashMap;
	}

	/**
	 * 删除团
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/gettravelnotcomplete")
	@ResponseBody
	public HashMap<String, Object> getTravelNotComplete(boolean withNull) {
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		ArrayList<Travel> travels = travelService.getTravelsNotComplete(withNull);
		hashMap.put("status", "success");
		hashMap.put("content", travels);
		return hashMap;
	}

	/**
	 * 
	 * @param travelId
	 * @return
	 */
	@RequestMapping(value = "/gettouristcountwithtravelnotpay")
	@ResponseBody
	public HashMap<String, Object> getTouristCountWithTravelNotPay(int travelId) {

		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		int count = touristService.getTouristCountWithTravelIdNotPay(travelId);
		hashMap.put("status", "success");
		hashMap.put("content", count);
		return hashMap;
	}

	/**
	 * 
	 * @param travelId
	 * @return
	 */
	@RequestMapping(value = "/gettouristcountwithtravelnotrebate")
	@ResponseBody
	public HashMap<String, Object> getTouristCountWithTravelNotRebate(int travelId) {

		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		int count = touristService.getTouristCountWithTravelIdNotRebate(travelId);
		hashMap.put("status", "success");
		hashMap.put("content", count);
		return hashMap;
	}

	/**
	 * 
	 * @param travelId
	 * @return
	 */
	@RequestMapping(value = "/gettouristcountwithtravel")
	@ResponseBody
	public HashMap<String, Object> getTouristCountWithTravel(int travelId) {

		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		int count = touristService.getTouristCountWithTravelId(travelId);
		hashMap.put("status", "success");
		hashMap.put("content", count);
		return hashMap;
	}

	/**
	 * 根据travel获取tourist信息
	 * 
	 * @return
	 * @throws IOException
	 * @throws JsonMappingException
	 * @throws JsonParseException
	 */
	@RequestMapping(value = "/gettouristswithtravel")
	@ResponseBody
	public HashMap<String, Object> getTouristsWithTravel(int travelId, String peerString, String peerStateString,
			boolean seatSort) throws JsonParseException, JsonMappingException, IOException {
		// 根据json获取真实参数
		ObjectMapper mapper = new ObjectMapper();
		ArrayList<Integer> peerList = mapper.readValue(peerString, new TypeReference<List<Integer>>() {
		});
		ArrayList<Integer> peerStateList = mapper.readValue(peerStateString, new TypeReference<List<Integer>>() {
		});
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		ArrayList<Tourist> arrayList = touristService.getTouristsWithTravelId(travelId, peerList, peerStateList,
				seatSort);
		hashMap.put("status", "success");
		hashMap.put("content", arrayList);
		return hashMap;
	}

	/**
	 * 获取表格内部显示的东西
	 * 
	 * @param travelId
	 * @param peerString
	 * @param peerStateString
	 * @param seatSort
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@RequestMapping(value = "/gettouristsdiswithtravel")
	@ResponseBody
	public HashMap<String, Object> getTouristsDisWithTravel(int travelId, String peerString, String peerStateString,
			boolean seatSort) throws JsonParseException, JsonMappingException, IOException {
		// 根据json获取真实参数
		ObjectMapper mapper = new ObjectMapper();
		ArrayList<Integer> peerList = mapper.readValue(peerString, new TypeReference<List<Integer>>() {
		});
		ArrayList<Integer> peerStateList = mapper.readValue(peerStateString, new TypeReference<List<Integer>>() {
		});
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		ArrayList<TouristDisplay> arrayList = touristService.getTouristsDisWithTravelId(travelId, peerList,
				peerStateList, seatSort);
		hashMap.put("status", "success");
		hashMap.put("content", arrayList);
		return hashMap;
	}

	@RequestMapping(value = "/getpeerstatisticswithtravel")
	@ResponseBody
	public HashMap<String, Object> getPeerStatisticsWithTravel(int travelId)
			throws JsonParseException, JsonMappingException, IOException {

		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		ArrayList<TouristDisplay> arrayList = touristService.getPeerStatisticsWithTravelId(travelId);

		HashMap<Integer, Integer> hashMap2 = new HashMap<Integer, Integer>();
		for (TouristDisplay touristDisplay : arrayList) {
			if (touristDisplay.getPeerState() == 0) {
				// 如果未交款
				if (hashMap2.containsKey(touristDisplay.getPeer())) {
					Integer temp = hashMap2.get(touristDisplay.getPeer());
					hashMap2.put(touristDisplay.getPeer(), temp + touristDisplay.getMoney());
				} else {
					hashMap2.put(touristDisplay.getPeer(), touristDisplay.getMoney());
				}
			}
		}
		ArrayList<PeerSta> arrayList2 = new ArrayList<PeerSta>();
		Iterator iter = hashMap2.entrySet().iterator();
		while (iter.hasNext()) {
			Map.Entry entry = (Map.Entry) iter.next();
			int key = (Integer) entry.getKey();
			int val = (Integer) entry.getValue();
			PeerSta peerSta = new PeerSta();
			peerSta.setPeer(key);
			peerSta.setMoney(val);

			arrayList2.add(peerSta);
		}

		hashMap.put("status", "success");
		hashMap.put("content", arrayList2);
		return hashMap;
	}

	/**
	 * 根据travelId获取同行信息
	 * 
	 * @param travelId
	 * @return
	 */
	@RequestMapping(value = "/getpeersimpleswithtravel")
	@ResponseBody
	public HashMap<String, Object> getPeerSimplesWithTravel(int travelId) {
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		ArrayList<PeerSimple> arrayList = peerService.getPeerSimplesWithTravelId(travelId);
		hashMap.put("status", "success");
		hashMap.put("content", arrayList);
		return hashMap;
	}

	/**
	 * 根据travelId获取同行信息
	 * 
	 * @param travelId
	 * @return
	 */
	@RequestMapping(value = "/getallpeersimples")
	@ResponseBody
	public HashMap<String, Object> getAllPeerSimples() {
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		ArrayList<PeerSimple> arrayList = peerService.getAllPeerSimples();
		hashMap.put("status", "success");
		hashMap.put("content", arrayList);
		return hashMap;
	}

	/**
	 * 更新
	 * 
	 * @param tourist
	 * @return
	 */
	@RequestMapping(value = "/updatetourist")
	@ResponseBody
	public HashMap<String, Object> updateTourist(Tourist tourist) {
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		if (touristService.updateByPrimaryKeySelective(tourist) > 0) {
			hashMap.put("content", "success");
		} else {
			hashMap.put("content", "error");
		}
		hashMap.put("status", "success");
		return hashMap;
	}

	/**
	 * 删除单个游客信息
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/deletetourist")
	@ResponseBody
	public HashMap<String, Object> deleteTourist(int id) {
		HashMap<String, Object> hashMap = new HashMap<String, Object>();

		if (touristService.deleteByPrimaryKey(id) > 0) {
			hashMap.put("content", "success");
		} else {
			hashMap.put("content", "error");
		}
		hashMap.put("status", "success");
		return hashMap;
	}

	@RequestMapping(value = "/deletetouristswithname")
	@ResponseBody
	public HashMap<String, Object> deleteTouristsWithName(Integer travelId, String name) {
		HashMap<String, Object> hashMap = new HashMap<String, Object>();

		if (touristService.deleteByName(travelId, name) > 0) {
			hashMap.put("content", "success");
		} else {
			hashMap.put("content", "error");
		}
		hashMap.put("status", "success");
		return hashMap;
	}

	/**
	 * 批量删除游客信息
	 * 
	 * @param id
	 * @return
	 * @throws IOException
	 * @throws JsonMappingException
	 * @throws JsonParseException
	 */
	@RequestMapping(value = "/deletetourists")
	@ResponseBody
	public HashMap<String, Object> deleteTourists(int travelId, String idString)
			throws JsonParseException, JsonMappingException, IOException {
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		ObjectMapper mapper = new ObjectMapper();
		ArrayList<String> idList = mapper.readValue(idString, new TypeReference<List<String>>() {
		});
		touristService.deleteSomeByName(travelId, idList);
		hashMap.put("content", "success");
		hashMap.put("status", "success");
		return hashMap;
	}

	/**
	 * 插入游客信息
	 * 
	 * @param idString
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@RequestMapping(value = "/inserttourist")
	@ResponseBody
	public HashMap<String, Object> insertTourist(Tourist tourist) {
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		if (touristService.insertSelective(tourist) > 0) {
			hashMap.put("content", "success");
		} else {
			hashMap.put("content", "error");
		}
		hashMap.put("status", "success");
		return hashMap;
	}
	
	@RequestMapping(value = "/gettouristcountwithname")
	@ResponseBody
	public HashMap<String, Object> getTouristCountWithName(int travelId,String name) {
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		int count=touristService.getTouristCountWithName(travelId,name);
		hashMap.put("status", "success");
		hashMap.put("content", count);
		return hashMap;
	}

	/**
	 * 插入游客信息
	 * 
	 * @param idString
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@RequestMapping(value = "/inserttourists")
	@ResponseBody
	public HashMap<String, Object> insertTourists(String name, String phone, String seats, int peer, String remark,
			int travelId, int peerState, int money) throws JsonParseException, JsonMappingException, IOException {
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		ObjectMapper mapper = new ObjectMapper();
		ArrayList<SeatInfo> seatList = mapper.readValue(seats, new TypeReference<List<SeatInfo>>() {
		});
		ArrayList<Tourist> tourists = new ArrayList<Tourist>();
		for (SeatInfo seat : seatList) {
			Tourist tourist = new Tourist();
			tourist.setName(name);
			tourist.setType(seat.getType());
			tourist.setPhone(phone);
			tourist.setSeat(seat.getNum());
			tourist.setPeer(peer);
			tourist.setRemark(remark);
			tourist.setTravelId(travelId);
			tourist.setPeerState(peerState);
			tourist.setMoney(money);
			tourists.add(tourist);
		}
		touristService.insertSelectives(tourists);
		hashMap.put("status", "success");
		hashMap.put("content", "success");
		return hashMap;
	}

	/**
	 * 修改游客信息
	 * 
	 * @param idString
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@RequestMapping(value = "/edittourists")
	@ResponseBody
	public HashMap<String, Object> editTourists(String oldname,String name, String phone, String seats, int peer, String remark,
			int travelId, int peerState, int money) throws JsonParseException, JsonMappingException, IOException {
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		ObjectMapper mapper = new ObjectMapper();
		ArrayList<SeatInfo> seatList = mapper.readValue(seats, new TypeReference<List<SeatInfo>>() {
		});
		ArrayList<Tourist> tourists = new ArrayList<Tourist>();
		for (SeatInfo seat : seatList) {
			Tourist tourist = new Tourist();
			tourist.setName(name);
			tourist.setType(seat.getType());
			tourist.setPhone(phone);
			tourist.setSeat(seat.getNum());
			tourist.setPeer(peer);
			tourist.setRemark(remark);
			tourist.setTravelId(travelId);
			tourist.setPeerState(peerState);
			tourist.setMoney(money);
			tourists.add(tourist);
		}
		touristService.editTourists(tourists,oldname);
		hashMap.put("status", "success");
		hashMap.put("content", "success");
		return hashMap;
	}

	/**
	 * 获取同行信息
	 * 
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	@RequestMapping(value = "/getpeerinfoswithcount")
	@ResponseBody
	public HashMap<String, Object> getPeerInfosWithCount(String startDate, String endDate) {
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		ArrayList<PeerInfoWithCount> peerInfos = peerService.getPeerInfosWithCount(startDate, endDate);
		hashMap.put("status", "success");
		hashMap.put("content", peerInfos);
		return hashMap;
	}
}
