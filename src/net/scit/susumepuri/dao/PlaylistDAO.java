package net.scit.susumepuri.dao;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import net.scit.susumepuri.vo.Playlist;
import net.scit.susumepuri.vo.Song;

public class PlaylistDAO {
	private SqlSessionFactory factory = MybatisConfig.getSqlSessionFactory(); 
	
	public int insertPlaylist(Playlist playlist) {
		SqlSession session = factory.openSession();
		PlaylistMapper mapper = session.getMapper(PlaylistMapper.class);
		
		int result = mapper.insertPlaylist(playlist);
		session.commit();
		return result;
	}
	
	public List<Song> getPlaylist(String memberId) {
		SqlSession session = factory.openSession();
		PlaylistMapper mapper = session.getMapper(PlaylistMapper.class);
		
		List<Song> list = mapper.getPlaylist(memberId);
		return list;
	}
	
	public List<Playlist> getAll() {
		SqlSession session = factory.openSession();
		PlaylistMapper mapper = session.getMapper(PlaylistMapper.class);
		
		List<Playlist> list = mapper.getAll();
		return list;
	}
	
	public int updatePlaylist(Playlist playlist) {
		SqlSession session = factory.openSession();
		PlaylistMapper mapper = session.getMapper(PlaylistMapper.class);
		
		int result = mapper.updatePlaylist(playlist);
		session.commit();
		return result;
	}
	
	public int deletePlaylist(Playlist playlist) {
		SqlSession session = factory.openSession();
		PlaylistMapper mapper = session.getMapper(PlaylistMapper.class);
		
		int result = mapper.deletePlaylist(playlist);
		session.commit();
		return result;
	}
	
	public int countPlaylist() {
		SqlSession session = factory.openSession();
		PlaylistMapper mapper = session.getMapper(PlaylistMapper.class);
		
		int result = mapper.countPlaylist();
		return result;
	}

	public int checkDuplicate(Playlist playlist) {
		SqlSession session = factory.openSession();
		PlaylistMapper mapper = session.getMapper(PlaylistMapper.class);

		int result = mapper.checkDuplicate(playlist);
		return result;
	}

	
}
