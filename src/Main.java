import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    enum Orientation {
        NORD,
        EAST,
        WEST,
        SOUTH
    }
    public static void main(String[] args) throws IOException {

        File file = new File("inputs//input_AoC_1b.txt");

        BufferedReader br = new BufferedReader(new FileReader(file));

        String s = br.readLine();

        String [] listOfStrings = s.split(",");

        for(int i=0; i<listOfStrings.length; i++){
            listOfStrings[i] = listOfStrings[i].trim();
        }

        int horisontalPosition = 0;
        int verticalPosition = 0;

        Orientation currentOrientation = Orientation.NORD;

        List<String> listOfLocations = new ArrayList<>();
        listOfLocations.add("0 0");

        int forceExit = 0;

        for(String str : listOfStrings){
            char direction = str.charAt(0);
            int numOfBlocks = Integer.parseInt(str.substring(1));


            if(direction == 'R'){
                if(currentOrientation == Orientation.NORD){
                    currentOrientation = Orientation.EAST;

                    for(int i=0; i<numOfBlocks; i++){
                        horisontalPosition ++;
                        if(listOfLocations.contains(horisontalPosition + " " + verticalPosition)){
                            forceExit++;
                            break;
                        }
                        listOfLocations.add(horisontalPosition + " " + verticalPosition);
                    }
                    if(forceExit != 0) break;
                }
                else if(currentOrientation == Orientation.EAST){
                    currentOrientation = Orientation.SOUTH;

                    for(int i=0; i<numOfBlocks; i++){
                        verticalPosition --;
                        if(listOfLocations.contains(horisontalPosition + " " + verticalPosition)) {
                            forceExit++;
                            break;
                        }
                        listOfLocations.add(horisontalPosition + " " + verticalPosition);
                    }
                    if (forceExit != 0) break;
                }
                else if(currentOrientation == Orientation.SOUTH){
                    currentOrientation = Orientation.WEST;

                    for(int i=0; i<numOfBlocks; i++){
                        horisontalPosition --;
                        if(listOfLocations.contains(horisontalPosition + " " + verticalPosition)) {
                            forceExit++;
                            break;
                        }
                        listOfLocations.add(horisontalPosition + " " + verticalPosition);
                    }
                    if(forceExit != 0) break;
                }
                else if(currentOrientation == Orientation.WEST){
                    currentOrientation = Orientation.NORD;

                    for(int i=0; i<numOfBlocks; i++){
                        verticalPosition ++;
                        if(listOfLocations.contains(horisontalPosition + " " + verticalPosition)) {
                            forceExit++;
                            break;
                        }
                        listOfLocations.add(horisontalPosition + " " + verticalPosition);
                    }
                    if(forceExit != 0) break;
                }
            }
            else if(direction == 'L'){
                if(currentOrientation == Orientation.NORD){
                    currentOrientation = Orientation.WEST;

                    for(int i=0; i<numOfBlocks; i++){
                        horisontalPosition --;
                        if(listOfLocations.contains(horisontalPosition + " " + verticalPosition)) {
                            forceExit++;
                            break;
                        }
                        listOfLocations.add(horisontalPosition + " " + verticalPosition);
                    }
                    if(forceExit != 0) break;
                }
                else if(currentOrientation == Orientation.EAST){
                    currentOrientation = Orientation.NORD;

                    for(int i=0; i<numOfBlocks; i++){
                        verticalPosition ++;
                        if(listOfLocations.contains(horisontalPosition + " " + verticalPosition)) {
                            forceExit++;
                            break;
                        }
                        listOfLocations.add(horisontalPosition + " " + verticalPosition);
                    }
                    if(forceExit != 0) break;
                }
                else if(currentOrientation == Orientation.SOUTH){
                    currentOrientation = Orientation.EAST;

                    for(int i=0; i<numOfBlocks; i++){
                        horisontalPosition ++;
                        if(listOfLocations.contains(horisontalPosition + " " + verticalPosition)) {
                            forceExit++;
                            break;
                        }
                        listOfLocations.add(horisontalPosition + " " + verticalPosition);
                    }
                    if(forceExit != 0) break;
                }
                else if(currentOrientation == Orientation.WEST){
                    currentOrientation = Orientation.SOUTH;

                    for(int i=0; i<numOfBlocks; i++){
                        verticalPosition --;
                        if(listOfLocations.contains(horisontalPosition + " " + verticalPosition)) {
                            forceExit++;
                            break;
                        }
                        listOfLocations.add(horisontalPosition + " " + verticalPosition);
                    }
                    if(forceExit != 0) break;
                }
            }
        }

        int distance = Math.abs(horisontalPosition) + Math.abs(verticalPosition);
        System.out.println("Distanc is: " + distance);
    }
}