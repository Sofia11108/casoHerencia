package clases.empleado;

import javax.swing.JOptionPane;

import clases.Persona;

public class Empleado extends Persona {

	private String codigoDeEmpleado;
	private int numeroDeHorasExtras;
	private String fechaDeIngreso;
	private String area;
	private String cargo;
	public String getCodigoDeEmpleado() {
		return codigoDeEmpleado;
	}
	
	@Override
	public void registrarDatos() {
		super.registrarDatos();
		
		codigoDeEmpleado = JOptionPane.showInputDialog("Ingrese el codigo del empleado");
		
		do {
			try {
				numeroDeHorasExtras = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de horas extras"));
					
			}catch(Exception e) {
				System.err.println("Ingrese un tipo numerico");
			}
		}while(numeroDeHorasExtras < 0);
		
		fechaDeIngreso = JOptionPane.showInputDialog("Ingrese la fecha de ingreso (dd/mm/aaaa)");
		area = JOptionPane.showInputDialog("Ingrese el area");
		cargo = JOptionPane.showInputDialog("Ingrese el cargo");
	}
	
	public void setCodigoDeEmpleado(String codigoDeEmpleado) {
		this.codigoDeEmpleado = codigoDeEmpleado;
	}
	public int getNumeroDeHorasExtras() {
		return numeroDeHorasExtras;
	}
	public void setNumeroDeHorasExtras(int numeroDeHorasExtras) {
		this.numeroDeHorasExtras = numeroDeHorasExtras;
	}
	public String getFechaDeIngreso() {
		return fechaDeIngreso;
	}
	public void setFechaDeIngreso(String fechaDeIngreso) {
		this.fechaDeIngreso = fechaDeIngreso;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
	
}
