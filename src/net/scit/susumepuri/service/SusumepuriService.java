package net.scit.susumepuri.service;

import net.scit.susumepuri.dao.MemberDAO;
import net.scit.susumepuri.dao.PlaylistDAO;
import net.scit.susumepuri.dao.SongDAO;
import net.scit.susumepuri.vo.Song;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class SusumepuriService {
    Scanner scanner = new Scanner(System.in);

    private String mbti;

    MemberDAO memberDAO = new MemberDAO();
    PlaylistDAO playlistDAO = new PlaylistDAO();
    SongDAO songDAO = new SongDAO();
    private String choice;

    public SusumepuriService(String mbti) {
        this.mbti = mbti;
        while (true) {
            System.out.println("** ȸ���Ը��� ���� �뷡 ��õ");
            System.out.println("�� MBTI  �� ������ ��п� ���� ��õ");
            System.out.print("���� > ");
            choice = scanner.nextLine();

            switch (choice) {
                case "1" :
                    recommendByMBTI();
                    break;
                case "2" : break;
                default :
                    System.out.println("�޴��� �ٽ� �������ּ���");
            }
        }
    }

    private void recommendByMBTI() {
        String one = null, two = null;
        System.out.println("�� �� ����� ��ǥ�ϴ� ���� 2���� �Է����ּ���");
        System.out.print("ù��° ��ǥ ���� (");
        String[] mbtiArray = new String[4];
        for (int i = 0; i < 4; i++) {
            mbtiArray[i] = Character.toString(mbti.charAt(i));
            System.out.print(mbtiArray[i] + " ");
        }
        System.out.print("�߿��� �Է�) : ");


        String first = scanner.nextLine();
        for (int i = 0; i < mbtiArray.length; i++) {
            if (first.equals(mbtiArray[i])) {
                one = first;
                break;
            }
        }
        while (one == null) {
            System.out.print("ù��° ��ǥ ������ �ٽ� �Է����ּ��� : ");
            first = scanner.nextLine();
            for (int i = 0; i < mbtiArray.length; i++) {
                if (first.equals(mbtiArray[i])) {
                    one = first;
                    break;
                }
            }
        }
        System.out.print("�ι�° ��ǥ ���� (");
        for (int i = 0; i < mbtiArray.length; i++) {
            System.out.print(mbtiArray[i] + " ");
        }
        System.out.print("�߿��� �Է�) : ");
        String second = scanner.nextLine();
        for (int i = 0; i < mbtiArray.length; i++) {
            if (second.equals(mbtiArray[i])) {
                two = second;
                break;
            }
        }
        while (two == null) {
            System.out.print("�ι�° ��ǥ ������ �ٽ� �Է����ּ��� : ");
            second = scanner.nextLine();
            for (int i = 0; i < mbtiArray.length; i++) {
                if (second.equals(mbtiArray[i])) {
                    two = second;
                    break;
                }
            }
        }
        System.out.println("�Է��Ͻ� ��ǥ ������ " + first + "�� " + second + "�Դϴ�.");

        Map<String, String> map = new HashMap<String, String>();
        map.put("first", first);
        map.put("second", second);

        List<Song> list = songDAO.getSongByMbti(map);

        for (int i = 0; i < list.size(); ++i) {
            System.out.println(list.get(i));
        }




    }

}
