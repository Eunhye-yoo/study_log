package st_dao;
import java.util.ArrayList;
import java.util.Scanner;

import javax.security.auth.Subject;

import st_dto.StudentInfo;
import st_dto.SubInfo;

public class StudentManager {
	// 학생 정보 객체(st_info)들을 저장하는 리스트
	ArrayList<StudentInfo> studentList = new ArrayList<>();
	
	// 자료형 확인(input을 int로만 받기위해)
	public int check_num(Scanner sc) {
        while (true) {
            try {
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("숫자만 입력하세요!");
                return 0; // 예외 발생 시 안전하게 0 반환
            }
        }
    }
	
	
	// 특정 학생의 과목 리스트에서 중복 과목 검색
	public int findSubjectIndex(int studentIndex, String subName) {
		// 인덱스 번호로 특정 학생 객체 추출
		StudentInfo student = studentList.get(studentIndex);
		
		// 해당 학생의 개인 과목 리스트 주소 가져오기
		ArrayList<SubInfo> subjectList = student.getSubjectList();
		
		// 과목 리스트의 처음부터 끝까지 순회
		for (int i=0; i< subjectList.size(); i++) {
			if (subjectList.get(i).getSubName().equals(subName)) {
				 return i;  // 일치하는 과목을 찾으면 해당 인덱스 반환
			}
		} return -1; // 끝까지 돌았는데 없으면 -1 반환
	}
	
	
	// 중복을 제거하기 위한 학생 이름 검색
	public int findStudentIndex(String name) {
		for (int i = 0; i < studentList.size(); i++) {
			if (studentList.get(i).getName().equals(name)) {
				return i; // 찾으면 즉시 인덱스 반환
			}
		}
		return -1; // 못 찾으면 -1 반환
	}
	
	
	// 학생 등록 (이름, 나이)
	public void addStudent(Scanner sc) {
		StudentInfo student = new StudentInfo(); // 빈 학생 객체 생성
		
		System.out.print("이름: ");
		student.setName(sc.nextLine());
		
		System.out.print("나이: ");
		student.setAge(check_num(sc));
		  
		// 생성된 학생 객체를 리스트에 추가
		studentList.add(student);
		System.out.println(student.printSt()+" 학생이 등록되었습니다.");
	}
	
	
	// 학생 정보 수정 및 삭제
	public void editStudent(Scanner sc) {
		System.out.print("수정할 학생 이름: ");
		String searchName=sc.nextLine();
		
		int studentIndex = findStudentIndex(searchName);
		
		// 학생을 못 찾았을 경우 예외 처리
		if (studentIndex == -1) {
			System.out.println("등록되지 않은 학생입니다.");
			return;
		}
		
		System.out.print("1. 수정 | 2. 삭제 ");
		int editOp = check_num(sc);
		
		if (editOp == 2) {
			// 리스트에서 해당 학생 삭제
			studentList.remove(studentIndex);
			System.out.println(searchName+ "학생 삭제가 완료되었습니다.");
		} else {
			StudentInfo student = studentList.get(studentIndex);
			
			System.out.print("변경 할 이름 (기존: " + student.getName() + 
					", 건너뛰려면 엔터): ");
			String changeName = sc.nextLine();
			
			// 엔터가 아닐 때만 새 이름으로 변경 (기존 값 유지)
			if (!changeName.isEmpty()) {
				student.setName(changeName);
			}
			
			
			System.out.print("변경 할 나이 (기존: " + student.getAge() + 
					", 건너뛰려면 엔터): ");
			String ageInput = sc.nextLine();
			
			// 엔터가 아닐 때만 새 나이로 변경 (기존 값 유지)
			if (!ageInput.isEmpty()) {
				try {
					int changeAge = Integer.parseInt(ageInput);
					student.setAge(changeAge);
				} catch (NumberFormatException e) {
					System.out.println("나이는 숫자만 입력 가능합니다. "
							+ "기존 나이로 유지됩니다.");
				}
			}
			
			System.out.println("수정이 완료되었습니다.");
		}   printStudents();
	}  
	
	
	// 학생 정보 출력
	public void printStudents() {
		// 바깥쪽 루프: 전교생 명단(studentList)에서 학생을 한 명씩 순서대로 꺼냄
		for (int i = 0; i<studentList.size(); i++) {
			StudentInfo student = studentList.get(i);
			
			
			System.out.print("이름:"+student.getName()+"("+student.getAge()+")"+
						"|| 수강 과목: ");
			
			// 현재 차례인 i번째 학생의 '개인 과목 리스트'만 쏙 끄집어냄
			ArrayList<SubInfo> subjectList = student.getSubjectList();
			
			// 안쪽 루프: 위에서 꺼낸 i번째 학생의 과목 리스트 내부를 j로 하나씩 순회
			for (int j = 0; j < subjectList.size(); j++) {
				SubInfo subject = subjectList.get(j);
				System.out.print(subject.getSubName() + " " + subject.getSubScore() + "점");
				
				// 마지막 과목이 아닐 때만 과목 사이에 쉼표(,) 출력
				if (j < subjectList.size() - 1) {
					System.out.print(", ");
				}
			}
			System.out.println("]"); // 한 학생의 모든 과목 출력이 끝나면 줄바꿈 후 다음 학생(i++)으로 이동
		}
	}
	
	
	
	// 학생별 수강 과목 및 점수 추가
		public void addSubject(Scanner sc) {
			// 1. 과목을 추가할 대상 학생 찾기
			System.out.print("과목 추가할 학생 이름: ");
			String searchName=sc.nextLine();
			
			// 이름으로 학생의 위치 인덱스 조회
			int studentIndex = findStudentIndex(searchName);
			
			// 학생을 못 찾았을 경우 예외 처리
			if (studentIndex == -1) {
				System.out.println("등록되지 않은 학생입니다.");
				return;
			}
			
			// 2. 과목 및 점수 입력받기
			System.out.print("등록할 과목 수: ");
			int subnum=check_num(sc);
			
			// 입력받은 과목 수만큼 반복 실행
			for(int i=1; i<=subnum; i++) {
			SubInfo subject = new SubInfo(); // 빈 학생 객체 생성
			
			System.out.print("과목: ");
			String subName = sc.nextLine();
			
			// 입력받은 학생 인덱스와 과목명으로 중복 여부 확인
		    int subIndex = findSubjectIndex(studentIndex,subName);
			
		    // 과목이 이미 존재하는 경우 예외 처리
			if (subIndex != -1) {
				System.out.println("이미 수강하고 있는 과목입니다. 다른 과목을 입력하세요.");
				i--;    // 중복이 발생했으므로 횟수(카운트)를 1 차감하여 기회 무효화
				continue;  // 아래 코드를 실행하지 않고 다음 바퀴로 패스
			} 
			
			// 중복이 없을 때만 과목 객체에 이름 저장
			subject.setSubName(subName);
			
			System.out.print("점수: ");
			subject.setSubScore(check_num(sc));
			  
			// 조회된 특정 학생의 개인 과목 리스트를 꺼내어 새 과목 객체 주입
			studentList.get(studentIndex).getSubjectList().add(subject);
			System.out.println(studentList.get(studentIndex).printSt() + 
					"에 [" + subject.getSubName() + "] 과목이 등록되었습니다.");
		   }
		}
			
		
		public void editSubject(Scanner sc) {
			System.out.print("과목 수정 할 학생 이름: ");
			String searchName = sc.nextLine();
			
			// 이름으로 학생의 위치 인덱스 조회
			int studentIndex = findStudentIndex(searchName);
			
			// 학생을 못 찾았을 경우 예외 처리
			if (studentIndex == -1) {
				System.out.println("등록되지 않은 학생입니다.");
				return;
			}
			
			StudentInfo student = studentList.get(studentIndex);
			
			System.out.print("수정 할 과목 명: ");
			String subName = sc.nextLine();
			
			int subjectIndex = findSubjectIndex(studentIndex, subName);
			ArrayList<SubInfo> subjectList = student.getSubjectList();
			
			if (subjectIndex == -1 ) {
				System.out.println("수강 중인 과목이 아닙니다.");
			} else {
				System.out.print(subName + "과목 (1. 수정 | 2. 삭제)");
				int editop = check_num(sc);
				
				if (editop==2) {
					subjectList.remove(subjectIndex);
					System.out.println(subName+"과목 삭제가 완료되었습니다.");
				} else {
					
					SubInfo subject = subjectList.get(subjectIndex);
					
					System.out.print("변경 할 과목명 (기존: " + subject.getSubName() + 
							", 건너뛰려면 엔터): ");
					String changeName = sc.nextLine();
					
					if (!changeName.isEmpty()){
						subject.setSubName(changeName);
					}
					
					System.out.print(subName+" 점수 변경 (기존: "+ subject.getSubScore() +
							", 건너뛰려면 엔터): ");
					
					String scoreInput = sc.nextLine();
					
					if (!scoreInput.isEmpty()) {
						try {
							int changeScore = Integer.parseInt(scoreInput);
							subject.setSubScore(changeScore);
						} catch (NumberFormatException e) {
							System.out.println("점수는 숫자만 입력 가능합니다. "
									+ "기존 점수로 유지됩니다.");
					}
				 } System.out.println("수정이 완료되었습니다.");
				 
			   }   	System.out.print(searchName + " 학생의 현재 과목 리스트: ");
					for(int i=0; i < subjectList.size();i++) {
						SubInfo subject = subjectList.get(i);
						System.out.println(subject.getSubName()+" "
						+ subject.getSubScore()+"점");
				   
				   
					}
			   
			   
			   
			}
		}

		
		
}
