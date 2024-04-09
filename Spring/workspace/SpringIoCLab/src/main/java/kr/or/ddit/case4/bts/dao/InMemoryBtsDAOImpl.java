package kr.or.ddit.case4.bts.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import kr.or.ddit.vo.BtsVO;
import lombok.Setter;

@Repository
@Setter
public class InMemoryBtsDAOImpl implements BtsDAO {
	@Resource(name = "btsMap")
	private Map<String, Object[]> btsMap;
	
//	Map<String, Object[]> btsMap = new LinkedHashMap<>();
	@PostConstruct
	public void init() {
		btsMap.put("B001", new Object[] {"뷔", "bts/bui", 100});
		btsMap.put("B002", new Object[] {"제이홉", "bts/jhop", 200});
		btsMap.put("B003", new Object[] {"지민", "bts/jimin", 300});
		btsMap.put("B004", new Object[] {"진", "bts/jin", 500});
		btsMap.put("B005", new Object[] {"정국", "bts/jungkuk", 120});
		btsMap.put("B006", new Object[] {"RM", "bts/rm", 30});
		btsMap.put("B007", new Object[] {"슈가", "bts/suga", 50});
	}
	
	@Override
	public BtsVO selectBts(String code) {
		BtsVO bvo = null;
//		if(btsMap.containsKey(code)) {
//			for(Entry<String, String[]> entry : btsMap.entrySet()) {
//				if(code.equals(entry.getKey())) {
//					vo = new BtsVO(entry.getKey(), entry.getValue()[0], entry.getValue()[1]);
//				}
//			}
//		}
		Object[] values = btsMap.get(code);
		if(values != null) {
				incrementHit(code);
				bvo = new BtsVO(code, (String) values[0], (String) values[1], (Integer) values[2]);
		}
//		System.out.println(bvo);
		return bvo;
	}

	@Override
	public List<BtsVO> selectBtsList() {
		List<BtsVO> btsList = new ArrayList<BtsVO>();
		BtsVO vo = null;
		for(Entry<String, Object[]> entry : btsMap.entrySet()) {
			String code = entry.getKey();
			String name = (String) entry.getValue()[0];
			String path = (String) entry.getValue()[1];
			int count = (Integer) entry.getValue()[2];
			
			vo = new BtsVO(code, name, path, count);
			btsList.add(vo);
		}
//		System.out.println(btsList);
		
		// 첫번째
//		return btsList.stream()
//				.sorted(Comparator.comparing(BtsVO::getCount).reversed())
//				.collect(Collectors.toList());
		// 두번째
		Collections.sort(btsList, new Comparator<BtsVO>() {
			@Override
			public int compare(BtsVO o1, BtsVO o2) {
				return o2.getCount() - o1.getCount();
			}
		});
		return btsList;
	}

	@Override
	public void incrementHit(String code) {
		BtsVO bvo = null;
		Object[] values = btsMap.get(code);
		bvo = new BtsVO(code, (String) values[0], (String) values[1], (Integer) values[2]);
//		System.out.println("조회수 증가 전 : " + values[2]);
		values[2] = (Integer) values[2] + 1;
//		System.out.println("조회수 증가 후 : " + btsMap.get(code)[2]);
	}
}