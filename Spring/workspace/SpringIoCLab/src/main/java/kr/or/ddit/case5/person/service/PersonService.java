package kr.or.ddit.case5.person.service;

import java.util.List;

import kr.or.ddit.vo.PersonVO;

/**
 * Business Logic Layer : 하나의 어플리케이션이 가진 특징적인 로직이 구현되는 객체
 *
 * ex) 급여 명세서를 구현한다면 ??
 * 사원 + 근태 -> Domain Layer 설계
 * 사원 데이터와 근태기록 조회(select) : Persistence Layer 구현
 * 사원 데이터와 근태기록을 토대로 급여 정보 계산 : Business Logic Layer 구현
 * 
 * 실행 환경에 종속되는 레이어 설계 : Controller Layer, View Layer
 */
public interface PersonService {
	public List<PersonVO> retrievePersonList();
	
	public PersonVO retrievePerson(String id);
}