/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Empleados;

/**
 *
 * @author ADRIAN CASTILLO
 */
public class ArbolEmpleados {
    NodoEmpleado raiz;
    
    // Constructor que inicializa la raíz como nula
    public ArbolEmpleados(){
        raiz = null;
    }
    
    // Método que agrega un nuevo empleado al árbol
    public void agregarEmpleado(String nombre,  double salario,  int id){
        NodoEmpleado nuevoEmpleado = new NodoEmpleado(nombre,salario,id);
        if (raiz == null) {
            // Si el árbol está vacío, el nuevo empleado se convierte en la raíz
            raiz = nuevoEmpleado;
            System.out.println("Registro exitoso!");
        } else {
            // Si el árbol no está vacío, se busca la posición adecuada para el nuevo empleado
            NodoEmpleado actual = raiz;
            NodoEmpleado padre;
            while (true) {
                //la variable actual se utilizara como auxiliar
                padre = actual;
                if (id< actual.id) {
                    actual = actual.hijoIzquierdo;//reasignar el nodo actual a Hijo izquierdo
                    if (actual == null) { //comprobar si el hijo esta vacio
                        // Si se llega al final de la rama izquierda, el nuevo empleado se agrega como hijo izquierdo del padre
                        padre.hijoIzquierdo = nuevoEmpleado; //se agrega el hijo al padre
                        System.out.println("Registro exitoso!");
                        return;
                    }
                    
                    //en caso que no este vacio se repite el procedimiento
                } else if (id > actual.id) {
                    actual = actual.hijoDerecho; //reasignar actual como hijo derecho
                    if (actual == null) { // si esta basio
                        // Si se llega al final de la rama derecha, el nuevo empleado se agrega como hijo derecho del padre
                        padre.hijoDerecho = nuevoEmpleado;
                        System.out.println("Registro exitoso!");
                        return;
                    }
                    
                } else {
                // Si se encuentra un empleado con el mismo ID, muestra un mensaje de error
                System.out.println("Ya existe un empleado con el ID: " + id);
                return;
            }
            }
        }        
    }
    
    // Busca un empleado en el árbol por su nombre
    public void buscarEmpleado(int id) {
        NodoEmpleado actual = raiz;
        while (actual != null && actual.id != id) {
            if (id < actual.id) {
                actual = actual.hijoIzquierdo;
            } else {
                actual = actual.hijoDerecho;
            }
        }
        if (actual == null) {
            // Si no se encuentra el empleado, se muestra un mensaje de error
            System.out.println("No se encontró el empleado con ID: " + id + " en la base de datos.");
        } else {
            // Si se encuentra el empleado, se muestra su nombre y salario
            System.out.println("El empleado con ID: " + id + " es " + actual.nombre + " y su salario es de " + actual.salario+ " dolares");
        }
    }
    // Elimina un empleado del árbol por su ID
    public void eliminarEmpleado(int id) {
        raiz = eliminarEmpleadoRecursivo(raiz, id);
        if(raiz==null){
            
        }
        System.out.println("El empleado con ID " + id + " ha sido eliminado.");
    }
    // Método auxiliar para eliminar un empleado recursivamente
    private NodoEmpleado eliminarEmpleadoRecursivo(NodoEmpleado nodo, int id) {
        if (nodo == null) {
            // Si el nodo es nulo, no se encontró el empleado en el árbol
            System.out.println("No se encontró el empleado con ID: " + id + " en la base de datos.");
            return null;
        }

        if (id < nodo.id) {
            // El ID buscado es menor, se busca en el subárbol izquierdo
            nodo.hijoIzquierdo = eliminarEmpleadoRecursivo(nodo.hijoIzquierdo, id);
        } else if (id > nodo.id) {
            // El ID buscado es mayor, se busca en el subárbol derecho
            nodo.hijoDerecho = eliminarEmpleadoRecursivo(nodo.hijoDerecho, id);
        } else {
            // Se encontró el empleado con el ID buscado
            if (nodo.hijoIzquierdo == null && nodo.hijoDerecho == null) {
                // Caso 1: El nodo a eliminar es una hoja (no tiene hijos)
                return null;
            } else if (nodo.hijoIzquierdo == null) {
                // Caso 2: El nodo a eliminar solo tiene hijo derecho
                return nodo.hijoDerecho;
            } else if (nodo.hijoDerecho == null) {
                // Caso 3: El nodo a eliminar solo tiene hijo izquierdo
                return nodo.hijoIzquierdo;
            } else {
                // Caso 4: El nodo a eliminar tiene ambos hijos
                // Se busca el sucesor inorden (el menor valor en el subárbol derecho)
                NodoEmpleado sucesor = obtenerSucesorInorden(nodo.hijoDerecho);
                // Se reemplaza el valor del nodo a eliminar con el del sucesor
                nodo.id = sucesor.id;
                nodo.nombre = sucesor.nombre;
                nodo.salario = sucesor.salario;
                // Se elimina el sucesor inorden del subárbol derecho
                nodo.hijoDerecho = eliminarEmpleadoRecursivo(nodo.hijoDerecho, sucesor.id);
            }
        }

        return nodo;
    }
    // Método auxiliar para obtener el sucesor inorden de un nodo
    private NodoEmpleado obtenerSucesorInorden(NodoEmpleado nodo) {
        NodoEmpleado actual = nodo;
        while (actual.hijoIzquierdo != null) {
            actual = actual.hijoIzquierdo;
        }
        return actual;
    }
    
    
    // Muestra los empleados en el árbol en orden ascendente por ID
    public void consultarEmpleados() {
        System.out.println("Empleados en la base de datos:");
        System.out.println("----------------------------------------");
        System.out.printf("%-5s %-20s %-10s\n", "ID", "Nombre", "Salario");
        System.out.println("----------------------------------------");
        inorden(raiz);
        System.out.println("----------------------------------------");
    }
    
    // Recorre el árbol en inorden por ID (izquierda - raíz - derecha)
    private void inorden(NodoEmpleado nodo) {
        if (nodo != null) {
            inorden(nodo.hijoIzquierdo);
            System.out.printf("%-5d %-20s %-10.2f\n", nodo.id, nodo.nombre, nodo.salario);
            inorden(nodo.hijoDerecho);
        }
    }
}
