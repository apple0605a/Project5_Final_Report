package com.example;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.jdbc.core.RowMapper;

@Repository
public class BoardDAO {
	@Autowired
	SqlSession sqlSession;

	public int insertBoard(BoardVO vo) {
		int result = sqlSession.update("Board.insertBoard", vo);
		return result;
	}

//	public int insertBoard(BoardVO vo) {
//		int count  = sqlSession.insert("Board.insertBoard",vo);
//		return count;
//	}

//	public void insertBoard(BoardVO vo) {
//		System.out.println("insertBoard");
//		mybatis.insert("BoardDAO.insertBoard", vo);
//	}
	public int updateBoard(BoardVO vo) {
		int result = sqlSession.update("Board.updateBoard", vo);
		return result;
	}

	public int deleteBoard(int seq) {
		int result = sqlSession.update("Board.deleteBoard", seq);
		return result;
	}

	public BoardVO getBoard(int seq) {
		BoardVO one = sqlSession.selectOne("Board.getBoard", seq);
		return one;
	}

	public List<BoardVO> getBoardList() {
		List<BoardVO> list = sqlSession.selectList("Board.getBoardList");
		return list;
	}


}

//	@Repository	//bean으로 자동 등록
//	public class  BoardDAO {
//
//		@Autowired	//rootContext에서 만든거 자동 적용
//		JdbcTemplate jdbcTemplate;
//
//		//설명 영상에서는 이 부분 들어가 있었음
////		public void setJdbcTemplate(JdbcTemplate template) {
////			this.template = template;
////		}
//
////		public int insertBoard(BoardVO vo) {
////			String sql = "insert into BOARD (title, writer, content, category) values ("
////					+ "'" + vo.getTitle() + "',"
////					+ "'" + vo.getWriter() + "',"
////					+ "'" + vo.getContent() + "',"
////					+ "'" + vo.getCategory() + "')";
////			return jdbcTemplate.update(sql);
////		}
//
//		public void insertBoard(BoardVO vo) {
//			System.out.println("insertBoard");
//			mybatis.insert("BoardDAO.insertBoard", vo);
//		}
//
//		// 글 삭제
//		public int deleteBoard(int seq) {
//			String sql = "delete from BOARD where seq = " + seq;
//			return jdbcTemplate.update(sql);
//		}
//
//		public int updateBoard(BoardVO vo) {
//			String sql = "update BOARD set title='"+ vo.getTitle() + "',"
//					+ " writer='" + vo.getWriter() + "',"
//					+ " content='" + vo.getContent() + "',"
//					+ " category='" + vo.getCategory() + "' where seq=" + vo.getSeq();
//
//			return jdbcTemplate.update(sql);
//		}
//
//		class BoardRowMapper implements RowMapper<BoardVO> {	//interface 상속 받음
//			@Override
//			public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
//				BoardVO vo = new BoardVO();
//				vo.setSeq(rs.getInt("seq"));
//				vo.setTitle(rs.getString("title"));
//				vo.setContent(rs.getString("content"));
//				vo.setWriter(rs.getString("writer"));
//				vo.setCategory(rs.getString("category"));
//				vo.setRegdate(rs.getDate("regdate"));
//				return vo;
//			}
//		}
//
//		public BoardVO getBoard(int seq) {
//			String sql = "select * from BOARD where seq=" + seq;
//			return jdbcTemplate.queryForObject(sql, new BoardRowMapper());
//		}
//
//		public List<BoardVO> getBoardList() {
//			String sql = "select * from BOARD order by regdate desc";
//			return jdbcTemplate.query(sql, new BoardRowMapper());
//		}
//	}
