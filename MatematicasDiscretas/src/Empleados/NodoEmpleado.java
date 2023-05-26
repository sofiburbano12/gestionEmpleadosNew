/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Empleados;

/**
 *
 * @author ADRIAN CASTILLO
 */
public class NodoEmpleado {
    String nombre;              // Nombre del empleado
    double salario;             // Salario del empleado
    int id;                     // Identificación del empleado
    NodoEmpleado hijoIzquierdo; // Referencia al hijo izquierdo del nodo
    NodoEmpleado hijoDerecho;   // Referencia al hijo derecho del nodo
  
    // Constructor de la clase NodoEmpleado
    public NodoEmpleado(String nombre,  double salario,  int id) {
    this.nombre = nombre;
    this.salario = salario;
    
    this.id=id;
    this.hijoIzquierdo = null;
    this.hijoDerecho = null;
    }
}
    
