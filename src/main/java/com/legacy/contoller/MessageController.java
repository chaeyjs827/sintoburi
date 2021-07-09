package com.legacy.contoller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {
	
	@GetMapping("/api/return-string")
	@ResponseBody
	public String returnString() {
		return "hello";
	}

	@GetMapping("/api/return-list")
	@ResponseBody
	public List<String> returnList() {
		List<String> list = Arrays.asList("ac","vv","dd","ss","ee");
		return list;
	}
	
	@GetMapping("/api/return-map")
	@ResponseBody
	public Map<String, Object> returnMap() {
		Map<String, Object> map = new HashMap<String, Object>() {{
			put("asd", "asd");
			put("fff", "fff");
			put("rrr", "rrr");
			put("eee", "eee");
			put("yyy", 123);
			put("zzz", 1l);
		}};
		return map;
	}
	
}
