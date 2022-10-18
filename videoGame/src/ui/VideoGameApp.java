package ui;

import java.util.Scanner;
import model.VideoGame;


public class VideoGameApp{
public static Scanner input=new Scanner(System.in);
public static VideoGame videoGame;
    
/**
    *Main <br>
    *<b>pre: </b>The program is initialized<br>
    *<b>post: </b> calls the method creat videogame and then the menu.
    */
    public static void main(String args[]) {
        createVideoGame();
        menu();
    }

/**
    *Creates the Video game <br>
    *<b>pre: </b>The program is initialized<br>
    *<b>post: </b> Creates the controler class VideoGame and initializes its variables.
    *@param name Is the name of the video game.
    *@param resolutionX is the number of pixels in the x axis of the screen.
    *@param resolutionY is the number of pixels in the Y axis of the screen.
    *@param videoGame is the object VideoGame that is created.
    */
    public static void createVideoGame(){
        String name= "Videojuego 1";
        int resolutionX=640;
        int resolutionY=480;
        videoGame= new VideoGame(name, resolutionX, resolutionY);
    }

/** 
     * Menu <br>
    * <b> pre: </b> The game must be initialiced <br>
    * <b> post: </b> The option that the user chooses will be done.
    * @param choice is the number of the option from the menu.
    */
    public static void menu(){
        System.out.println("Menu: Ingrese el numero de la operacion que desea realizar");
        System.out.println("1. Crear un Jugador");
        System.out.println("2. Registrar enemigo a un nivel");
        System.out.println("3. Registrar tesoro a un nivel");
        System.out.println("4. Modificar el puntaje de un jugador");
        System.out.println("5. Incrementar nivel para un jugador");
        
        System.out.println("6. Informar los tesoros y enemigos");
        System.out.println("7. Informar la cantidad encontrada de un tesoro en todos los niveles");
        System.out.println("8. Informar la cantidad encontrada de un enemigo en todos los niveles");
        System.out.println("9. Informar el tesoro más repetido en todos los niveles.");
        System.out.println("10. Informar el enemigo que otorga mayor puntaje y el nivel donde se ubica");
        System.out.println("11. Informar la cantidad de consonantes encontradas en los nombres de los enemigos del juego");
        System.out.println("12. Informar el top 5 de los jugadores de acuerdo al puntaje");
        System.out.println("13. Finalizar");

        String choice= input.nextLine();
        switch (choice) {
            case "1":
                registerPlayer();
                menu();
                break;
            case "2":
                registerEnemy();
                menu();
                break;
            case "3":
                registerTreasure();
                menu();
                break;
            case "4":
                modifyPoints();
                menu();
                break;
            case "5":
                levelUp();
                menu();
                break;
            case "6":
                informTreasuresAndEnemies();
                menu();
                break;
            case "7":
                numberOfTreasures();
                menu();
                break;
            case "8":
                numberOfEnemies();
                menu();
                break;
            case "9":
                mostRepeatedTreasure();
                menu();
                break;
            case "10":
                biggestEnemy();
                menu();
                break;
            case "11":
                numberOfConsonants();
                menu();
                break;
            case "12":
                top5();
                menu();
                break;
            case "13":
                System.out.println("Gracias");
                break;
            default: 
                System.out.println("Ingrese una opcion valida");
                menu();
        }
    }

/**
    *Registers a new player <br>
    *<b>pre: </b>The user chooses the option to register a player in the menu<br>
    *<b>post: </b> Creates a new player  with the given data.
    *@param nickname Is the unique id of the new player.
    *@param name is the name of the player
    *@param points The number of points that this player has.
    *@param lives The number of lives that a player has.
    *@param lvl The level of a player.
    *@param message a confirmation or error message displayed after trying to add a new player.
    */
    public static void registerPlayer(){
        System.out.println("1. Crear un Jugador");
        System.out.println("Ingrese el Nickname del jugador");
        String nickname= input.nextLine();
        System.out.println("Ingrese su nombre");
        String name= input.nextLine();
        int points=10;
        int lives=5;
        int lvl=1;
        String message= videoGame.addPlayer(nickname,name,points,lives,lvl);
        System.out.println(message);
    }
    
/**
    *Registers the characteristics of a level <br>
    *<b>pre: </b>The levels must be created <br>
    *<b>post: </b> Changes the default settings of a level to the setting entered.
    *@param level Is the number of the level to modify.
    *@param scoreToNextLevel is the number of points a player must obtain to get to the next level.
    */
    public static void registerLevel(){
        System.out.println("Ingrese el numero del nivel que desea registrar");
        int level= input.nextInt();
        input.nextLine();
        System.out.println("Ingrese el puntaje que este nivel requiere para pasar al siguiente");
        int scoreToNextLevel= input.nextInt();
        input.nextLine();
    }

/**
    *Registers a new treasure to a certain level <br>
    *<b>pre: </b>The levels must be created <br>
    *<b>post: </b> Adds a new treasure with the characteristics entered.
    *@param name Is the name of the treasure.
    *@param imageURL Is the URL of the image of the treasure.
    *@param pointsIfFound the number of points that a player gets after finding the treasure.
    *@param level the level in which the treasure is going to be added.
    *@param msg is the message displayed after adding the treasure.
    */
    public static void registerTreasure(){
        System.out.println("3. Registrar tesoro a un nivel");
        System.out.println("Ingrese el nombre del tesoro");
        String name= input.nextLine();
        System.out.println("Ingrese la URL de la imagen");
        String imageURL= input.nextLine();
        System.out.println("Ingrese los puntos que otorga este tesoro cuando sea encontrado");
        int pointsIfFound= input.nextInt();
        input.nextLine();
        System.out.println("Ingrese el nivel en el que desea registrar este tesoro");
        int level= input.nextInt();
        input.nextLine();
        if (level>10 || level<1){
            System.out.println("Ingrese un numero valido (del 1 al 10) ");
            level= input.nextInt();
            input.nextLine();
        }
        String msg= videoGame.addTreasure(name, imageURL, pointsIfFound,level);
        System.out.println(msg);
    }

/**
    *Registers a new enemy to a certain level <br>
    *<b>pre: </b>The levels must be created <br>
    *<b>post: </b> Adds a new enemy with the characteristics entered.
    *@param id Is the identifier of the enemy.
    *@param pointsGiven Is the number of points a player recieves after defeating the enemy.
    *@param pointsSubtracted the number of points that a player gets subtracted if the enemy defeats them.
    *@param level the level in which the enemy is going to be added.
    *@param msg is the message displayed after adding the Enemy.
    */
    public static void registerEnemy(){
        System.out.println("2. Registrar enemigo a un nivel");
        System.out.println("Ingrese el nombre del enemigo");
        String id= input.nextLine();
        System.out.println("Ingrese los puntos que otorga este enemigo cuando es derrotado");
        int pointsGiven= input.nextInt();
        input.nextLine();
        System.out.println("Ingrese el tipo de enemigo:\n 1. OGRO \n2. ABSTRACTO \n3. JEFE \n4. MAGO");
        int enemyType= input.nextInt();
        if (enemyType>4 || enemyType<1){
            System.out.println("Ingrese un numero valido (del 1 al 4) ");
            enemyType= input.nextInt();
            input.nextLine();
        }
        input.nextLine();
        System.out.println("Ingrese los puntos que quita este enemigo cuando te vence");
        int pointsSubtracted= input.nextInt();
        input.nextLine();
        System.out.println("Ingrese el numero del nivel en el que desea registrar este enemigo");
        int level= input.nextInt();
        input.nextLine();
        if (level>10 || level<1){
            System.out.println("Ingrese un numero valido (del 1 al 10) ");
            level= input.nextInt();
            input.nextLine();
        }
        String msg= videoGame.addEnemy(id, pointsGiven, pointsSubtracted,level, enemyType);
        System.out.println(msg);
    }

/**
    *Modifies the points of a certain player <br>
    *<b>pre: </b>The player must be allready created <br>
    *<b>post: </b> Changes the points of the entered player, to the entered points.
    *@param nickname Is the identifier of the player.
    *@param points Is the number of points the player will recieve.
    *@param msg Is the message that will be displayed after the process is completed.
    */
    public static void modifyPoints(){
        System.out.println("4. Modificar el puntaje de un jugador");
        System.out.println("Ingrese el nickname del jugador");
        String nickname= input.nextLine();
        System.out.println("Ingrese el nuevo puntaje");
        int points= input.nextInt();
        input.nextLine();
        String msg= videoGame.changePoints(nickname,points);
        System.out.println(msg);
    }

/**
    *Increases the level of a player <br>
    *<b>pre: </b>The player must be allready created <br>
    *<b>post: </b> Changes the level of the entered player.
    *@param nickname Is the identifier of the player.
    *@param msg Is the message that will be displayed after the process is completed.
    */
    public static void levelUp(){
        System.out.println("5. Incrementar nivel para un jugador");
        System.out.println("Ingrese el nombre del jugador");
        String nickname= input.nextLine();
        String msg= videoGame.levelUp(nickname);
        System.out.println(msg);
    }

/**
    *Informs the treasures and enemies of a level <br>
    *<b>pre: </b>The game must be created <br>
    *<b>post: </b> Informs the treasures and enemies of a level.
    *@param lvl Is the number of the level.
    *@param msg Is the message that will be displayed after the process is completed.
    */
    public static void informTreasuresAndEnemies(){
        System.out.println("6. Informar los tesoros y enemigos");
        System.out.println("Ingrese el numero del nivel para conocer sus tesoros y enemigos");
        int lvl=input.nextInt();
        input.nextLine();
        String msg= videoGame.informTreasuresAndEnemies(lvl);
        System.out.println(msg);
    }

/**
    *Informs the total number of treasures in the game <br>
    *<b>pre: </b>The game must be allready created <br>
    *<b>post: </b> Informs the total number of treasures in the game .
    *@param treasurename Is the name of the treasure.
    *@param msg Is the message that will be displayed after the process is completed.
    */
    public static void numberOfTreasures(){
        System.out.println("7. Informar la cantidad encontrada de un tesoro en todos los niveles");
        System.out.println("Ingrese el nombre del tesoro");
        String treasurename= input.nextLine();
        String msg= videoGame.numberOfTreasures(treasurename);
        System.out.println(msg);
    }

/**
    *Informs the total number of an enemy in the game <br>
    *<b>pre: </b>The game must be allready created <br>
    *<b>post: </b> Informs the total number of an enemy in the game .
    *@param enemyName Is the name of the enemy.
    *@param msg Is the message that will be displayed after the process is completed.
    */
    public static void numberOfEnemies(){
        System.out.println("8. Informar la cantidad encontrada de un enemigo en todos los niveles");
        System.out.println("Ingrese el nombre del enemigo");
        String enemyName= input.nextLine();
        String msg= videoGame.numberOfEnemies(enemyName);
        System.out.println(msg);
    }

/**
    *Informs the most repeated treasure in the game <br>
    *<b>pre: </b>The game and levels must be allready created <br>
    *<b>post: </b> Informs the most repeated treasure in the game.
    *@param msg Is the message that will be displayed after the process is completed.
    */
    public static void mostRepeatedTreasure(){
        System.out.println("9. Informar el tesoro más repetido en todos los niveles.");
        String msg= videoGame.mostRepeatedTreasure();
        System.out.println("El tesoro mas repetido en todos los niveles es: "+msg);
    }

/**
    *Informs the enemy that gives the most points in the game <br>
    *<b>pre: </b>The game must be allready created <br>
    *<b>post: </b> Informs the  enemy that gives the most points in the game.
    *@param msg Is the message that will be displayed after the process is completed.
    */
    public static void biggestEnemy(){
        System.out.println("10. Informar el enemigo que otorga mayor puntaje y el nivel donde se ubica");
        String msg= videoGame.biggestEnemy();
        System.out.println(msg);
    }

/**
    *Informs the number of consonants in all the names of the enemies in the game <br>
    *<b>pre: </b>The game must be allready created <br>
    *<b>post: </b> Informs the number of consonants in the names of the enemies in the game.
    *@param msg Is the message that will be displayed after the process is completed.
    */
    public static void numberOfConsonants(){
        System.out.println("11. Informar la cantidad de consonantes encontradas en los nombres de los enemigos del juego");
        String msg= videoGame.consonants();
        System.out.println(msg);
    }

/**
    *Informs the top 5 playes based on the points <br>
    *<b>pre: </b>The game must be allready created <br>
    *<b>post: </b> Informs the number of consonants in the names of the enemies in the game.
    *@param msg Is the message that will be displayed after the process is completed.
    */
    public static void top5(){
        System.out.println("12. Informar el top 5 de los jugadores de acuerdo al puntaje");
        System.out.println(videoGame.top5());
    }
}