import java.time.LocalDate;
import java.time.Period;
import java.util.HashSet;
import java.util.Set;

public class MortgageCalculator {
	private final Set<String> employeeLvl1 = Set.of("Developer","Architect","Scrum master");
	private final Set<String> employeeLvl2 = Set.of("Tester","System Administrator","Technical writer");
	private final Set<String> employeeLvl3 = Set.of("Department head","Professor");
	
	public double computeMaxMortgage(int yearOfBirt, int month, int day, double monthlyIncome, boolean married, double monthlyIncomePartner, String profession) {
		LocalDate birthday = LocalDate.of(yearOfBirt, month, day);
		int age = Period.between(birthday, LocalDate.now()).getYears();

		if (age < 18) return 0;

		double totalIncome = (married)? monthlyIncome + monthlyIncomePartner * 0.94 : monthlyIncome;

		if (2000<=totalIncome && totalIncome<3000) {
			if (employeeLvl1.contains(profession)) return 160000;
			if (employeeLvl2.contains(profession)) return 120000;
			if (employeeLvl3.contains(profession)) return 220000;
		}
		if (3000<=totalIncome && totalIncome<5000) {
			if (employeeLvl1.contains(profession)) return 180000;
			if (employeeLvl2.contains(profession)) return 140000;
			if (employeeLvl3.contains(profession)) return 250000;
		}
		if (5000<=totalIncome) {
			if (employeeLvl1.contains(profession)) return 220000;
			if (employeeLvl2.contains(profession)) return 160000;
			if (employeeLvl3.contains(profession)) return 280000;
		}
		return 0;
	}
}
