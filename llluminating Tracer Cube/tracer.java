import java.util.LinkedList;
public class tracer{
    public static void main(String args[]){
        int width = 6; //program does not work for odd numbers currently
        //int origin = 0;
        int x = 0;
        int y = 0;
        int z = 0;
        int index = 0; //index counter        
        LinkedList<subCube> subCubes = new LinkedList<subCube>();
        subCube firstCube = new subCube(x, y, z);
        subCubes.add(index, firstCube);
        light light = new light();//constructs default light with position (0,0,0)
        int directionX = 1; //sets x in pos x direction
        int directionY = 1; //sets y in pos y direction

        System.out.println("( " + x + ", " + y + ", " + z + " )");
        for(int i = 1; i <= width; i++){ // i = number of z positions moved = width - 1
            for (int j = 0; j < width; j++){ //j = number of y positions moved = width - 1
                for(int k = 1; k < width; k++){//k = number of x positions moved = width - 1
                    if(directionX == 1){ //if we are moving in pos x dir
                        x++;
                        index++;
                        subCube xCube = new subCube(x, y, z);
                        subCubes.add(index, xCube);
                        light.changePosition(x, y, z);
                        if(x == width -1){//if we are at the edge of cube where x == width -1, change direction x
                            directionX = 0;
                        }
                    }else{
                        x--;
                        index++;
                        subCube xCube = new subCube(x, y, z);
                        subCubes.add(index, xCube); 
                        light.changePosition(x, y, z);
                        if(x==0){//if we are at the edge of cube where x == 0, change direction x
                            directionX = 1;
                        }
                    }
                    System.out.println("( " + x + ", " + y + ", " + z + " )");
                }

                //ERROR IN DETERMINING Y POSITION: WITH WIDTH 10, Y DOES NOT ITERATE CORRECTLY ON FINAL LEVEL, REPEATS Y=0 TOO MANY TIMES RIGHT BEFORE PROGRAM END
                if(directionY == 1 && !((x == 3 && y == 3) || (x==3 && y ==0))){ //if we are moving in pos y dir
                    if(!(z%2 == 1 && x ==0 && y == 0)){ //and y is not in either the origin and an odd index of xy plane z
                        y++;
                        index++;
                        subCube yCube = new subCube(x, y, z);
                        subCubes.add(index, yCube);
                        light.changePosition(x, y, z);
                        System.out.println("( " + x + ", " + y + ", " + z + " )");
                    }
                    
                    if(y == width -1){//if we are at the edge of cube where y == width - 1,change direction y
                        directionY = 0;
                    }
                }else if(directionY == 0 && !((x == 3 && y == 3) || (x==3 && y ==0))){ // if already moving negative y direction
                    if(!((x == 0 && y == 3 && z%2 == 0) || (x == 0 && y == 0 && z%2 ==1))){
                        y--;
                        index++;
                        subCube yCube = new subCube(x, y, z);
                        subCubes.add(index, yCube);
                        light.changePosition(x, y, z);
                        System.out.println("( " + x + ", " + y + ", " + z + " )");
                    }
                    if(x==0 && y == 0 && z%2 == 1){//if we are at the edge of cube where y == 0, change direction y
                        directionY = 1;
                    }
                }
            }
            if(z==width-1){break;}
            z++;//xyplane++
            index++;
            subCube zCube = new subCube(x, y, z);
            subCubes.add(index, zCube);
            light.changePosition(x, y, z);
            System.out.println("( " + x + ", " + y + ", " + z + " )");
            //System.out.println("Light is at position: (" + light.getXposition() + ", " + light.getYposition() + ", " + light.getZposition() + ")");
        }
        System.out.println("Light is at position: (" + light.getXposition() + ", " + light.getYposition() + ", " + light.getZposition() + ")");
    }
}