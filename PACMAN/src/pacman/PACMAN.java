
package pacman;

import java.util.Scanner;
import java.io.IOException;
import java.util.Random;

public class PACMAN {
         
 // METODO PRINCIPAL, MENU DE INICIO DEL JUEGO
    public static void main(String[] args)  {
       
        // ASIGNACION DE VALORES PARA MENU PRINCIPAL
        contadorhistorial=0;  
        String principal="";
        
        String [] historialnombre=new String[20] ;
        String[]historialedad=new String[20] ;
        int[]historialpuntos=new int[20];
        int[]historialmovimiento=new int[20];
        //INICIO DEL PROGRAMA
        limpiarpantalla();
            System.out.println(); 
            System.out.println("                        ¡PRESIONA ENTER PARA COMENZAR!                        ");
            System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            System.out.println("%                             %%%%%%%%%%%%%%%%%                               %");
            System.out.println("%                          %%%%%%%%%%%%%%%%%%%%%%%                            %");
            System.out.println("%                        %%%%%%%%%%%%%%%%%%%%%%%%%%%                          %");
            System.out.println("%                      %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%                        %");
            System.out.println("%                    %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%                      %");
            System.out.println("%                   %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%                            %");
            System.out.println("%                  %%%%%%%%%%%%%%%%%%%%%%%%%%                                 %");
            System.out.println("%                  %%%%%%%%%%%%%%%%%%%%                                       %");
            System.out.println("%                  %%%%%%%%%%%%%%%%%%%%                                       %");
            System.out.println("%                  %%%%%%%%%%%%%%%%%%%%%%%%%%                                 %");
            System.out.println("%                   %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%                            %");
            System.out.println("%                    %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%                      %");
            System.out.println("%                      %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%                        %");
            System.out.println("%                        %%%%%%%%%%%%%%%%%%%%%%%%%%%                          %");
            System.out.println("%                          %%%%%%%%%%%%%%%%%%%%%%%                            %");
            System.out.println("%                             %%%%%%%%%%%%%%%%%                               %");
            System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            new Scanner(System.in).nextLine();
            
            
       //MENU DEL JUEGO
       while (principal!="3"){
            limpiarpantalla(); 
            Scanner opcion = new Scanner(System.in);
            System.out.println();
            System.out.println("                                 Menú Principal                               ");
            System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            System.out.println();
            System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%");
            System.out.println("% 1. Jugar              %");
            System.out.println("% 2. Historial          %");
            System.out.println("% 3. Salir              %");
            System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%");
            System.out.print("Ingrese la opción: ");
            principal=opcion.nextLine(); 
            
                switch (principal){
                    case "1" :
                        contadorhistorial++;
                        datosjugador(historialnombre,historialedad);
                        tamañotablero();
                        mensajejuego();
                        juego(historialpuntos,historialmovimiento);
                        break;
                    case "2" :
                        
                        mostrarhistorial(historialnombre,historialedad,historialpuntos,historialmovimiento);
                        break;
                    case "3" : 
                        limpiarpantalla();
                        System.exit(0);
                        break;    
                    default:
                        System.out.println("PORFAVOR INGRESE UNA OPCIÓN VALIDA");
                        System.out.println();
                        System.out.println("Para volver a seleccionar una opcion presione Enter");
                        new Scanner(System.in).nextLine();
                               
                }  
        } 
    }
       
    
    //VARIABLES PARA USAR EN TODOS LOS METODOS
    private static String nombre,edad;
    private static int fila,columna, contadorhistorial;
    private static int nmovimiento,puntos;
    private static String [] historialnombre; String[]historialedad;int[]historialpuntos;int[]historialmovimiento;
    
   //LIMPIAR PANTALLA EN WINDOWS, MAC Y LINUX
    public static void limpiarpantalla() {
       try{
            String sistemaOperativo = System.getProperty("os.name");
            if(sistemaOperativo.contains("Windows")){
                new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
            }else{
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
         
        }  catch(Exception  e){
            System.err.println("Error al limpiar la pantalla" + e.getMessage());
        }         
    }   
    
    //HISTORIAL
    public static void mostrarhistorial(String [] historialnombre, String[]historialedad,int[]historialpuntos,int[]historialmovimiento){
        
        limpiarpantalla();
        System.out.println();
        System.out.println("                                   Historial                                  ");
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        System.out.println();
        try{
            for(int i=0;i<10;i++){
                if (i == (contadorhistorial-1)||i<contadorhistorial ){
                    System.out.println("Nombre: "+ historialnombre[i] );
                    System.out.println("Edad: "+ historialedad [i]);
                    System.out.println("Punteo: "+ historialpuntos[i] );          
                    System.out.println("Movimientos: "+ historialmovimiento[i]);    
                    System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
                                   
                        }  
            }  
        } catch(Exception  e){
            System.err.println("Error " + e.getMessage());
        } 
        //VOLVER A MENU PRINCIPAL
        System.out.println();
        System.out.println("Para volver al Menu presione Enter");
        new Scanner(System.in).nextLine();
        limpiarpantalla();    
    }    
    
    // DATOS DEL JUGADOR   
    public static void datosjugador(String [] historialnombre,String[]historialedad)  {
        limpiarpantalla();
        System.out.println();
        System.out.println("                              Datos del Jugador                               ");
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%5%%%%%%%");
        System.out.println();
        System.out.println("Ingrese su nombre:");
        Scanner datosnombre = new Scanner(System.in);
        nombre = datosnombre.nextLine();
        System.out.println("Ingrese su edad:");
        Scanner datosedad = new Scanner(System.in);
        edad = datosedad.nextLine();
          for(int i=0; i<20;i++){
            if (i==contadorhistorial-1){
                historialnombre[i]=nombre;  
                historialedad[i]=edad;
               
            }
         }  
        
    }
    
    //INGRESAR FILAS Y COLUMNAS
    public static void tamañotablero() {
        
        limpiarpantalla();
        System.out.println();
        System.out.println("                            Dimensiones del tablero                           ");
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        System.out.println();
        try{
            Scanner datos = new Scanner(System.in);
            System.out.println("Ingrese número de filas de su tablero:");
            fila = datos.nextInt()+2;
            datos.nextLine();
            while (fila < 10) { 
                System.out.println("El número no es valido (valor minimo 8)");
                System.out.println("Ingrese número de filas de su tablero:");
                fila = datos.nextInt()+2;
                datos.nextLine();
               
            } 
            System.out.println("Ingrese número de colunas de su tablero:");
            columna = datos.nextInt()+2;
            datos.nextLine();
            while (columna < 10) { 
                System.out.println("El número no es valido (valor minimo 8)");
                System.out.println("Ingrese número de columnas de su tablero:");
                columna = datos.nextInt()+2;
                datos.nextLine();
            }       
        } catch(Exception  e){
            System.out.println(" ");
            System.out.println("ERROR, no se permiten letras");
            System.out.println("Presione Enter para volver a colocar las dimensiones.....");
            new Scanner(System.in).nextLine();
            tamañotablero();
             
        } 
    }
    
    // INFORMACION SOBRE LOS MOVIMIENTOS EN EL JUEGO 
    public static void mensajejuego() {
     
        limpiarpantalla();
        System.out.println();
        System.out.println("                                  Importante                                  ");
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        System.out.println();
        System.out.println("Las teclas para moverse en el juego son:");
        System.out.println();
        System.out.println("Con la tecla D avanza hacia la derecha");
        System.out.println("Con la tecla A avanza hacia la izquierda");
        System.out.println("Con la tecla W avanza hacia arriba");
        System.out.println("Con la tecla S avanza hacia abajo");
        System.out.println();
        System.out.println("SOLO SE ACEPTARAN LAS MAYÚSCULAS,si es minúscula su movimiento no sera valido. ");
        System.out.println("Presione Enter despues de teclear su movimiento para que este se ejecute.");
        System.out.println();
        System.out.println("Presione Enter para continuar....");
        new Scanner(System.in).nextLine();
        limpiarpantalla();
        System.out.println();
        System.out.println("                                  Importante                                  ");
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        System.out.println();
        System.out.println("Los items le sumaran o restaran puntos de la siguiente forma:");
        System.out.println();
        System.out.println("Si come el # se restaran 10 puntos");
        System.out.println("Si come el @ se sumaran 10 puntos");
        System.out.println("Si come el $ se sumaran 15 puntos");
        System.out.println();
        System.out.println("Presione Enter para Comenzar el juego....");
        new Scanner(System.in).nextLine();
    }
    
      //MENSAJE DE CONFIRMACION PARA ABANDONAR PARTIDA
    public static boolean confirmar(){
        boolean confirmacion= true;
        try{
            Scanner leer= new Scanner(System.in);
            System.out.println(" "); 
            System.out.print("¿Desea abandonar la partida? \n1 - Si \t2 - No\n ---->");
            String lee=leer.next();
            int op = Integer.parseInt(lee);
            if(op == 1){
                confirmacion = false;

            }else if(op == 2){
                confirmacion = true; 
            }
            while (op < 1||op > 2) {   
               System.out.println("La opcion no es valida, intente de nuevo: "); 
               lee=leer.next();
               op = Integer.parseInt(lee);
            if(op == 1){
                confirmacion = false;

            }else if(op == 2){
                confirmacion = true; 
            }
            }       
        
        }catch(NumberFormatException n){
            System.err.println("Error " + n.getMessage());
            confirmar();
           
        }    
        return confirmacion;
    }
     
    
    // CONTANDO MOVIMIENTOS Y PUNTOS DEL PACMAN
    public static void informacionj(){
        System.out.println();    
        System.out.println("Nombre: " + nombre);
        System.out.println("Punteo: " + puntos);
        System.out.println("Movimientos:" + nmovimiento);
    }
    
    //DIBUJANDO TABLERO Y JUGAR
    public static void juego(int [] historialpuntos,int[]historialmovimiento){
        
        boolean confirmacion = true;
        limpiarpantalla();
        //CALCULOS PARA LOS ESPACIOS LIBRES EN LOS BORDES 
        int libre, libre1;
        if (fila%2 == 0){
            libre=(fila/2)-1;
            libre1 = libre+1;
        }else{
            libre=((fila-1)/2)-1;
            libre1= libre+1;
        }
        
        // RANDOM PARA LOS OBSTACULOS Y POSICION INICIAL DEL PACMAN
        Random aleatorio = new Random();
        Random posicionp1=new Random();
        Random posicionp2=new Random();
        int fi= posicionp1.nextInt(fila-1);
        int ci=posicionp2.nextInt(columna-2);
        while(fi==0||ci==0){
            fi= posicionp1.nextInt(fila-1);
            ci=posicionp2.nextInt(columna-2);
        }
        
        //ASIGNACION DE VALOR PARA LAS VARIABLES A UTILIZAR
        int posicionc=ci;
        int posicionf=fi;
        nmovimiento=0;
        puntos=10;
        int contador=0,contador1=0,contador2=0;
       
        
       
        //LLENANDO Y DIBUJANDO MATRIZ POR PRIMERA VEZ
        informacionj();
        String [][] matriz = new String[fila][columna];
        for(int i = 0; i < fila; i++){
            for (int j = 0; j < columna; j++){
                
                // BORDES
                if (j == (columna-1) || j == 0 || i == (fila -1) || i == 0){
                    if (i == libre || i == libre1){
                        matriz [i][j] = " ";  
                    }else{
                        matriz [i][j] = "%";     
                    }   
                }
                //ALEATORIO POSICION INICIAL PACMAN
                if(i==fi && j==ci){
                   matriz [i][j] ="V";   
                    }
                
                 //ALEATORIO PAREDES INERNAS           
                if ( i !=libre && i!=libre1 &&i!=fi && j!=ci  ){
                        if (aleatorio.nextBoolean()) {
                            matriz[i][j]="%";
                        }     
                }
                 // ITEMS INICIALES           
                if (j != (columna-1) || j != 0 || i != (fila -1) || i != 0){
                    if(contador==0&& matriz[i][j]==null){
                        if (aleatorio.nextBoolean()) {
                            matriz[i][j]="#";
                            contador++;
                        }
                    }
                    
                    if(contador1==0&& matriz[i][j]==null){
                        if (aleatorio.nextBoolean()) {
                            matriz[i][j]="$";
                            contador1++;
                        }
                    }
                    
                    if(contador2==0&& matriz[i][j]==null){
                        if (aleatorio.nextBoolean()) {
                            matriz[i][j]="@";
                            contador2++;
                        }
                    }
                }
                 //IMPRIMIR MATRIZ            
                if(matriz[i][j]==null){
                    System.out.print(" ");
                } else{
                    System.out.print(matriz[i][j]);
                }
                
                if(j+1==columna){
                    System.out.println("");
                }         
            }
        } 
        
       
        // MOVIMIENTO EN EL JUEGO
        Scanner datos = new Scanner(System.in);
        String movimiento="";
        while (movimiento!=" "&& confirmacion){
            movimiento= datos.nextLine(); 
           
            switch (movimiento){
                
                case "A" :
                   
                    nmovimiento++;
                     
                     // CONDICIONES PARA SUMA DE PUNTOS
                    if (matriz[posicionf][posicionc-1]=="@"){
                        contador2=0;
                        puntos=puntos+10;
                    }else  if (matriz[posicionf][posicionc-1]=="$"){
                        contador1=0;
                        puntos=puntos+15;
                    }else if(matriz[posicionf][posicionc-1]=="#"){
                        contador=0;
                        puntos=puntos-10;
                    }
                    
                    matriz[posicionf][posicionc]=null;
                    if (matriz[posicionf][posicionc-1]=="%"){
                        posicionc=posicionc; 
                    }else if(posicionf>=1){
                        posicionc-=1;
                    }  
                    limpiarpantalla(); 
                    informacionj();
                    for(int i = 0; i < fila; i++){
                        for (int j = 0; j < columna; j++){
                            
                            if (j != (columna-1) || j != 0 || i != (fila -1) || i != 0){
                                if(contador==0 && matriz[i][j]==null){
                                    if (aleatorio.nextBoolean()) {
                                        matriz[i][j]="#";
                                        contador++;
                                    }
                                }

                                if(contador1==0&& matriz[i][j]==null){
                                    if (aleatorio.nextBoolean()) {
                                        matriz[i][j]="$";
                                        contador1++;
                                    }
                                }

                                if(contador2==0&& matriz[i][j]==null){
                                    if (aleatorio.nextBoolean()) {
                                        matriz[i][j]="@";
                                        contador2++;
                                    }
                                }
                            } 
                            //POSICION PACMAN- TECLAS
                            if(i==posicionf && j== posicionc){
                                   if (i == libre || i == libre1){      
                                        if (j==0){
                                               matriz [i][columna-2] ="V";
                                               posicionc=(columna-2);   
                                        }else{
                                            matriz [i][j] = "V"; 
                                        } 
                                    } else {
                                       matriz [i][j] = "V"; 
                                   }
                                    
                                    
                                }
                                //IMPRIMIR MATRIZ
                                if(matriz[i][j]==null){
                                    System.out.print(" ");
                                } else{
                                    System.out.print(matriz[i][j]);
                                }
                
                                if(j+1==columna){
                                    System.out.println("");
                                }         
                            }
                        }
                    //CONDICIONES PARA GANAR O PERDER
                    if(puntos<=0){
                        limpiarpantalla(); 
                        puntos=0;
                        System.out.println("GAME OVER");
                        System.out.println();
                        System.out.println("Presione Enter para regresar al menú....");
                        new Scanner(System.in).nextLine();
                        for(int i=0; i<20;i++){
                            if (i==contadorhistorial-1){
                                historialpuntos[i]=puntos;
                                historialmovimiento[i]=nmovimiento;
                            }
                         }
                        nmovimiento=0;
                        confirmacion =false;
                    }
                     
                    if(puntos>=100){
                        limpiarpantalla(); 
                        puntos=100;
                        System.out.println("GAME ");
                        System.out.println("¡Felicitaciones!");
                        System.out.println();
                        System.out.println("Presione Enter regresar al menú....");
                        new Scanner(System.in).nextLine();
                        for(int i=0; i<20;i++){
                            if (i==contadorhistorial-1){
                                historialpuntos[i]=puntos;
                                historialmovimiento[i]=nmovimiento;
                            }
                         }
                        nmovimiento=0;
                        confirmacion =false;   
                    }
                    
                    break;
                case "S":   
               
                   
                    nmovimiento++;
                    if (matriz[posicionf+1][posicionc]=="@"){
                        contador2=0;
                        puntos=puntos+10;
                    }else  if (matriz[posicionf+1][posicionc]=="$"){
                        contador1=0;
                        puntos=puntos+15;
                    }else if(matriz[posicionf+1][posicionc]=="#"){
                        contador=0;
                        puntos=puntos-10;
                    }
                 
                    matriz[posicionf][posicionc]=null;
                    if (matriz[posicionf+1][posicionc]=="%"){
                        posicionf=posicionf;
                    }else if(posicionf<fila-2){
                        posicionf+=1;
                    } 
                     limpiarpantalla();
                    informacionj();
                    for(int i = 0; i < fila; i++){
                        for (int j = 0; j < columna; j++){
                            if (j != (columna-1) || j != 0 || i != (fila -1) || i != 0){
                                if(contador==0 && matriz[i][j]==null){
                                    if (aleatorio.nextBoolean()) {
                                        matriz[i][j]="#";
                                        contador++;
                                    }
                                }

                                if(contador1==0&& matriz[i][j]==null){
                                    if (aleatorio.nextBoolean()) {
                                        matriz[i][j]="$";
                                        contador1++;
                                    }
                                }

                                if(contador2==0&& matriz[i][j]==null){
                                    if (aleatorio.nextBoolean()) {
                                        matriz[i][j]="@";
                                        contador2++;
                                    }
                                }
                            }   
                            
                            if(i==posicionf && j== posicionc){   
                                matriz [i][j] = "V";  
                            }
                             
                            if(matriz[i][j]==null){
                                System.out.print(" ");
                            } else{
                                System.out.print(matriz[i][j]);
                            }
                
                            if(j+1==columna){
                                System.out.println("");
                            }         
                        }
                    }
                    if(puntos<=0){
                        limpiarpantalla(); 
                        puntos=0;
                        System.out.println("GAME OVER");
                        System.out.println();
                        System.out.println("Presione Enter para continuar....");
                        new Scanner(System.in).nextLine();
                         for(int i=0; i<20;i++){
                            if (i==contadorhistorial-1){
                                historialpuntos[i]=puntos;
                                historialmovimiento[i]=nmovimiento;
                            }
                         }
                        nmovimiento=0;
                        confirmacion =false;
                    }
                     
                    if(puntos>=100){
                        limpiarpantalla();
                        puntos=100;
                        System.out.println("GAME ");
                        System.out.println("¡Felicitaciones!");
                        System.out.println();
                        System.out.println("Presione Enter para continuar....");
                        new Scanner(System.in).nextLine();
                         for(int i=0; i<20;i++){
                            if (i==contadorhistorial){
                                historialpuntos[i]=puntos;
                                historialmovimiento[i]=nmovimiento;
                            }
                         }
                        nmovimiento=0;
                        confirmacion =false;  
                    }
                    break;
                    
                 case "D" :
                   
                    nmovimiento++;
                    if (matriz[posicionf][posicionc+1]=="@"){
                        contador2=0;
                        puntos=puntos+10;
                    }else  if (matriz[posicionf][posicionc+1]=="$"){
                        contador1=0;
                        puntos=puntos+15;
                    }else if(matriz[posicionf][posicionc+1]=="#"){
                        contador=0;
                        puntos=puntos-10;
                    }
                    matriz[posicionf][posicionc]=null;
                    if (matriz[posicionf][posicionc+1]=="%"){
                        posicionc=posicionc;  
                    }else if(posicionc<columna-2){
                        posicionc+=1;
                    } 
                     limpiarpantalla();
                    informacionj();
                    for(int i = 0; i < fila; i++){
                        for (int j = 0; j < columna; j++){
                            if (j != (columna-1) || j != 0 || i != (fila -1) || i != 0){
                                if(contador==0 && matriz[i][j]==null){
                                    if (aleatorio.nextBoolean()) {
                                        matriz[i][j]="#";
                                        contador++;
                                    }
                                }

                                if(contador1==0&& matriz[i][j]==null){
                                    if (aleatorio.nextBoolean()) {
                                        matriz[i][j]="$";
                                        contador1++;
                                    }
                                }

                                if(contador2==0&& matriz[i][j]==null){
                                    if (aleatorio.nextBoolean()) {
                                        matriz[i][j]="@";
                                        contador2++;
                                    }
                                }
                            }  
                            if(i==posicionf && j== posicionc){
                                if (i == libre || i == libre1){      
                                    if (j==columna-2){
                                        matriz [i][1] ="V";
                                        posicionc=1;   
                                    }else{
                                        matriz [i][j] = "V"; 
                                    } 
                                } else {
                                    matriz [i][j] = "V"; 
                                }                  
                            }
                            if(matriz[i][j]==null){
                                System.out.print(" ");
                            } else{
                                System.out.print(matriz[i][j]);
                            }
                
                            if(j+1==columna){
                                System.out.println("");
                            }         
                        }
                    }
                    if(puntos<=0){
                        limpiarpantalla(); 
                        puntos=0;
                        System.out.println("GAME OVER");
                        System.out.println();
                        System.out.println("Presione Enter para continuar....");
                        new Scanner(System.in).nextLine();
                         for(int i=0; i<20;i++){
                            if (i==contadorhistorial-1){
                                historialpuntos[i]=puntos;
                                historialmovimiento[i]=nmovimiento;
                            }
                         }
                        nmovimiento=0;
                        confirmacion =false;
                   }
                     
                    if(puntos>=100){
                        limpiarpantalla(); 
                        puntos=100;
                        System.out.println("GAME ");
                        System.out.println("¡Felicitaciones!");
                        System.out.println();
                        System.out.println("Presione Enter para continuar....");
                        new Scanner(System.in).nextLine();
                         for(int i=0; i<20;i++){
                            if (i==contadorhistorial-1){
                                historialpuntos[i]=puntos;
                                historialmovimiento[i]=nmovimiento;
                            }
                         }
                        nmovimiento=0;
                        confirmacion =false;  
                    }
                    break;  
                case "W":   
                  
                    nmovimiento++;
                    if (matriz[posicionf-1][posicionc]=="@"){
                        contador2=0;
                        puntos=puntos+10;
                    }else  if (matriz[posicionf-1][posicionc]=="$"){
                        contador1=0;
                        puntos=puntos+15;
                    }else if(matriz[posicionf-1][posicionc]=="#"){
                        contador=0;
                        puntos=puntos-10;
                    }
                    
                    matriz[posicionf][posicionc]=null;
                    if (matriz[posicionf-1][posicionc]=="%"){
                        posicionf=posicionf;
                     
                    }else if(posicionf>1){
                        posicionf-=1;
                    } 
                     limpiarpantalla();
                    informacionj();
                    for(int i = 0; i < fila; i++){
                        for (int j = 0; j < columna; j++){
                            if (j != (columna-1) || j != 0 || i != (fila -1) || i != 0){
                                if(contador==0 && matriz[i][j]==null){
                                    if (aleatorio.nextBoolean()) {
                                        matriz[i][j]="#";
                                        contador++;
                                    }
                                }

                                if(contador1==0&& matriz[i][j]==null){
                                    if (aleatorio.nextBoolean()) {
                                        matriz[i][j]="$";
                                        contador1++;
                                    }
                                }

                                if(contador2==0&& matriz[i][j]==null){
                                    if (aleatorio.nextBoolean()) {
                                        matriz[i][j]="@";
                                        contador2++;
                                    }
                                }
                            }  
                            if(i==posicionf && j== posicionc){ 
                                matriz [i][j] = "V"; 
                            }
                            if(matriz[i][j]==null){
                                System.out.print(" ");
                            } else{
                                System.out.print(matriz[i][j]);
                            }
                
                            if(j+1==columna){
                                System.out.println("");
                            }         
                        }
                    }
                    if(puntos<=0){
                        limpiarpantalla(); 
                        puntos=0;
                        System.out.println("GAME OVER");
                        System.out.println();
                        System.out.println("Presione Enter para continuar....");
                        new Scanner(System.in).nextLine();
                         for(int i=0; i<20;i++){
                            if (i==contadorhistorial-1){
                                historialpuntos[i]=puntos;
                                historialmovimiento[i]=nmovimiento;
                            }
                         }
                        nmovimiento=0;
                        confirmacion =false; 
                    }
                     
                    if(puntos>=100){
                        limpiarpantalla(); 
                        puntos=100;
                        System.out.println("GAME ");
                        System.out.println("¡Felicitaciones!");
                        System.out.println();
                        System.out.println("Presione Enter para continuar....");
                        new Scanner(System.in).nextLine();
                         for(int i=0; i<20;i++){
                            if (i==contadorhistorial-1){
                                historialpuntos[i]=puntos;
                                historialmovimiento[i]=nmovimiento;
                            }
                         }
                        nmovimiento=0;
                        confirmacion =false;  
                    }
                    break;    
                    
                case "M":
                    
                    if(!(confirmar())){
                         for(int i=0; i<20;i++){
                            if (i==contadorhistorial-1){
                                historialpuntos[i]=puntos;
                                historialmovimiento[i]=nmovimiento;
                            }
                         }
                        confirmacion =false;
                        nmovimiento=0;
                    } else{
                        
                        System.out.println(" ");
                        System.out.println("Realice su proximo movimiento para continuar");
                        break;           
                    }
                default : 
                    
                    System.out.println("Movimiento no valido");  
                    
            }
        }        
    }
    
}
