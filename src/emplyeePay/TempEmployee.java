package emplyeePay;


public class TempEmployee extends Employee {
   String dept;
   private long temphour;
   
   public TempEmployee(String ename, String esno, String dept, long temphour) {
      super(ename, esno);
      this.dept = dept;
      this.temphour = temphour;
   }
   
   long getHour() {
      return getHour();
   }
   
   void setHour() {
      
   }
   
   public String toString() {
      return super.toString() + ", 부서 : " + dept 
            + ", 근무시간수 : " + temphour + ", 급여액 : " + (temphour * 3 + "만원");
   }
   
   public long earnings(long pay) {
      return super.earnings(temphour);
   }
   
}