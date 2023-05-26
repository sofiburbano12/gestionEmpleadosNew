/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Empleados;

import java.util.Scanner;

/**
 *
 * @author ADRIAN CASTILLO
 */
public class ProgramaEmpleados {
  public static void main(String[] args) {
    
    ArbolEmpleados arbolEmpleados = new ArbolEmpleados();
    Scanner sc = new Scanner(System.in);
    boolean continuar = true;
    while (continuar==true) {
        try {
            System.out.println("\n¿Qué acción desea realizar?");
            System.out.println("1. Agregar empleado");
            System.out.println("2. Buscar empleado");
            System.out.println("3. Consultar todos los empleados");
            System.out.println("4. Eliminar empleado");
            System.out.println("5. Salir");
            System.out.print("Digite la opcion que desea realizar: ");
            int opcion = sc.nextInt();
            sc.nextLine(); // consumir el salto de línea
        switch (opcion) {
          case 1:
                  
            System.out.println("---------Agregar empleado--------------");
            System.out.print("NOMBRE: ");
            String nombre = sc.nextLine();
            
            System.out.print("SALARIO: ");
            double salario = sc.nextDouble();
            
            System.out.print("ID: ");
            int id = sc.nextInt();
            
            arbolEmpleados.agregarEmpleado(nombre, salario, id);
            break;
          case 2:

            System.out.println("----------Buscar empleado----------");
            System.out.print("ID: ");
            id = sc.nextInt();
            arbolEmpleados.buscarEmpleado(id);
            System.out.println("---------------------------------");
            break;
          case 3:

            System.out.println("--------Consultar todos los empleados---------");
            arbolEmpleados.consultarEmpleados();
            
            break;
          case 4:
            System.out.println("\n-----------Eliminar Empleado----------------");
            System.out.print("ID: ");
            id = sc.nextInt();
            arbolEmpleados.eliminarEmpleado(id);
            break;
          case 5:
            System.out.println("Gracias por utilizar el programa");
            continuar = false;
            break;
          default:
            System.out.println("\n---------------------------");
            System.out.println("\nOpción inválida");
        }
        } catch (Exception e) {
            System.out.println("Error, solo datos numericos");
            
        }
          
    }
    System.out.println("\n¡Hasta pronto!");
  }
}