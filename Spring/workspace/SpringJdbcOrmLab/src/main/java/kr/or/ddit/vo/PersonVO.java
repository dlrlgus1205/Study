package kr.or.ddit.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Domain Layer : raw data 구조를 반영하여 모델링함.
 * MemberData.properties 파일의 저장된 사용자의 정보 로딩에 필요한 객체
 * model : id, name, gender, age, address
 */
@ToString
@EqualsAndHashCode(of = "id")
@Data
public class PersonVO {
	private String id;
	private String name;
	private String gender;
	private String age;
	private String address;
}