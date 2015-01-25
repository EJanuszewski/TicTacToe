package com.ejanuszewski;

import java.io.InputStream;
import java.util.Scanner;

public class Main {

    private static Player player1, player2, currentPlayer;
    public static String[] coords = new String[2];
    public static int coordX, coordY = 0;
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

        Scanner input = new Scanner(System.in);
        System.out.print("Welcome to Tic Tac Toe\nPlease pick O's or X's for player 1: ");
        if(input.next().toUpperCase() == "X") {
            player1.setSide("X");
            player2.setSide("O");
        } else {
            player1.setSide("O");
            player2.setSide("X");
        }
        //X goes first
        if(player1.getSide() == "X") {
            currentPlayer = player1;
        } else {
            currentPlayer = player2;
        }
        System.out.println(currentPlayer.getName() + " goes first.\nPlease enter the X and Y coordinates separated by a comma, e.g. 1,2: ");
        setMarker(currentPlayer, input.next());

        drawBoard();

        System.out.println();

        //MainMenu();
    }

    public static void drawBoard() {
        for(String[] row : board) {
            System.out.println(row[0] + "|" + row[1] + "|" + row[2]);
        }
//        System.out.println("___|___|___");
//        System.out.println("___|___|___");
//        System.out.println("   |   |   ");
    }

    private static void setMarker(Player player, String position) {
        coords = position.split(",");
        coordX = Integer.parseInt(coords[0]) - 1;
        coordY = Integer.parseInt(coords[1]) - 1;
        if(board[coordY][coordX] == "-") {
            board[coordY][coordX] = player.getSide();
        }
    }

    /*private static int MainMenu() {

    }*/
}
