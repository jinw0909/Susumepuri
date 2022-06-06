package net.scit.susumepuri.vo;

public class Member {
	private String memberId;

	private String password;
	private String nickname;
	private String mbti;
	private String genreId;

	public Member() {
		super();
	}

	public Member(String memberId, String password, String nickname, String mbti, String genreId) {
		super();
		this.memberId = memberId;
		this.password = password;
		this.nickname = nickname;
		this.mbti = mbti;
		this.genreId = genreId;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getNickname() {
		return nickname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getMbti() {
		return mbti;
	}

	public void setMbti(String mbti) {
		this.mbti = mbti;
	}

	public String getGenreId() {
		return genreId;
	}

	public void setGenreId(String genreId) {
		this.genreId = genreId;
	}

	@Override
	public String toString() {
		return "입력하신 Id는 " + memberId + ", 닉네임은 " + nickname + ", mbti는 " + mbti + ", 좋아하시는 장르는 " + genreId
				+ "입니다.";
	}

}
