package 선택정렬;

public class SelectionSort {
	
	public static void main(String[] args) {
		int array[] = {9, 6, 7, 3, 5};
		boolean isChange = false; //교환 여부 판단!
		int arrLen = array.length;
		for(int i=0; i<(arrLen-1); i++){ //4회전 세팅
			isChange = false;
			int min = array[i];//0번째 원소를 초기값으로 세팅!
			int index = 0; //최솟값 위치변수.
			for(int j=i+1; j<arrLen; j++){ //최솟값을 찾자!
				int jIndex = array[j];
				if(min > jIndex){
					min = jIndex;
					index = j;
					isChange = true; //최솟값이 있음!
				}
			}//inner-for end
			if(isChange){
				int temp = array[i];
				array[i] = min;
				array[index] = temp;
			}
            if(!isChange) break; //더이상 찾을께 없으면 멈추자
		}//outer-for end
		
		
	}
}
