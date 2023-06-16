package clases.empleado;

import javax.swing.JOptionPane;

public class EmpleadoPlanilla extends Empleado{

	private double salarioMensual;
	private double porcentajeAdicionalPorHoraExtra;
	
	@Override
	public void registrarDatos() {
		super.registrarDatos();
		
		do {
			try {					
				salarioMensual = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el salario Mensual"));
			}catch(Exception e) {
				System.err.println("Ingrese un tipo numerico");
			}
		}while(salarioMensual < 0);
		
		porcentajeAdicionalPorHoraExtra = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el Porcentaje Adicional por Hora Extra"));
	}
	
	public double getSalarioMensual() {
		return salarioMensual;
	}
	public void setSalarioMensual(double salarioMensual) {
		this.salarioMensual = salarioMensual;
	}
	public double getPorcentajeAdicionalPorHoraExtra() {
		return porcentajeAdicionalPorHoraExtra;
	}
	public void setPorcentajeAdicionalPorHoraExtra(double procentajeAdicionalPorHoraExtra) {
		this.porcentajeAdicionalPorHoraExtra = procentajeAdicionalPorHoraExtra;
	}
	
	
	
}
