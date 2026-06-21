package st_dto;

import java.util.ArrayList;

import st_dto.SubInfo;

public class StudentInfo {

	private String name;
	private int age;
	// 학생 개인이 수강하는 과목 목록 저장소
	ArrayList<SubInfo> subjectList = new ArrayList<>(); 
	
	// 기본 생성자 (객체를 처음 생성할 때 호출됨)
	public StudentInfo() {
	}
	
	// 이름을 외부로 돌려주는 메서드
	public String getName() {
		return this.name;
	}
	
	// 외부에서 준 이름을 내부 변수에 저장하는 메서드
	public void setName(String name) {
		this.name= name;
	}
	
	// 나이를 외부로 돌려주는 메서드
	public int getAge() {
		return this.age;
	}
	
	// 외부에서 준 나이를 내부 변수에 저장하는 메서드
	public void setAge(int age) {
		this.age=age;
	}
	
	// 학생의 기본 정보를 콘솔창에 한 줄로 출력하는 메서드
	public String printSt() {
		return this.name + "(" + this.age + "세)";
	}
	
	// 학생이 수강 중인 과목 리스트를 외부에 제공
	public ArrayList<SubInfo> getSubjectList() {
		return this.subjectList;  // 과목 리스트 상자 반환
	}

}
