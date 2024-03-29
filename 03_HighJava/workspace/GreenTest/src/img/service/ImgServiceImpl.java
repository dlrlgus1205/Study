package img.service;

import java.util.List;

import img.dao.IImgDao;
import img.dao.ImgDaoImpl;
import img.vo.ImgVO;
import post.dao.IPostDao;
import post.dao.PostDaoImpl;
import post.service.PostServiceImpl;

public class ImgServiceImpl implements IImgService{
	
	private static ImgServiceImpl service;
	private IImgDao dao;
	
	public ImgServiceImpl() {
		dao=ImgDaoImpl.getInstance();
	}
	
	public static ImgServiceImpl getInstance() {
		if(service==null) service = new ImgServiceImpl();
		return service;
	}
	
	
	@Override
	public int insertImg(ImgVO vo) {
		
		return dao.insertImg(vo);
	}

	@Override
	public List<ImgVO> getAllImg() {
		
		return dao.getAllImg();
	}

	@Override
	public ImgVO getImg(int imgNo) {
		
		return dao.getImg(imgNo);
	}
	
	//식물위키 썸네일 가져오기 메소드
	@Override
	public ImgVO imgSelect(int post_no) {
		return dao.imgSelect(post_no);
	}
}
