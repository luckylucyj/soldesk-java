package com.peisia.spring.mi.controller;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.peisia.spring.mi.service.GuestService;
import com.peisia.spring.mi.vo.GuestVO;
import com.peisia.spring.mi.vo.kw.KWeatherVo;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@RequestMapping("/guest/*")
@AllArgsConstructor
@Controller
public class GuestController {
	private GuestService service;
	
	@GetMapping("/getList")
	public void getList(@RequestParam(value="currentPage", defaultValue = "1") int currentPage, Model model) {
		model = service.getList(model, currentPage);
	}	
	
	@GetMapping({"/read", "/modify"})
	public void read(@RequestParam("bno") Long bno, Model model) {
		log.info("컨트롤러 ==== 글번호 ==============="+bno);
		model.addAttribute("read",service.read(bno));
	}
	
	@GetMapping("/del")
	public String del(@RequestParam("bno") Long bno) {
		log.info("컨트롤러 ==== 글번호 ==============="+bno);
		service.del(bno);
		return "redirect:/guest/getList";	// 책 p.245 참고
	}
	
	@PostMapping("/write")
	public String write(GuestVO gvo) {
		service.write(gvo);
		return "redirect:/guest/getList";	// 책 p.245 참고
	}
	
	@GetMapping("/write")	// 책 p.239 /write 중복이지만 이건 글쓰기 화면을 위한 url 매핑
	public void write() {
		
	}
	
	@PostMapping("/modify")
	public String modify(GuestVO gvo) {
		service.modify(gvo);
		return "redirect:/guest/getList";
	}
	
	@GetMapping("/kw")	// 책 p.239 /write 중복이지만 이건 글쓰기 화면을 위한 url 매핑
	public void kweather(Model m) {
		//// 우리나라 공공 api ////
		//인코딩 인증키
		String API_KEY = "TDf%2Fho9nOMC2Ho71ocCWLwhwgKl9KBhSyyX67Pylaw%2BN0V7GQsIt%2B7UaJQsN9X%2FrpsIc%2FJJR%2Bltqo30nKyUXjA%3D%3D";
		String API_URL = "http://apis.data.go.kr/1360000/AsosDalyInfoService/getWthrDataList?numOfRows=10&pageNo=1&dateCd=DAY&startDt=20230220&endDt=20230220&stnIds=108&dataCd=ASOS&dataType=JSON&serviceKey=" + API_KEY;
		RestTemplate restTemplate = new RestTemplate();
		//// **** 중요 **** uri	
		URI uri = null;	
		try {	
			uri = new URI(API_URL);
		} catch (URISyntaxException e) {	
			e.printStackTrace();
		}
		String s = restTemplate.getForObject(uri, String.class); //
		log.info("====== 우리나라 날씨 잘 나오나? "+s);
		
		//맵에 넣어 쉽게 빼기
		KWeatherVo kw = restTemplate.getForObject(uri, KWeatherVo.class); // 자기 클래스로 바꾸시오..
		log.info("==== json ==== : 우리나라 날씨 잘 나오냐? : "+kw.response.body.dataType);
		log.info("==== json ==== : 우리나라 날씨 잘 나오냐? : "+kw.response.body.dataType);
		String location = kw.response.body.items.item.get(0).stnNm;
		String tMin = kw.response.body.items.item.get(0).minTa;
		String tMax = kw.response.body.items.item.get(0).maxTa;
		String ddara = String.format("어제의 날씨입니다~ 어제 %s 의 최저기온은 %s 도 최고 기온은 %s 였습니다. 날씨였습니다.", location, tMin, tMax);
		log.info("==== json ==== : "+ddara);
		m.addAttribute("ddara",ddara);
	}	
}