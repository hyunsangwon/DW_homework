package 선택정렬;

public class SelectionSort {
	
	public static void main(String[] args) {
		int array[] = {9, 6, 7, 3, 5};
		boolean isChange = false; //교환 여부 판단!

		for(int i=0; i<(array.length-1); i++){ //4회전 세팅
			int min = array[i];//0번째 원소를 초기값으로 세팅!
			int index = 0; //최솟값 위치변수.
			for(int j=i+1; j<array.length; j++){
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
            if(!isChange) break;
		}//outer-for end
		
		
	}
}
