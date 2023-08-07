package emplyeePay;

import java.util.Scanner;


public class TestEmployee2 {
   public static void main(String[] args) {
      
      
      Scanner in = new Scanner(System.in);
      
      System.out.print("입력 자료 수: ");
      int n = in.nextInt(); // 입려할 자료 수
      
      Employee ee[] = new Employee[n];
      
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
            ee[i] = new Staff(name, sno, de, pay);
         }
            else if(ki == 2) {
            System.out.print("부서, 업무, 월 임금… ");
            de = in.next();
            par = in.next();   
            pay = in.nextLong();
            ee[i] = new RegEmployee(name, sno, de, pay, par);
            }
            else if(ki == 3) {
            System.out.print("부서, 월 근무시간… ");      
            de = in.next();
            ti = in.nextInt();
            ee[i] = new TempEmployee(name, sno, de, ti);
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
            System.out.println(ee[i]);
      }
      
      
      in.close();
   }
   
}