package com.ejanuszewski;

import java.io.InputStream;
import java.util.Scanner;

public class Main {

    private static int option = 0;
    private static Player player1, player2;
    public static String coords;


    private static class Player {

        private String name;
        private char side;

        public Player(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public char getSide() {
            return side;
        }

        public void setSide(char side) {
            this.side = side;
        }
    }


    public static void main(String[] args) {
        player1 = new Player("Player 1");
        player2 = new Player("Player 2");

        Scanner input = new Scanner(System.in);
        System.out.print("Welcome to Tic Tac Toe\nPlease pick O's or X's for player 1");
        if(input.next().toUpperCase() == "O") {
            player1.setSide('O');
            player2.setSide('X');
        } else {
            player1.setSide('X');
            player2.setSide('O');
        }
        //X goes first
        if(player1.getSide() == 'X') {
            System.out.print(player1.getName() + " goes first.\nPlease enter the X and Y coordinates seperated by a comma, e.g. 1,2");
        }
        coords = input.next();

        System.out.println();

        //MainMenu();
    }

    private static void drawBoard() {
        System.out.println("___|___|___");
        System.out.println("___|___|___");
        System.out.println("   |   |   ");
    }

    private static void setMarker(Player player, String position) {
        //x = position.split(",");
    }

    /*private static int MainMenu() {

    }*/
}
