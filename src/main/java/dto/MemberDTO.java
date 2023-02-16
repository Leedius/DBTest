package dto;

public class MemberDTO {
	private int memNum;
	private String memName;
	private int memAge;
	
	public MemberDTO() {
		
	}
	
	public MemberDTO(int memNum, String memName, int memAge) {
		super();
		this.memNum = memNum;
		this.memName = memName;
		this.memAge = memAge;
	}

	public int getMemNum() {
		return memNum;
	}

	public void setMemNum(int memNum) {
		this.memNum = memNum;
	}

	public String getMemName() {
		return memName;
	}

	public void setMemName(String memName) {
		this.memName = memName;
	}

	public int getMemAge() {
		return memAge;
	}

	public void setMemAge(int memAge) {
		this.memAge = memAge;
	}
	
	
	

}
