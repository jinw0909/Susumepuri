package net.scit.susumepuri.vo;

public class Song {
	private int songId;
	private String singer;
	private String songName;
	private String genreId;
	private String releaseYear;
	private String mbti;

	public Song() {
		super();
	}

	public Song(int songId, String singer, String songName, String genreId, String releaseYear, String mbti) {
		super();
		this.songId = songId;
		this.singer = singer;
		this.songName = songName;
		this.genreId = genreId;
		this.releaseYear = releaseYear;
		this.mbti = mbti;
	}

	public int getSongId() {
		return songId;
	}

	public void setSongId(int songId) {
		this.songId = songId;
	}

	public String getSinger() {
		return singer;
	}

	public void setSinger(String singer) {
		this.singer = singer;
	}

	public String getSongName() {
		return songName;
	}

	public void setSongName(String songName) {
		this.songName = songName;
	}

	public String getGenreId() {
		return genreId;
	}

	public void setGenreId(String genreId) {
		this.genreId = genreId;
	}

	public String getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(String releaseYear) {
		this.releaseYear = releaseYear;
	}

	public String getMbti() {
		return mbti;
	}

	public void setMbti(String mbti) {
		this.mbti = mbti;
	}

	@Override
	public String toString() {
		return "songID: " + songId + "- 가수 : " + singer + ", 노래 제목 : " + songName ;
	}

}
