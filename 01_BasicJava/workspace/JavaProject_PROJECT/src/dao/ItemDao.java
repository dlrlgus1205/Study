package dao;

import java.util.List;
import java.util.Map;

import util.JDBCUtil;
import vo.InvenVo;
import vo.ItemDetailspaceVo;
import vo.ItemListVo;
import vo.ItemSpaceVo;
import vo.ItemUgVo;

public class ItemDao {
	private static ItemDao instance = null;

	private ItemDao() {
	}

	public static ItemDao getInstance() {
		if (instance == null) {
			instance = new ItemDao();
		}
		return instance;
	}
	
	JDBCUtil jdbc = JDBCUtil.getInstance();
	
	public ItemUgVo itemUpgradeSystem(List<Object> parami) {
		String sql = " select * from upgrade" + 
					 "		where up_no = ?";
		return jdbc.selectOne(sql,parami,ItemUgVo.class);
	}
	
	public void itemUpnoUpdate(List<Object> param) {
		String sql = " update itemspace\r\n" + 
				"         set up_no = ?\r\n" + 
				"       where inven_no = ?\r\n" + 
				"         and SP_NO = ?";
		jdbc.update(sql, param);
	}

	public ItemSpaceVo itemSpaceDetail(List<Object> param) {
		String sql = "select * \r\n" + 
				"   from itemspace a, inventory b\r\n" + 
				"   where a.inven_no = b.inven_no\r\n" + 
				"     and a.itm_del = 'N'"
				+ "   and a.sp_no = ?";
		return jdbc.selectOne(sql,param,ItemSpaceVo.class);
	}

	public List<ItemSpaceVo> itemList(List<Object> param) {
		String sql = "\r\n" + 
				" select sp_no,itm_no,up_no \r\n" + 
				"   from itemspace a, inventory b\r\n" + 
				"   where a.inven_no = b.inven_no\r\n" + 
				"     and a.itm_del = 'N'\r\n" + 
				"     and a.inven_no = ?";
		return jdbc.selectList(sql, param, ItemSpaceVo.class);
	}
	
	
	public List<ItemListVo> itemStoreList(List<Object> param) {
		String sql = "SELECT ITM_NO,ITM_NAME,ITM_CON,ITM_CLS,ITM_TYPE,ITM_PRICE,ST_GRADE\r\n" + 
				"  FROM ITEMMENU\r\n" + 
				"  WHERE  ? >= ST_GRADE\r\n" + 
				"    AND ITM_DEL = 'N'"
				+ " ORDER BY 7";
		
		return jdbc.selectList(sql,param,ItemListVo.class);
	}
	public List<ItemListVo> itemAllList() {
		String sql = "\r\n" + 
				"  SELECT *\r\n" + 
				"    FROM ITEMMENU\r\n" + 
				"    WHERE ITM_DEL = 'N'";
		
		return jdbc.selectList(sql,ItemListVo.class);
		
	}

	public void itemBuyItem(List<Object> param) {
		String sql = "INSERT INTO BUYPROD(BUY_NO,BUY_YN,MEM_NO,ITM_NO)\r\n" + 
				"  VALUES (SEQ_BUYPROD_NO.NEXTVAL,'Y',\r\n" + 
				"          (SELECT mem_no \r\n" + 
				"             from member \r\n" + 
				"            where mem_no = ?),\r\n" + 
				"            ?)";
		
		jdbc.update(sql,param);
		
	}

	public void itemUpdate(List<Object> param1) {
		String sql = "INSERT INTO ITEMSPACE(SP_NO,INVEN_NO,ITM_NO)\r\n" + 
				"VALUES(SEQ_SP_NO.NEXTVAL,(SELECT INVEN_NO FROM INVENTORY WHERE MEM_NO = ?), ?)";
		
		jdbc.update(sql, param1);
	}

	public void itemSale(List<Object> param2) {
		String sql = "update itemspace"
				+ "		 set itm_del = 'Y'"
				+ "     where itm_no = ?";
		
		jdbc.update(sql, param2);
	}

	public InvenVo inventoryNum(List<Object> param) {
		String sql = "select inven_no from inventory where mem_no = ?";
		
		return jdbc.selectOne(sql,param,InvenVo.class);
	}

	public ItemDetailspaceVo itemSelDetail(int num) {
		String sql = "select B.SP_NO,B.INVEN_NO,A.ITM_NO,A.ITM_NAME,A.ITM_CON,A.ITM_CLS,A.ITM_TYPE,B.UP_NO"
				+ "		from itemmenu A, itemspace B"
				+ "    WHERE A.ITM_NO = B.ITM_NO"
				+ "		 AND B.SP_NO = "+num;
		return  jdbc.selectOne(sql,ItemDetailspaceVo.class);
	}

	public void memberGcashplus(List<Object> param1) {
		String sql = "   update member\r\n" + 
				"           set mem_gcash = mem_gcash+(select itm_price/2\r\n" + 
				"                                   	 from itemmenu\r\n" + 
				"                                  	 	where itm_no = ?)"
				+ "       where mem_no = ?";
		jdbc.update(sql,param1);
	}

	public void memberGcashminus(List<Object> param2) {
		String sql = "update member\r\n" + 
				"      set mem_gcash = mem_gcash-(select itm_price\r\n" + 
				"                                   from itemmenu\r\n" + 
				"                                  where itm_no = ?)\r\n" + 
				"    where mem_no = ?";
		jdbc.update(sql,param2);
	}

	public List<ItemListVo> itemNameSearch(String name) {
		String sql = "SELECT ITM_NO,ITM_NAME,ITM_CON,ITM_CLS,ITM_TYPE,ITM_PRICE\r\n" + 
				"  FROM ITEMMENU\r\n" + 
				"  WHERE ITM_NAME LIKE '"+name+"%'";
		return jdbc.selectList(sql,ItemListVo.class);
	}
	
	public List<ItemListVo> itemClsSearch(String cls) {
		String sql = "SELECT ITM_NO,ITM_NAME,ITM_CON,ITM_CLS,ITM_TYPE,ITM_PRICE\r\n" + 
				"  FROM ITEMMENU\r\n" + 
				"  WHERE ITM_CLS LIKE '"+cls+"%'";
		return jdbc.selectList(sql,ItemListVo.class);
	}
	
	public List<ItemListVo> itemTypeSearch(String type) {
		String sql = "SELECT ITM_NO,ITM_NAME,ITM_CON,ITM_CLS,ITM_TYPE,ITM_PRICE\r\n" + 
				"  FROM ITEMMENU\r\n" + 
				"  WHERE ITM_NAME LIKE '"+type+"%'";
		return jdbc.selectList(sql,ItemListVo.class);
	}

	public void itemspaceDelete(List<Object> param) {
		String sql = "    UPDATE ITEMSPACE\r\n" + 
				"       SET ITM_DEL = 'Y'\r\n" + 
				"       WHERE ITM_NO = ?";
		jdbc.update(sql,param);
	}
	
	public void itemUPgcashMinus(List<Object> param2) {
		String sql = "\r\n" + 
				"   UPDATE MEMBER\r\n" + 
				"      SET MEM_GCASH = MEM_GCASH-?*10000 ";
		jdbc.update(sql,param2);
	}

	public ItemListVo itemSelectList(List<Object> selit) {
		String sql = "SELECT * "
				+ "	    FROM ITEMMENU "
				+ "	   WHERE ITM_NO = ?";
		
		return jdbc.selectOne(sql,selit,ItemListVo.class);
	}

	public void rareitemstoreUpgrade(List<Object> param) {
		String sql = "UPDATE MEMBER\r\n" + 
				"      SET MEM_GCASH = MEM_GCASH- ?,"
				+ "		   MEM_STGRADE = 2"
				+ "    WHERE MEM_NO = ?";
		
		jdbc.update(sql,param);
	}

	public void uniqueitemstoreUpgrade(List<Object> param) {
		String sql = "UPDATE MEMBER\r\n" + 
				"      SET MEM_GCASH = MEM_GCASH- ?,"
				+ "		   MEM_STGRADE = 3"
				+ "    WHERE MEM_NO = ?";
		
		jdbc.update(sql,param);
	}

	public void heroitemstoreUpgrade(List<Object> param) {
		String sql = "UPDATE MEMBER\r\n" + 
				"      SET MEM_GCASH = MEM_GCASH- ?,"
				+ "		   MEM_STGRADE = 4"
				+ "    WHERE MEM_NO = ?";
		
		jdbc.update(sql,param);
	}
	
	public void legenditemstoreUpgrade(List<Object> param) {
		String sql = "UPDATE MEMBER\r\n" + 
				"      SET MEM_GCASH = MEM_GCASH- ?,"
				+ "		   MEM_STGRADE = 5"
				+ "    WHERE MEM_NO = ?";
		
		jdbc.update(sql,param);
	}

	public void misticitemstoreUpgrade(List<Object> param) {
		String sql = "UPDATE MEMBER\r\n" + 
				"      SET MEM_GCASH = MEM_GCASH- ?,"
				+ "		   MEM_STGRADE = 6"
				+ "    WHERE MEM_NO = ?";
		
		jdbc.update(sql,param);

	}
	
	public Map<String, Object> itemStorageUpdate(List<Object> param) {
		String sql = " SELECT UP_SUC"
				+ "	FROM UPGRADE" + 
				 "	WHERE UP_NO = ?";
		return jdbc.selectOne(sql, param);
	}

}
