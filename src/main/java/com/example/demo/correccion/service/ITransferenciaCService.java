package com.example.demo.correccion.service;

import java.math.BigDecimal;

import com.example.demo.correccion.modelo.TransferenciaC;

public interface ITransferenciaCService {
	
	public void realizar(String numeroOirgen, String numeroDestino, BigDecimal monto);

}
