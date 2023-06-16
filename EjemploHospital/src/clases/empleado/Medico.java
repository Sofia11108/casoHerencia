package clases.empleado;

import javax.swing.JOptionPane;

public class Medico extends EmpleadoPlanilla{

	private String especialidad;
	private int numeroDeConsultorio;
	
	@Override
	public void registrarDatos() {
		super.registrarDatos();
		
		especialidad = JOptionPane.showInputDialog("Ingrese su especialidad");
		
		do {
			try {					
				numeroDeConsultorio = Integer.parseInt(JOptionPane.showInputDialog("Num consultorio"));
			}catch(Exception e) {
				System.err.println("Ingrese un tipo numerico");
			}
		}while(numeroDeConsultorio < 0);
	}
	
	public String getEspecialidad() {
		return especialidad;
	}
	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}
	public int getNumeroDeConsultorio() {
		return numeroDeConsultorio;
	}
	public void setNumeroDeConsultorio(int numeroDeConsultorio) {
		this.numeroDeConsultorio = numeroDeConsultorio;
	}
	
	
}
