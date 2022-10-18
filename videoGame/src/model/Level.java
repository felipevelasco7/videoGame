package model;
public class Level{
    //attributes
	private int id;
	private int scoreToNextLevel;
     
    
	//relations
	private Treasure[] treasures;
    private Enemy[] enemies;

	//methods

/** 
    *Creats the object Level <br>
    * <b> pre: </b> the array level must be created <br>
    * <b> post: </b> Initializes the variables in this object and creates the enemy and treasure arrays.
    *@param id Is the unique id of the new player.
    *@param scoreToNextLevel is the number of points a player must reach to advance level.
    *@param enemies is the array containing the levels of the game.
    *@param treasures is the array containing the treasures of the game.
    */
    public Level(int id, int scoreToNextLevel){
        this.id=id;
		this.scoreToNextLevel= scoreToNextLevel;
        enemies= new Enemy[5];
        treasures= new Treasure[10];
    }

/**
    *Registers a new enemy to this level <br>
    *<b>pre: </b>The levels must be created <br>
    *<b>post: </b> Adds a new enemy with the characteristics entered.
    *@param id Is the identifier of the enemy.
    *@param pointsGiven Is the number of points a player recieves after defeating the enemy.
    *@param pointsSubtracted the number of points that a player gets subtracted if the enemy defeats them.
    *@param objEnemy is an object enemy.
    *@param available indicates if there is an available space in the array to save the enemy.
    *@param message is the message displayed after adding the Enemy.
    *@return a confirmation message
    */
    public String addEnemy(String id, int pointsGiven, int pointsSubtracted, int type){
        String message="Error";
        if (searchEnemy(id)){
            Enemy objEnemy= new Enemy(id, pointsGiven, pointsSubtracted, type);

            for (int i = 0; i < enemies.length; i++) {
                if(enemies[i]==null){
                    enemies[i]= objEnemy;
                    i=enemies.length;
                    message="Enemigo guardado exitosamente en el nivel";
                }
                else{
                    message="no hay espacios disponibles para guardar este enemigo";
                }
            }	  
		}
        else {
            message="Este enemigo ya esta registrado en este nivel";
        }
        return message;
    }

/** 
    *Looks for an enemy nickname inside the enemy array <br>
    * <b> pre: </b> the array enemy must be created <br>
    * <b> post: </b> returns false if the enemy is allready registered in the enemy array.
    *@param id Is the unique id of the enemy.
    *@param isAvailable shows if there is an available space for the enemy or not.
    *@return true if the id is available
    */
    public boolean searchEnemy(String id){
        boolean isAvailable=true;
        for (int i = 0; i < enemies.length; i++) {
            if(isAvailable && enemies[i]!=null && enemies[i].getId().equalsIgnoreCase(id)){
                isAvailable=false;
            }
        }
        return isAvailable;
    }

/**
    *Registers a new treasure to this level <br>
    *<b>pre: </b>The array treasure must be created <br>
    *<b>post: </b> Adds a new treasure with the characteristics entered.
    *@param name Is the name of the treasure.
    *@param imageURL Is the URL of the image of the treasure.
    *@param pointsIfFound the number of points that a player gets after finding the treasure.
    *@param objTreasure Is the object that will be created.
    *@param message is the message displayed after adding the treasure.
    *@param available shows if there is an available space for the treasure or not.
    *@return a confirmation message
    */
    public String addTreasure(String name, String imageURL, int pointsIfFound){
        String message="Error";
        Treasure objTreasure= new Treasure(name, imageURL, pointsIfFound);

            for (int i = 0; i < treasures.length; i++) {
                if(treasures[i]==null){
                    treasures[i]= objTreasure;
                    i=treasures.length;
                    message="Tesoro guardado exitosamente en el nivel";
                }
                else{
                    message="no hay espacios disponibles para guardar este tesoro";
                }
            }	  
        return message;
    }


    //getters

/**
    *Gets the id of the level<br>
    *<b>pre: </b>The level must be created <br>
    *<b>post: </b> Returns the id of the level.
    *@param id Is the id of the level.
    *@return the id
    */
     public int getId(){
		return id;
	}

/**
    *Gets the length of the treasure<br>
    *<b>pre: </b>The level and treasures arraymust be created <br>
    *<b>post: </b> Returns the length of the array.
    *@param treasureslength Is the length of the array.
    *@return the length of the treasure array
    */
    public int getTreasuresLength(){
        int treasureslength=treasures.length;
		return treasureslength;
	}

/**
    *Gets the length of the enemies array<br>
    *<b>pre: </b>The level and enemies array must be created <br>
    *<b>post: </b> Returns the length of the array.
    *@param enemiesLength Is the length of the array.
    *@return the length of the enemies array
    */
    public int getEnemiesLength(){
        int enemiesLength=enemies.length;
		return enemiesLength;
	}

/**
    *Gets the score neede To advance Level of this level<br>
    *<b>pre: </b>The level must be created <br>
    *<b>post: </b> Returns the scoreToNextLevel of the level.
    *@param scoreToNextLevel Is the score neede To advance Level of the level.
    *@return the score to the next level
    */
    public int getScoreToNextLevel(){
		return scoreToNextLevel;
	}

/**
    *Gets the name of the treasures <br>
    *<b>pre: </b>The level and treasure array must be created <br>
    *<b>post: </b> the names of the treasures of the level.
    *@param treasureNames Is the names of the treasures.
    *@return the names of the treasures of the level.
    */
    public String getTreasureNames(){
		String treasureNames="No hay tesoros registrados";
        if(treasures[0]!=null){
            treasureNames=treasures[0].getName();
        }
        for(int i=1; i < treasures.length; i++){
            if(treasures[i]!=null){
                treasureNames=treasureNames+ ", " +treasures[i].getName();
            }
        }
        return treasureNames;
    }

/**
    *Gets the names of the enemies <br>
    *<b>pre: </b>The level and enemies array must be created <br>
    *<b>post: </b> the names of the enemies of the level.
    *@param enemyNames Is the names of the enemies.
    *@return the names of the enemies of the level.
    */
    public String getEnemyNames(){
		String enemyNames="No hay enemigos registrados";
        if(enemies[0]!=null){
            enemyNames=enemies[0].getId();
        }
        for(int i=1; i < enemies.length; i++){
            if(enemies[i]!=null){
                enemyNames=enemyNames+ ", " +enemies[i].getId();
            }
        }
        return enemyNames;
    }
    
/**
    *Is enemy registered <br>
    *<b>pre: </b>The enemies array must be created <br>
    *<b>post: </b> true if the enemy is registered.
    *@param isRegistered indicates if the enemy is arleady registred.
    *@return true if the enemy is registered.
    */    
    public boolean isEnemyRegistered(int j){
        boolean isRegistered=true;
        if(enemies[j]==null){
            isRegistered=false;
        }
        return isRegistered;
    }

/**
    *Is registered <br>
    *<b>pre: </b>The enemies array must be created <br>
    *<b>post: </b> true if the enemy is registered.
    *@param isRegistered indicates if the enemy is arleady registred.
    *@return true if the enemy is registered.
    */    
    public boolean isRegistered(int j){
        boolean isRegistered=true;
        if(treasures[j]==null){
            isRegistered=false;
        }
        return isRegistered;
    }
    
/**
    *Get treasure name <br>
    *<b>pre: </b>The treasure array must be created <br>
    *<b>post: </b> the name of the treasure.
    *@param treasureName is the name of the treasure.
    *@return the name of the treasure.
    */  
    public String getTreasureName(int j){
		String treasureName="No hay tesoros registrados";
                treasureName=treasures[j].getName();
        return treasureName;
    }

/**
    *Get enemy name <br>
    *<b>pre: </b>The enemies array must be created <br>
    *<b>post: </b> the name of the enemy.
    *@param enemyName is the name of the enemy.
    *@return the name of the enemy.
    */  
    public String getEnemyName(int j){
		String enemyName="No hay enemigos registrados";    
        enemyName=enemies[j].getId();       
        return enemyName;
    }

/**
    *Get enemy points <br>
    *<b>pre: </b>The enemies array must be created <br>
    *<b>post: </b> the points that the enemy gives.
    *@param pointsGiven is the points that the enemy gives.
    *@return the points that the enemy gives.
    */  
    public int getEnemyPointsGiven(int j){
        int pointsGiven=0;
        pointsGiven=enemies[j].getPointsGiven();
        return pointsGiven;
    }

/**
    *Count number of treasures <br>
    *<b>pre: </b>The treasurea array must be created <br>
    *<b>post: </b> the number of treasures in the level.
    *@param treasureNum is the number of treasures in the level.
    *@return the number of treasures in the level.
    */      
    public int countNumberOfTreasures(String name){
		int treasureNum=0;
        for (int i = 0; i < treasures.length; i++) {
            if(treasures[i]!=null && treasures[i].getName().equalsIgnoreCase(name)){
                treasureNum=treasureNum+1;
            }
        }
        return treasureNum;
    }

/**
    *Count number of enemies <br>
    *<b>pre: </b>The enemies array must be created <br>
    *<b>post: </b> the number of enemies in the level.
    *@param enemyNum is the number of enemies in the level.
    *@return the number of enemies in the level.
    */      
    public int countNumberOfEnemies(String name){
		int enemyNum=0;
        for (int i = 0; i < enemies.length; i++) {
            if(enemies[i]!=null && enemies[i].getId().equalsIgnoreCase(name)){
                enemyNum=enemyNum+1;
            }
        }
        return enemyNum;
    }
    

    //setters
/**
    *Sets the id of the level<br>
    *<b>pre: </b>The level must be created <br>
    *<b>post: </b> Sets the id of the level to the one entered.
    *@param id Is the id entered.
    */
    public void setId(int id){
		this.id=id;
	}

/**
    *Sets the score neede To advance Level of this level<br>
    *<b>pre: </b>The level must be created <br>
    *<b>post: </b> Sets the score neede To advance Level of the level to the one entered.
    *@param scoreToNextLevel Is the score neede To advance Level entered.
    */
    public void setScoreToNextLevel(int scoreToNextLevel){
		this.scoreToNextLevel=scoreToNextLevel;
	}
}