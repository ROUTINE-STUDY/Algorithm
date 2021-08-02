class Solution {
    public int maximumUnits(int[][] boxT, int t) {
        
        // 2차원 배열 정렬
        Arrays.sort(boxT, new Comparator<int[]>(){ // 정렬 기준 익명 클래스로 생성
            //@Override
            public int compare(int[] o1, int[] o2){
                if(o1[1] == o2[1]){ // 두 번째 값으로 비교 해야 함.
                    return 0; 
                }else if(o1[1] > o2[1]){
                    return -1;
                }else{
                    return 1;
                }
            }
        });
        
        int total = 0;
        
        // while 문으로 t가 0보다 클 때 계속 돌아야함.
		while(t > 0) {
			for(int i=0; i<boxT.length; i++) {
				for(int j=0; j<boxT[i][0]  && t > 0; j++) { // t의 조건을 걸어주지 않으면 반복문 t가 마이너스가 되더라도 돌 수 있음.
					total += boxT[i][1];
					t--;
				}
			}
            break; //남은 박스의 개수가 없으면 멈춰라!
		}
        
        return total;
        
        
    }
} 
/* 
    뒤에 값이 무게
    10짜리 5개
    9짜리 3개
    7짜리 2개
    
    50 + 27 + 14 = 91
    
    1. 키 값이 truckSize까지
    2. 밸류 값이 큰 거 부터
    3. 자바 2차원 배열 정렬 하고 , 정렬 기준을 뒤에 값이 크게 해준다.
    4. 앞에 부터 채워나가면 , 정렬을 큰 기준으로 했기 때문에 가능
*/