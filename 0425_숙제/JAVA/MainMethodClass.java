package shopping;

import java.util.ArrayList;
import java.util.List;

public class MainMethodClass {
	
	
	public static void main(String[] args) {
		
		List<UserVO> userList = new ArrayList<UserVO>();
		userList.add(new UserVO(110,500,"BRIAN","2019-07-01 08:14:31"));
		userList.add(new UserVO(1000,500,"ALLEN","2020-03-01 14:30:31"));
		userList.add(new UserVO(120,800,"SANGWON","2021-05-11 18:20:31"));
		userList.add(new UserVO(130,1100,"KING","2022-04-21 09:10:31"));
		userList.add(new UserVO(140,300,"SMITH","2022-04-21 09:00:31"));
		userList.add(new UserVO(150,200,"SCOTT","2022-04-21 09:20:31"));
		userList.add(new UserVO(160,900,"WILLSON","2022-04-21 09:17:31"));
		userList.add(new UserVO(50,770,"SAM","2022-04-21 10:57:00"));
		
		ShoppingServiceImpl shopping = new ShoppingService();
		//1. 회원 중 포인트가 가장 많은 회원 정보 조회.(단, 중복데이터는 없다고 가정)
		UserVO vo = shopping.getPointRankerUser(userList);
		//printResult(vo);
		//2. 회원 중 앞글자에 S가 들어간 회원 정보 조회.
		userList = shopping.getFindByName(userList, "S");
		//3. 현재날짜 기준으로 90일동안 방문 없었던 회원 휴먼 계정으로 수정.
		userList = shopping.updateNotSleeperToSleeper(userList, 90);
		printResult(userList);
		//4. 휴먼계정 인원 수 조회.
		int count = shopping.getSleeperUserCount(userList);
		System.out.println("휴먼계정 인원 수 : "+count);
		//5. 휴먼계정이 아닌 회원에게 100포인트 추가 지급.
		userList = shopping.updatePoint(userList, 100);
		printResult(userList);
		//6. 포인트가 가장 높은 회원 조회.(단, 중복데이터는 없다고 가정) (1번하고 동일)
		//7. 특정 회원에게 상품구매 발생.
	    //   구매한 상품의 가격 5%가 포인트로 지급. 	
		ProductVO productVO = new ProductVO();
		productVO.setPrice(300000);
		productVO.setProductName("자전거");
		int smithNo = 140;
		userList = shopping.getPurchaseRankerUser(userList, productVO, smithNo);
		printResult(userList);
		//8. 구매이력이 있는 회원만 조회.
		shopping.getUserList(userList);
	}
	
	public static void printResult(UserVO vo){
		System.out.println("====================================================================");
		System.out.println("사원 번호 : "+vo.getUserNo()+", 사원 이름 : "+vo.getUserName()+", 포인트 : "+vo.getPoint()+", 방문 날짜 : "+vo.getVisitAt()+", 방문 날짜 : "+vo.isSleeper());
		if(vo.getList() != null){
			System.out.println("사원 번호 : "+vo.getUserNo()+", 사원 이름 : "+vo.getUserName()+", 포인트 : "+vo.getPoint()+", 방문 날짜 : "+vo.getVisitAt()+", 방문 날짜 : "+vo.isSleeper());
			for(ProductVO productVO : vo.getList()){
				System.out.println("상품 이름 : "+productVO.getProductName()+", 상품 가격 : "+productVO.getPrice());
			}
		}
		System.out.println("====================================================================");
	}
	public static void printResult(List<UserVO> list){
		System.out.println("====================================================================");
		for(UserVO vo : list){
			System.out.println("사원 번호 : "+vo.getUserNo()+", 사원 이름 : "+vo.getUserName()+", 포인트 : "+vo.getPoint()+", 방문 날짜 : "+vo.getVisitAt()+", 방문 날짜 : "+vo.isSleeper());
			if(vo.getList() != null){
				for(ProductVO productVO : vo.getList()){
					System.out.println("상품 이름 : "+productVO.getProductName()+", 상품 가격 : "+productVO.getPrice());
				}
			}
		}
		System.out.println("====================================================================");
	}
}