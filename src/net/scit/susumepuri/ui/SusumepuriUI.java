package net.scit.susumepuri.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import net.scit.susumepuri.dao.MemberDAO;
import net.scit.susumepuri.dao.PlaylistDAO;
import net.scit.susumepuri.dao.SongDAO;
import net.scit.susumepuri.vo.Member;
import net.scit.susumepuri.vo.Playlist;
import net.scit.susumepuri.vo.Song;

public class SusumepuriUI {
	Scanner scanner = new Scanner(System.in);
	MemberDAO memberDAO = new MemberDAO();
	PlaylistDAO playlistDAO = new PlaylistDAO();
	SongDAO songDAO = new SongDAO();
	String memberid;
	public SusumepuriUI() {
		susumepuriLogin();
	}

	private void susumepuriLogin() {
		String choice;
		while (true) {
			System.out.println("               **Susumepuri**");
			System.out.println("안녕하세요! Susumepuri는 개인 맞춤형 노래 추천 서비스입니다!");
			System.out.println();
			System.out.println("                  1. 로그인");
			System.out.println();
			System.out.println("          회원이 아니시라면 회원가입을 도와드리겠습니다.");
			System.out.println("**회원 등록을 하시면 더욱더 구체적인 노래 추천을 받으실 수 있습니다.");
			System.out.println();
			System.out.println("                  2. 회원가입");
			System.out.println();
			System.out.print("                   선택 > ");
			choice = scanner.nextLine();

			switch (choice) {
				case "1":
					login();
					break;
				case "2":
					regist();
					break;
				default:
					System.out.println("메뉴를 다시 선택해주세요");
			}
		}
	}

	private void susumepuriUIMain() {
		String choice;
		while (true) {
			menu();
			choice = scanner.nextLine();
			switch (choice) {
				case "1":
					regist();
					break;
				case "2":
					genreRecommend();
					break;
				case "3":
					myPlaylist();
					break;
				case "4":
					recommendForYou();
					break;
				case "5":
					othersPlaylist();
					break;
				case "6":
					delete();
					break;
				case "0":
					System.out.println("** 프로그램을 종료합니다.");
					return;
				default:
					System.out.println("메뉴 선택 다시!");
			}
			System.out.println("메뉴를 다시 보시려면 엔터키를 눌러주세요");
			scanner.nextLine();
		}
	}

	private void login() {
		String memberid, password;
		System.out.println("** 로그인");
		System.out.print("아이디 : ");
		memberid = scanner.nextLine();
		System.out.print("비밀번호 : ");
		password = scanner.nextLine();
		Member member = memberDAO.login(memberid, password);
		if (member != null) {
			System.out.println("**로그인 성공");
			this.memberid = member.getMemberId();
			susumepuriUIMain();
		}

	}

	private void regist() {
		String memberId, password, nickname, mbti, genreId;
		String passwordConfirm;

		System.out.println("**회원 등록을 하시면 더욱더 구체적인 노래 추천을 받으실 수 있습니다.");
		System.out.print("ID : ");
		memberId = scanner.nextLine();

		if (idCheck(memberId)) {
			System.out.println();
			System.out.println("중복된 아이디가 있네요! 다른 아이디를 입력해 주세요.");
			return;
		}

		if (memberId != null) {
			System.out.println("입력하신 아이디는 " + memberId + "입니다.");
			System.out.println();
		}

		System.out.print("비밀번호 : ");
		password = scanner.nextLine();
		System.out.print("비밀번호 확인 : ");
		passwordConfirm = scanner.nextLine();
		if (!password.equals(passwordConfirm)) {
			System.out.println("** 비밀번호를 확인해주세요");
			return;
		}

		System.out.print("닉네임 : ");
		nickname = scanner.nextLine();

		if (memberId != null) {
			System.out.println("입력하신 닉네임은 " + nickname + "입니다.");
			System.out.println();
		}

		System.out.print("MBTI : ");
		mbti = takeMbti();

		if (mbti != null) {
			System.out.println("입력하신 MBTI는 " + mbti + "입니다.");
			System.out.println();
		}

		System.out.print("좋아하는 장르 : ");
		genreId = takeGenre();

		Member member = new Member();
		member.setMemberId(memberId);
		member.setPassword(password);
		member.setNickname(nickname);
		member.setMbti(mbti);
		member.setGenreId(genreId);

		System.out.println(member);
		int result = memberDAO.insertMember(member);

		if (result > 0) {
			System.out.println("감사합니다. 회원가입이 완료되었습니다!");
			susumepuriUIMain();
		}
	}

	private boolean idCheck(String memberId) {
		Member member = memberDAO.findById(memberId);
		if (member != null) {
			return true;
		}
		return false;
	}

	private void genreRecommend() {
		String choice;

		System.out.println("선택하신 장르의 노래를 추천해 드립니다");
		System.out.println("1) 발라드(BA) 2) 힙합(HI) 3) 댄스(DA) 4) 락(RO) 5) 클래식(CL)");
		System.out.print("번호를 선택해 주세요 > ");
		choice = scanner.nextLine();

		switch (choice) {
		case "1":
			List<Song> songBA = songDAO.getAllBA();

			for (Song s : songBA) {
				System.out.println(s);
			}
			break;
		case "2":
			List<Song> songHI = songDAO.getAllHI();

			for (Song s : songHI) {
				System.out.println(s);
			}
			break;
		case "3":
			List<Song> songDA = songDAO.getAllDA();

			for (Song s : songDA) {
				System.out.println(s);
			}
			break;
		case "4":
			List<Song> songRO = songDAO.getAllRO();

			for (Song s : songRO) {
				System.out.println(s);
			}
			break;
		case "5":
			List<Song> songCL = songDAO.getAllCL();

			for (Song s : songCL) {
				System.out.println(s);
			}
			break;
		}
	}

	// System.out.println("노래가 마음에 드신다면 회원님의 플레이리스트에 추가해둘 수 있습니다.");
//	}

	private void myPlaylist() {
		List<Song> playlist = new ArrayList<Song>();
		System.out.println("**나만의 플레이리스트 조회**");
		String memberId = this.memberid;
		System.out.println(memberid + "님의 플레이리스트입니다 > ");
		List<Song> list = playlistDAO.getPlaylist(memberId);
		for (int i = 0; i < list.size(); ++i) {
			System.out.println(i + ")" + list.get(i));
		}

		System.out.println("**추가 메뉴");
		while (true) {
			System.out.println("1) 플레이리스트에 노래 추가  2) 플레이리스트에서 노래 삭제  3) 이전 메뉴로");
			System.out.print("선택(1/2/3) : ");
			String choice = scanner.nextLine();
			switch (choice) {
			case "1":
				playlist = getSongByName();
				break;
			case "2":
				deleteFromPlaylist();
				break;
			case "3":
				System.out.println("메인 메뉴로 돌아갑니다");
				return;
			default:
				System.out.println("올바른 값을 입력해주세요");
			}
			System.out.println("플레이리스트에 등록하고자 하는 노래의 번호를 입력해주세요");
			choice = scanner.nextLine();
			for (int i = 0; i < playlist.size(); ++i) {
				if (Integer.parseInt(choice) == i) {
					Song song = playlist.get(i);
					Playlist pl = new Playlist(this.memberid, song.getSongId());
					System.out.print("등록하시려는 노래는 ");
					System.out.println(song.getSinger() + "의 " + song.getSongName() + "입니다.");
					System.out.println("y) 플레이리스트에 추가  n) 다시 검색하기");
					System.out.print("선택(y/n) : ");
					choice = scanner.nextLine();
					switch (choice) {
					case "y":
						int result = playlistDAO.insertPlaylist(pl);
						if (result > 0)
							System.out.println(result + "개의 노래가 플레이리스트에 추가되었습니다.");
						break;
					case "n":
						return;
					default:
						System.out.println("y또는 n을 입력해주세요");
					}
					break;
				}
			}

		}
	}

	private void recommendForYou() {
		// TODO Auto-generat
	}

	private void othersPlaylist() {
		// TODO Auto-generated method stub
	}

	private void delete() {
		String memberId, answer;

		int count = memberDAO.countMember();
		if (count == 0) {
			System.out.println("가입한 회원이 없습니다.");
			return;
		}

		System.out.println("정말 탈퇴하실 건가요? (Y/N)");
		System.out.print(">");
		answer = scanner.nextLine();
		System.out.println();

		if (!answer.equals("Y")) {
			System.out.println("탈퇴가 취소되었습니다.");
			System.out.println("감사합니다! 더 열심히 할게요!");
			return;
		} else {

			System.out.println("삭제할 아이디를 입력해 주세요");
			System.out.print(">");
			memberId = scanner.nextLine();
			System.out.println();

			Member member = memberDAO.findById(memberId);
			if (member == null) {
				System.out.println("입력한 아이디는 존재하지 않네요!");
				System.out.println();
				return;
			}

			System.out.println(member);
			System.out.println();

			System.out.println("정말로 탈퇴하실 건가요? (Y/N)");
			System.out.print(">");
			answer = scanner.nextLine();
			System.out.println();

			if (!answer.equals("Y")) {
				System.out.println("탈퇴가 취소되었습니다.");
				System.out.println("감사합니다! 더 열심히 할게요!");
				return;
			}
			int result = memberDAO.deleteMember(memberId);

			System.out.printf("** 탈퇴되었습니다.%n", result);
		}
	}

	private void menu() {
		System.out.println();
		System.out.println("               **Susumepuri**");
		System.out.println("");
		System.out.println("                <1. 장르별 추천>");
		System.out.println("            <2. 나만의 플레이리스트 조회>");
		System.out.println("            <3. 회원님만을 위한 노래 추천>");
		System.out.println("            <4. 친구들의 플레이리스트 조회>");
		System.out.println("                <5. 회원 탈퇴>");
		System.out.println("                  <0. 종료>");
		System.out.println("-----------------------------------------------");
		System.out.print("                메뉴 선택 > ");
	}

	private String takeMbti() {
		while (true) {
			String mbti = scanner.nextLine();
			switch (mbti) {
			case "ESTJ":
				mbti = "ESTJ";
				return mbti;
			case "ESTP":
				mbti = "ESTP";
				return mbti;
			case "ESFJ":
				mbti = "ESFJ";
				return mbti;
			case "ESFP":
				mbti = "ESFP";
				return mbti;
			case "ENTJ":
				mbti = "ENTJ";
				return mbti;
			case "ENTP":
				mbti = "ENTP";
				return mbti;
			case "ENFJ":
				mbti = "ENFJ";
				return mbti;
			case "ENFP":
				mbti = "ENFP";
				return mbti;
			case "ISTJ":
				mbti = "ISTJ";
				return mbti;
			case "ISTP":
				mbti = "ISTP";
				return mbti;
			case "ISFJ":
				mbti = "ISFJ";
				return mbti;
			case "ISFP":
				mbti = "ISFP";
				return mbti;
			case "INTJ":
				mbti = "INTJ";
				return mbti;
			case "INTP":
				mbti = "INTP";
				return mbti;
			case "INFJ":
				mbti = "INFJ";
				return mbti;
			case "INFP":
				mbti = "INFP";
				return mbti;
			default:
				System.out.println("err) 올바른 MBTI를 입력해주세요");
			}
		}
	}

	private String takeGenre() {
		while (true) {
			System.out.println("1) 발라드  2) 힙합  3) 댄스  4) 락  5) 클래식");
			System.out.print(">선택 : ");
			String choice = scanner.nextLine();
			switch (choice) {
			case "1":
				System.out.println("입력하신 선호 장르는 발라드입니다.");
				System.out.println();
				return "BA";
			case "2":
				System.out.println("입력하신 선호 장르는 힙합입니다.");
				System.out.println();
				return "HI";
			case "3":
				System.out.println("입력하신 선호 장르는 댄스입니다.");
				System.out.println();
				return "DA";
			case "4":
				System.out.println("입력하신 선호 장르는 락입니다.");
				System.out.println();
				return "RO";
			case "5":
				System.out.println("입력하신 선호 장르는 클래식입니다.");
				System.out.println();
				return "CL";
			default:
				System.out.println("올바른 숫자를 입력해주세요");
				System.out.println();
			}
		}
	}

	private List<Song> getSongByName() {
		System.out.println("**추가할 곡명을 검색합니다");
		System.out.print("노래 제목 입력 : ");
		String name = scanner.nextLine();
		List<Song> list = songDAO.getSongByName(name);
		for (int i = 0; i < list.size(); ++i) {
			System.out.println(i + ") " + list.get(i));
		}
		return list;
	}

	private int deleteFromPlaylist() {
		return 0;
	}

}
