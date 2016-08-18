package ch04.homework;
/*
 * 4x + 5y = 60을 만족하는 방정식의 해를 구하여 출력하시오.
 * 단, (1 <= x, y <= 10) 범위를 만족시킨다.
 */
public class HomeWork2 {

	public static void main(String[] args) {
		int i, j, chk = 0; // i == x, j == y, 결과값 변수 선언 
		for(i=1; i<=10; i++){ // x값인 i를 1~10으로 대입하기 위한 반복문
			chk = (60 - i*4) % 5; // i를 대입한 결과를 chk에 저장
			switch(chk){
			case 0: //chk의 나머지 값이 0, 즉 해를 만족한 조건인 경우
				j = (60 - i*4) / 5; // j에 해당하는 해의 값을 저장한다
				if(j>=1 && j<=10){ //단, 조건인 1~10에 해당하는 범위의 값인지 판단
					System.out.println("( " + i + ", " + j + " )");//맞으면 출력
				}//if j
				break;
			default: //chk의 나머지 값이 0이 아닐 경우, 즉 해를 만족하지 못한다면
			} //switch
			/*if(chk==0){
				j = (60 - i*4) / 5;
				if(j>=1 && j<=10){
					System.out.println("( " + i + ", " + j + " )");
				}//if j
			}//if chk */ // switch를 if문으로 만들었을 경우이다.
		}//for

	}//main

}//class
