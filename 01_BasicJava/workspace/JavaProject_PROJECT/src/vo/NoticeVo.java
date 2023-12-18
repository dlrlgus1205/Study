package vo;

import java.util.Date;

import lombok.Data;
@Data
public class NoticeVo {
	 private int ntc_no;
	 private String ntc_title;
	 private String ntc_con;
	 private Date ntc_date;
	 private int ntc_view;
	 private String ntc_del;
	 private int ad_no;
}
