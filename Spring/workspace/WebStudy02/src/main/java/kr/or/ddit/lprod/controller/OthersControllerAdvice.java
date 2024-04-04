package kr.or.ddit.lprod.controller;

import javax.servlet.http.HttpServletRequest;

import kr.or.ddit.lprod.service.OthersService;
import kr.or.ddit.lprod.service.OthersServiceImpl;

/**
 * POJO(Plain Old Java Object)
 *
 */
public class OthersControllerAdvice {
	private OthersService serivce = new OthersServiceImpl();
	
	public void addLprodList(HttpServletRequest req) {
		req.setAttribute("lprodList", serivce.retrieveLprodList());
	}
	
	public void addbuyerList(HttpServletRequest req) {
		req.setAttribute("buyerList", serivce.retrieveBuyerList());
	}
}
