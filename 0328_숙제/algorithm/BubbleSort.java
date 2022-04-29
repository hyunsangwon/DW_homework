package 버블정렬;

public class BubbleSort {
	public static void main(String[] args) {
		int array[] = {1, 10, 4, 3, 5};
		int count = 0; //총 몇회전 했는지 알아내는 변수
		boolean isChange = false;
		int len =  array.length;

		for(int i=len; i > 0; i--){
		    isChange = false;
		    for (int j=0; j < (i - 1); j++) {
		        if (array[j] > array[j+1]) {
		            int temp = array[j]; //temp를 사용하지 않으면 i+1번째 배열에 i번째 원소(index 값)를 swap할 수 없다.
		            array[j] = array[j+1];
		            array[j+1] = temp;
		            isChange = true;          
		            ++count;
		         }
		    }
		    if(!isChange) break; //더이상 정렬이 없으면 for문 멈춤
		}
		
		for(int i : array){
			System.out.print(i+" ");
		}
	}
}
