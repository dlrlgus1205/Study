package img.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import img.vo.ImgVO;
import kr.or.ddit.mybatis.config.MybatisUtil;



public class ImgDaoImpl implements IImgDao{

private static ImgDaoImpl dao;
	
	private ImgDaoImpl() {
		
	}
	public static ImgDaoImpl getInstance() {
		if(dao==null) dao =new ImgDaoImpl();
		return dao;
	}
	
	
	@Override
	public int insertImg(ImgVO vo) {
		int cnt =0;
		
		SqlSession session =MybatisUtil.getSqlSession();
		try {
			cnt=session.insert("img.insertImg", vo);
			if(cnt>0) {
				session.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null);
		}
		return cnt;
	}
	@Override
	public List<ImgVO> getAllImg() {
		List<ImgVO> imgList =null;
		SqlSession session = null;
		
		try {
			session = MybatisUtil.getSqlSession();
			
			imgList = session.selectList("img.getAllImg");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null) session.close();
		}
		return imgList;
	}
	@Override
	public ImgVO getImg(int imgNo) {
		ImgVO imgVo = null;
		SqlSession session =null;
		
		try {
			session=MybatisUtil.getSqlSession();
			imgVo =session.selectOne("img.getImg", imgNo);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null) session.close();
		}
		return imgVo;
	}

	@Override
	public ImgVO imgSelect(int post_no) {
		SqlSession session = null;
		ImgVO vo = new ImgVO();
		try {
			session = MybatisUtil.getSqlSession();
			vo = session.selectOne("img.imgSelect",post_no);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.commit();
			if(session != null) session.close();
		}
		return vo;
	}
	
}
