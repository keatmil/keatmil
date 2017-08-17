package com.academy.replybbs.service;

import java.util.List;
import java.util.Map;

public interface ReplyBBSService {
	boolean login(Map map) throws Exception;

	List<ReplyBBSDto> selectList(Map map) throws Exception;
	ReplyBBSDto selectOne(Map map) throws Exception;
	
	int insert(ReplyBBSDto dto) throws Exception;
	int update(ReplyBBSDto dto) throws Exception;
	int delete(ReplyBBSDto dto) throws Exception;
	
	int getTotalCount(Map map) throws Exception;
	
	void reply(Map map) throws Exception;
	
	void close() throws Exception;
}
