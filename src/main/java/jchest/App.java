package jchest;

import jchest.game.Board;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //System.out.println( "Hello World!" );
        Board b = new Board();
        b.newGame();
        System.out.println(b.toString());
    }
}
