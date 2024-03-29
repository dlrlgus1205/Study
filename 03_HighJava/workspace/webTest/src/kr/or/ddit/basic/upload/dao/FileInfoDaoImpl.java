package kr.or.ddit.basic.upload.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.basic.upload.vo.FileInfoVo;
import kr.or.ddit.util.MybatisUtil;

public class FileInfoDaoImpl implements IFileInfoDao {
	private static FileInfoDaoImpl dao;
	
	private FileInfoDaoImpl() {}
	
	public static FileInfoDaoImpl getInstance() {
		if(dao==null) dao = new FileInfoDaoImpl();
		return dao;
	}
	@Override
	public int insertFileinfo(FileInfoVo fileVo) {
		int cnt = 0;		//반환값이 저장될 변수 선언
		SqlSession session = null;
		
		try {
			session = MybatisUtil.getSqlSession();
			cnt = session.insert("fileinfo.insertFileinfo", fileVo);
			if(cnt>0) {
				session.commit();
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null) session.close();
		}
		return cnt;
	}

	@Override
	public List<FileInfoVo> getAllFileinfo() {
		List<FileInfoVo> list = new ArrayList<FileInfoVo>();
		SqlSession session = null;
		try {
			session = MybatisUtil.getSqlSession();
			
			list = session.selectList("fileinfo.getAllFileinfo");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null) session.close();
		}
		return list;
	}

	@Override
	public FileInfoVo getFileinfo(int fileNo) {
		FileInfoVo fvo = new FileInfoVo();
		SqlSession session = MybatisUtil.getSqlSession();
		try {
			fvo = session.selectOne("fileinfo.getFileinfo", fileNo);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null) session.close();
		}
		return fvo;
	}

}
