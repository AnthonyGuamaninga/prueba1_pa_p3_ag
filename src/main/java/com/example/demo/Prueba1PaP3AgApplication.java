package com.example.demo;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.correccion.modelo.CuentaC;
import com.example.demo.correccion.service.ICuentaCService;
import com.example.demo.correccion.service.ITransferenciaCService;

@SpringBootApplication
public class Prueba1PaP3AgApplication implements CommandLineRunner{

	@Autowired
	private ICuentaCService cuentaService;
	@Autowired
	private ITransferenciaCService iTransferenciaCService;
	
	
	public static void main(String[] args) {
		SpringApplication.run(Prueba1PaP3AgApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		// FUNCIONALIDAD 1
		CuentaC cuenta = new CuentaC();
		cuenta.setNumero("01");
		cuenta.setCedula("1123");
		cuenta.setTipo("Ahorros");
		cuenta.setSaldo(new BigDecimal(200));
		//this.cuentaService.crear(cuenta);
		
		CuentaC cuenta2 = new CuentaC();
		cuenta2.setNumero("02");
		cuenta2.setCedula("2223");
		cuenta2.setSaldo(new BigDecimal(150));
		cuenta2.setTipo("Ahorros");		
		//this.cuentaService.crear(cuenta2);
		
		// FUNCIONALIDAD 2
		BigDecimal monto = new BigDecimal(10);
		this.iTransferenciaCService.realizar(cuenta.getNumero(), cuenta2.getNumero(), monto);
		
		// FUNCIONALIDAD 3
		//System.out.println("Saldo Origen: ");
		//this.cuentaService.buscar(cuenta.getNumero());
		
		
		
	}

}
