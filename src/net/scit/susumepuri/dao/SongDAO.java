package net.scit.susumepuri.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import net.scit.susumepuri.vo.Member;
import net.scit.susumepuri.vo.Song;

public class SongDAO {
	private SqlSessionFactory factory = MybatisConfig.getSqlSessionFactory();

	 public List<Song> getSongByName(String name) {
	        SqlSession session = factory.openSession();
	        SongMapper mapper = session.getMapper(SongMapper.class);

	        List<Song> list = mapper.getSongByName(name);
	        return list;
	    }

	
	public int insertSong(Song song) {
		SqlSession session = null;

		session = factory.openSession();
		SongMapper mapper = session.getMapper(SongMapper.class);

		int result = mapper.insertSong(song);
		session.commit();

		return result;
	}

//	public int getSong(String songId) {
//		SqlSession session = factory.openSession();
//		SongMapper mapper = session.getMapper(SongMapper.class);
//
//		int result = mapper.getSong(null);
//		return result;
//	}

	public List<Song> getAllSong() {
		SqlSession session = null;
		session = factory.openSession();

		SongMapper mapper = session.getMapper(SongMapper.class);

		List<Song> list = mapper.getAllSong();

		return list;
	}

	public Song getSongByGenre(String genreId) {
		 SqlSession session = null;
		 session = factory.openSession();
		 
		 SongMapper mapper = session.getMapper(SongMapper.class);
		 
		 Song song = mapper.getSongByGenre(genreId);
		 
		 return song;
	}
	
	public int updateSong(Song song) {
		SqlSession session = null;
		session = factory.openSession();

		SongMapper mapper = session.getMapper(SongMapper.class);

		int result = mapper.updateSong(song);
		session.commit();

		return result;
	}

	public int deleteSong(int songId) {
		SqlSession session = null;
		session = factory.openSession();

		SongMapper mapper = session.getMapper(SongMapper.class);

		int result = mapper.deleteSong(songId);
		session.commit();

		return result;
	}

	public int countSong() {
		SqlSession session = null;
		session = factory.openSession();
		
		SongMapper mapper = session.getMapper(SongMapper.class);

		int result = mapper.countSong();
		
		return result;
	}

	public Member findById(String memberId) {
		SqlSession session = null;
		session = factory.openSession();

		MemberMapper mapper = session.getMapper(MemberMapper.class);

		Member member = mapper.findById(memberId);

		return member;
	}
	
	public List<Song> getAllBA() {
		 SqlSession session = null;
		 session = factory.openSession();
		 
		 SongMapper mapper = session.getMapper(SongMapper.class);
		 
		 List<Song> list = mapper.getAllBA();
		 
		 return list;
	}
	
	public List<Song> getAllHI() {
		 SqlSession session = null;
		 session = factory.openSession();
		 
		 SongMapper mapper = session.getMapper(SongMapper.class);
		 
		 List<Song> list = mapper.getAllHI();
		 
		 return list;
	}
	
	public List<Song> getAllDA() {
		 SqlSession session = null;
		 session = factory.openSession();
		 
		 SongMapper mapper = session.getMapper(SongMapper.class);
		 
		 List<Song> list = mapper.getAllDA();
		 
		 return list;
	}
	
	public List<Song> getAllRO() {
		 SqlSession session = null;
		 session = factory.openSession();
		 
		 SongMapper mapper = session.getMapper(SongMapper.class);
		 
		 List<Song> list = mapper.getAllRO();
		 
		 return list;
	}
	
	public List<Song> getAllCL() {
		 SqlSession session = null;
		 session = factory.openSession();
		 
		 SongMapper mapper = session.getMapper(SongMapper.class);
		 
		 List<Song> list = mapper.getAllCL();
		 
		 return list;
	}

	public List<Song> getSongByMbti(Map<String, String> map) {
		SqlSession session = null;
		session = factory.openSession();

		SongMapper mapper = session.getMapper(SongMapper.class);
		List<Song> list = mapper.getSongByMbti(map);
		return list;
	}
}
