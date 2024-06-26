package kr.or.ddit.basic.upload.dao;

import java.util.List;

import kr.or.ddit.basic.upload.vo.FileInfoVo;

public interface IFileInfoDao {
	/** 
	 * FileInfoVO객체에 저장된 자료를 DB에 insert하는 메서드
	 * 
	 * @param fileVo 저장할 데이터가 저장된 FileInfoVO객체
	 * @return 작업성공 1, 작업실패 0
	 */
	public int insertFileinfo(FileInfoVo fileVo);
	
	/**
	 * DB에 저장된 전체 파일 목록을 가져와 List에 담아서 반환하는 메서드
	 * @return 파일 정보 목록이 저장된 List객체
	 */
	public List<FileInfoVo> getAllFileinfo();
	
	/**
	 * fileNo를 매개변수로 받아서 해당 파일 정보를 검색하여 찾은 파일 정보를 반환하는 메서드
	 * 
	 * @param fileNo 검색할 파일번호
	 * @return 
	 */
	public FileInfoVo getFileinfo(int fileNo);
}
