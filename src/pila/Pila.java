
package pila;
import java.io.*;
import java.util.Scanner;
/**
 *
 * @author ARRAZOLA JIMENEZ ALEJANDRO
 */
public class Pila {
 char[]pila=new char[10];
 Integer tope=9;
 Integer tamaño=-1;
 
 
 
 public void comparacion(String cadena){
    int entrada=0;
    int salida=0;
    tamaño=-1;
   for(int i=0;i<cadena.length();i++){
   if(cadena.charAt(i)=='{'||cadena.charAt(i)=='['||cadena.charAt(i)=='('){
     push(cadena.charAt(i));
     entrada++;
   }
   if(cadena.charAt(i)=='}'||cadena.charAt(i)==']'||cadena.charAt(i)==')'){
      salida++;
   }
   if(cadena.charAt(i)==')'&&tamaño>-1){
       if(pila[tamaño]=='('){
        pop();
      }
    }
   if(cadena.charAt(i)==']'&&tamaño>-1){
       if(pila[tamaño]=='['){
        pop();
      }
    }
   if(cadena.charAt(i)=='}'&&tamaño>-1){
       if(pila[tamaño]=='{'){
        pop();
      }
    }
   
   }
   
  if(tamaño==-1&&entrada==salida){System.out.println("SI");}
  else{System.out.println("NO");}
 }
 
 public void leer(String documento){
      int numero=0;
     Scanner archivo=null;
        try{
      archivo= new Scanner(new File(documento));
      }
      catch(Exception e){
          System.out.println("archivo no encontrado!!");
      }
      while(archivo.hasNext()){
      archivo.next();
      numero=numero+1;
      }
      
      String cadenas[]=new String[numero];
      String aux="";
      int o=0;
      Scanner archivo1=null;
        try{
      archivo1= new Scanner(new File(documento));
      }
      catch(Exception e){
          System.out.println("archivo no encontrado!!");
      }
      while(archivo1.hasNext()){
      aux = archivo1.next();
      cadenas[o]=aux;
      o=o+1;
      }
      for(int l=1;l<numero;l++){
       comparacion(cadenas[l]);
      }
      
     
    }
 
 public void push(char dato){
  if(tamaño<tope){
  tamaño++;
  pila[tamaño]=dato;
  }
  
  else{System.out.println("desbordamiento");}
 }
 
 public char pop(){
   char resultado =' ';
   if(tamaño>-1){
   resultado=pila[tamaño];
   pila[tamaño]=' ';
   tamaño--;
   }
 else{System.out.println("SUBdesbordamiento");}
  return resultado;
 }
 
 public char pick(){
 char resultado =' ';
 if(tamaño>-1){
  resultado=pila[tamaño];
 }
 else{System.out.println("SUBdesbordamiento");}
 return resultado;
 
 }
 
    
    public static void main(String[] args)throws IOException {
     BufferedReader lee= new BufferedReader(new InputStreamReader(System.in));
     System.out.println("ingresa la direccion del archivo");
     Pila b=new Pila();
     String documento=lee.readLine();
     b.leer(documento);
     //b.leer("C:\\Users\\alejandro\\Desktop\\numeros.txt");
     
        }
    
}
