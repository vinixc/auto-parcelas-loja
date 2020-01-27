package model.service;

import java.util.Date;
import java.util.List;

import model.entity.Installment;

public interface ServicePaymentOnline {
	
	List<Installment> installment(double valorParcela, Integer parcelas, Date date);
}
