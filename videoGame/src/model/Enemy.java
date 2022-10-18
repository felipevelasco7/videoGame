package model;

public class Enemy{
    //attributes
	private String id;
	private int pointsGiven;
    private int pointsSubtracted;
	private int positionX;
    private int positionY;

    
    
	//relations
    
    //private TypeEnemy enemyType;

	

	//methods
	
/** 
    *Creats the object Enemy <br>
    * <b> pre: </b> the array enemy must be created <br>
    * <b> post: </b> Initializes the variables in this object and creats a randon location.
    *@param id Is the unique id of the enemy.
    *@param pointsGiven Is the number of points a player recieves after defeating the enemy.
    *@param pointsSubtracted the number of points that a player gets subtracted if the enemy defeats them.
    *@param positionX is the coordenate in the x axis of the enemy.
    *@param positionY is the coordenate in the y axis of the enemy.
    *@param type is the enemy type.
	*/
    public Enemy(String id, int pointsGiven, int pointsSubtracted, int type){
        this.id=id;
		this.pointsGiven= pointsGiven;
		this.pointsSubtracted= pointsSubtracted;
		this.positionX=(int)(Math.random()*640+1);
        this.positionY=(int)(Math.random()*480+1);
    /* if (type==1){this.enemyType=TypeEnemy.OGRO;}
            else if (type==2){this.enemyType=TypeEnemy.ABSTRACTO;}
            else if (type==3){this.type=TypeEnemy.JEFE;}
            else if (type==4){this.type=TypeEnemy.MAGO;}
        */
    }

    //getters
/**
    *Gets the id of the enemy<br>
    *<b>pre: </b>The Enemy must be created <br>
    *<b>post: </b> Returns the id of the enemy.
    *@param id Is the id of the enemy.
    *@return the id.
    */
    public String getId(){
		return id;
	}

/**
    *Gets the points an enemy gives<br>
    *<b>pre: </b>The Enemy must be created <br>
    *<b>post: </b> Returns the points an enemy gives.
    *@param pointsGiven Is the points an enemy gives.
    *@return the poitns given.
    */
    public int getPointsGiven(){
		return pointsGiven;
	}

/**
    *Gets the points an enemy subtracts <br>
    *<b>pre: </b>The Enemy must be created <br>
    *<b>post: </b> Returns the ppoints an enemy subtracts.
    *@param pointsSubtracted Is the points an enemy subtracts.
    *@return the poitns subtracted.
    */
    public int getPointsSubtracted(){
		return pointsSubtracted;
	}

/**
    *Gets the x cordenate of the enemy<br>
    *<b>pre: </b>The Enemy must be created <br>
    *<b>post: </b> Returns the positionX of the enemy.
    *@param positionX Is the x cordenate of the enemy.
    *@return the position.
    */
    public int getPositionX(){
		return positionX;
	}

/**
    *Gets the y cordenate of the enemy<br>
    *<b>pre: </b>The Enemy must be created <br>
    *<b>post: </b> Returns the positionY of the enemy.
    *@param positionY Is the y cordenate of the enemy.
    *@return the position.
    */
    public int getPositionY(){
		return positionY;
	}


    //setters

/**
    *Sets the id of the enemy<br>
    *<b>pre: </b>The Enemy must be created <br>
    *<b>post: </b> Sets the id of the enemy.
    *@param id Is the entered id of the enemy.
    */
    public void setid(String id){
		this.id=id;
	}

/**
    *Sets the points an enemy subtracts<br>
    *<b>pre: </b>The Enemy must be created <br>
    *<b>post: </b> sets the points an enemy subtracts.
    *@param pointsSubtracted Is the points an enemy subtracts entered.
    */
    public void setPointsSubtracted(int pointsSubtracted){
		this.pointsSubtracted=pointsSubtracted;
	}

/**
    *Sets the points an enemy gives<br>
    *<b>pre: </b>The Enemy must be created <br>
    *<b>post: </b> sets the points an enemy gives.
    *@param pointsSubtracted Is the points an enemy gives entered.
    */
    public void setPointsGiven(int pointsGiven){
		this.pointsGiven=pointsGiven;
	}

/**
    *Sets the x cordenate of the enemy<br>
    *<b>pre: </b>The Enemy must be created <br>
    *<b>post: </b> sets the positionX of the enemy.
    *@param positionX Is the x cordenate of the enemy.
    */
    public void setPositionX(int positionX){
		this.positionX=positionX;
	}

/**
    *Sets the y cordenate of the enemy<br>
    *<b>pre: </b>The Enemy must be created <br>
    *<b>post: </b> sets the positionY of the enemy.
    *@param positionY Is the y cordenate of the enemy.
    */
    public void setPositionY(int positionY){
		this.positionY=positionY;
	}

}