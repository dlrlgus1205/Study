package likes.service;

import java.util.Map;

import likes.dao.ILikesDao;
import likes.dao.LikesDaoImpl;

public class LikesServiceImpl implements ILikesService {
	private static ILikesService service;
	private static ILikesDao dao;
	
	private LikesServiceImpl() {
		dao = LikesDaoImpl.getInstance();
	}
	
	public static ILikesService getInstance() {
		if(service == null) {
			service = new LikesServiceImpl();
		}
		return service;
	}
	
	
	@Override
	public int Likeinsert(Map<String, Object> param) {
		return dao.Likeinsert(param);
	}

	@Override
	public int LikeDelete(Map<String, Object> param) {
		return dao.LikeDelete(param);
	}

	@Override
	public int LikeSelect(Map<String, Object> param) {
		return dao.LikeSelect(param);
	}

	@Override
	public int likesCount(int post_no) {
		return dao.likesCount(post_no);
	}
	
}
