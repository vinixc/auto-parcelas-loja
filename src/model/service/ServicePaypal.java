package model.service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.entity.Installment;

public class ServicePaypal implements ServicePaymentOnline {

	private double jurosSimples = 0.01;
	private double taxaPagamento = 0.02;

	@Override
	public List<Installment> installment(double valorParcela, Integer parcelas, Date data) {

		List<Installment> installments = new ArrayList<Installment>();

		for (long i = 1; i <= parcelas; i++) {
			LocalDate dataParcela = data.toInstant().atZone(ZoneId.systemDefault()).toLocalDate().plusMonths(i);
			double valorFinal = (valorParcela + (valorParcela * jurosSimples * i));
			valorFinal = valorFinal + (valorFinal * taxaPagamento);
			installments.add(new Installment(Date.from(dataParcela.atStartOfDay(ZoneId.systemDefault()).toInstant()),
					valorFinal));
		}
		return installments;
	}

}
