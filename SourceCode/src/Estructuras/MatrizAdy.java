/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

import Estructuras.Nodos.Vertice;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import proyecto2.Objetos.CarpetaObj;

/**
 *
 * @author brest12
 */
public class MatrizAdy {
    
    private final Vertice root;
    private int numVertices;
    private int count;
    public MatrizAdy(){
        this.root = new Vertice("root",new CarpetaObj("root", null,  null, null, -1), -1, -1);
        numVertices = 0;
        count = 0;
    }
    
    public Vertice getRoot(){
        return root;
    }
    
    public Vertice buscarFila(int y){
        Vertice temp = root;
        while(temp != null){
            if(temp.getY() == y){
                return temp;
            }
            temp = temp.getDown();
        }
        return null;
    }
    
    public Vertice buscarFila(String nombreCarpeta){
        Vertice temp = root;
        CarpetaObj c;
        while(temp != null){
            c = (CarpetaObj)temp.getDato();
            if(c.getNombre().equals(nombreCarpeta)){
                return temp;
            }
            temp = temp.getDown();
        }
        return null;
    }
    
    public Vertice buscarNodo(String padre, String hijo){
        Vertice temp = root;
        Vertice node;
        CarpetaObj c;
        while (temp != null) {
            c = (CarpetaObj) temp.getDato();
            if (c.getNombre().equals(padre)) {
                node = temp.getRight();
                while(node != null){
                    c = (CarpetaObj) node.getDato();
                    if(c.getNombre().equals(hijo)){
                        return node;
                    }
                    node = node.getRight();
                }
            }
            temp = temp.getDown();
        }
        return null;
    }
    
    public int numVertice(String nombreCarpeta){
        Vertice temp = root;
        CarpetaObj c;
        while(temp != null){
            c = (CarpetaObj) temp.getDato();
            if(c.getNombre().equals(nombreCarpeta)){
                return temp.getX();
            }
            temp = temp.getRight();
        }
        return -1;
    }
    
    public boolean eliminarVertice(String nombreCarpeta){
        int xy = numVertice(nombreCarpeta);
        System.out.println(xy);
        if(xy >= 0){
            Vertice auxCol = buscarColumna(xy);
            Vertice auxRow = buscarFila(xy);
            if(auxCol != null && auxRow != null){
                System.out.println("Shoud delete col: "+((CarpetaObj)auxCol.getDato()).getNombre());
                System.out.println("Shoud delete row: "+((CarpetaObj)auxRow.getDato()).getNombre());
                auxCol.left.right = auxCol.right;
                if(auxCol.right != null){
                    auxCol.right.left = auxCol.left;
                }
                Vertice temp = auxCol.down;
                System.out.println("abajo: "+((CarpetaObj)temp.getDato()).getNombre());
                //   3 4 5 10
                // 3   4   
                // 4
                // 
                // 8
                // 10
                if(temp.left != null){
                    temp.left.right = temp.right;
                }
                auxCol.down = null;
                 
                auxRow.up.down = auxRow.down;
                if (auxRow.down != null) {
                    auxRow.down.up = auxRow.up;
                }
                System.out.println(auxRow.right);
                auxRow.right = null;
                
                auxCol = null;
                auxRow = null;
                return true;

            }
        }
        return false;
    }
    
    private Vertice buscarNodo(int x, int y){
        Vertice aux = root.down;
        while(aux != null){
            
        
        }
            
        return aux;
    }

    public boolean eliminarCarpeta(String padre, String hijo) {
        Vertice nodo = buscarNodo(padre, hijo);
        Vertice cabeceraFila, cabeceraCol, aux, aux2;
        String nombreCabecera;
        if (nodo != null) {
            cabeceraCol = nodo.up;
            cabeceraFila = nodo.left;
            nombreCabecera = cabeceraCol.getNombreNodo();
            System.out.println("Col: " + nombreCabecera);
            aux = nodo.left;
            while (aux != null) {
                if (aux.left == null) {
                    aux2 = aux.down;
                    while (aux2 != null) {
                        if (aux2.getNombreNodo().equals(nombreCabecera)) {
                            System.out.println("Found: " + aux2.getNombreNodo());
                            cabeceraFila = aux2;
                            break;
                        }
                        aux2 = aux2.down;
                    }
                }
                aux = aux.left;
            }
            
            if(nodo.right != null){
                nodo.right.left = nodo.left;
            }
            if(nodo.left != null){
                nodo.left.right = nodo.right;
            }
            
            if(cabeceraCol.right != null){
                cabeceraCol.right.left = cabeceraCol.left;
            }
            if(cabeceraCol.left != null){
                cabeceraCol.left.right = cabeceraCol.right;
            }
            
            if(cabeceraFila.down != null){
                cabeceraFila.down.up = cabeceraFila.up;
            }
            if(cabeceraFila.up != null){
                cabeceraFila.up.down = cabeceraFila.down;
            }
            
            cabeceraCol.down = null;
            if(cabeceraFila.right == nodo){
                cabeceraFila.right = null;
            }
            
            if(nodo.up != null){
                System.out.println("Still alive? "+nodo.up.getNombreNodo());
                nodo.up = null;
            }
            if(nodo.left == cabeceraCol){
                nodo.left = null;
            }
            
            nodo = null;
            cabeceraCol = null;
            cabeceraFila = null;
            return true;
        }

        return false;
    }
    
    public Vertice buscarColumna(int x) {
        Vertice temp = root;
        while (temp != null) {
            if (temp.getX() == x) {
                return temp;
            }
            temp = temp.getRight();
        }
        return null;
    }
    
    public int findDeepestCarpeta(){
        Vertice temp = root;
        while(temp != null){
            if(temp.getRight() == null){
                return temp.getX();
            }
            temp = temp.getRight();
        }
        return 0;
    }
    
    public void convertList_to_Matriz(ListaEnlazada ls){
        CarpetaObj c = ls.obtainCarpeta(0);
        //crear_Cabeceras(0, c.getNombre(), c, false);
        convertingListToMatrix(c, count);
    }
    
    private void convertingListToMatrix(CarpetaObj c, int x){
        crear_Cabeceras(x, c.getNombre(), c, false);
        String nombreNodo;
        if(!c.getNombre().equals("/")){
            if(c.getPadre().getNombre().equals("/")){
                nombreNodo = "/"+c.getNombre();
            }else{
                nombreNodo = c.getPadre().getNombre()+"/"+c.getNombre();
            }
            Vertice p = buscarFila(c.getPadre().getNombre());
            int hijo = cantidadCarpetas(p)+1;
            int padre = numVertice(c.getPadre().getNombre());
            CarpetaObj nueva = new CarpetaObj(nombreNodo, c.getArchivos(), 
                    c.getPadre(), c.getHijos(), c.getnCarpeta());
            insertar_elemento(x,padre, nueva);
        }
        count++;
        if(c.getHijos().getSize() > 0){
            for(int i=0; i < c.getHijos().getSize(); i++){
                convertingListToMatrix(c.getHijos().obtainCarpeta(i), count);
            }
        }
    }
    
    private Vertice insertar_ordenado_columna(Vertice nuevo, Vertice head_col){
       Vertice temp = head_col;
       boolean flag = false;
       
       while(true){
           if(temp.getX() == nuevo.getX()){
               temp.setY(nuevo.getY());
               temp.setDato(nuevo.getDato());
               return temp;
           }
           else if(temp.getX() > nuevo.getX()){
               flag = true;
               break;
           }
           if(temp.getRight() != null){
               temp = temp.getRight();
           }
           else{
               break;
           }
       }
       if(flag){
           nuevo.right = temp;
           temp.left.right = nuevo;
           nuevo.left = temp.left;
           temp.left = nuevo;
       }else{
           temp.right = nuevo;
           nuevo.left = temp;
       }
       return nuevo;
    }
    
    private Vertice insertar_ordenado_fila(Vertice nuevo, Vertice head_col){
       Vertice temp = head_col;
       boolean flag = false;
       
       while(true){
           if(temp.getY() == nuevo.getY()){
               temp.setX(nuevo.getX());
               temp.setDato(nuevo.getDato());
               return temp;
           }
           else if(temp.getY() > nuevo.getY()){
               flag = true;
               break;
           }
           if(temp.getDown()!= null){
               temp = temp.getDown();
           }
           else{
               break;
           }
       }
       if(flag){
           nuevo.down = temp;
           temp.up.down = nuevo;
           nuevo.up = temp.up;
           temp.up = nuevo;    
           
       }else{
           temp.down = nuevo;
           nuevo.up = temp;
       }
       return nuevo;
    }
    
    public int crear_Cabeceras(int x, String nombre, CarpetaObj carp, boolean reinsert){
        System.out.println("insert: "+carp.getNombre());
        if(buscarColumna(x) != null && buscarFila(x) != null){
            if(reinsert){
                    x = x + 1;
                while(buscarColumna(x) != null){
                    x = x + 1;
                }
            }else{
                return -1;
            }
        }
        Vertice c = crear_Columna(x, nombre, carp);
        Vertice f = crear_Fila(x, nombre, carp);
        numVertices++;
        return x;
    }
    
    private Vertice crear_Columna(int x, String nombre, CarpetaObj c){
        Vertice head_col = root;
        Vertice columna = insertar_ordenado_columna(new Vertice(nombre+x,c,x,-1), head_col);
        return columna;
    }
    
    private Vertice crear_Fila(int y, String nombre, CarpetaObj c){
        Vertice head_row = root;
        Vertice row = insertar_ordenado_fila(new Vertice(nombre+y,c,-1,y), head_row);
        return row;
    }
    
    /* Metodo que es llamado cuando se insertara una carpeta nueva en una
    ** posicion donde ya hay una carpeta, entonces la nueva carpeta se debe
    ** insertar en dicha posicion, pero antes re acomodar las carpetas ya existentes
    ** una posicion hacia la derecha.
    */
    public void reAcomodarXCarpetas(Vertice nuevaCarpeta, Vertice carpetaExistente){
        //Reacomodando su x
        Vertice aux = carpetaExistente;
        Vertice node;
        while(aux != null){
            System.out.println("Moving: "+aux.getNombreNodo());
            aux.setX(aux.getX()+1);            
            node = aux.getDown();
            if(node != null){
                node.setX(node.getX()+1);
                System.out.println("node: "+node.getNombreNodo()+" new x : "+node.getX());
            }
            System.out.println("new: "+aux.getNombreNodo());
            aux = aux.getRight();
        }
        
    }
    
    public void reAcomodarYCarpetas(Vertice nuevaCarpeta, Vertice carpetaExistente) {
        //Reacomodando su y
        System.out.println(carpetaExistente.getNombreNodo());
        Vertice aux = carpetaExistente;
        Vertice node;
        while (aux != null) {
            aux.setY(aux.getY() + 1);
            node = aux.getRight();
                if(node != null){
                    node.setY(node.getY()+1);
                }
            aux = aux.getDown();
        }
    }
    
    
    public int cantidadCarpetas(Vertice carpeta){
        int n = 0;
        if(carpeta.right == null){
            return n;
        }
        while(carpeta.right != null){
            n++;
            carpeta = carpeta.right;
        }
        return n;
    }
    
    public ListaEnlazada getHijos(String nombrePadre){
        Vertice aux = buscarFila(nombrePadre);
        ListaEnlazada hijos = new ListaEnlazada();
        while(aux.right != null){
            aux = aux.right;
            hijos.insert(aux.getDato());
        }
        return hijos;
    }
    
    public boolean insertar_elemento(int x, int y, Object dato){
        Vertice nuevo = new Vertice(((CarpetaObj)dato).getNombre(),dato, x, y);
        Vertice columna = buscarColumna(x);
        Vertice fila = buscarFila(y);
        CarpetaObj carpeta = (CarpetaObj) dato;
        
        if(columna == null && fila == null){
            columna = crear_Columna(x, carpeta.getNombre(), carpeta);
            fila = crear_Fila(y, carpeta.getNombre(), carpeta);
            nuevo = insertar_ordenado_columna(nuevo, fila);
            insertar_ordenado_fila(nuevo, columna);
            System.out.println("x: "+nuevo.getX()+" Y: "+nuevo.getY());
            return true;    
        }
        else if(columna == null && fila != null){
            columna = crear_Columna(x, carpeta.getNombre(), carpeta);
            nuevo = insertar_ordenado_columna(nuevo, fila);
            insertar_ordenado_fila(nuevo, columna);
            return true;
        }
        else if(columna != null && fila == null){
            fila = crear_Fila(y, carpeta.getNombre(), carpeta);
            nuevo = insertar_ordenado_columna(nuevo, fila);
            insertar_ordenado_fila(nuevo, columna);
            return true;
        }
        else if(columna != null && fila != null){
            nuevo = insertar_ordenado_columna(nuevo, fila);
            insertar_ordenado_fila(nuevo, columna);
            return true;
        }
        
        return false;
    }
    
    public void imprimir(){
        Vertice aux = root.getDown();
        Vertice col;
        CarpetaObj c;
        while(aux != null){
            System.out.println("------- FILA "+aux.getY()+" -------");
            col = aux.getRight();
            while(col  != null){
                System.out.println("    ------- COL "+col.getX()+" -------");
                c = (CarpetaObj)col.getDato();
                System.out.println("        "+c.getNombre());
                col = col.getRight();
            }
            System.out.println("");
            aux = aux.getDown();
        }
        
        System.out.println("\n--------- END ------------");
        
    }
    
    public void graficar(){
        File archivo = new File("Reports/MatrizAdy.dot");
        try {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
                writer.write(llenarDot());
                
            }
            
            ProcessBuilder publicar;
            publicar = new ProcessBuilder("dot", "-Tpng", "-o", "Reports/MatrizAdy.png", "Reports/MatrizAdy.dot");
            publicar.redirectErrorStream(true);
            publicar.start();
            
        } catch (IOException ex) {
            Logger.getLogger(TablaHash.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private String llenarDot(){
        String archivo = "";
        Vertice temp = root;
        CarpetaObj c = (CarpetaObj) temp.getDato();
        archivo += "digraph Matrix{\n";
        archivo += "    node [shape=box]\n";
        archivo += "    graph [ranksep=\"0.5\", nodesep=\"0.6\"];\n";
        archivo += "    /* Group 0 para alinear verticalmente RAIZ*/ \n";
        archivo += "    "+c.getNombre()+"[label = \""+c.getNombre()+"\", width = 1.5,";
        archivo += " style = filled, fillcolor = coral, group = 0];\n\n";
        
        //CREACION DE NODOS
        archivo += "    //Filas\n";
        Vertice fila = temp.getDown();
        while(fila != null){
            c = (CarpetaObj) fila.getDato();
            archivo += "    Fila"+fila.getY()+" [label = \""+c.getNombre()+"\" width = 1.5";
            archivo += " style = filled, fillcolor = bisque1, group = 0];\n";
            fila = fila.getDown();
        }
        
        //Creacion enlaces de filas
        archivo += "\n  //Enlaces de filas\n";
        fila = temp.getDown();
        
        while(fila != null){
            if(fila.getDown() != null){
                archivo += "    Fila"+fila.getY()+"->Fila"+fila.getDown().getY();
                archivo += "\n";
            }
            fila = fila.getDown();
        }
        
        //Creacion de columnas
        archivo += "\n  //Columnas\n";
        Vertice col = temp.getRight();
        while(col != null){
            c = (CarpetaObj) col.getDato();
            archivo += "    Column"+col.getX()+"[label =\""+c.getNombre()+"\" width = 1.5";
            archivo +=  " style = filled, fillcolor = pink2, group = "+(col.getX()+1)+"];\n";
            col = col.getRight();
        }
        
        archivo += "\n\n    //Enlaces de columnas\n";
        col = temp.getRight();
        while(col != null){
            if(col.getRight() != null){
                archivo += "    Column"+col.getX()+"->Column"+col.getRight().getX()+"\n";
            }
            col = col.getRight();
        }
        //Alineacion horizontal de raiz con columnas
        col = temp.getRight();
        archivo += "\n  //Alinear Raiz con columnas\n";
        c = (CarpetaObj) temp.getDato();
        archivo += "    {rank = same; "+c.getNombre()+";";
        while(col != null){
            archivo += " Column"+col.getX()+";";
            col = col.getRight();
        }
        archivo += "};\n";
        
        archivo += "\n      //Enlaces Raiz con primera fila y column\n";
        archivo += "    "+c.getNombre()+"->Column"+temp.getRight().getX()+";\n";
        archivo += "    "+c.getNombre()+"->Fila"+temp.getDown().getY()+";\n";
        
        //CREACION DE NODOS
        fila = temp.getDown();
        String group = "";
        while(fila != null){
            archivo += "    //(^<---------------------- F I L A   "+fila.getY()+"---------------------->\n";
            col = fila.getRight();
            while(col != null){
                group = ""+(col.getX()+1);
                c = (CarpetaObj) col.getDato();
                archivo += "    N"+col.getX()+"_F"+fila.getY()+" [label = ";
                archivo += "\""+c.getNombre()+"\" width = 1.5 group = "+group+" style = filled,";
                archivo += " fillcolor = lavenderblush1];\n";
                col = col.getRight();
            }
            fila = fila.getDown();
            archivo += "\n";
        }
        
        //ENLACES DE NODOS
        fila = temp.getDown();
        while(fila != null){
            archivo += "    //E N L A C E S  F I L A   "+fila.getY()+"\n";
            col = fila.getRight();
            while(col != null){
                if(fila.getUp() == temp){
                    archivo += "    Column"+col.getX()+"->N"+col.getX()+"_F"+fila.getY();
                    archivo += ";\n";
                }else{
                    if(col.getUp().getY() == -1){
                        archivo += "    Column"+col.getX()+"->N"+col.getX()+"_F"+fila.getY();
                        archivo += ";\n";
                    }else{
                      //  archivo += "    N"+col.getX()+"_F"+fila.getY()+
                      //          "->N"+col.getUp().getX()+"_F"+col.getUp().getY();
                     //   archivo += ";\n";
                    }
                }
                if(col.getLeft() == fila){
                    archivo += "    Fila"+fila.getY()+"->N"+col.getX()+"_F"+fila.getY();
                    archivo += ";\n";
                }
                if(col.getRight() != null){
                    archivo += "    N"+col.getX()+"_F"+fila.getY()+"->N"+col.getRight().getX();
                    archivo += "_F"+fila.getY()+";\n";
                }
                col = col.getRight();
            }
            col = fila.getRight();
            archivo += "    {rank = same; Fila"+fila.getY()+"; ";
            while(col != null){
                archivo += "N"+col.getX()+"_F"+col.getY()+"; ";
                col = col.getRight();
            }
            archivo += "};\n\n";
            fila = fila.getDown();
        }
        archivo += "}\n";
        
        return archivo;
    }
}
