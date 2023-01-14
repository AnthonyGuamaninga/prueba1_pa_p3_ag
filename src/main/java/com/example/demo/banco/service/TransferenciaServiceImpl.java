package com.example.demo.banco.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.banco.modelo.Cuenta;
import com.example.demo.banco.modelo.Transferencia;
import com.example.demo.banco.repository.ICuentaRepo;
import com.example.demo.banco.repository.ITransferenciaRepo;

@Service
public class TransferenciaServiceImpl implements ITransferenciaService {

	@Autowired
	private ITransferenciaRepo iTransferenciaRepo;
	@Autowired
	private ICuentaRepo cuentaRepo;
	
	
	@Override
	public void realizarTransferencia(String cuentaOrigen, String cuentaDestino, BigDecimal monto) {
		// TODO Auto-generated method stub
		Transferencia transferencia = new Transferencia();
		transferencia.setFechaTransferencia(LocalDateTime.now());
		transferencia.setCuentaOrigen(cuentaOrigen);
		transferencia.setCuentaDestino(cuentaDestino);
		transferencia.setMonto(monto);
		
		//transferencia
		Cuenta cOrigen = this.cuentaRepo.buscar(cuentaOrigen);
		Cuenta cDestino = this.cuentaRepo.buscar(cuentaDestino);
		
		BigDecimal saldoOrigen = cOrigen.getSaldo();
		BigDecimal saldoDestino = cDestino.getSaldo();
		
		boolean seRealizo=false;
		if(monto.intValue()>saldoOrigen.intValue()) {
			System.out.println("SALDO INSUFICIENTE");
			
		}else {
			
			BigDecimal SaldoActualOrigen = saldoOrigen.subtract(monto);
			BigDecimal saldoActualDestino = saldoDestino.add(monto);
			
			cOrigen.setSaldo(SaldoActualOrigen);
			cDestino.setSaldo(saldoActualDestino);
			System.out.println("Transferencia realizada con exito !");
			
			if(cOrigen.getSaldo().intValue()<0) {
				System.out.println("La cuenta se quedará en cero");
				System.out.println("Se necesita sustraer la COMISION");
			}else {
				
				seRealizo=true;
			}
			
		}
		
		
		if(seRealizo) {
			BigDecimal comision = monto.multiply(new BigDecimal(0.05));
			transferencia.setComision(comision);
			cOrigen.setSaldo(cOrigen.getSaldo().subtract(comision));
			this.cuentaRepo.actualizar(cOrigen);
			this.cuentaRepo.actualizar(cDestino);
			this.iTransferenciaRepo.insertar(transferencia);
		}else {
			System.out.println("No se realizó la transferencia");
		}
		
		
	}

	@Override
	public void modificar(Transferencia transferencia) {
		// TODO Auto-generated method stub
		this.iTransferenciaRepo.actualizar(transferencia);
	}

	@Override
	public Transferencia buscar(Integer id) {
		// TODO Auto-generated method stub
		return iTransferenciaRepo.buscar(id);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.iTransferenciaRepo.eliminar(id);
	}

}
