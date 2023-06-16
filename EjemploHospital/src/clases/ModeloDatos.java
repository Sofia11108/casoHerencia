package clases;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.swing.JOptionPane;

import clases.empleado.EmpleadoEventual;
import clases.empleado.EmpleadoPlanilla;
import clases.empleado.Medico;

public class ModeloDatos {

	HashMap<String, Paciente> pacientesMap;
	HashMap<String, EmpleadoPlanilla> empleadosPlanillaMap;
	HashMap<String, EmpleadoEventual> empleadosEventualMap;
	HashMap<String, Medico> medicosMap;
	ArrayList<CitaMedica> citasList;

	public ModeloDatos() {
		pacientesMap = new HashMap<String, Paciente>();
		empleadosPlanillaMap = new HashMap<String, EmpleadoPlanilla>();
		medicosMap = new HashMap<String, Medico>();
		empleadosEventualMap = new HashMap<String, EmpleadoEventual>();
		citasList = new ArrayList<CitaMedica>();
	}

	public void registrarCitaMedica(CitaMedica miCita) {
		citasList.add(miCita);
		System.out.println("Se ha registrado la cita exitosamente\n");
		System.out.println(miCita.informacionCitaMedica());
	}

	public Paciente consultarPacientePorDocumento(String documentoPaciente) {
		Paciente miPaciente = null;

		if (pacientesMap.containsKey(documentoPaciente)) {
			miPaciente = pacientesMap.get(documentoPaciente);
		}

		return miPaciente;
	}

	public Medico consultarMedicoPorNombre(String nombreMedico) {

		for (Medico medico : medicosMap.values()) {

			if (medico.getNombre().equalsIgnoreCase(nombreMedico)) {
				return medico;
			}
		}

		return null;
	}

	public void registrarPersona(Paciente miPaciente) {

		if (!pacientesMap.containsKey(miPaciente.getNumeroDeDNI())) {
			pacientesMap.put(miPaciente.getNumeroDeDNI(), miPaciente);
			System.out.println("Se ha registrado el paciente " + miPaciente.getNombre() + " Satisfactoriamente");

		} else {
			System.out.println("El paciente" + miPaciente.getNombre() + " con DNI " + miPaciente.getNumeroDeDNI()
					+ " ya se encuentra registrado");
		}
	}

	public void registrarPersona(EmpleadoPlanilla miEmpPlanilla) {

		if (!empleadosPlanillaMap.containsKey(miEmpPlanilla.getNumeroDeDNI())) {
			empleadosPlanillaMap.put(miEmpPlanilla.getNumeroDeDNI(), miEmpPlanilla);
			System.out.println(
					"Se ha registrado el empleado por planilla " + miEmpPlanilla.getNombre() + " Satisfactoriamente");
		} else {
			System.out.println("El empleado planilla" + miEmpPlanilla.getNombre() + " con DNI "
					+ miEmpPlanilla.getNumeroDeDNI() + " ya se encuentra registrado");
		}
	}

	public void registrarPersona(EmpleadoEventual miEmpEventual) {

		if (!empleadosEventualMap.containsKey(miEmpEventual.getNumeroDeDNI())) {
			empleadosEventualMap.put(miEmpEventual.getNumeroDeDNI(), miEmpEventual);
			System.out.println(
					"Se ha registrado el empleado eventual " + miEmpEventual.getNombre() + " Satisfactoriamente");
		} else {
			System.out.println("El empleado eventual" + miEmpEventual.getNombre() + " con DNI "
					+ miEmpEventual.getNumeroDeDNI() + " ya se encuentra registrado");
		}
	}

	public void registrarPersona(Medico miMedico) {

		if (!medicosMap.containsKey(miMedico.getNumeroDeDNI())) {

			medicosMap.put(miMedico.getNumeroDeDNI(), miMedico);
			System.out.println("Se ha registrado el medico " + miMedico.getNombre() + " Satisfactoriamente");
		} else {
			System.out.println("El medico" + miMedico.getNombre() + " con DNI " + miMedico.getNumeroDeDNI()
					+ " ya se encuentra registrado");
		}
	}

	public void imprimirPacientes() {

		if (!pacientesMap.isEmpty()) {

			String msj = "PACIENTES REGISTRADOS\n";
			Iterator<String> iterador = pacientesMap.keySet().iterator();

			while (iterador.hasNext()) {
				String clave = iterador.next();
				pacientesMap.get(clave).imprimirDatosPersona(msj);
			}

		} else {
			System.err.println("No hay pacientes registrados");
		}
	}

	public void imprimirEmpleadosEventuales() {

		if (!empleadosEventualMap.isEmpty()) {

			String msj = "EMPLEADOS EVENTUALES REGISTRADOS\n";

			for (String clave : empleadosEventualMap.keySet()) {
				empleadosEventualMap.get(clave).imprimirDatosPersona(msj);
			}
		} else {
			System.err.println("No hay empleados eventuales registrados");
		}
	}

	public void imprimirEmpleadosPorPlanilla() {

		if (!empleadosPlanillaMap.isEmpty()) {

			String msj = "EMPLEADOS POR PLANILLA REGISTRADOS\n";

			for (EmpleadoPlanilla empleadoPlanilla : empleadosPlanillaMap.values()) {
				empleadoPlanilla.imprimirDatosPersona(msj);
			}

			imprimirMedicos();

		} else {
			System.err.println("No hay empleados por planilla registrados");
		}
	}

	public void imprimirMedicos() {

		if (!medicosMap.isEmpty()) {

			String msj = "MEDICOS REGISTRADOS\n";

			for (Map.Entry<String, Medico> elemento : medicosMap.entrySet()) {
				elemento.getValue().imprimirDatosPersona(msj);
			}
		} else {
			System.err.println("No hay medicos registrados");
		}
	}

	public void imprimirCitasMedicasProgramadas() {

		if (!citasList.isEmpty()) {

			String msj = "CITAS MEDICAS PROGRAMADAS\n";
			CitaMedica miCita = null;

			System.out.println(msj + "\n");

			if (citasList.size() > 0) {
				for (int i = 0; i < citasList.size(); i++) {
					miCita = citasList.get(i);
					System.out.println(miCita.informacionCitaMedica());
				}
			} else {
				System.out.println("No existen citas programadas");
			}

		} else {
			System.err.println("No hay citas programadas registrados");
		}
	}

	public void imprimirPaciente() {

		if (!pacientesMap.isEmpty()) {

			String documento = JOptionPane.showInputDialog("Ingrese el numero del documento");

			String msj = "PACIENTE REGISTRADO\n";

			if (pacientesMap.containsKey(documento)) {

				pacientesMap.get(documento).imprimirDatosPersona(msj);
			}
		} else {
			System.err.println("No hay pacientes registrados");
		}
	}

	public void imprimirEmpleadoEventual() {

		if (!empleadosEventualMap.isEmpty()) {

			String documento = JOptionPane.showInputDialog("Ingrese el numero del documento");

			String msj = "EMPLEADO EVENTUAL REGISTRADO\n";

			if (empleadosEventualMap.containsKey(documento)) {

				empleadosEventualMap.get(documento).imprimirDatosPersona(msj);
			}
		} else {
			System.err.println("No hay empleados eventuales registrados");
		}
	}

	public void imprimirEmpleadoPlanilla() {

		if (!empleadosPlanillaMap.isEmpty()) {

			String documento = JOptionPane.showInputDialog("Ingrese el numero del documento");

			String msj = "EMPLEADO POR PLANILLA REGISTRADO\n";

			if (empleadosPlanillaMap.containsKey(documento)) {

				empleadosPlanillaMap.get(documento).imprimirDatosPersona(msj);

			}
		} else {
			System.err.println("No hay empleados por planilla registrados");
		}
	}

	public void imprimirMedico() {

		if (!medicosMap.isEmpty()) {

			String documento = JOptionPane.showInputDialog("Ingrese el numero del documento");

			String msj = "MEDICO REGISTRADO\n";

			if (medicosMap.containsKey(documento)) {

				medicosMap.get(documento).imprimirDatosPersona(msj);
			}
		} else {
			System.err.println("No hay medicos registrados");
		}

	}

}
