package ui;

import model.data_structures.Borde;
import model.data_structures.Grafo;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {

	
	
    private static Grafo g;
    private static Scanner sc;


    public static void main(String[] args) {

    	
        sc = new Scanner(System.in);
        graphSize();

        int option;

        do {
        	
            option = printMenu();

            switch (option) {
                case 1:
                	agregarBorde();
                    break;
                    
                case 2:
                    BFS();
                    break;

            }
            

        } while (option != 3 && option > 0);


    }
    
    
    //MENU PARA QUE EL USUARIO ESCOJA UNA OPCION
    private static int printMenu() {
        System.out.println("------------------------------------------------------------*\n" +
                "***************Grafo de numeros enteros***************\n" +
                "1. Agregar conexiones" + "\n" +
                "2. Algoritmo de BFS" + "\n" +
                "3. Salir del Menu");

            try {
                return sc.nextInt();

            }catch (Exception e){
                System.out.println("*. El tamaño debe ser un numero entero");
                printMenu();
            }
        System.out.println("-----------------------------------------------------------\n" );
        return 0;
    }

    
    
    
    //METODO EQUIVALENTE A AGREGAR UN BORDE PARA EL GRAFOO
    
    private static void agregarBorde() {
    	
        System.out.println("*. Digite un nodo inicial: ");
        
        int init = sc.nextInt();
        System.out.println("*. Digite el nodo final: ");
        int end = sc.nextInt();
        
        System.out.println("1. Conexion A-B\n" + "2. Conexion circular  " );

        int option = sc.nextInt();

        switch (option) {
            case 1:
                g.agregarBorde(init, end);
                break;
            case 2:
                g.agregarBorde(init, end);
                g.agregarBorde(end, init);
                break;
        }

    }
    

    
    
    
    
    private static void graphSize() {
    	
    	
    	//METODO PARA EL TAMAÑO DEL GRAFO
        System.out.println("*. Digite el tamaño del grafo: ");

        try {
        	
            g = new Grafo(sc.nextInt());

        }catch (Exception e){
        	
            System.out.println("*. El tamaño debe ser un numero entero");
            graphSize();
        }

        

    }
    
    
    
    //BFS PARA BFS
    private static void BFS() {
        LinkedList<Borde>[] vertex = g.getAdj();
        boolean result = true;

        for(LinkedList<Borde> e : vertex){
            if (e.size() != 0 && g.BFS(e.getFirst().getS()).size() != g.getSize()){
                result = false;
                break;
            }else{
                System.out.println(g.BFS(e.getFirst().getS()).toString());
            }

        }
    
        
        
        
        //DICE SI EL GRAFO ES FUERTEMENTE CONEXO O NO
        if (result){
            System.out.println("*. SI es un grafo fuertemente conexo");
        }else{
            System.out.println("*.  NO es un grafo fuertemente conexo");
        }

    }


}
