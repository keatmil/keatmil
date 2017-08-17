package com.academy.replybbs.service.impl;

import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import com.academy.replybbs.service.ReplyBBSDto;
import com.academy.replybbs.service.ReplyBBSService;
import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

@Repository
public class ReplyBBSDao implements ReplyBBSService{
	@Resource(name="template")
	private SqlSessionTemplate template;
	
	/*
	private static SqlSessionFactory sqlMapper;
	static {
		try {
			Reader reader = Resources.getResourceAsReader("mybatis/Configuration.xml");
			sqlMapper = new SqlSessionFactoryBuilder().build(reader);
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	*/
	@Override
	public boolean login(Map map) throws Exception {
		/*
		SqlSession session = sqlMapper.openSession();
		int count = session.selectOne("ReplyBBSLogin", map);
		session.close();
		*/
		
		int count = template.selectOne("ReplyBBSLogin", map);
		
		return count == 1 ? true : false;
	}

	@Override
	public List<ReplyBBSDto> selectList(Map map) throws Exception {
		return template.selectList("ReplyBBSlist", map);
	}

	@Override
	public ReplyBBSDto selectOne(Map map) throws Exception {
		return template.selectOne("ReplyBBSone", map);
	}

	@Override
	public int insert(ReplyBBSDto dto) throws Exception {
		/*
		SqlSession session = sqlMapper.openSession();
		int count = session.insert("ReplyBBSinsert", dto);
		session.commit();
		session.close();
		*/
		int count = template.insert("ReplyBBSinsert", dto);
		return count;
	}

	@Override
	public int update(ReplyBBSDto dto) throws Exception {
		return template.update("ReplyBBSupdate", dto);
	}

	@Override
	public int delete(ReplyBBSDto dto) throws Exception {
		return template.delete("ReplyBBSdelete", dto);
	}

	@Override
	public int getTotalCount(Map map) throws Exception {
		return template.selectOne("ReplyBBStotal", map);
	}

	@Override
	public void reply(Map map) throws Exception {
		template.update("ReplyBBSreply_uqdate", map);
		template.insert("ReplyBBSreply_insert", map);
	}

	@Override
	public void close() throws Exception {
	}
	
	/*
	@Resource(name="sqlMapClient")
	private SqlMapClient sqlMapper;
	*/
	
	/*private static SqlMapClient sqlMapper;
	static {
		try {
			Reader reader = Resources.getResourceAsReader("ibatis/SqlMapConfig.xml");
			sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}*/
	/*
	@Resource(name="ibatisTemplate")
	private SqlMapClientTemplate sqlMapper;
	
	@Override
	public boolean login(Map map) throws Exception {
		int count = Integer.parseInt(sqlMapper.queryForObject("ReplyBBS.Login", map).toString());
		return count == 1 ? true : false;
	}

	@Override
	public List<ReplyBBSDto> selectList(Map map) throws Exception {
		return sqlMapper.queryForList("ReplyBBS.list", map);
	}
	
	@Override
	public ReplyBBSDto selectOne(Map map) throws Exception {
		return (ReplyBBSDto)sqlMapper.queryForObject("ReplyBBS.one", map);
	}

	@Override
	public int insert(ReplyBBSDto dto) throws Exception {
		return sqlMapper.update("ReplyBBS.insert", dto);
	}//insert

	@Override
	public int update(ReplyBBSDto dto) throws Exception {
		return sqlMapper.update("ReplyBBS.update", dto);
	}

	@Override
	public int delete(ReplyBBSDto dto) throws Exception {
		return sqlMapper.update("ReplyBBS.delete", dto);
	}

	@Override
	public int getTotalCount(Map map) throws Exception {
		return Integer.parseInt(sqlMapper.queryForObject("ReplyBBS.total", map).toString());
	}

	@Override
	public void reply(Map map) throws Exception {
		sqlMapper.update("ReplyBBS.reply_uqdate", map);
		sqlMapper.update("ReplyBBS.reply_insert", map);
	}

	@Override
	public void close() throws Exception {
	}
	*/
	
	/*
	@Resource(name="datasourceByJNDI")
	private DataSource source;
	
	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;

	@Override
	public boolean login(Map map) throws Exception {
		String sql = "SELECT COUNT(*) FROM MEMBER WHERE ID=? AND PWD=?";
		psmt = source.getConnection().prepareStatement(sql);
		psmt.setString(1, map.get("id").toString());
		psmt.setString(2, map.get("pwd").toString());
		rs = psmt.executeQuery();
		rs.next();
		int count = rs.getInt(1);
		close();
		if (count == 0){
			return false;
		}	
		return true;
	}

	@Override
	public List<ReplyBBSDto> selectList(Map map) throws Exception {
		List<ReplyBBSDto> list = new Vector<ReplyBBSDto>();
		String sql = "SELECT * FROM (SELECT T.*,ROWNUM R FROM (SELECT RE.*,NAME FROM MEMBER M JOIN REPLYBBS RE ON M.ID=RE.ID ";
		if(map.get("searchColumn") != null){
			sql += " WHERE " + map.get("searchColumn") + " LIKE '%" + map.get("searchWord") +"%' ";
		}
		sql += " ORDER BY REFER DESC,STEP ASC) T) WHERE R BETWEEN ? AND ?";
		
		psmt = source.getConnection().prepareStatement(sql);
		psmt.setInt(1, Integer.parseInt(map.get("start").toString()));
		psmt.setInt(2, Integer.parseInt(map.get("end").toString()));
		
		rs = psmt.executeQuery();
		while(rs.next()){
			ReplyBBSDto dto = new ReplyBBSDto();
			dto.setNo(rs.getString(1));
			dto.setId(rs.getString(2));
			dto.setTitle(rs.getString(3));
			dto.setContent(rs.getString(4));
			dto.setPostdate(rs.getDate(5));
			dto.setRefer(rs.getString(6));
			dto.setStep(rs.getString(7));
			dto.setDepth(rs.getString(8));
			dto.setName(rs.getString(9));
			list.add(dto);
		}
		close();
		return list;
	}

	@Override
	public ReplyBBSDto selectOne(Map map) throws Exception {
		String sql = "SELECT R.*, NAME FROM MEMBER M JOIN REPLYBBS R ON M.ID = R.ID WHERE NO=?";
		ReplyBBSDto dto = null;
		psmt = source.getConnection().prepareStatement(sql);
		psmt.setString(1, map.get("no").toString());
		rs = psmt.executeQuery();
		if(rs.next()){
			dto = new ReplyBBSDto();
			dto.setNo(rs.getString(1));
			dto.setId(rs.getString(2));
			dto.setTitle(rs.getString(3));
			dto.setContent(rs.getString(4));
			dto.setPostdate(rs.getDate(5));
			dto.setRefer(rs.getString(6));
			dto.setStep(rs.getString(7));
			dto.setDepth(rs.getString(8));
			dto.setName(rs.getString(9));
		}
		close();
		return dto;
	}

	@Override
	   public int insert(ReplyBBSDto dto) throws Exception {
	      int affected = 0;
	      String sql="INSERT INTO REPLYBBS(NO, ID, TITLE, CONTENT, REFER) VALUES(SEQ_REPLYBBS.NEXTVAL, ?, ?, ?, SEQ_REPLYBBS.CURRVAL)";
	      psmt = source.getConnection().prepareStatement(sql);
	      psmt.setString(1, dto.getId());
	      psmt.setString(2, dto.getTitle());
	      psmt.setString(3, dto.getContent());
	      affected = psmt.executeUpdate();
	      close();
	      return affected;
	   }

	@Override
	public int update(ReplyBBSDto dto) throws Exception {
		int affected = 0;
		String sql = "UPDATE REPLYBBS SET TITLE=?, CONTENT=? WHERE NO=?";
		psmt = source.getConnection().prepareStatement(sql);
		psmt.setString(1, dto.getTitle());
		psmt.setString(2, dto.getContent());
		psmt.setString(3, dto.getNo());
		affected = psmt.executeUpdate();
		close();
		return affected;
	}

	@Override
	public int delete(ReplyBBSDto dto) throws Exception {
		int affected = 0;
		String sql = "DELETE REPLYBBS WHERE NO=?";
		psmt = source.getConnection().prepareStatement(sql);
		psmt.setString(1, dto.getNo());
		affected = psmt.executeUpdate();
		close();
		return affected;
	}

	@Override
	public int getTotalCount(Map map) throws Exception {
		String sql = "SELECT COUNT(*) FROM REPLYBBS RE JOIN MEMBER M ON RE.ID = M.ID ";
		if(map.get("searchColumn") != null){
			sql += " WHERE " + map.get("searchColumn") + " LIKE '%" + map.get("searchWord") +"%' ";
		}
		psmt = source.getConnection().prepareStatement(sql);
		rs = psmt.executeQuery();
		rs.next();
		int total = rs.getInt(1);
		close();
		return total;
	}

	@Override
	public void reply(Map map) throws Exception {
		String sql = "UPDATE REPLYBBS SET STEP=STEP+1 WHERE REFER=? AND STEP > ?";
		psmt = source.getConnection().prepareStatement(sql);
		psmt.setString(1, map.get("refer").toString());
		psmt.setString(2, map.get("step").toString());
		psmt.executeUpdate();
		
		sql = "INSERT INTO REPLYBBS VALUES(SEQ_REPLYBBS.NEXTVAL, ?, ?, ?, SYSDATE, ?, ?, ?)";
		psmt = source.getConnection().prepareStatement(sql);
		psmt.setString(1, map.get("id").toString());
		psmt.setString(2, map.get("title").toString());
		psmt.setString(3, map.get("content").toString());
		psmt.setString(4, map.get("refer").toString());
		psmt.setInt(5, (Integer.parseInt(map.get("step").toString())+1));
		psmt.setInt(6, (Integer.parseInt(map.get("depth").toString())+1));
		psmt.executeUpdate();
		
		close();
	}

	@Override
	public void close() throws Exception {
		if (rs != null) rs.close();
		if (psmt != null) psmt.close();
		if (conn != null) conn.close();
	}
	*/
}
