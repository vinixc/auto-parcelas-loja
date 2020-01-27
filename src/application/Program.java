package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entity.Contract;
import model.service.ParcelasService;
import model.service.ServicePaypal;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println("Enter contract data");
		System.out.print("Number: ");
		String number = sc.nextLine();
		System.out.println("Date (dd/MM/yyyy): ");
		Date date = sdf.parse(sc.nextLine());
		System.out.print("Contract value: ");
		Double value = sc.nextDouble();
		System.out.print("Enter number of installments: ");
		Integer installments = sc.nextInt();
		
		Contract contract = new Contract(Integer.parseInt(number), date, value);
		
		ParcelasService pc = new ParcelasService(installments, new ServicePaypal(), contract);
		contract = pc.calculaPrestacao(installments);
		
		System.out.println("Installments:");
		
		contract.getInstallment().forEach(i -> {
			System.out.println( sdf.format(i.getDueDate()) +  " - " + i.getAmount());
		});
		
		sc.close();
	}

}
