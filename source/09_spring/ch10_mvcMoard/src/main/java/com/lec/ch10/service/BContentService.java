package com.lec.ch10.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lec.ch10.dao.BoardDao;
@Service
public class BContentService implements BService {
	@Autowired
	private BoardDao boardDao;
	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		Map<String, Object> map = model.asMap();
		int bid = (Integer)map.get("bid");
		String after = (String)map.get("after"); //"u"(수정완료후 이거나) null(list에서옴)
		if(after==null) {
			boardDao.hitUp(bid);
		}
		model.addAttribute("contentBoard", boardDao.getBoardNotHitUp(bid));
	}

}
