package net.scit.susumepuri.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import net.scit.susumepuri.dao.MemberDAO;
import net.scit.susumepuri.dao.PlaylistDAO;
import net.scit.susumepuri.dao.SongDAO;
import net.scit.susumepuri.service.SusumepuriService;
import net.scit.susumepuri.vo.Member;
import net.scit.susumepuri.vo.Playlist;
import net.scit.susumepuri.vo.Song;

public class SusumepuriUI {
	Scanner scanner = new Scanner(System.in);
	MemberDAO memberDAO = new MemberDAO();
	PlaylistDAO playlistDAO = new PlaylistDAO();
	SongDAO songDAO = new SongDAO();
	String memberid;
	String nickname;
	String mbti;
	public SusumepuriUI() {
		susumepuriLogin();
	}

	private void susumepuriLogin() {
		String choice;
		while (true) {
			System.out.println("               **Susumepuri**");
			System.out.println("�ȳ��ϼ���! Susumepuri�� ���� ������ �뷡 ��õ �����Դϴ�!");
			System.out.println();
			System.out.println("                 �� �α���");
			System.out.println();
			System.out.println("          ȸ���� �ƴϽö�� ȸ�������� ���͵帮�ڽ��ϴ�.");
			System.out.println("**ȸ�� ����� �Ͻø� ����� ��ü���� �뷡 ��õ�� ������ �� �ֽ��ϴ�.");
			System.out.println();
			System.out.println("                  �� ȸ������");
			System.out.println();
			System.out.print("                   ���� > ");
			choice = scanner.nextLine();

			switch (choice) {
				case "1":
					login();
					break;
				case "2":
					regist();
					break;
				default:
					System.out.println("�޴��� �ٽ� �������ּ���");
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
					genreRecommend();
					break;
				case "2":
					myPlaylist();
					break;
				case "3":
					recommendForYou(this.mbti);
					break;
				case "4":
					othersPlaylist();
					break;
				case "5":
					delete();
					break;
				case "0":
					System.out.println("** ���� �������� �α׾ƿ��մϴ�.");
					return;
				default:
					System.out.println("�޴� ���� �ٽ�!");
			}
			System.out.println("\n** ��� �����Ͻ÷��� ����Ű�� �����ּ��� **");
			scanner.nextLine();
		}
	}

	private void login() {
		String memberid, password;
		System.out.println("** �α��� **");
		System.out.print("���̵� : ");
		memberid = scanner.nextLine();
		while (memberid.isEmpty()) {
			System.out.println("���̵� �Է����ּ���");
			System.out.print("���̵� : ");
			memberid = scanner.nextLine();
		}
		System.out.print("��й�ȣ : ");
		password = scanner.nextLine();
		while (password.isEmpty()) {
			System.out.println("��й�ȣ�� �Է����ּ���");
			System.out.print("��й�ȣ : ");
			password = scanner.nextLine();
		}
		Member member = memberDAO.login(memberid, password);
		if (member != null) {
			System.out.println("** �α��� ���� **");
			this.memberid = member.getMemberId();
			this.nickname = member.getNickname();
			this.mbti = member.getMbti();
			System.out.println("** " + this.nickname + "�� Susumepuri�� ���� ���� ȯ���մϴ� **");
			susumepuriUIMain();
		} else {
			System.out.println();
			System.out.println("** ���̵�� ��й�ȣ�� Ȯ�����ּ���");
			System.out.println();
		}

	}

	private void regist() {
		String memberId, password, nickname, mbti, genreId;
		String passwordConfirm;

		System.out.println("**ȸ�� ����� �Ͻø� ����� ��ü���� �뷡 ��õ�� ������ �� �ֽ��ϴ�.");
		System.out.print("ID : ");
		memberId = scanner.nextLine();
		while (memberId.isEmpty()) {
			System.out.println("���̵� �Է����ּ���");
			System.out.print("ID : ");
			memberId = scanner.nextLine();
		}

		while (idCheck(memberId)) {
			System.out.println();
			System.out.println("�ߺ��� ���̵� �ֳ׿�! �ٸ� ���̵� �Է��� �ּ���.");
			System.out.print("ID : ");
			memberId = scanner.nextLine();
		}

		if (memberId != null) {
			System.out.println("�Է��Ͻ� ���̵�� " + memberId + "�Դϴ�.");
			System.out.println();
		}

		System.out.print("��й�ȣ : ");
		password = scanner.nextLine();
		while (password.isEmpty()) {
			System.out.println("��й�ȣ�� �Է����ּ���");
			System.out.print("��й�ȣ : ");
			password = scanner.nextLine();
		}

		System.out.print("��й�ȣ Ȯ�� : ");
		passwordConfirm = scanner.nextLine();
		while (!password.equals(passwordConfirm)) {
			System.out.println("** ��й�ȣ�� Ȯ�����ּ���");
			System.out.print("��й�ȣ Ȯ�� : ");
			passwordConfirm = scanner.nextLine();
		}

		System.out.print("�г��� : ");
		nickname = scanner.nextLine();

		if (memberId != null) {
			System.out.println("�Է��Ͻ� �г����� " + nickname + "�Դϴ�.");
			System.out.println();
		}

		System.out.print("MBTI : ");
		mbti = takeMbti();

		if (mbti != null) {
			System.out.println("�Է��Ͻ� MBTI�� " + mbti + "�Դϴ�.");
			System.out.println();
		}

		System.out.print("�����ϴ� �帣 : ");
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
			System.out.println("�����մϴ�. ȸ�������� �Ϸ�Ǿ����ϴ�!");
			System.out.println("**����Ͻ� ���̵�� ��й�ȣ�� �α��� ���ּ���");
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

		System.out.println("�����Ͻ� �帣�� �뷡�� ��õ�� �帳�ϴ�");
		System.out.println("�� �߶��(BA) �� ����(HI) �� ��(DA) �� ��(RO) �� Ŭ����(CL)");
		System.out.print("��ȣ�� ������ �ּ��� > ");
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

	// System.out.println("�뷡�� ������ ��Ŵٸ� ȸ������ �÷��̸���Ʈ�� �߰��ص� �� �ֽ��ϴ�.");
//	}

	private void myPlaylist() {
		while(true) {
			List<Song> playlist = new ArrayList<Song>();
			System.out.println("** ������ �÷��̸���Ʈ ��ȸ **");
			String memberId = this.memberid;
			System.out.println("** " + this.nickname + "���� �÷��̸���Ʈ�Դϴ� > ");
			List<Song> list = playlistDAO.getPlaylist(memberId);
			if (list.isEmpty()) System.out.println("* �÷��̸���Ʈ�� ����ֽ��ϴ�.");
			for (int i = 0; i < list.size(); ++i) {
				System.out.println(list.get(i));
			}
			System.out.println("�� �÷��̸���Ʈ�� �뷡 �߰�  �� �÷��̸���Ʈ���� �뷡 ����  �� ���� �޴���");
			System.out.print("���� > ");
			String choice = scanner.nextLine();
			switch (choice) {
				case "1" :
					System.out.println(" ** �뷡 �߰� ** ");
					addPlaylist(playlist);
					break;
				case "2" :
					System.out.println("** �뷡 ���� **");
					deleteFromPlaylist(list);
					break;
				case "3" :
					System.out.println("���� �޴��� ���ư��ϴ�.");
					return;
				default :
					System.out.println("�޴��� �ٽ� �������ּ���");
			}
		}


	}

	private void recommendForYou(String mbti) {
		new SusumepuriService(mbti);
	}

	private void othersPlaylist() {
		List<Song> playlist = new ArrayList<Song>();
		System.out.println("** ģ���� �÷��̸���Ʈ ��ȸ **");
		System.out.print("** �÷��̸���Ʈ�� ��ȸ�Ͻ� ģ���� ���̵� �Է����ּ��� : ");
		String friendId = scanner.nextLine();

		Member friend = memberDAO.findById(friendId);
		if (friend != null) {
			System.out.println("** " + friend.getMemberId() + "���� �÷��̸���Ʈ�Դϴ� **");
		} else {
			System.out.println("��ȸ�Ͻ� ���̵��� ȸ���� �������� �ʽ��ϴ�.");
		}
		List<Song> list = playlistDAO.getPlaylist(friend.getMemberId());
		for (int i = 0; i < list.size(); ++i) {
			System.out.println(i + ")" + list.get(i));
		}

		System.out.println("** �߰� �޴�");
		while (true) {
			System.out.println("�� ģ���� �÷��̸���Ʈ�� ���ƿ� �߰�  �� ���� �޴���");
			System.out.print("���� : ");
			String choice = scanner.nextLine();
			switch (choice) {
				case "1":

					break;
				case "2":
					System.out.println("** ���� �޴��� ���ư��ϴ�");
					return;
				default:
					System.out.println("�ùٸ� ���� �Է����ּ���");
			}
		}
	}

	private void delete() {
		String memberId, answer;

		int count = memberDAO.countMember();
		if (count == 0) {
			System.out.println("������ ȸ���� �����ϴ�.");
			return;
		}

		System.out.println("���� Ż���Ͻ� �ǰ���? (Y/N)");
		System.out.print(">");
		answer = scanner.nextLine();
		System.out.println();

		if (!answer.equals("Y")) {
			System.out.println("Ż�� ��ҵǾ����ϴ�.");
			System.out.println("�����մϴ�! �� ������ �ҰԿ�!");
			return;
		} else {

			System.out.println("������ ���̵� �Է��� �ּ���");
			System.out.print(">");
			memberId = scanner.nextLine();
			System.out.println();

			Member member = memberDAO.findById(memberId);
			if (member == null) {
				System.out.println("�Է��� ���̵�� �������� �ʳ׿�!");
				System.out.println();
				return;
			}

			System.out.println(member);
			System.out.println();

			System.out.println("������ Ż���Ͻ� �ǰ���? (Y/N)");
			System.out.print(">");
			answer = scanner.nextLine();
			System.out.println();

			if (!answer.equals("Y")) {
				System.out.println("Ż�� ��ҵǾ����ϴ�.");
				System.out.println("�����մϴ�! �� ������ �ҰԿ�!");
				return;
			}
			int result = memberDAO.deleteMember(memberId);

			System.out.printf("** Ż��Ǿ����ϴ�.%n", result);
		}
	}

	private void menu() {
		System.out.println();
		System.out.println("               **Susumepuri**");
		System.out.println("");
		System.out.println("                <1. �帣�� ��õ>");
		System.out.println("            <2. ������ �÷��̸���Ʈ ��ȸ>");
		System.out.println("            <3. ȸ���Ը��� ���� �뷡 ��õ>");
		System.out.println("            <4. ģ������ �÷��̸���Ʈ ��ȸ>");
		System.out.println("                <5. ȸ�� Ż��>");
		System.out.println("                  <0. �α� �ƿ�>");
		System.out.println("-----------------------------------------------");
		System.out.print("                �޴� ���� > ");
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
				System.out.println("err) �ùٸ� MBTI�� �Է����ּ���");
			}
		}
	}

	private String takeGenre() {
		while (true) {
			System.out.println("1) �߶��  2) ����  3) ��  4) ��  5) Ŭ����");
			System.out.print(">���� : ");
			String choice = scanner.nextLine();
			switch (choice) {
			case "1":
				System.out.println("�Է��Ͻ� ��ȣ �帣�� �߶���Դϴ�.");
				System.out.println();
				return "BA";
			case "2":
				System.out.println("�Է��Ͻ� ��ȣ �帣�� �����Դϴ�.");
				System.out.println();
				return "HI";
			case "3":
				System.out.println("�Է��Ͻ� ��ȣ �帣�� ���Դϴ�.");
				System.out.println();
				return "DA";
			case "4":
				System.out.println("�Է��Ͻ� ��ȣ �帣�� ���Դϴ�.");
				System.out.println();
				return "RO";
			case "5":
				System.out.println("�Է��Ͻ� ��ȣ �帣�� Ŭ�����Դϴ�.");
				System.out.println();
				return "CL";
			default:
				System.out.println("�ùٸ� ���ڸ� �Է����ּ���");
				System.out.println();
			}
		}
	}

	private List<Song> getSongByName() {
		System.out.println("**�߰��� ����� �˻��մϴ�");
		System.out.print("�뷡 ���� �Է� : ");
		String name = scanner.nextLine();
		List<Song> list = songDAO.getSongByName(name);
		for (int i = 0; i < list.size(); ++i) {
			System.out.println(i + ") " + list.get(i));
		}
		return list;
	}
	private void addPlaylist(List<Song> playlist) {
		while (true) {
			System.out.println("1) �÷��̸���Ʈ�� �뷡 �߰�  2) ���� �޴���");
			System.out.print("����(��/��) : ");
			String choice = scanner.nextLine();
			switch (choice) {
				case "1":
					playlist = getSongByName();
					System.out.print("�÷��̸���Ʈ�� ����ϰ��� �ϴ� �뷡�� ��ȣ�� �Է����ּ��� > ");
					choice = scanner.nextLine();
					for (int i = 0; i < playlist.size(); ++i) {
						if (Integer.parseInt(choice) == i) {
							Song song = playlist.get(i);
							Playlist pl = new Playlist(this.memberid, song.getSongId());
							System.out.print("����Ͻ÷��� �뷡�� ");
							System.out.println(song.getSinger() + "�� " + song.getSongName() + "�Դϴ�.");
							System.out.println("y) �÷��̸���Ʈ�� �߰�  n) ���");
							System.out.print("����(��/��) : ");
							while (true) {

								choice = scanner.nextLine();
								switch (choice) {
									case "y":
										int flag = playlistDAO.checkDuplicate(pl);
										if (flag > 0) {
											System.out.println("�̹� ���� �뷡�� �÷��̸���Ʈ�� ��ϵǾ��ֽ��ϴ�.");
											return;
										}
										int result = playlistDAO.insertPlaylist(pl);
										if (result > 0)
											System.out.println(result + "���� �뷡�� �÷��̸���Ʈ�� �߰��Ǿ����ϴ�.");
											return;
									case "n":
										return;
									default:
										System.out.println("y �Ǵ� n�� �Է����ּ���");
								}
							}
						}
					}
					break;
				case "2":
					System.out.println("���� �޴��� ���ư��ϴ�");
					return;
				default:
					System.out.println("�ùٸ� �������� �Է����ּ���");
			}

		}
	}

	private void deleteFromPlaylist(List<Song> list) {
		System.out.println("** �÷��̸���Ʈ���� �뷡 ���� **");
		for (int i = 0; i < list.size(); ++i) {
			System.out.println(i + ") " + list.get(i).getSongName() + " by " + list.get(i).getSinger());
		}
		System.out.print("** ������ �뷡�� ��ȣ�� �Է� : ");
		String index = scanner.nextLine();
		Song songToDelete = list.get(Integer.parseInt(index));
		System.out.println("�÷��̸���Ʈ���� �����Ϸ��� �뷡�� " + songToDelete.getSinger() + "�� " + songToDelete.getSongName() + "�Դϴ�.");
		System.out.println("y) ����  n) ���");
		System.out.print("����(��/��) : ");
		String choice = scanner.nextLine();
		if (choice.equals("y")) {
			Playlist pl = new Playlist(this.memberid, songToDelete.getSongId());
			playlistDAO.deletePlaylist(pl);
		} else {
			return;
		}
	}

}
