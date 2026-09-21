package demo;
import java.util.Scanner; 
public class EmployeeTest {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Employee employee=new Employee();
		Attendance attendance=new Attendance();
		Salary salary=new Salary();
		int choice;
		// do-while is used due to appear at least once
		do
		{
			System.out.println("\n====================================");
			System.out.println("EMPLOYEE ATTENDANCE & PAYROLL SYSTEM");
			System.out.println("======================================");
			System.out.println("1. Enter Employee Details");
			System.out.println("2. Calaculate Attendance");
			System.out.println("3. Calaculate Salary");
			System.out.println("Display Employee Details");
			System.out.println("5. Exist");
			System.out.println("Enter your choice: ");
			choice=sc.nextInt();
			switch(choice){
			case 1:
				System.out.println("\n---ENTER EMPLOYEE DETAILS---");
				System.out.print("Enter Employee ID: ");
				employee.employeeId=sc.nextInt();
				sc.nextLine();
				System.out.println("Enter Employee Name: ");
				employee.employeeName=sc.nextLine();
				System.out.println("\nSelect Department:");
				System.out.println("1. IT");
				System.out.println("3. HR");
				System.out.println("3. Finance");
				System.out.println("4. Marketing");
				System.out.println("Enter Department Choice: ");
				employee.departmentChoice=sc.nextInt();
				switch(employee.departmentChoice) {
				case 1:
					employee.department="IT";
					break;
				case 2:
					employee.department="HR";
					break;
				case 3:
					employee.department="Finance";
					break;
				case 4:
					employee.department="Marketing";
					break;
				default:
					employee.department="Unknown";
					System.out.println("Invalid department choice.");
				}
				System.out.println("Enter Basic Salary: ");
				employee.basicSalary=sc.nextDouble();
				if(employee.basicSalary>0) {
					System.out.println("Employee details entered successfully.");
				}else {
					System.out.println("Invalid salary.Salary must be greter than zero.");
				}
				break;
			case 2:
				System.out.println("\n---ATTENDANCE CALACULATION---");
				System.out.println("Enter Total Working Day:");
				attendance.totalWorkingDays = sc.nextInt();
				if (attendance.totalWorkingDays > 0) {
				   attendance.presentDays=0;
				   attendance.absentDays=0;
				   for (int day =1;day <= attendance.totalWorkingDays; day++) {
					   System.out.print("Day " + " - Enter 1 for present,0 for Adsent: ");
					   attendance.attendance = sc.nextInt();
					   if (attendance.attendance == 1 ) {
						   attendance.presentDays++;
					   }else if(attendance.attendance == 0) {
						   attendance.absentDays++;
					   }else {
						   System.out.println("Invalid input.Enter only 1 or 0.");
					   }
				   }
				   attendance.attendancePercentage=((double) attendance.presentDays /attendance.totalWorkingDays)*100;
				   System.out.println("\nPresent Days : " + attendance.presentDays);
				   System.out.println("Absent Days : " + attendance.absentDays);
				   System.out.println("Attendance % : " + attendance.attendancePercentage + "%");
				   
				   if(attendance.attendancePercentage>=75) {
						System.out.println("Attendance Status: Eligible");
					}else {
						System.out.println("Attendance Status: Not Eligible");
					}
		 	}		else {
						System.out.println("Working days must be greater than zero.");
					}break;
			case 3 :
				System.out.println("\n---SALARY CALCULATION---");
				
				if(employee.basicSalary > 0) {
					if(attendance.totalWorkingDays > 0) {
						if(attendance.attendancePercentage >= 90) {
							salary.incentive = employee.basicSalary * 0.10;
							salary.finalSalary = employee.basicSalary + salary.incentive;
							System.out.println("Attendance Category: Excellent");
							System.out.println("Attendance Incentive: 10%");
						}  else if (attendance.attendancePercentage>=75) {
							salary.incentive=0;
							salary.deduction=0;
							salary.finalSalary=employee.basicSalary;
							System.out.println("Attendance Category: Good");
							System.out.println("Attendance Incentive: 0%");
						}  else {
							salary.deduction=employee.basicSalary*0.10;
							salary.finalSalary=employee.basicSalary-salary.deduction;
							System.out.println("Attendance Category: Low");
							System.out.println("Attendance Incentive: 10%");
						} 
						System.out.println("Basic Salary : Rs." + employee.basicSalary);
						System.out.println("Final Salary : Rs." + salary.finalSalary);	
					} else {
						System.out.println("Please calculate attendance first");
					}
				} else {
					System.out.println("Please enter valid employee details first");
				}
				break;
			case 4:
				System.out.println("\n---Employee Details---");
				
				if (employee.employeeId !=0) {
					System.out.println("employee id:" +employee.employeeId);
					System.out.println("employee name : " + employee.employeeName);
					System.out.println("department : " + employee.department);
					System.out.println("basic salary : " + employee.basicSalary);
					System.out.println("present days : " + attendance.presentDays);
					System.out.println("absent days : " + attendance.absentDays);
					System.out.println("Attendance % : " + attendance.attendancePercentage + "%");
					System.out.println("Final Salary : Rs." + salary.finalSalary);
				} else {
					System.out.println("No employee details available");
				}
				break;
			case 5:
				System.out.println("\n Thank you for using the system.");
				break;
			default:
					System.out.println("Invalid menu choice.please enter 1 to 5.");
			}
	}
		while(choice !=5);
		sc.close();
	}
}