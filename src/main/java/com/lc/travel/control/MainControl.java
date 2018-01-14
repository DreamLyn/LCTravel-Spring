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
import com.lc.travel.beans.PeerSimple;
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
public class MainControl {

	@RequestMapping(value = "/")
	public String getAllTravels() {
		return "index";
	}
	
	
}
