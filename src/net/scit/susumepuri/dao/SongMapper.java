package net.scit.susumepuri.dao;

import java.util.List;
import java.util.Map;

import net.scit.susumepuri.vo.Song;

public interface SongMapper {
	// °î »ðÀÔ
	public int insertSong(Song song);

//	public int getSong(int songId);

	// ÀüÃ¼ °î Ãâ·Â
	public List<Song> getAllSong();

	// Àå¸£º°·Î °î »Ì±â
	public Song getSongByGenre(String genreId);

	public List<Song> getSongByName(String name);
	
	// °î ¾÷µ¥ÀÌÆ®
	public int updateSong(Song song);

	// °î »èÁ¦
	public int deleteSong(int songId);

	// °î ¼ö ¼¼±â
	public int countSong();

	public List<Song> getAllBA();

	public List<Song> getAllHI();

	public List<Song> getAllDA();

	public List<Song> getAllRO();

	public List<Song> getAllCL();

	public List<Song> getSongByMbti(Map<String, String> map);
}
