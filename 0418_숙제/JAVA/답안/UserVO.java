package user;

public class UserVO {
	
	 private String ename; //직원 이름
     private String dname; //부서 이름
     private int sal;  //급여
     private int lv; //직원 레벨
     
     public UserVO(String ename, String dname, int sal){
         this.ename = ename;
         this.dname = dname;
         this.sal = sal;
     }

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public int getSal() {
		return sal;
	}

	public void setSal(int sal) {
		this.sal = sal;
	}

	public int getLv() {
		return lv;
	}

	public void setLv(int lv) {
		this.lv = lv;
	}
}
