package com.lec.ex.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.ex.dao.ProductDao;
import com.lec.service.Service;

public class ProductStockService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String pname = request.getParameter("pname");
		ProductDao pDao = ProductDao.getInstace();
		int pStock = pDao.getProductStock(pname);
		System.out.println("재고량 " + pStock);
		if (pStock == -1) {
			request.setAttribute("pStock", "없는제품");
		} else {
			request.setAttribute("pStock", pStock + "개 재고");

		}
	}
}
