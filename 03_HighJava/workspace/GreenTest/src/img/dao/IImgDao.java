package img.dao;

import java.util.List;

import img.vo.ImgVO;



public interface IImgDao {
	
	
	public int insertImg(ImgVO vo);
	
	public List<ImgVO> getAllImg();
	
	public ImgVO getImg(int imgNo);
	
	/**
	 * 이미지 섬네일 가져오기 메소드
	 * @param post_no
	 * @return
	 */
	public ImgVO imgSelect(int post_no);
}
