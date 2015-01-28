package com.ejanuszewski;

import java.io.InputStream;
import java.util.Scanner;

public class Main {

    private static Player player1, player2, currentPlayer;
    public static String[] coords = new String[2];
    public static int coordX, coordY = 0;
    public static String input;
    public static String[][] board = {
        {"-","-","-"},
        {"-","-","-"},
        {"-","-","-"}
    };


    private static class Player {

        private String name;
        private String side;

        public Player(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public String getSide() {
            return side;
        }

        public void setSide(String side) {
            this.side = side;
        }
    }


    public static void main(String[] args) {
        player1 = new Player("Player 1");
        player2 = new Player("Player 2");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Welcome to Tic Tac Toe\nPlease pick O's or X's for player 1: ");
        input = scanner.next().toUpperCase();
        if(input.equals("X")) {
            player1.setSide("X");
            player2.setSide("O");
        } else {
            player1.setSide("O");
            player2.setSide("X");
        }
        //X goes first
        if(player1.getSide().equals("X")) {
            currentPlayer = player1;
        } else {
            currentPlayer = player2;
        }
        takeGo();
    }

    public static void drawBoard() {
        for(String[] row : board) {
            System.out.println(row[0] + "|" + row[1] + "|" + row[2]);
        }
    }

    private static void takeGo() {
        System.out.println(currentPlayer.getName() + "'s turn.");
        System.out.print("Please enter the X and Y coordinates separated by a comma, e.g. 1,2: ");
        Scanner scanner = new Scanner(System.in);
        input = scanner.next().toUpperCase();

        try {
            if(setMarker(input)) {
                drawBoard();

                //Check if that move the game
                if(!hasWon(currentPlayer)) {
                    if (currentPlayer == player1) {
                        currentPlayer = player2;
                    } else {
                        currentPlayer = player1;
                    }
                    takeGo();
                } else {
                    System.out.printf("We have a winner!, congratulations %s", currentPlayer.getName());
                }

            } else {
                System.out.println("That space is already taken, pick another!");
            }
        } catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("Please ensure you enter 3 or less for both coordinates");
            takeGo();
        }
    }

    private static boolean setMarker(String position) {
        coords = position.split(",");
        coordX = Integer.parseInt(coords[0]) - 1;
        coordY = Integer.parseInt(coords[1]) - 1;
        if(board[coordY][coordX].equals("-")) {
            board[coordY][coordX] = currentPlayer.getSide();
            return true;
        } else {
            return false;
        }
    }

    private static boolean hasWon(Player player) {
        String side = player.getSide();
        int rowCount = 0;
        //Horizontal line
        for(String[] row : board) {
            for(String cell : row) {
                if(cell.equals(side))
                    rowCount += 1;
            }
        }
        //Vertical line
        for (int i = 0; i < 3; i++) {
            //(0=>"0,0|0,1|0,2");
            //(1=>"1,0|1,1|1,2");
            //(2=>"2,0|2,1|2,2");
            System.out.println(i + "," + i);
            System.out.println(i + 1 + "," + i);
            System.out.println(i + 2 + "," + i);
            if(board[i][i].equals(side) && board[i+1][i].equals(side) && board[i+2][i].equals(side)) {
            }
        }

        for(String[] row : board) {
            if(row[0].equals(side) && row[0].equals(side)) {

            }
        }
        if(rowCount == 3)
            return true;//Winner

        return false;
    }

    /*private static int MainMenu() {

    }*/
}
