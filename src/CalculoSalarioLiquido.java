import java.util.Locale;
import java.util.Scanner;

import entities.Employee;
import services.PensionService;
import services.SalaryService;
import services.TaxService;

public class CalculoSalarioLiquido {

	/*
	 * Solu��o sem utilizar componentes
	 */
	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		System.out.print("Nome do funcion�rio: ");
		String name = sc.nextLine();
		System.out.print("Sal�rio Bruto: ");
		double grossSalary = sc.nextDouble();

		Employee employee = new Employee(name, grossSalary);
		TaxService taxService = new TaxService();
		PensionService pensionService = new PensionService();
		SalaryService salaryService = new SalaryService(taxService, pensionService);
	
		double netSalary = salaryService.netSalary(employee);
		System.out.printf("Sal�rio L�quido = %.2f%n ", netSalary);
		
		sc.close();
	}
}
