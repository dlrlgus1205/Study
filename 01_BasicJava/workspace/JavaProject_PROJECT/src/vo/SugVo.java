package vo;

import java.util.Date;

import lombok.Data;

@Data
public class SugVo {
	 private int sug_no;
	 private String sug_title;
	 private String sug_con;
	 private Date sug_date;
	 private int sug_view;
	 private String sug_del;
	 private String mem_id;
}
