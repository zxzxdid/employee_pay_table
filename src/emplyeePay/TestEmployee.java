package emplyeePay;

import java.util.Scanner;

/*
1. 입력 자료 수는main(String[] args) 이용하여 입력 받는다.
2. 사원번호, 이름을 입력
3. 사원의 근무유형은 관리직(1), 정규직(2), 임시직(3)으로 구분한다.
   사원번호가 잘 못 입력되면 “근무유형 오류 재입력….”을 출력하고 다시 입력을 받는다.
4. 관리자 - 직책과 임금을 입력
   정규직 - 부서, 업무, 임금을 입력
   임시직 - 부서, 월 근무시간수
5. 직무 유형에 따라 수당
   관리자 : 20만원 정규직 : 10만원을 더해서 급여액을 더하여 출력한다.
   임시직 : 시간당 3만원으로 정하고 시간 수에 월급여액을 구해서 출력한다.


금성 회사 급여 입력화면

입력 자료 수: 5
사원번호, 이름… 1001 진달래
사원의 근무유형: (1:CEO, 2:정규직, 3:임시직)… 1
직책, 월 임금…. 대표 1180

사원번호, 이름… 2001 개나리
사원의 근무유형: (1:CEO, 2:정규직, 3:임시직)… 2
부서, 업무, 월 임금…. 인사부 기획 800

사원번호, 이름… 2002 민들레
사원의 근무유형: (1:CEO, 2:정규직, 3:임시직)… 4
근무유형 오류 재입력…

사원번호, 이름… 2002 민들레
사원의 근무유형: (1:CEO, 2:정규직, 3:임시직)… 3
부서, 월 근무시간 수… 총무부 42

사원번호, 이름… 2003 수선화
사원의 근무유형: (1:CEO, 2:정규직, 3:임시직)… 2
부서, 업무, 월 임금… 영업부 영업 1100

사원번호, 이름… 2004 선인장
사원의 근무유형: (1:CEO, 2:정규직, 3:임시직)… 3
부서, 월 근무시간 수… 총무부 35

금성 회사 급여 출력화면

급여 보고서
이름: 진달래, 사원번호: 1001, 직책: 대표, 급여액: 1200만 원
이름: 개나리, 사원번호: 2001, 부서: 인사부, 담당업무: 기획, 급여액: 810만원
이름: 민들레, 사원번호: 2002, 부서: 총무부, 근무시간수: 42, 급여액: 126만원
이름: 수선화, 사원번호: 2003, 부서: 영업부, 담당업무: 영업, 급여액: 1110만원
이름: 선인장, 사원번호: 2004, 부서: 총무부, 근무시간수: 35, 급여액: 105만원
 */


public class TestEmployee {
   public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      
      System.out.print("입력 자료 수: ");
      int n = in.nextInt(); // 입려할 자료 수
      
      Employee ceo[] = new Staff[n];
      Employee reg[] = new RegEmployee[n];
      Employee tem[] = new TempEmployee[n];
      
      for(int i = 0; i < n; i++) {
         System.out.print("사원번호, 이름… ");
         String sno = in.next();
         String name = in.next();
         
         System.out.print("사원의 근무유형: (1:CEO, 2:정규직, 3:임시직)… ");
         int ki = in.nextInt(); // kind 근무 유형
         
         String de = ""; //dept 직책 및 부서
         String par = ""; // part 업무
         long pay = 0; // pay 급여
         int ti = 0; // time 근무시간
         String err = ""; // 사원 근무 유형 오류
         
         
         if(ki == 1) {
            System.out.print("직책, 월 임금… ");
            de = in.next();
            pay = in.nextLong();
            ceo[i] = new Staff(name, sno, de, pay);
         }
            else if(ki == 2) {
            System.out.print("부서, 업무, 월 임금… ");
            de = in.next();
            par = in.next();   
            pay = in.nextLong();
            reg[i] = new RegEmployee(name, sno, de, pay, par);
            }
            else if(ki == 3) {
            System.out.print("부서, 월 근무시간… ");      
            de = in.next();
            ti = in.nextInt();
            tem[i] = new TempEmployee(name, sno, de, ti);
            }
            else {
            err = "근무유형 오류 재입력… ";
            System.out.println(err);
            i -= 1;
            }
         System.out.println();
      }
      System.out.println();
      System.out.println("급여 보고서");
   
      
      for(int i = 0; i < n; i++) {
         if(ceo[i] == null)
            System.out.print("");
         else 
            System.out.println(ceo[i]);
         
         if(reg[i] == null)
            System.out.print("");
         else 
            System.out.println(reg[i]);
         
         if(tem[i] == null)
            System.out.print("");
         else 
            System.out.println(tem[i]);
            
         
      }
      
      
      
      in.close();
   }
   
}