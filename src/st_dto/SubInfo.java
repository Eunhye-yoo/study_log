package st_dto;

public class SubInfo {
	
	private String subName;
	private int subScore;
	
	// 기본 생성자
	public SubInfo() {
	}
	
	// 과목 이름 가져오기
	public String getSubName() {
		return this.subName;
	}
	
	// 과목 이름 저장하기
	public void setSubName(String subName) {
		this.subName= subName;
	}
	
	// 과목 점수 가져오기
	public int getSubScore() {
		return this.subScore;
	}

	// 과목 점수 저장하기
	public void setSubScore(int subScore) {
		this.subScore=subScore;
	}
	
	// 과목 정보(이름과 점수) 출력
	public void printInfo() {
		System.out.println("["+getSubName()+"]: " + getSubScore());
	}

}
