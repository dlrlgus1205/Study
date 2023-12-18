package service;

import java.util.List;
import java.util.Map;

import dao.ItemDao;
import vo.InvenVo;
import vo.ItemDetailspaceVo;
import vo.ItemListVo;
import vo.ItemSpaceVo;
import vo.ItemUgVo;

public class ItemService {
	private static ItemService instance = null;

	private ItemService() {
	}

	public static ItemService getInstance() {
		if (instance == null) {
			instance = new ItemService();
		}
		return instance;
	}
	ItemDao dao = ItemDao.getInstance();
	
	   
	   
	
	public ItemUgVo itemUpgradeSystem(List<Object> parami) {
		return dao.itemUpgradeSystem(parami);
	}
	
	public void itemUpnoUpdate(List<Object> param) {
		dao.itemUpnoUpdate(param);
	}
	
	public ItemSpaceVo itemSpaceDetail(List<Object> param) {
		return dao.itemSpaceDetail(param);
	}

	public List<ItemSpaceVo> itemList(List<Object> param) {
		return dao.itemList(param);
	}

	public List<ItemListVo> itemAllList() {
		return dao.itemAllList();
		
	}

	public void itemBuyItem(List<Object> param) {
		dao.itemBuyItem(param);
		
	}

	public void itemUpdate(List<Object> param1) {
		dao.itemUpdate(param1);
	}

	public void itemSale(List<Object> param2) {
		dao.itemSale(param2);
		
	}

	public InvenVo inventoryNum(List<Object> param) {
		return dao.inventoryNum(param);
	}

	public ItemDetailspaceVo itemSelDetail(int num) {
		return dao.itemSelDetail(num);
	}

	public void memberGcashplus(List<Object> param1) {
		dao.memberGcashplus(param1);
		
	}

	public void memberGcashminus(List<Object> param2) {
		dao.memberGcashminus(param2);
	}
	
	public List<ItemListVo> itemNameSearch(String name) {
		return dao.itemNameSearch(name);
	}
	public List<ItemListVo> itemClsSearch(String cls) {
		return dao.itemClsSearch(cls);
	}
	public List<ItemListVo> itemTypeSearch(String type) {
		return dao.itemNameSearch(type);
	}

	public void itemspaceDelete(List<Object> param) {
		dao.itemspaceDelete(param);
	}
	
	public void itemUPgcashMinus(List<Object> param2) {
		dao.itemUPgcashMinus(param2);
	}

	public ItemListVo itemSelectList(List<Object> selit) {
		return dao.itemSelectList(selit);
	}


	public List<ItemListVo> itemStoreList(List<Object> itemList) {
		return dao.itemStoreList(itemList);
	}
	
	public void rareitemstoreUpgrade(List<Object> param) {
		dao.rareitemstoreUpgrade(param);
	}

	public void uniqueitemstoreUpgrade(List<Object> param) {
		dao.uniqueitemstoreUpgrade(param);
	}

	public void legenditemstoreUpgrade(List<Object> param) {
		dao.legenditemstoreUpgrade(param);
	}

	public void misticitemstoreUpgrade(List<Object> param) {
		dao.misticitemstoreUpgrade(param);
	}
	public Map<String, Object> itemStorageUpdate(List<Object> param) {
		return dao.itemStorageUpdate(param);
	}

	public void heroitemstoreUpgrade(List<Object> param) {
		dao.heroitemstoreUpgrade(param);
	}
		
}