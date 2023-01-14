package com.example.demo;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.banco.modelo.Cuenta;
import com.example.demo.banco.service.ICuentaService;
import com.example.demo.banco.service.ITransferenciaService;

@SpringBootApplication
public class Prueba1PaP3AgApplication implements CommandLineRunner{

	@Autowired
	private ICuentaService cuentaService;
	
	@Autowired
	private ITransferenciaService iTransferenciaService;
	
	
	public static void main(String[] args) {
		SpringApplication.run(Prueba1PaP3AgApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		// FUNCIONALIDAD 1
		Cuenta cuenta = new Cuenta();
		cuenta.setNumero("1");
		cuenta.setCedula("1123");
		cuenta.setTipo("Ahorros");
		cuenta.setSaldo(new BigDecimal(100));
		//this.cuentaService.crear(cuenta);
		
		Cuenta cuenta2 = new Cuenta();
		cuenta2.setNumero("2");
		cuenta2.setCedula("2223");
		cuenta2.setSaldo(new BigDecimal(50));
		cuenta2.setTipo("Ahorros");		
		//this.cuentaService.crear(cuenta2);
		
		// FUNCIONALIDAD 2
		BigDecimal monto = new BigDecimal(10);
		this.iTransferenciaService.realizarTransferencia(cuenta.getNumero(), cuenta2.getNumero(), monto);
		
		// FUNCIONALIDAD 3
		System.out.println("Saldo Origen: ");
		this.cuentaService.buscar(cuenta.getNumero());
		
		
		
	}

}
