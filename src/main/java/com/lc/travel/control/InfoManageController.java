package com.lc.travel.control;

import java.io.IOException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

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
import com.lc.travel.dao.BusLineMapper;
import com.lc.travel.entity.BusLine;
import com.lc.travel.entity.Peer;
import com.lc.travel.service.BusLineService;
import com.lc.travel.service.PeerService;

/**
 * 旅行社信息控制器
 */
@Controller
@RequestMapping("/infomanage")
public class InfoManageController {

	@Autowired
	private PeerService peerService;
	@Autowired
	private BusLineService buslineService;
	

	/**
	 * 获取所有同行信息
	 * @return
	 */
	@RequestMapping(value = "/getpeers")
	@ResponseBody
	public HashMap<String, Object> getPeers() {
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		ArrayList<Peer> arrayList = peerService.getPeers();
		hashMap.put("status", "success");
		hashMap.put("content", arrayList);
		return hashMap;
	}/**
	 * 获取所有线路信息
	 * @return
	 */
	@RequestMapping(value = "/getbuslines")
	@ResponseBody
	public HashMap<String, Object> getBusLines() {
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		ArrayList<BusLine> arrayList = buslineService.getBusLines();
		hashMap.put("status", "success");
		hashMap.put("content", arrayList);
		return hashMap;
	}
	/**
	 * 更新同行信息
	 * @param peer
	 * @return
	 */
	@RequestMapping(value = "/updatepeer")
	@ResponseBody
	public HashMap<String, Object> updatePeer(Peer peer) {
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		if(peerService.updateByPrimaryKeySelective(peer)>0) {
			hashMap.put("content", "success");
		}else {
			hashMap.put("content","error");;
		}
		hashMap.put("status", "success");
		return hashMap;
	}
	
	/**
	 * 更新线路信息
	 * @param peer
	 * @return
	 */
	@RequestMapping(value = "/updatebusline")
	@ResponseBody
	public HashMap<String, Object> updateBusLine(BusLine busLine) {
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		if(buslineService.updateByPrimaryKeySelective(busLine)>0) {
			hashMap.put("content", "success");
		}else {
			hashMap.put("content","error");;
		}
		hashMap.put("status", "success");
		return hashMap;
	}
	
	@RequestMapping(value = "/deletepeer")
	@ResponseBody
	public HashMap<String, Object> deletePeer(int id) {
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		if(peerService.deletePeer(id)>0) {
			hashMap.put("content", "success");
		}else {
			hashMap.put("content","error");;
		}
		hashMap.put("status", "success");
		return hashMap;
	}
	
	
	@RequestMapping(value = "/deletebusline")
	@ResponseBody
	public HashMap<String, Object> deleteBusLine(int id) {
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		if(buslineService.deleteBusLine(id)>0) {
			hashMap.put("content", "success");
		}else {
			hashMap.put("content","error");;
		}
		hashMap.put("status", "success");
		return hashMap;
	}
	
	@RequestMapping(value = "/deletepeers")
	@ResponseBody
	public HashMap<String, Object> deletePeers(String idString) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		ArrayList<Integer> idList = mapper.readValue(idString, new TypeReference<List<Integer>>() {
		});
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		peerService.deletePeers(idList);
		hashMap.put("status", "success");
		hashMap.put("content", "success");
		return hashMap;
	}
	
	@RequestMapping(value = "/deletebuslines")
	@ResponseBody
	public HashMap<String, Object> deleteBusLines(String idString) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		ArrayList<Integer> idList = mapper.readValue(idString, new TypeReference<List<Integer>>() {
		});
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		buslineService.deleteBusLines(idList);
		hashMap.put("status", "success");
		hashMap.put("content", "success");
		return hashMap;
	}
	
	@RequestMapping(value = "/insertpeer")
	@ResponseBody
	public HashMap<String, Object> insertPeer(Peer peer) {
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		if(peerService.insertPeer(peer)>0) {
			hashMap.put("content", "success");
		}else {
			hashMap.put("content","error");;
		}
		hashMap.put("status", "success");
		return hashMap;
	}
	
	@RequestMapping(value = "/insertbusline")
	@ResponseBody
	public HashMap<String, Object> insertBusLine(BusLine busLine) {
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		if(buslineService.insertBusLine(busLine)>0) {
			hashMap.put("content", "success");
		}else {
			hashMap.put("content","error");;
		}
		hashMap.put("status", "success");
		return hashMap;
	}
}
