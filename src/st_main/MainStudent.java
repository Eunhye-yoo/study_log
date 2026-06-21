package st_main;
import java.util.Scanner;

import st_dao.StudentManager;

public class MainStudent {

	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	StudentManager op=new StudentManager();  //methods클래스에서 메서드 불러오기

	String menu[] = {"학생추가","학생목록","학생정보수정","과목추가","과목정보수정","종료"};
	boolean check = true; //프로그램의 무한 루프 상태를 제어하는 플래그 변수
	
	// 메뉴 프린트
	while(check==true) {
		System.out.println("\n=========== REGISTER MENU ===========");
		for (int i=0; i<menu.length;i++) {
			System.out.println(" [" + (i + 1) + "] " + menu[i]);
		}
		System.out.println("=====================================");
	    System.out.print("▶ 항목 선택: ");
		int option = op.check_num(sc);  //정수 검증 메서드
		
		// 사용자의 option 선택에 따른 메서드
		switch(option) {
		
		case 1:
			op.addStudent(sc);  // 학생 등록 기능 호출
			break;
		case 2:
			op.printStudents();
			break;
		case 3:
			op.editStudent(sc);
			break;
		case 4:
			op.addSubject(sc);
			break;
		case 5:
			op.editSubject(sc);
			break;
		case 6: 
	    //check를 false로 변경하여 다음 while문 조건 검사 시 루프를 탈출
			check = false;
			System.out.println("프로그램 종료");
			break;
		
		}
	}
	


	}

}
