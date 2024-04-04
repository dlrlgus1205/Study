package kr.or.ddit.vo;

import java.io.Serializable;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * DataMapper[ORM] 를 사용해서 mult entity 를 조회하는 단계
 * 
 * 1. 사용할 entity 결정, LPROD(1), BUYER(N)
 * 2. entity 하나 당 하나의 VO 모델링
 * 3. entity 간의 관계를 파악, Main entity 를 1로 두고 파악
 * 		1:1, 1:N, N:M
 * 4. VO 간의 관계를 entity 간의 관계를 반영하여 모델링
 * 		1:1(Has A) 1:N(Has Many)
 * 5. JOIN 쿼리 작성
 * 6. resultType 대신 resultMap 으로 조회 결과를 바인딩
 * 		1:1 - association 으로 바인드
 * 		1:N - collection 으로 바인드
 */
@Data
@EqualsAndHashCode(of="lprodId")
public class LprodVO implements Serializable {
	private String lprodId;
	private String lprodGu;
	private String lprodNm;
	
	private List<BuyerVO> buyerList;
}