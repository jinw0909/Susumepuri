package net.scit.susumepuri.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import net.scit.susumepuri.vo.Member;

public class MemberDAO {
	private SqlSessionFactory factory = MybatisConfig.getSqlSessionFactory();

	public Member login(String memberid, String password) {
		SqlSession session = null;
		session = factory.openSession();
		MemberMapper mapper = session.getMapper(MemberMapper.class);
		Member idAndPw = new Member();
		idAndPw.setMemberId(memberid);
		idAndPw.setPassword(password);

		Member member = mapper.login(idAndPw);
		return member;

	}
	public int insertMember(Member member) {
		SqlSession session = null;
		session = factory.openSession();
		
		MemberMapper mapper = session.getMapper(MemberMapper.class);
		int result = mapper.insertMember(member);
		
		session.commit();
		
		return result;
	}

	public int getMember(String memberId) {
		SqlSession session = null;
		session = factory.openSession();
		
		MemberMapper mapper = session.getMapper(MemberMapper.class);
		int result = mapper.getMember(null);
		
		return result;
	}

	public List<Member> getAllMember() {
		SqlSession session = null;
		session = factory.openSession();
		
		MemberMapper mapper = session.getMapper(MemberMapper.class);
		List<Member> list = mapper.getAllMember();
		
		return list;
	}

	public int updateMember(Member member) {
		SqlSession session = null;
		session = factory.openSession();
		
		MemberMapper mapper = session.getMapper(MemberMapper.class);
		int result = mapper.updateMember(member);
		
		return result;
	}

	public int deleteMember(String memberId) {
		SqlSession session = null;
		session = factory.openSession();

		MemberMapper mapper = session.getMapper(MemberMapper.class);

		int result = mapper.deleteMember(memberId);
		session.commit();

		return result;
	}

	public int countMember() {
		SqlSession session = null;
		session = factory.openSession();
		
		MemberMapper mapper = session.getMapper(MemberMapper.class);
		int result = mapper.countMember();
		
		return result;
	}

	public Member findById(String memberId) {
		SqlSession session = null;
		session = factory.openSession();

		MemberMapper mapper = session.getMapper(MemberMapper.class);

		Member member = mapper.findById(memberId);

		return member;
	}
}
