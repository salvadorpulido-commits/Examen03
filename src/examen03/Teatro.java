

	
	/*1 - En el main, define una matriz de asientos sala con 6 filas y 10 columnas. 
○ Cada asiento puede estar: 
■ 'L' (Libre) 
■ 'R' (Reservado) 
■ 'O' (Ocupado) 
○ Inicializa toda la sala a 'L'.*/
	
	

	/*2 - Crea una función pintarSala que pida  sala como argumento y muestre la sala 
por consola con formato de tabla, incluyendo: 
● encabezado con número de columna, 
● número de fila al inicio de cada línea, 
● el estado de cada asiento.*/
		
	
		
	/*3 - Crea una función esPosicionValida con sala, fila, columna de 
argumentos que devuelva true si la fila y columna están dentro del rango de la 
matriz.*/
		
   /*4 - Crea una función contarEstado con sala, estado de argumentos que 
	devuelva cuántos asientos hay de un estado concreto ('L', 'R' u 'O').*/
		
	/*5 - Crea una función reservarAsiento con los argumentos que necesites que: 
● compruebe si la posición es válida, 
● reserve el asiento si está libre ('L' -> 'R'), 
● devuelva true si la operación se realiza, false si no se puede. */
		
	/* 6 - 	Crea una función reservarGrupoEnFila con sala, fila, 
numeroPersonas como argumentos que: 
● busque en esa fila un bloque de numeroPersonas asientos consecutivos 
libres, 
● si lo encuentra, los cambie a reservados  y devuelva un array int[] que 
contiene dos datos: la columna de inicio y de fin del bloque reservado, 
● si no lo encuentra, devuelva null. */
		
	/* 7 - TEATRO 
1. Mostrar sala 
2. Reservar asiento suelto 
3. Reservar grupo en una fila 
4. Confirmar reservas (R -> O) 
5. Cancelar reservas (R -> L) 
6. Estadísticas 
7. Salir 

*/
		
package examen03;

	import java.util.Scanner;

	public class Teatro {

	    public static void main(String[] args) {

	        Scanner sc = new Scanner(System.in);

	        char[][] sala = new char[6][10];
	        int opcion;
	        int fila;
	        int columna;
	        int numeroPersonas;
	        String entrada;
	        String[] partes;
	        int[] bloque;

	        
	        
	        // Inicializar sala a L
	       for (int i = 0; i < sala.length; i++) {
	           for (int j = 0; j < sala[i].length; j++) {
	                sala[i][j] = 'L';
	            }
	        }

	        do {

	            System.out.println("\nTEATRO");
	            System.out.println("1. Mostrar sala ");
	            System.out.println("2. Reservar asiento suelto");
	            System.out.println("3. Reservar grupo en una fila");
	            System.out.println("4. Confirmar reservas");
	            System.out.println("5. Cancelar reservas");
	            System.out.println("6. Estadisticas");
	            System.out.println("7. Salir");

	            System.out.print("Opcion: ");
	            opcion = sc.nextInt();
	            sc.nextLine();

	           switch(opcion) {

	                case 1:
	                    pintarSala(sala);
	                    break;

	                case 2:
	                    try {
	                        System.out.print(" Introduce fila,columna (ejemplo 2,7): ");
	                        entrada = sc.nextLine();
	                        partes = entrada.split(",");

	                        fila = Integer.parseInt(partes[0]);
	                        columna = Integer.parseInt(partes[1]);

	                        if (reservarAsiento(sala, fila, columna))   {
	                            System.out.println("Asiento reservado.");
	                        }else {
	                            System.out.println("No se pudo reservar.");
	                        }

	                    }catch (Exception e) {
	                        System.out.println("Formato incorrecto.");
	                    }
	                    break;

	                case 3:

	                    try {
	                        System.out.print("Fila: ");
	                        fila = sc.nextInt();

	                        System.out.print("Numero de personas: ");
	                        numeroPersonas = sc.nextInt();
	                        sc.nextLine();

	                        bloque = reservarGrupoEnFila(sala, fila, numeroPersonas);

	                       if (bloque != null) {
	                            System.out.println("Reservado desde columna "
	                                    + bloque[0] + " hasta " + bloque[1]);
	                        }else {
	                            System.out.println("No hay hueco suficiente.");
	                        }

	                    } catch (Exception e) {
	                        System.out.println("Entrada incorrrecta.");
	                        sc.nextLine();
	                    }

	                    break;

	                case 4:
	                    confirmarReservas(sala);
	                    System.out.println("Reservas confirmadas.");
	                    break;

	                case 5:
	                    cancelarReservas(sala);
	                    System.out.println("Reservas canceladas.");
	                    break;

	                case 6:
	                    mostrarEstadisticas(sala);
	                    break;
	                 
	            }

	        } while (opcion != 7);

	        sc.close();
	    }

	    private static void cancelarReservas(char [][] sala) {

	   
	    }

		
		
		private static void confirmarReservas(char [][] sala) {

		}

		// Mostrar sala
		
	    static void pintarSala(char[][] sala) {

	        System.out.print("   ");
	        for (int j = 0; j < sala[0].length; j++) {
	            System.out.print(j + " ");
	        }
	        System.out.println();

	        for (int i = 0; i < sala.length; i++) {
	            System.out.print(i + "  ");
	            for (int j = 0; j < sala[i].length; j++) {
	                System.out.print(sala[i][j] + " ");
	            }
	            System.out.println();
	        }
	    }

	    // Comprobar posicon valida	    
	        static boolean esPosicionValida(char[][] sala, int fila, int columna) {

	        if (fila >=  0 && fila < sala.length &&
	                columna >= 0 && columna < sala[0].length) {
	            return true;
	        }

	        return false;
	    }

	    // Contar estado	
	    
	    static int contarEstado(char[][] sala, char estado) {
	        int contador = 0;

	        for (int i = 0; i < sala.length; i++) {
	            for (int j = 0; j < sala[i].length; j++) {
	                if (sala[i][j] == estado) {
	                    contador++;
	                }
	            }
	            
	           }	
	        return contador;
	        }
	    
	    
	    // Reservar asiento 
	    
	    
	    static boolean reservarAsiento(char[][] sala, int fila, int columna) {

	        if (esPosicionValida(sala, fila, columna) && sala[fila][columna] == 'L') {
	            sala[fila][columna] = 'R';
	            return true;
	        }

	        return false;
	    }
	    
	    // Reservrar grupo en fila
	    
	    	
	    static int[] reservarGrupoEnFila(char[][] sala, int fila, int numeroPersonas) {

	        if (fila < 0 || fila >= sala.length) {
	            return null;
	        }

	        for (int j = 0; j <= sala[fila].length - numeroPersonas; j++) {
	            boolean bloqueLibre = true;

	            for (int k = 0; k < numeroPersonas; k++) {
	                if (sala[fila][j + k]!= 'L') {
	                    bloqueLibre = false;
	                    break;
	                }
	            }

	            if (bloqueLibre) {
	                for (int k = 0; k < numeroPersonas; k++) {
	                    sala[fila][j + k]= 'R';
	                }
	                return new int[]{j, j + numeroPersonas - 1};
	            }
	        }

	        return null;
	        
	               
	    }
	    
	    // Estadisticas
	    
	    static void mostrarEstadisticas(char[][] sala) {
	        int libres = contarEstado(sala, 'L');
	        int reservados = contarEstado(sala, 'R');
	        int ocupados = contarEstado(sala, 'O');

	        System.out.println("Estadisticas:");
	        System.out.println("Libres: " + libres);
	        System.out.println("Reservados: " + reservados);
	        System.out.println("Ocupados: " + ocupados);
	        
	        	}
	    
	    
	    
	    }
	
	
	
	    
	
	       
	   
		
	
	
	
	
		
	    

	      
	    
	    
	    
	    
	  