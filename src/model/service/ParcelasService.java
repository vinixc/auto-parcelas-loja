package model.service;

import model.entity.Contract;

public class ParcelasService {
	
	private Integer parcelas;
	
	private ServicePaymentOnline paymentOnline;
	private Contract contrato;
	
	public ParcelasService(Integer parcelas,
			ServicePaymentOnline paymentOnline, Contract contrato) {
		this.parcelas = parcelas;
		this.paymentOnline = paymentOnline;
		this.contrato = contrato;
	}
	public Integer getParcelas() {
		return parcelas;
	}
	public void setParcelas(Integer parcelas) {
		this.parcelas = parcelas;
	}
	public ServicePaymentOnline getPaymentOnline() {
		return paymentOnline;
	}
	public void setPaymentOnline(ServicePaymentOnline paymentOnline) {
		this.paymentOnline = paymentOnline;
	}
	
	public Contract calculaPrestacao(Integer parcelas){
		this.parcelas = parcelas;
		contrato.setInstallment(paymentOnline.installment(contrato.getTotalValue() / parcelas, parcelas, contrato.getDate()));
		return contrato;
	}
	
}
