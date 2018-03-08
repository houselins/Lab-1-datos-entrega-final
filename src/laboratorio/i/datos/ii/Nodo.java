/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laboratorio.i.datos.ii;

/**
 *
 * @author ofortich
 */
public class Nodo {
    
    Boolean paquete;//si es un paquete va a ser verdadero
    private String nombre;
    private String data;
    private Nodo rLink;
    private Nodo lLink;

    public Nodo(String nombre, Boolean paquete) {
        this.nombre = nombre;
        this.paquete=paquete;
        this.data=data;
    }
    
    /*
    void add(int i) {
        Nodo temp=this,ant=null;
        while(temp!=null){
            if(temp.data==i)break;
            else if(i>temp.data){
                ant=temp;
                temp=temp.Rlink;
            }else{
                ant=temp;
                temp=temp.Llink;
            }
        }
        if(temp==null){//no esta repetido
            if(i>ant.data) ant.rLink= new Nodo(i);
            else ant.Llink= new Nodo(i);
        }
    }
    */
    void add(String nombre, Boolean paquete){
        if (paquete) {
            this.ultPaquete().lLink=new Nodo(nombre, true);
        }else{
            this.ultEntregable().rLink=new Nodo(nombre, false);
        }
    }
    
    private Nodo ultPaquete(){
        Nodo p=this;
        while(p.lLink != null){
            p=p.lLink;
        }
        return p;
    }
    boolean existe(String nombre, Nodo p){
        if (p==null) {
            return false;
        }else{
            if (p.nombre.equals(nombre)) {
                return true;
            }else{
               return existe(nombre, p.lLink)||existe(nombre, p.rLink);
            }
        }
    }
    Nodo buscarPaquete(String nombre, Nodo p) {
        if (p != null) {
            if (p.nombre.equals(nombre)) {
                return p;
            } else {
                buscarPaquete(nombre, p.lLink);
            }
        }
        return null;
    }
    Nodo buscarEntregable(String nombre, Nodo p){
        if (p!=null) {
            if (p.nombre.equals(nombre)) {
                return p;
            }else{
                buscarEntregable(nombre,p.rLink);
            }
        }
        return null;
    }
    
    private Nodo ultEntregable(){
        Nodo p=this;
        while(p.rLink != null){
            p=p.rLink;
        }
        return p;
    }
}
