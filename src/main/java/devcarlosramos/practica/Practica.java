package devcarlosramos.practica;

import java.util.ArrayList;
import java.util.Scanner;

public class Practica {

    public static void main(String args[]) {
        Scanner scn = new Scanner(System.in);

        String FIN = "";
        ArrayList<String> listEnglish = new ArrayList();
        ArrayList<String> listSpanish = new ArrayList();

        do {
            int opcion = 0;

            System.out.println("ESCOGER OPCIÓN");
            System.out.println("1.Agregar palabra nueva");
            System.out.println("2.Eliminar palabras");
            System.out.println("3.Empezar a jugar");
            System.out.println("4.FIN");
            System.out.println("Introduce opción:");

            boolean entradaValida = false;
            while (!entradaValida) {
                try {
                    opcion = scn.nextInt();
                    scn.nextLine();
                    entradaValida = true;
                } catch (Exception e) {
                    System.out.println("Tienes que introducir un número de la lista");
                    scn.nextLine();
                }
            }

            switch (opcion) {
                case 1:

                    System.out.println("Palabra en español?");
                    String palabraEspanol = scn.nextLine();
                    listSpanish.add(palabraEspanol);

                    System.out.println("world in english?");
                    String palabraEnglish = scn.nextLine();
                    listEnglish.add(palabraEnglish);

                    break;
                case 2:

                    System.out.println("Lista español");
                    System.out.println(listSpanish);
                    for (String world : listSpanish) {
                        int posicion = listSpanish.indexOf(world) + 1;
                        System.out.println(posicion + "-" + world);
                    }

                    System.out.println("List English");
                    System.out.println(listEnglish);
                    for (String world : listEnglish) {
                        int posicion = listEnglish.indexOf(world) + 1;
                        System.out.println(posicion + "-" + world);
                    }

                    boolean controlEliminar = true;
                    if (controlEliminar) {
                        System.out.println("Eliminar palabra (pon el numero)");
                        int numeroEliminar = scn.nextInt();
                        scn.nextLine();
                        listSpanish.remove(--numeroEliminar);
                        listEnglish.remove(numeroEliminar);
                        
                        System.out.println("Se borro las palabras: "
                                +listSpanish.get(numeroEliminar)+"-"
                                +listEnglish.get(numeroEliminar));
                        controlEliminar=false;
                    }

                    break;
                case 3:
                    boolean terminarjuego=true;
                    int contador=0;
                    do{
                        System.out.println(listEnglish.get(contador));
                        System.out.println("Mostrar palabra en español? A o D");
                        String SioNo= scn.nextLine();
                        if(SioNo.equals("A") || SioNo.equals("a")){
                            System.out.println(listSpanish.get(contador));
                        }
                        
                        System.out.println("Aprendiste la palabra? A o D");
                        String aprender = scn.nextLine();
                        if(aprender.equals("A")|| aprender.equals("a")){
                            listSpanish.remove(contador);
                            listEnglish.remove(contador);       
                        }
                        if(listSpanish.size()==0){
                            System.out.println("Fin del juego");
                            terminarjuego=false;
                        }
                        
                    }while(terminarjuego);

                    break;
                default:
                    FIN = "FIN";

            }

        } while (!FIN.equals("FIN"));

    }
}
