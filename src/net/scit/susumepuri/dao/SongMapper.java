package net.scit.susumepuri.dao;

import java.util.List;
import java.util.Map;

import net.scit.susumepuri.vo.Song;

public interface SongMapper {
	// �� ����
	public int insertSong(Song song);

//	public int getSong(int songId);

	// ��ü �� ���
	public List<Song> getAllSong();

	// �帣���� �� �̱�
	public Song getSongByGenre(String genreId);

	public List<Song> getSongByName(String name);
	
	// �� ������Ʈ
	public int updateSong(Song song);

	// �� ����
	public int deleteSong(int songId);

	// �� �� ����
	public int countSong();

	public List<Song> getAllBA();

	public List<Song> getAllHI();

	public List<Song> getAllDA();

	public List<Song> getAllRO();

	public List<Song> getAllCL();

	public List<Song> getSongByMbti(Map<String, String> map);
}
