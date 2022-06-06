package net.scit.susumepuri.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;


public class GenreDAO {
	SqlSessionFactory factory = MybatisConfig.getSqlSessionFactory();
	
	public int getGenre(String genreId) {
		SqlSession session = null;
		session = factory.openSession();
		
		GenreMapper mapper = session.getMapper(GenreMapper.class);
		
		int result = mapper.getGenre(genreId);
		return result;
	}
	

	
}
