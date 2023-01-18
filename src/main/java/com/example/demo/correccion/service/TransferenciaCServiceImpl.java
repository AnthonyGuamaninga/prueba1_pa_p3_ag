package com.example.demo.correccion.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.correccion.modelo.CuentaC;
import com.example.demo.correccion.modelo.TransferenciaC;
import com.example.demo.correccion.repository.ICuentaCRepository;
import com.example.demo.correccion.repository.ITransferenciaCRepo;

@Service
public class TransferenciaCServiceImpl implements ITransferenciaCService {

	@Autowired
	private ITransferenciaCRepo transferenciaCRepo;
	
	@Autowired
	private ICuentaCRepository cuentaCRepository;

	@Override
	public void realizar(String numeroOrigen, String numeroDestino, BigDecimal monto) {
		// TODO Auto-generated method stub
		//ORIGEN
		CuentaC origen = this.cuentaCRepository.buscar(numeroOrigen);
		BigDecimal comision = monto.multiply(new BigDecimal(0.05));
		BigDecimal montoDebitar = monto.add(comision);

		BigDecimal saldoActualOrigen = origen.getSaldo();							
		
		
		//DESTINO
		CuentaC destino = this.cuentaCRepository.buscar(numeroDestino);
		BigDecimal saldoActualDestino = destino.getSaldo();
		
		
		if(saldoActualOrigen.compareTo(montoDebitar) < 0) {
			System.out.println("Monto no permitido");
		}else {
			origen.setSaldo(saldoActualOrigen.subtract(montoDebitar));
			this.cuentaCRepository.actualizar(origen);
			
			destino.setSaldo(saldoActualDestino.add(monto));
			this.cuentaCRepository.actualizar(destino);
			
			//TRANSFERENCIA
			TransferenciaC transferenciaC = new TransferenciaC();
			transferenciaC.setComision(comision);
			transferenciaC.setCuentaOrigen(numeroOrigen);
			transferenciaC.setCuentaDestino(numeroDestino);
			transferenciaC.setMonto(monto);
			transferenciaC.setFechaTransferencia(LocalDateTime.now());
			this.transferenciaCRepo.insertar(transferenciaC);
			
		}
		
		
		
	}

}
