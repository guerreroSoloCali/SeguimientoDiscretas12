package model.data_structures;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class Grafo{

	
    private int v;
    
    //lINKEDLIST
    
    
    
    private LinkedList<Borde> adj[];

    public Grafo(int v) {
    	
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
        
    }

    
    
    
    public LinkedList<Borde>[] getAdj() {
        return adj;
    }

    
    
    //FUNCION AGREGAR BORDEEE
    
    public void agregarBorde(int s, int d) {
    	
    	
    	Borde e = new Borde(s, d);
        adj[(int) s].add(e);
        
    }

    
    
    //ARRAYLIST
    public ArrayList BFS(int s) {
    	
        ArrayList<Integer> msg = new ArrayList<>();

        boolean visited[] = new boolean[v];
        LinkedList<Integer> queue = new LinkedList<>();
        visited[s] = true;
        queue.add(s);
        while (!queue.isEmpty()) {
            s = queue.poll();
            msg.add(s);
            Iterator<Borde> i = getAdj()[s].listIterator();
            while (i.hasNext()) {
                int n = i.next().getD();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
        return msg;
    }

    
    //GET
    
    public int getSize() {
        return v;
    }


}