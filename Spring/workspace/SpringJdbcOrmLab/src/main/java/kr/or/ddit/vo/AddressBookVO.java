package kr.or.ddit.vo;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class AddressBookVO {
	private Long adrsNo;
	private String memId;
	private String adrsName;
	private String adrsTel;
	private String adrsAdd;
}
