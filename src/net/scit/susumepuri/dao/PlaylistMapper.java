package net.scit.susumepuri.dao;

import java.util.List;

import net.scit.susumepuri.vo.Playlist;
import net.scit.susumepuri.vo.Song;

public interface PlaylistMapper {
	public int insertPlaylist(Playlist playlist);
	public List<Song> getPlaylist(String memberId);
	public List<Playlist> getAll();
	public int updatePlaylist(Playlist playlist);
	public int deletePlaylist(Playlist playlist);
	public int countPlaylist();
	public int checkDuplicate(Playlist playlist);

}
