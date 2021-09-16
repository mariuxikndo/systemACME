/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package systemacme;

import junit.framework.TestCase;
import org.junit.Test;
import systemacme.controlador.GestionSalarioEmpleado;

/**
 *
 * @author mcando
 */
public class GestionSalarioEmpleadoTest extends TestCase {

    private GestionSalarioEmpleado gestionSAlarioEmpleado;

    public void inicializarObjetoTest() {
        gestionSAlarioEmpleado = new GestionSalarioEmpleado();
    }

    @Test
    public void testCalcularCantidadHoras() {
        inicializarObjetoTest();
        double resultado = gestionSAlarioEmpleado.calcularCantidadHoras(10, 12);
        TestCase.assertEquals(2.0, resultado);
    }

    @Test
    public void testCalcularSumaTotalPagar() {
        inicializarObjetoTest();

        String[] lista_dias_trabajados = {"MO10:00-12:00", "TH12:00-14:00", "SU20:00-21:00"};

        double resultado = gestionSAlarioEmpleado.calcularSumaTotalPagar(lista_dias_trabajados);
        TestCase.assertEquals(85.0, resultado);
    }

    @Test
    public void testObtenerTipoJornada() {
        inicializarObjetoTest();
        int hora_inicio = 10;
        int hora_fin = 14;
        int minuto_inicio = 1;
        int minuto_fin = 59;
        // 1 => PRIMERA JORNADA(00:01 - 09:00) , 2 => SEGUNDA JORNADA (09:01 - 18:00), 3 => TERCERA JORNADA(18:01 - 00:00) 
        int tipo_jornada = 2;
        
        int resultado = gestionSAlarioEmpleado.obtenerTipoJornada(hora_inicio, hora_fin, minuto_inicio, minuto_fin);
        
        TestCase.assertEquals(tipo_jornada, resultado);
    }

    @Test
    public void testObtenerTipoHorario() {
        inicializarObjetoTest();
        
        int hora_inicio = 10;
        int hora_fin = 14;
        int minuto_inicio = 1;
        int minuto_fin = 59;
        String dia_semana = "SU";
        /**
         * PRIMERA JORNADA(00:01 - 09:00) , SEGUNDA JORNADA (09:01 - 18:00), TERCERA JORNADA(18:01 - 00:00)
         * DIA NORMAL(MO, TU, WE, TH, FR), FIN DE SEMANA (SA, SU)
         * ****** TIPO HORARIO *******
         * 1 => DIA NORMAL, PRIMERA JORNADA
         * 2 => DIA NORMAL, SEGUNDA JORNADA
         * 3 => DIA NORMAL, TERCERA JORNADA
         * 4 => FIN DE SEMANA, PRIMERA JORNADA
         * 5 => FIN DE SEMANA, SEGUNDA JORNADA
         * 6 => FIN DE SEMANA, TERCERA JORNADA
         */
        
        int tipo_horario = 5;
        
        int resultado = gestionSAlarioEmpleado.obtenerTipoHorario(dia_semana,hora_inicio, hora_fin, minuto_inicio, minuto_fin);
        TestCase.assertEquals(tipo_horario, resultado);
    }

    @Test
    public void testCalcularTotalPagoHorario() {
        inicializarObjetoTest();
        /**
         * PRIMERA JORNADA(00:01 - 09:00) , SEGUNDA JORNADA (09:01 - 18:00), TERCERA JORNADA(18:01 - 00:00)
         * DIA NORMAL(MO, TU, WE, TH, FR), FIN DE SEMANA (SA, SU)
         * ****** TIPO HORARIO *******
         * 1 => DIA NORMAL, PRIMERA JORNADA
         * 2 => DIA NORMAL, SEGUNDA JORNADA
         * 3 => DIA NORMAL, TERCERA JORNADA
         * 4 => FIN DE SEMANA, PRIMERA JORNADA
         * 5 => FIN DE SEMANA, SEGUNDA JORNADA
         * 6 => FIN DE SEMANA, TERCERA JORNADA
         */
        int tipo_horario = 1;
        int cantidad_horas = 2;
        double resultado = gestionSAlarioEmpleado.calcularTotalPagoHorario(tipo_horario, cantidad_horas);
        TestCase.assertEquals(50.0, resultado);
    }

}
