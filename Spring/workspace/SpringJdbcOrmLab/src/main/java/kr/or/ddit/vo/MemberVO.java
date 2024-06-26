package kr.or.ddit.vo;

import java.io.Serializable;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.validation.groups.Default;

import com.fasterxml.jackson.annotation.JsonIgnore;

import kr.or.ddit.validate.groups.DeleteGroup;
import kr.or.ddit.validate.groups.InsertGroup;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 회원관리를 위한 Domain Layer
 *
 * 1번 그룹 (가입 시 검증 그룹) : 아이디, 주민번호1, 주민번호2 + 기본 그룹
 * 2번 그룹 (수정 시 검증 그룹) : + 기본 그룹
 * 기본 그룹 (가입과 수정 시 모두 검증 그룹 : 비밀번호, 이름, 우편번호, 주소1, 주소2, 이메일
 * 3번 그룹 (탈퇴 시 검증 그룹) : 비밀번호
 */

@Data
@Getter
@Setter
@ToString(exclude = {"memPass","memRegno1","memRegno2"})
@EqualsAndHashCode(of = "memId")
public class MemberVO implements Serializable {
	@NotBlank(groups = InsertGroup.class)
	private String memId;
	// 마샬링 할 때도 노출안되게 하는 방법 : @JsonIgnore
	@NotBlank(groups = {Default.class, DeleteGroup.class})
	@Size(min = 4, max = 12, groups = {Default.class, DeleteGroup.class})
	@JsonIgnore
	private transient String memPass; //노출X : transient
	@NotBlank
	@Size(max = 20)
	private String memName;
	@NotBlank(message = "주민번호 1번 누락", groups = InsertGroup.class)
	@JsonIgnore
	private transient String memRegno1;
	@NotBlank(groups = InsertGroup.class)
	@JsonIgnore
	private transient String memRegno2;
	private String memBir;
	@NotBlank
	private String memZip;
	@NotBlank
	private String memAdd1;
	@NotBlank
	private String memAdd2;
	private String memHometel;
	private String memComtel;
	private String memHp;
	@NotBlank
	@Email
	private String memMail;
	private String memJob;
	private String memLike;
	private String memMemorial;
	private String memMemorialday;
	private Long memMileage;
	private boolean memDelete;
	
	// 구매기록
	@JsonIgnore 
	// transient 직렬화에서 제외
	private transient Set<CartVO> cartList; //Has Many //set :중복을 허용하지 않겠다!
	
	// 사용자 역할 정보
	private String memRole;
}