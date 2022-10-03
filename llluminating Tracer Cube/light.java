public class light {
    
    
    public int x;
    public int y;
    public int z;
    public int[] position = {x, y, z};
    light(){
        //initialize position to superCube origin at (0,0,0)
        this.x = 0;
        this.y = 0;
        this.z = 0;
    }
    protected void changePosition(int x, int y, int z){
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public int[] getPosition(){
        return this.position;
    }
    public int getXposition(){
        return this.x;
    }
    public int getYposition(){
        return this.y;
    }
    public int getZposition(){
        return this.z;
    }
}
