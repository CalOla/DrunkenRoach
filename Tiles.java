/**
 * File Name: Tiles class 
 * Author: Caleb Olaoye
 * Course and Section: COMP 280
 * Date: 01-19-2016
 * Description:
 * The Tiles class constructs a group of nxm tiles with an array initially filled with 0's
 * With the of the values passed in from the DrunkenRoach class, the methods and fields
 * in Tiles class are able to fill the 2D array with appropriate values
 * 
 */
package drunkenroach;

public class Tiles
{
    private int[][] tile;
    private int row;
    private int column;
    
    /**
     * The Tiles constructor has two formal parameters that determines the size
     * of the 2D array
     * The Tiles constructor constructs a 2D array that is filled with 0's  
     * The Tiles constructor initializes int row and column 
     * @param row
     * @param column 
     */
    public Tiles(int row, int column)
    {
        tile = new int[row][column];
        
        this.row = row;
        this.column = column;
        
        for(row = 0; row < tile.length; row++)
        {
            for(column = 0; column < tile[row].length; column++)
            {
                tile[row][column]=0;
            }
        }
    
    }
    
   
 /**
  * Updates the number of times the roach has touched a specific tile
  * The two formal parameters lets the method know the location of the tile
  * @param i
  * @param j 
  */  
   public void increment(int i, int j)
   {
       int x = tile[i][j];
       tile[i][j] = x + 1;        
   }
   
   
   /**
    * Determines if the game is over or not by going through all the 
    *elements in the array to see if the roach has been there or not
    * @return 
    */
   public boolean checker()
   {
       boolean check = true;
       for(row = 0; row < tile.length; row++)
        {
            for(column = 0; column < tile[row].length; column++)
            {
                if(tile[row][column]== 0)
                {
                    check = false;
                }
                
            }
        }
       return check;
   }
   
  /**
   * Determines the total number of times the roach has touched each tile
   * @return 
   */   
   public int total()
   {
       int add = 0;
       for(row = 0; row < tile.length; row++)
        {
            for(column = 0; column < tile[row].length; column++)
            {      
                add += tile[row][column];
                
            }
        }
       return add;
   }
  
   /**
    * The toString updates the 2D array with the new values and arranges
    * the content of the array
    * @return 
    */
   public String toString()
   {
      String str = "";
      for (row = 0; row < tile.length; row++)
      {
         str = str + "";

        for (column = 0;  column < tile[row].length; column++)        
        {
            str = str +""+ tile[row][column] +""+ "\t";
        }
            str = str + "\n";
            
      }

      return str;
   }
}

