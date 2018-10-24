/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ister.controlador;

import ec.edu.ister.vista.*;

/**
 * @Instituto Rumiñahui
 * @author Paola
 */
public class Coordinador {

    Login login = new Login(this);
    Docente docente = new Docente(this);
    Estudiante estudiante = new Estudiante(this);

    public void mostrarLogin() {
        login.setVisible(true);
    }

    public void mostrarDocente() {
        docente.setVisible(true);
    }

    public void mostrarEstudiante() {
        estudiante.setVisible(true);
    }

    public void ocultarLogin() {
        login.setVisible(false);
    }

    public void ocultarDocente() {
        docente.setVisible(false);
    }

    public void ocultarEstudiante() {
        estudiante.setVisible(false);
    }

    public boolean validarCedula(String cedula) {
        boolean respuestaValidacion = false;
        try {
            if (cedula.length() == 10) {
                int tercerDigito = Integer.parseInt(cedula.substring(2, 3));

                if (tercerDigito < 6) {
                    int[] coefValCedula = {2, 1, 2, 1, 2, 1, 2, 1, 2};
                    int verificador = Integer.parseInt(cedula.substring(9, 10));
                    int suma = 0;
                    int digito = 0;

                    for (int i = 0; i < (cedula.length() - 1); i++) {
                        digito = Integer.parseInt(cedula.substring(i, i + 1)) * coefValCedula[i];
                        suma += ((digito % 10) + (digito / 10));
                    }

                    if ((suma % 10 == 0) && (suma % 10 == verificador)) {
                        respuestaValidacion = true;
                    } else if ((10 - (suma % 10)) == verificador) {
                        respuestaValidacion = true;
                    } else {
                        respuestaValidacion = false;
                    }
                } else {
                    System.out.println("La cédula ingresada no existe en ecuador ");
                    respuestaValidacion = false;
                }
            } else {
                System.out.println("La cédula ingresada no tine 10 digitos ");
                respuestaValidacion = false;
            }
        } catch (NumberFormatException numFormatEx) {
            respuestaValidacion = false;
        } catch (Exception ex) {
            System.out.println("Una excepcion ocurrio en el proceso de validadcion ");
            respuestaValidacion = false;
        }
        if (!respuestaValidacion) {
            System.out.print("La cédula ingresada es Incorrecta ");
        }
        if (respuestaValidacion) {
            System.out.print("La cédula ingresada es Correcta ");
        }
        return respuestaValidacion;
    }

}
