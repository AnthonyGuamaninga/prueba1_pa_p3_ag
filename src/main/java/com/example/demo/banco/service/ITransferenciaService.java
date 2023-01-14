package com.example.demo.banco.service;

import java.math.BigDecimal;

import com.example.demo.banco.modelo.Transferencia;

public interface ITransferenciaService {
	
	public void realizarTransferencia(String cuentaOrigen, String cuentaDestino, BigDecimal monto);
	public void modificar(Transferencia transferencia);
	public Transferencia buscar(Integer id);
	public void eliminar(Integer id);

}
