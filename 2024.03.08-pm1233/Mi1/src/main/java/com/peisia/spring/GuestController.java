package com.peisia.spring;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.client.RestTemplate;

import com.peisia.dto.GuestDto;
import com.peisia.service.GuestService;
import com.peisia.spring.atmosphere.AtmosphereDto;
import com.peisia.spring.mi.vo.kw.KWeatherDto;
import com.peisia.spring.pharmacy.PharmacyDto;
import com.peisia.spring.seoul.pharmacy.Row;
import com.peisia.spring.seoul.pharmacy.SPharmacyDto;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@RequestMapping("/guest/*")
@AllArgsConstructor
@Controller
@SessionAttributes("x") // 1. 이 어노테이션을 붙이고
public class GuestController {

	private GuestService service;
	private final ResourceLoader resourceLoader;

	@GetMapping("/getList")
	public void getList(@RequestParam(value = "currentPage", defaultValue = "1") int currentPage, Model model) {
		ArrayList<GuestDto> list = service.getList(model, currentPage);
		int totalPage = service.getTotalPage(); // 총 페이지 수 가져오기
		model.addAttribute("list", list);
		model.addAttribute("totalPage", totalPage);
	}

	@GetMapping({ "/read", "/modify" })
	public void read(@RequestParam("bno") Long bno, Model model) {
		log.info("컨트롤러 ==== 글번호 ===============" + bno);
		model.addAttribute("read", service.read(bno));
	}

	@GetMapping("/del")
	public String del(@RequestParam("bno") Long bno) {
		log.info("컨트롤러 ==== 글번호 ===============" + bno);
		service.del(bno);
		return "redirect:/guest/getList?currentPage=1"; // 책 p.245 참고
	}

	@PostMapping("/write")
	public String write(GuestDto gvo) {
		service.write(gvo);
		return "redirect:/guest/getList?currentPage=1"; // 책 p.245 참고
	}

	@GetMapping("/write") // 책 p.239 /write 중복이지만 이건 글쓰기 화면을 위한 url 매핑
	public void write() {

	}

	@PostMapping("/modify")
	public String modify(GuestDto gvo) {
		service.modify(gvo);
		return "redirect:/guest/getList?currentPage=1";
	}

	@GetMapping("/aaa")
	public void sessionExample(HttpSession session) {
		session.setAttribute("cat", "고양이");
	}

	// 스프링 세션 사용하기
	@GetMapping("/a")
	public void a(HttpSession s, Model m) {
		s.setAttribute("a", "개");
		// 2. 모델에 x 키로 고양이 저장. ( 세션에도 x 키로 고양이가 저장됨 )
		m.addAttribute("x", "고양이");
	}

	@RequestMapping("/weatherList")
	public void w(Model m) {
//		//// 우리나라 공공 api ////
//		// 인코딩 인증키
//		String API_KEY = "QFOfiZ8YJEQdpbWKTs92CQy3%2BGIv8uusBFVx9FEd4A%2Fn9cxgi3F2E4lnC%2F%2FbUWtk01Gb5OYaHyxVqKfVARKBmQ%3D%3D";
//		// 페이지 개수 많은 목록
//		String API_URL = "http://apis.data.go.kr/1360000/AsosDalyInfoService/getWthrDataList?numOfRows=10&pageNo=1&dateCd=DAY&startDt=20240303&endDt=20240303&stnIds=108&dataCd=ASOS&dataType=JSON&serviceKey="
//				+ API_KEY;
//
//		// * 주의 * https 아님 http 임. https 는 인증관련 복잡한 처리를 해야함.
//		RestTemplate restTemplate = new RestTemplate();
//
//		//// **** 중요 **** uri
//		URI uri = null; // java.net.URI 임포트 하셈
//		try {
//			uri = new URI(API_URL);
//		} catch (URISyntaxException e) {
//			e.printStackTrace();
//		}
//
////		String s = restTemplate.getForObject(uri, String.class); //		
////		log.info("====== 우리나라 날씨 잘 나오나? "+s);		
//
//		KWeatherDto kw = restTemplate.getForObject(uri, KWeatherDto.class); // 자기 클래스로 바꾸시오..
//		log.info("==== json ==== : 우리나라 날씨 잘 나오냐? : " + kw.response.body.dataType);
//		String location = kw.response.body.items.item.get(0).stnNm;
//		String tMin = kw.response.body.items.item.get(0).minTa;
//		String tMax = kw.response.body.items.item.get(0).maxTa;
//		String ddara = String.format("==== json ==== : 어제의 날씨입니다~ 어제 %s 의 최저기온은 %s 도 최고 기온은 %s 였습니다. 날씨였습니다.", location,
//				tMin, tMax);
//		log.info(ddara);
//		m.addAttribute("location", location);
//		m.addAttribute("tMin", tMin);
//		m.addAttribute("tMax", tMax);

//		return "redirect:/guest/wea";
	}

	// 약국 정보 불러오는 api 설정
	@RequestMapping("/pharmacy")
	public void pharmacy(Model m) {
		//// 우리나라 공공 api ////
		// 인코딩 인증키
		String API_KEY = "QFOfiZ8YJEQdpbWKTs92CQy3%2BGIv8uusBFVx9FEd4A%2Fn9cxgi3F2E4lnC%2F%2FbUWtk01Gb5OYaHyxVqKfVARKBmQ%3D%3D";
		String API_URL = "http://apis.data.go.kr/B552657/ErmctInsttInfoInqireService/getParmacyFullDown?pageNo=1&numOfRows=30&serviceKey="
				+ API_KEY;

		RestTemplate restTemplate = new RestTemplate();

		// URI로 변환
		URI uri;
		try {
			uri = new URI(API_URL);
		} catch (URISyntaxException e) {
			e.printStackTrace();
			return; // 예외 발생 시 종료
		}

		// RestTemplate을 사용하여 API에 GET 요청을 보내고 응답을 받습니다.
		String result = restTemplate.getForObject(uri, String.class);
		// UTF-8로 디코딩하여 문자열을 제대로 표시
		String decodedResult = new String(result.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
		log.info("====== 잘 나오나? " + decodedResult);
		PharmacyDto ph = restTemplate.getForObject(uri, PharmacyDto.class); // 자기 클래스로 바꾸시오..
		String dutyName = ph.response.body.items.item.dutyName;
		String dutyAddr = ph.response.body.items.item.dutyAddr;

		// 월요일 진료시간(c)
		int dutyTime1c = ph.response.body.items.item.dutyTime1c;
		// 화요일 진료시간(c)
		int dutyTime2c = ph.response.body.items.item.dutyTime2c;
		// 수요일 진료시간(c)
		int dutyTime3c = ph.response.body.items.item.dutyTime3c;
		// 목요일 진료시간(c)
		int dutyTime4c = ph.response.body.items.item.dutyTime4c;
		// 금요일 진료시간(c)
		int dutyTime5c = ph.response.body.items.item.dutyTime5c;
		// 토요일 진료시간(c)
		int dutyTime6c = ph.response.body.items.item.dutyTime6c;
		// 일요일 진료시간(c)
		int dutyTime7c = ph.response.body.items.item.dutyTime7c;
		// 공휴일 진료시간(c)
		int dutyTime8c = ph.response.body.items.item.dutyTime8c;

//////ssssssss

		// 월요일 진료시간(s)
		String dutyTime1s = ph.response.body.items.item.dutyTime1s;
		// 화요일 진료시간(s)
		String dutyTime2s = ph.response.body.items.item.dutyTime2s;
		// 수요일 진료시간(s)
		String dutyTime3s = ph.response.body.items.item.dutyTime3s;
		// 목요일 진료시간(s)
		String dutyTime4s = ph.response.body.items.item.dutyTime4s;
		// 금요일 진료시간(s)
		String dutyTime5s = ph.response.body.items.item.dutyTime5s;
		// 토요일 진료시간(s)
		String dutyTime6s = ph.response.body.items.item.dutyTime6s;
		// 토요일 진료시간(s)
		int dutyTime7s = ph.response.body.items.item.dutyTime7s;
		// 토요일 진료시간(s)
		int dutyTime8s = ph.response.body.items.item.dutyTime8s;
		// 예외 설정(s)
		int dutyTime = ph.response.body.items.item.dutyTime;
		// 약국 세부 사항
		String dutyInf = ph.response.body.items.item.dutyInf;

		//
//		String phar = String.format("==== json ==== : 약국 데이터 어제 %s 의 최저기온은 %s 도 최고 기온은 %s 였습니다. 날씨였습니다.", location, tMin, tMax);
//		log.info(phar);
		m.addAttribute("dutyName", dutyName);
		m.addAttribute("dutyAddr", dutyAddr);
		m.addAttribute("dutyTime1c", dutyTime1c);
		m.addAttribute("dutyTime2c", dutyTime2c);
		m.addAttribute("dutyTime3c", dutyTime3c);
		m.addAttribute("dutyTime4c", dutyTime4c);
		m.addAttribute("dutyTime5c", dutyTime5c);
		m.addAttribute("dutyTime6c", dutyTime6c);
		m.addAttribute("dutyTime7c", dutyTime7c);
		m.addAttribute("dutyTime8c", dutyTime8c);

		m.addAttribute("dutyTime1s", dutyTime1s);
		m.addAttribute("dutyTime2s", dutyTime2s);
		m.addAttribute("dutyTime3s", dutyTime3s);
		m.addAttribute("dutyTime4s", dutyTime4s);
		m.addAttribute("dutyTime5s", dutyTime5s);
		m.addAttribute("dutyTime6s", dutyTime6s);
		m.addAttribute("dutyTime7s", dutyTime7s);
		m.addAttribute("dutyTime8s", dutyTime8s);
		m.addAttribute("dutyTime", dutyTime);
		m.addAttribute("dutyInf", dutyInf);
	}

	@RequestMapping("/atmosphere")
	public void atmosphere(Model m) {

		String API_KEY = "QFOfiZ8YJEQdpbWKTs92CQy3%2BGIv8uusBFVx9FEd4A%2Fn9cxgi3F2E4lnC%2F%2FbUWtk01Gb5OYaHyxVqKfVARKBmQ%3D%3D";
		String API_URL = "https://apis.data.go.kr/B552584/ArpltnStatsSvc/getCtprvnMesureLIst?itemCode=PM10&dataGubun=HOUR&pageNo=1&numOfRows=100&returnType=json&serviceKey=QFOfiZ8YJEQdpbWKTs92CQy3%2BGIv8uusBFVx9FEd4A%2Fn9cxgi3F2E4lnC%2F%2FbUWtk01Gb5OYaHyxVqKfVARKBmQ%3D%3D";
//		https://apis.data.go.kr/B552584/ArpltnStatsSvc/getCtprvnMesureSidoLIst?sidoName=%EC%84%9C%EC%9A%B8&searchCondition=DAILY&pageNo=1&numOfRows=100&returnType=xml&serviceKey=QFOfiZ8YJEQdpbWKTs92CQy3%2BGIv8uusBFVx9FEd4A%2Fn9cxgi3F2E4lnC%2F%2FbUWtk01Gb5OYaHyxVqKfVARKBmQ%3D%3D	
		// * 주의 * https 아님 http 임. https 는 인증관련 복잡한 처리를 해야함.
		RestTemplate restTemplate = new RestTemplate();

		//// **** 중요 **** uri
		URI uri = null; // java.net.URI 임포트 하셈
		try {
			uri = new URI(API_URL);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}

		AtmosphereDto ap = restTemplate.getForObject(uri, AtmosphereDto.class); // 자기 클래스로 바꾸시오..
//				String s = restTemplate.getForObject(uri, String.class); // 자기 클래스로 바꾸시오..
//				log.info("====== 잘 나오나? "+s);

		String dataTime = ap.response.body.items.get(0).dataTime;
		String dataGubun = ap.response.body.items.get(0).dataGubun;
		String itemCode = ap.response.body.items.get(0).itemCode;
		String seoul = ap.response.body.items.get(0).seoul;
		String jeju = ap.response.body.items.get(0).jeju;
		String daegu = ap.response.body.items.get(0).daegu;
		String chungnam = ap.response.body.items.get(0).chungnam;
		String incheon = ap.response.body.items.get(0).incheon;
		String daejeon = ap.response.body.items.get(0).daejeon;
		String gyeongbuk = ap.response.body.items.get(0).gyeongbuk;
		String sejong = ap.response.body.items.get(0).sejong;
		String gwangju = ap.response.body.items.get(0).gwangju;
		String jeonbuk = ap.response.body.items.get(0).jeonbuk;
		String gangwon = ap.response.body.items.get(0).gangwon;
		String ulsan = ap.response.body.items.get(0).ulsan;
		String jeonnam = ap.response.body.items.get(0).jeonnam;
		String busan = ap.response.body.items.get(0).busan;
		String chungbuk = ap.response.body.items.get(0).chungbuk;
		String gyeongnam = ap.response.body.items.get(0).gyeongnam;
//				String ddara = String.format("==== json ==== : 나오나?'%s','%s','%s','%s','%s'", dataTime, dataGubun, itemCode,seoul,jeju);
		m.addAttribute("dataTime", dataTime);
		m.addAttribute("dataGubun", dataGubun);
		m.addAttribute("itemCode", itemCode);
		m.addAttribute("seoul", seoul);
		m.addAttribute("jeju", jeju);
		m.addAttribute("daegu", daegu);
		m.addAttribute("chungnam", chungnam);
		m.addAttribute("incheon", incheon);
		m.addAttribute("daejeon", daejeon);
		m.addAttribute("gyeongbuk", gyeongbuk);
		m.addAttribute("sejong", sejong);
		m.addAttribute("gwangju", gwangju);
		m.addAttribute("jeonbuk", jeonbuk);
		m.addAttribute("gangwon", gangwon);
		m.addAttribute("ulsan", ulsan);
		m.addAttribute("jeonnam", jeonnam);
		m.addAttribute("busan", busan);
		m.addAttribute("chungbuk", chungbuk);
		m.addAttribute("gyeongnam", gyeongnam);
//				log.info(ddara);
	}

	@RequestMapping("/seoulPharmacy")
	public void seoul(Model m) {
		String API_URL = "http://openapi.seoul.go.kr:8088/6470426c6f6a65793131326768447459/json/TbPharmacyOperateInfo/1/5/";

		RestTemplate restTemplate = new RestTemplate();

		// URI로 변환
		URI uri;
		try {
			uri = new URI(API_URL);
		} catch (URISyntaxException e) {
			e.printStackTrace();
			return; // 예외 발생 시 종료
		}
	    String s=restTemplate.getForObject(uri, String.class);
	    log.info("======😀😀😀😀 😀😀  나오나? "+s);
		SPharmacyDto sp = restTemplate.getForObject(uri, SPharmacyDto.class); // 자기 클래스로 바꾸시오..
//		List<Map<String, String>> pharmacyList = new ArrayList<>();
		List<Row> row=sp.TbPharmacyOperateInfo.row;
		m.addAttribute("row", row);
	}

	
	@RequestMapping("/culture")
	public void c(Model m) {
		String API_URL = "http://api.kcisa.kr/openapi/API_CIA_144/request?serviceKey=1f061410-9ea1-459a-a2b6-d40514901f6c&numOfRows=10&pageNo=1";

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

		HttpEntity<String> requestEntity = new HttpEntity<>(headers);

		RestTemplate restTemplate = new RestTemplate();
		
		URI uri = null;

		try {
			uri = new URI(API_URL);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		
		ResponseEntity<String> responseEntity = restTemplate.exchange(uri, HttpMethod.GET, requestEntity, String.class);
		
		// API 요청에 대한 응답을 ResponseEntity로 받아옴
//	    ResponseEntity<String> responseEntity = restTemplate.exchange(uri, HttpMethod.GET, null, String.class);

		// ResponseEntity의 body를 JSON으로 파싱하여 처리
		String s = responseEntity.getBody();

		log.info("잘찍히나?" + s);
		// 여기서 responseBody는 JSON 형식의 문자열입니다. 이를 원하는 방식으로 파싱하여 사용하면 됩니다.
	}


}
