//package com.peisia.spring;
//
//import javax.servlet.http.HttpSession;
//
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.SessionAttributes;
//
//@SessionAttributes("x")			// 1. 이 어노테이션을 붙이고					
//public class BoardController {								
//	@GetMapping("/a")							
//	public void a(HttpSession s, Model m) {							
//		s.setAttribute("a", "개");						
//		// 2. 모델에 x 키로 고양이 저장. ( 세션에도 x 키로 고양이가 저장됨 )						
//		m.addAttribute("x","고양이");						
//	}		
//	
//}