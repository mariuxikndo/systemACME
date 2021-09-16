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
public class GestionSalarioEmpleadoTest extends TestCase{
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
    
}
