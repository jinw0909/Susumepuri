package net.scit.susumepuri.dao;

import java.util.List;

import net.scit.susumepuri.vo.Member;

public interface MemberMapper {

	//로그인
	public Member login(Member idAndPw);

	//회원가입
	public int insertMember(Member member);

	//
	public int getMember(String memberId);

	//전체출력
	public List<Member> getAllMember();

	//수정
	public int updateMember(Member member);

	//삭제
	public int deleteMember(String id);

	//인원수 조회
	public int countMember();

	//ID로 조회
	public Member findById(String memberId);
}
