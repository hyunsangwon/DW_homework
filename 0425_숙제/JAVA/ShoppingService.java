package shopping;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class ShoppingService implements ShoppingServiceImpl{

	@Override
	public List<UserVO> getUserList(List<UserVO> list) {
		for(int i=0; i<list.size(); i++){
			if(list.get(i).getList() != null){
				System.out.println("사원 번호 : "+list.get(i).getUserNo()+", 사원 이름 : "+list.get(i).getUserName()+", 포인트 : "+list.get(i).getPoint()+", 방문 날짜 : "+list.get(i).getVisitAt()+", 방문 날짜 : "+list.get(i).isSleeper());
			}
		}
		return list;
	}

	@Override
	public List<UserVO> getFindByName(List<UserVO> list, String word) {
		// TODO Auto-generated method stub
		for(int i=0; i<list.size(); i++){
			String firstName = list.get(i).getUserName().substring(0, 1);
			if(firstName.equals(word)){
				System.out.println("사원 번호 : "+list.get(i).getUserNo()+", 사원 이름 : "+list.get(i).getUserName()+", 포인트 : "+list.get(i).getPoint()+", 방문 날짜 : "+list.get(i).getVisitAt()+", 방문 날짜 : "+list.get(i).isSleeper());
			}
		}
		return list;
	}

	@Override
	public int getSleeperUserCount(List<UserVO> list) {
		// TODO Auto-generated method stub
		int count = 0;
		for(int i=0; i<list.size(); i++){
			boolean isSleep = list.get(i).isSleeper();
			if(isSleep) ++count;
		}
		return count;
	}

	@Override
	public List<UserVO> updateNotSleeperToSleeper(List<UserVO> list, int days) {
		// TODO Auto-generated method stub
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.KOREA);
		String strToday = formatter.format(Calendar.getInstance().getTime());//오늘날짜 조회
		Date today = null;
		Date visit = null;
		
		for(int i=0; i<list.size(); i++){
			String strVisitAt = list.get(i).getVisitAt();
			try {
				visit = formatter.parse(strVisitAt);
				today = formatter.parse(strToday);
				long diff = (today.getTime() - visit.getTime()) / (1000*60*60*24);
				if(diff >= days){
					list.get(i).setSleeper(true);//휴먼 계정!
				}else{
					list.get(i).setSleeper(false);
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public List<UserVO> updatePoint(List<UserVO> list, int point) {
		// TODO Auto-generated method stub
		for(int i=0; i<list.size(); i++){
			boolean isSleep = list.get(i).isSleeper();
			if(!isSleep) list.get(i).setPoint(list.get(i).getPoint() + 100);
		}
		return list;
	}

	@Override
	public UserVO getPointRankerUser(List<UserVO> list) {
		// TODO Auto-generated method stub
		int max = 0;
		int index = 0;
		for(int i=0; i<list.size(); i++){
			int point = list.get(i).getPoint();
			if(max < point){
				max = point;
				index = i;
			}
		}
		return list.get(index);
	}

	@Override
	public List<UserVO> getPurchaseRankerUser(List<UserVO> list, ProductVO vo, int userNo) {
		List<ProductVO> productList = new ArrayList<ProductVO>();
		double pointPercent = 0.05;// 5% 보너스
		for(int i=0; i<list.size(); i++){
			if(userNo == list.get(i).getUserNo()){
				productList.add(vo);
				int productPrice = vo.getPrice();
				int point = (int)(productPrice * pointPercent);
				list.get(i).setList(productList);//구매이력 추가
				list.get(i).setPoint(list.get(i).getPoint() + point); //포인트 추가
			}
		}
		return list;
	}

}
