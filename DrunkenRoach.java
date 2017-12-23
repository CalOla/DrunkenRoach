
package drunkenroach;

import java.util.Random;
import java.util.Scanner;
/**
 * File Name: DrunkenRoach class 
 * Author: Caleb Olaoye
 * Course and Section: COMP 280
 * Date: 01-19-2016
 * Description: The DrunkenRoach class, is the main class in the of the project
 * The functions of the DrunkenRoach class includes accepting user inputs and basic
 * manipulations of those inputs for delivery to the Tiles class
 */
public class DrunkenRoach {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        // TODO code application logic here
        
        

        Scanner in = new Scanner(System.in);
        
        System.out.print("Enter number of rows: ");
        int numberOfRows = in.nextInt();
        
        System.out.print("Enter number of columns: ");
        int numberOfColumns = in.nextInt();
           
        System.out.print("Initial starting row: ");
        int startRow = in.nextInt(); 
        
        System.out.print("Initial starting column: ");
        int startColumn = in.nextInt();
        
        Tiles tile = new Tiles(numberOfRows, numberOfColumns);
     
//      int rowPostion and columnPosition are the positions of the roach
//      on the tiles at any given time
        int rowPosition = startRow;
        int columnPosition = startColumn;

//      stores the last position of the roach  
        int storeRow = 0;
        int storColumn = 0;
        
        
        try
        {
            tile.increment(startRow, startColumn);
        
        

//          The while statement loops till the checker method in the Tiles class returns true
            while(tile.checker() == false)
            {
                try
                {
            
//                  integer whileLoopCounter determines the number of times the while loop has been iterated  
                    int whileLoopCounter = 0;
                    whileLoopCounter++;
            
                    Random rand = new Random();
                
//                  int k is as described in the programming assignment  
                    int k = rand.nextInt(8);

//                  int ibug and jbug are as described in the assignment  
                    int ibug = 0;
                    int jbug = 0;
            
            
//                  The if statements determines where the roach moves on the tiles
                    if(k == 0)
                    {
                        ibug = -1;
                        jbug = 1;
                    }
                    else if(k == 1)
                    {
                        ibug = 0;
                        jbug = 1;
                    }
                    else if(k == 2)
                    {
                        ibug = 1;
                        jbug = 1;
                    }
                    else if(k == 3)
                    {
                        ibug = 1;
                        jbug = 0;
                    }
                    else if(k == 4)
                    {
                        ibug = 1;
                        jbug = -1;
                    }
                    else if(k == 5)
                    {
                        ibug = 0;
                        jbug = -1;
                    }
                    else if(k == 6)
                    {
                        ibug = -1;
                        jbug = -1;
                    }
                    else if(k == 7)
                    {
                        ibug = -1;
                        jbug = 0;
                    }
                
            
//              The if statement checks if the while statement has been iterated atleast once
//                
//              If the while statement has not been iterated, the if statement uses the value
//              passed in by the user to determine the next position of the bug
//                
//              If the while statement has been iterated atleast once, the if statement uses the old
//              position of the roach to determine the next position    
                    if(whileLoopCounter < 0)
                    {
                        rowPosition = ibug+startRow;
                        columnPosition = jbug+startColumn;
                    }
                    else
                    {
                        storeRow = rowPosition;
                        storColumn = columnPosition;
                
                        rowPosition = rowPosition + ibug;
                        columnPosition = columnPosition + jbug;
                    }
        
                tile.increment(rowPosition, columnPosition);
            
//              checks if the bug has made more than 50,000 legal moves  
                if(tile.total() > 50000)
                {
                    System.out.println("The number of legal moves has exceeded 50,000");
                    break;
                }
            }
        
            catch(ArrayIndexOutOfBoundsException ar)
            {
//              Helps the roach to go back to its last in bound position if it goes out of bounds  
                rowPosition = storeRow;
                columnPosition = storColumn;   
            }
            }
        
        
//          checks if the roach has not made more than 50,000 legal moves       
            if(tile.total() <= 50000)
            {
                System.out.println("Number of legal moves: "+tile.total());
                System.out.print(tile.toString());
            }
        }
      
//      Keeps the programming from crashing if the initial starting position of the roach is
//      out of bounds
        
        catch(ArrayIndexOutOfBoundsException AIO)
        {
            System.out.println("Carefully enter the values next time");
        }
    }
}
    
