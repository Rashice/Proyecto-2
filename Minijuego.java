import java.util.Scanner;
public class Minijuego{
    public static void main (String [] args){
        Tanques [][] tanques = new Tanques [2][2]; 
        Scanner scan = new Scanner(System.in);

        System.out.println("----Bienvenido presione el numero 1 para comenzar el Juego.----");
        System.out.println("----Presione el numero 2 para disparar una bala.----");
        System.out.println("----Presione el numero 3 para activar bomba atomica.----");
        System.out.println("----Presione el numero 4 para activar bicho mutante.----");
        System.out.println("----Presione el numero 5 para recibir un consejo de tu abuela.----");
        System.out.println("----Presione el numero 0 para salir.----");

        int num = scan.nextInt();

        while(true){

            if(num == 0){
                System.out.println("EL JUEGO HA TERMINADO.");
                break;

            }else if(num == 1){
                for(int i  = 0; i < 2; i++){
                    for(int j = 0; j < 2;j++){
                        tanques[i][j] = new Tanques("",0);
                    }
                }

                int cantidadTanques = (int )Math.floor(Math.random()*4+1);
                System.out.println("Se creara esta cantidad de tanques = " + cantidadTanques); 

                int limite = 0;

                for(int i = 0; i < 2; i++){
                    for(int j = 0; j < 2; j++){
                        int tanquesCrear = (int )Math.floor(Math.random()*2+1);
                        if(limite == cantidadTanques){
                            break;
                        }else if(tanquesCrear == 1){
                            Tanques b1 = new Tanques("BN",10);
                            limite++;
                            tanques[i][j] = b1;
                        }else if(tanquesCrear == 2){
                            Tanques b2 = new Tanques("BA",20);
                            limite++;
                            tanques[i][j] = b2;
                        }
                    }
                }

                Tanques.tablaTanques(tanques);
            }else if (num == 2){

                System.out.println("Ingrese el numero de la fila:");

                int fila = scan.nextInt();

                System.out.println("Ingrese el numero de la columna:");

                int columna = scan.nextInt();
                if (fila > 1){
                    break;
                }else if(columna > 1){
                    break;  
                }else{
                    tanques[fila][columna].atacar();
                }

                Tanques.tablaTanques(tanques);
            }else if(num==3){
                int filaA = (int)Math.floor(Math.random()*2);
                int columnaA = (int)Math.floor(Math.random()*2);

                tanques[filaA][columnaA].bombaAtomica();
                Tanques.tablaTanques(tanques);
            }else if(num==4){
                int posMenor = 0;
                int posMenor1 = 0;
                int mayorBichos = tanques[0][0].getSalud();

                for(int i=0; i < 2; i++){
                    for(int j = 0; j < 2; j++){
                        if(tanques[i][j].getSalud()!=0){ 
                            if(mayorBichos > tanques[i][j].getSalud()){
                                mayorBichos = tanques[i][j].getSalud();
                                posMenor = i;
                                posMenor1 = j;
                            }
                        }
                    }
                }
                tanques[posMenor][posMenor1].tanqueMutante();
                Tanques.tablaTanques(tanques);
                
            }else if(num==5){
                System.out.println("Siemrpe recuerda que eres el mejor");
            }
            if(tanques[0][0].getSalud()==0){
                if(tanques[0][1].getSalud()==0){
                    if(tanques[1][0].getSalud()==0){
                        if(tanques[1][1].getSalud()==0){
                            break;
                        }
                    }
                }
            }

            num = scan.nextInt();            
        }

    }
}