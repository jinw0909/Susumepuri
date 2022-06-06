package net.scit.susumepuri.vo;

public class Playlist {
	private String memberid;
	private int songid;

	public Playlist() {
		super();
	}

	public Playlist(String memberid, int songid) {
		super();
		this.memberid = memberid;
		this.songid = songid;
	}

	public String getMemberid() {
		return memberid;
	}

	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}

	public int getSongid() {
		return songid;
	}

	public void setSongid(int songid) {
		this.songid = songid;
	}

	@Override
	public String toString() {
		return "Playlist [memberid=" + memberid + ", songid=" + songid + "]";
	}

	
}
