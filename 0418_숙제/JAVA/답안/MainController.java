package user;

import java.util.ArrayList;
import java.util.List;

public class MainContoller {
	
	public static void main(String[] args) {
		List<UserVO> list = new ArrayList<UserVO>();
        list.add(new UserVO("Alex","DEVELOP",200));
        list.add(new UserVO("Max","DEVELOP",80));
        list.add(new UserVO("Brian","DEVELOP",100));
        list.add(new UserVO("mr.Hyun","MANAGER",300));
        list.add(new UserVO("Allen","DEVELOP",110));
        list.add(new UserVO("Katter","DEVELOP",220));
        list.add(new UserVO("Hooker","MANAGER",1500));
        list.add(new UserVO("King","MASTER",0));
       
        UserServiceImple service = new UserService();
        //1번
        list = service.updateSal(list,"DEVELOP");
        printList(list);
        //2번
        list = service.updateLv(list);
        printList(list);
        //3번
        list = service.deleteUser(list, 3);
        printList(list);
        //4번
        UserVO vo = service.selectUserByEname(list, "King");
        System.out.println("사원 이름 : "+vo.getEname()+", 부서 이름 : "+vo.getDname()+", 직원 급여 : "+vo.getSal()+", 직원 레벨 : "+vo.getLv());
	}
	//결과를 확인하는 메소드
	public static void printList(List<UserVO> list){
		System.out.println("====================================================================");
		for(UserVO vo : list){
			System.out.println("사원 이름 : "+vo.getEname()+", 부서 이름 : "+vo.getDname()+", 직원 급여 : "+vo.getSal()+", 직원 레벨 : "+vo.getLv());
		}
		System.out.println("====================================================================");
	}
	
}