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
            System.out.println("** 회원님만을 위한 노래 추천");
            System.out.println("① MBTI  ② 오늘의 기분에 따른 추천");
            System.out.print("선택 > ");
            choice = scanner.nextLine();

            switch (choice) {
                case "1" :
                    recommendByMBTI();
                    break;
                case "2" : break;
                default :
                    System.out.println("메뉴를 다시 선택해주세요");
            }
        }
    }

    private void recommendByMBTI() {
        String one = null, two = null;
        System.out.println("이 중 당신을 대표하는 성향 2개를 입력해주세요");
        System.out.print("첫번째 대표 성향 (");
        String[] mbtiArray = new String[4];
        for (int i = 0; i < 4; i++) {
            mbtiArray[i] = Character.toString(mbti.charAt(i));
            System.out.print(mbtiArray[i] + " ");
        }
        System.out.print("중에서 입력) : ");


        String first = scanner.nextLine();
        for (int i = 0; i < mbtiArray.length; i++) {
            if (first.equals(mbtiArray[i])) {
                one = first;
                break;
            }
        }
        while (one == null) {
            System.out.print("첫번째 대표 성향을 다시 입력헤주세요 : ");
            first = scanner.nextLine();
            for (int i = 0; i < mbtiArray.length; i++) {
                if (first.equals(mbtiArray[i])) {
                    one = first;
                    break;
                }
            }
        }
        System.out.print("두번째 대표 성향 (");
        for (int i = 0; i < mbtiArray.length; i++) {
            System.out.print(mbtiArray[i] + " ");
        }
        System.out.print("중에서 입력) : ");
        String second = scanner.nextLine();
        for (int i = 0; i < mbtiArray.length; i++) {
            if (second.equals(mbtiArray[i])) {
                two = second;
                break;
            }
        }
        while (two == null) {
            System.out.print("두번째 대표 성향을 다시 입력헤주세요 : ");
            second = scanner.nextLine();
            for (int i = 0; i < mbtiArray.length; i++) {
                if (second.equals(mbtiArray[i])) {
                    two = second;
                    break;
                }
            }
        }
        System.out.println("입력하신 대표 성향은 " + first + "와 " + second + "입니다.");

        Map<String, String> map = new HashMap<String, String>();
        map.put("first", first);
        map.put("second", second);

        List<Song> list = songDAO.getSongByMbti(map);

        for (int i = 0; i < list.size(); ++i) {
            System.out.println(list.get(i));
        }




    }

}
