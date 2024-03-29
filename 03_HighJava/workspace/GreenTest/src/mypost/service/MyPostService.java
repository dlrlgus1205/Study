package mypost.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mypost.dao.MyPostDao;
import mypost.vo.MyPostPageVO;
import mypost.vo.MyPostVO;

public class MyPostService implements IMyPostService {
	
	private MyPostDao dao;
	private static MyPostService instance;
		
		private MyPostService() { 
			dao = MyPostDao.getInstance();
		}
		
		public static MyPostService getInstance() {
			if(instance==null) instance= new MyPostService();
			
			return instance;
		}

	@Override
	public int getTotalCount(Map<String, Object> map) {
		
		return dao.getTotalCount(map);
	}

	@Override
	public MyPostPageVO pageInfo(int pageNo, int board_no, String stype, String sword, String mem_id, int category_no) {
		//전체 글 갯수
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("stype", stype);
				map.put("sword", sword);
				map.put("mem_id", mem_id);
				map.put("board_no", board_no);
				map.put("category_no", category_no);
				
				int count = this.getTotalCount(map);
				
				//전체 페이지수 구하기
				int perList = MyPostPageVO.getPerList();
				
				int totalPage = (int)Math.ceil((double)count/perList);
				
				//시작 글번호
				int start = (pageNo -1) * perList + 1;
				int end = start + perList -1;
				if(end>count) end = count;
				
				//시작페이지
				int perPage = MyPostPageVO.getPerPage(); 
				int startPage = ((pageNo-1) / perPage * perPage)+1;
				int endPage = startPage + perPage - 1;
				if(endPage > totalPage) endPage = totalPage ;
				
				MyPostPageVO vo = new MyPostPageVO();
				vo.setStart(start);
				vo.setEnd(end);
				vo.setStartPage(startPage);
				vo.setEndPage(endPage);
				vo.setTotalPage(totalPage);
				vo.setTotalPost(count);
			
				return vo;
	}

	@Override
	public List<MyPostVO> selctByPage(Map<String, Object> map) {
		
		return dao.selctByPage(map);
	}

}
