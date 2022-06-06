package net.scit.susumepuri.dao;

import java.util.List;

import net.scit.susumepuri.vo.Member;

public interface MemberMapper {

	//�α���
	public Member login(Member idAndPw);

	//ȸ������
	public int insertMember(Member member);

	//
	public int getMember(String memberId);

	//��ü���
	public List<Member> getAllMember();

	//����
	public int updateMember(Member member);

	//����
	public int deleteMember(String id);

	//�ο��� ��ȸ
	public int countMember();

	//ID�� ��ȸ
	public Member findById(String memberId);
}
