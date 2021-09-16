/*
 * Clase que contiene las funciones para poder determinar el salario de un empleado
 */
package systemacme.controlador;

/**
 *
 * @author mcando
 */
public class GestionSalarioEmpleado {

    /**
     * *
     * Función que calcula el total de horas trabajadas
     *
     * @param hora_inicio
     * @param hora_fin
     * @return
     */
    public double calcularCantidadHoras(double hora_inicio, double hora_fin) {
        if (hora_fin >= hora_inicio) {
            return hora_fin - hora_inicio;
        }
        return 0;
    }

    /**
     * *
     * Función que permite determinar el tipo de jornada trabajada
     *
     * @param hora_inicio
     * @param hora_fin
     * @param minuto_inicio
     * @param minuto_fin
     * @return
     */
    public int obtenerTipoJornada(int hora_inicio, int hora_fin, int minuto_inicio, int minuto_fin) {

        double hora_minuto_inicio, hora_minuto_fin;

        hora_minuto_inicio = hora_inicio + (minuto_inicio / 60);
        hora_minuto_fin = hora_fin + (minuto_fin / 60);

        if (hora_minuto_inicio > 0 && hora_minuto_fin <= 9) {
            return 1;
        } else {
            if (hora_minuto_inicio > 9 && hora_minuto_fin <= 18) {
                return 2;
            } else {
                return 3;
            }
        }

    }

    /**
     * *
     * Función que permite determinar el tipo de horario de trabajo
     *
     * @param dia_semana
     * @param hora_inicio
     * @param hora_fin
     * @param minuto_inicio
     * @param minuto_fin
     * @return
     */
    public int obtenerTipoHorario(String dia_semana, int hora_inicio, int hora_fin, int minuto_inicio, int minuto_fin) {
        int tipo_horario = 0;
        //Se determina el tipo de jornada de trabajo
        int tipo_jornada = obtenerTipoJornada(hora_inicio, hora_fin, minuto_inicio, minuto_fin);
        //Para determinar el tipo de horario de trabajo dependiendo del día de la semana y el tipo de jornada
        switch (dia_semana) {
            case "MO":
            case "TU":
            case "WE":
            case "TH":
            case "FR":
                if (tipo_jornada == 1) {
                    tipo_horario = 1;
                } else {
                    if (tipo_jornada == 2) {
                        tipo_horario = 2;
                    } else {
                        if (tipo_jornada == 3) {
                            tipo_horario = 3;
                        }
                    }
                }
                break;
            case "SA":
            case "SU":
                if (tipo_jornada == 1) {
                    tipo_horario = 4;
                } else {
                    if (tipo_jornada == 2) {
                        tipo_horario = 5;
                    } else {
                        if (tipo_jornada == 3) {
                            tipo_horario = 6;
                        }
                    }
                }
                break;
            default:
                tipo_horario = 0;
        }
        return tipo_horario;
    }

    /**
     * Función para calcular el total a pagar según la cantidad de horas trabajadas y el tipo
     * de horario en el que se trabajó
     *
     * @param tipo
     * @param cantidad_horas
     * @return
     */
    public double calcularTotalPagoHorario(int tipo, double cantidad_horas) {
        double total_pago;
        switch (tipo) {
            case 1:
            case 6:
                total_pago = cantidad_horas * 25;
                break;
            case 2:
                total_pago = cantidad_horas * 15;
                break;
            case 3:
            case 5:
                total_pago = cantidad_horas * 20;
                break;
            case 4:
                total_pago = cantidad_horas * 30;
                break;
            default:
                total_pago = 0;
        }

        return total_pago;
    }
    
    /***
     * Calcula el total a pagar según un listado de días trabajados
     * @param lista_dias_trabajados
     * @return 
     */
    public double calcularSumaTotalPagar(String[] lista_dias_trabajados) {
        String[] lista_horarios;
        String dia_semana;
        int hora_inicio, minuto_inicio, hora_fin, minuto_fin;
        double cantidad_horas;
        int tipo_horario;
        double suma_total_pagar = 0;

        for (String dia_trabajado : lista_dias_trabajados) {

            //Para obtener el día de la semana, ya que los códigos son de 2 caracteres(MO, TU, WE, etc.)
            dia_semana = dia_trabajado.substring(0, 2);
            
            //Para obtener la hora de inicio y fin del día trabajado, ya que esta información se separa por el caracter -
            lista_horarios = dia_trabajado.substring(2).split("-");

            hora_inicio = Integer.parseInt(lista_horarios[0].substring(0, 2));
            minuto_inicio = Integer.parseInt(lista_horarios[0].substring(3));
            hora_fin = Integer.parseInt(lista_horarios[1].substring(0, 2));
            minuto_fin = Integer.parseInt(lista_horarios[1].substring(3));
            
            //Se determina el tipo de horario trabajado
            tipo_horario = obtenerTipoHorario(dia_semana, hora_inicio, hora_fin, minuto_inicio, minuto_fin);
            
            //Se determina la cantidad de horas trabajadas
            cantidad_horas = calcularCantidadHoras(hora_inicio, hora_fin);
            
            //Se calcula el total a pagar por día trabajado y se va sumando a la variable que almacena el resultado del total a pagar
            suma_total_pagar += calcularTotalPagoHorario(tipo_horario, cantidad_horas);

        }
        return suma_total_pagar;
    }
    
    /***
     * Función que gestiona y muestra el total a pagar a un empleado
     * @param cadena_texto
     * @return 
     */
    public String gestionarTotalPagarEmpleado(String cadena_texto) {
        String nombre_empleado;
        String[] lista_cadena, lista_dias_trabajados;

        lista_cadena = cadena_texto.split("=");
        //Se obtiene el nombre del emppleado
        nombre_empleado = lista_cadena[0];
        
        //Se obtiene el listado de días trabajados
        lista_dias_trabajados = lista_cadena[1].split(",");
        return ("El total por pagar a " + nombre_empleado + " es: " + calcularSumaTotalPagar(lista_dias_trabajados) + " USD");

    }
}
