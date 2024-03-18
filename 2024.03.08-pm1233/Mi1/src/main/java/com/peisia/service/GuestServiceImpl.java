package com.peisia.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.peisia.dto.GuestDto;
import com.peisia.mapper.GuestMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
//@AllArgsConstructor
public class GuestServiceImpl implements GuestService{

	@Setter(onMethod_ = @Autowired)
	private GuestMapper mapper;	
	
	@Override
	public ArrayList<GuestDto> getList(Model m,int currentPage) {
		GuestDto num=new GuestDto();
		num.getBno();
		num.setBtext("안녕");
		num.getBtext();
		  int listCountPerPage = 5; // 페이지당 보여줄 글 수
	        int pagesPerBlock = 3; // 블럭 당 페이지 수
	        int currentBlock = 1; // 현재 페이지 블럭
	        int blockStartPage = 1; // 블럭 시작 페이지
	        int blockEndPage = 1; // 블럭 끝 페이지
	        int blockCount = 1; // 블럭 총 수
	        int prevPage = 1; // 이전 블럭 링크 클릭에 걸 페이지
	        int nextPage = 1; // 다음 블럭 링크 클릭에 걸 페이지

	        int limitIndex = (currentPage - 1) * listCountPerPage;
	        ArrayList<GuestDto> guestList = new ArrayList<>();
	        guestList = mapper.getList(limitIndex);

	        int count = mapper.getTotalPage();
	        m.addAttribute("count", count);

	        // 방식은 여기가 길어져도 일단 쉬운 방식으로 함.

	        //// 총 페이지 수 구하기. ////
	        int totalPageCount = 0;
	        // 총 페이지 수 = 전체 글 수 / 페이지당 보여줄 글 수. 단, 짜투리도 계산해야함.
	        totalPageCount = (int) Math.ceil((double) count / listCountPerPage);
	        log.info("==== 방명록 ==== : 총 게시글 수는 " + count);
	        log.info("==== 방명록 ==== : 총 페이지 수는 " + totalPageCount);

	        // 블럭 당 페이지 수 전달
	        m.addAttribute("pagesPerBlock", pagesPerBlock);

	        // 블럭 총 수
	        blockCount = (int) Math.ceil((double) totalPageCount / pagesPerBlock);
	        m.addAttribute("blockCount", blockCount);

	        // 현재 페이지 번호로 현재 블럭 번호 구하기
	        // 공식: 현재 블럭 번호 = 현재 페이지 번호 / 블럭 당 페이지 수 << 후 올림 처리
	        currentBlock = (int) Math.ceil((double) currentPage / pagesPerBlock);
	        m.addAttribute("currentBlock", currentBlock);

	        // 블럭 시작,끝 페이지 구하기
	        blockStartPage = (currentBlock - 1) * pagesPerBlock + 1;
	        blockEndPage = currentBlock * pagesPerBlock;
	        // 예외처리. 마지막 페이지 보다 크면 마지막 페이지 값 전달.
	        if (blockEndPage > totalPageCount) {
	            blockEndPage = totalPageCount;
	        }
	        m.addAttribute("blockStartPage", blockStartPage);
	        m.addAttribute("blockEndPage", blockEndPage);

	        // 이전 블럭 이동 가능 여부
	        if (currentBlock > 1) {
	            m.addAttribute("hasBlockPrev", true);
	            // 이전 블럭 링크 클릭에 걸 페이지 계산 처리
	            prevPage = (currentBlock - 1) * pagesPerBlock;
	            m.addAttribute("prevPage", prevPage);
	        }
	        // 다음 블럭 이동 가능 여부
	        if (currentBlock < blockCount) {
	            m.addAttribute("hasBlockNext", true);
	            // 다음 블럭 링크 클릭에 걸 페이지 계산 처리
	            nextPage = currentBlock * pagesPerBlock + 1;
	            m.addAttribute("nextPage", nextPage);
	        }
	        return guestList;
	}
	
	
	@Override
	public GuestDto read(long bno) {
		return mapper.read(bno);
	}
	
	@Override
	public void del(long bno) {
		mapper.del(bno);
	}
	
	@Override
	public void write(GuestDto dto) {
		mapper.write(dto);
	}		
	
	@Override
	public void modify(GuestDto dto) {
		mapper.modify(dto);
	}	
	
    @Override
    public int getTotalPage() {
    	 return mapper.getTotalPage();
    }
}
