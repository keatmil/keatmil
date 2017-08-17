package com.academy.replybbs.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.academy.replybbs.service.ReplyBBSDto;
import com.academy.replybbs.service.ReplyBBSService;

@Service("bbsService")
public class ReplyBBSServiceImpl implements ReplyBBSService{

	@Resource(name="replyBBSDao")
	private ReplyBBSDao dao;
	
	@Override
	public boolean login(Map map) throws Exception {
		return dao.login(map);
	}

	@Override
	public List<ReplyBBSDto> selectList(Map map) throws Exception {
		return dao.selectList(map);
	}

	@Override
	public ReplyBBSDto selectOne(Map map) throws Exception {
		return dao.selectOne(map);
	}

	@Override
	public int insert(ReplyBBSDto dto) throws Exception {
		return dao.insert(dto);
	}

	@Override
	public int update(ReplyBBSDto dto) throws Exception {
		return dao.update(dto);
	}

	@Override
	public int delete(ReplyBBSDto dto) throws Exception {
		return dao.delete(dto);
	}

	@Override
	public int getTotalCount(Map map) throws Exception {
		return dao.getTotalCount(map);
	}

	@Override
	public void reply(Map map) throws Exception {
		dao.reply(map);		
	}

	@Override
	public void close() throws Exception {
		dao.close();
	}

}
