/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.unit4test;
import java.util.Random;

/**
 *
 * @author ttang2026
 */
public class Unit4Test {
    public static void main(String[] args) {
        
        // Array to hold 5 unique cards
        Card[] cards = new Card[5];
        
        // randomly generate 5 unique cards
        for (int i = 0; i < 5; i++) {
            boolean duplicate = true;
            
            while (duplicate) {
                
                // create a new random card
                cards[i] = new Card();
                duplicate = false;
                
                // checking if the card already exists in the array
                for (int c = 0; c < i; c++) {
                    if (cards[i].getSuit().equals(cards[c].getSuit()) && 
                        cards[i].getValue() ==
                        cards[c].getValue()) {
                        
                        duplicate = true; // if found, the card's a duplicate
                        break;
                    }
                }
            }
        }
        
        // printing each card and finding the highest card int 
        int maxValue = -1;
        String highestCard = ""; 
        
        for (int i = 0; i < 5; i++) {
            System.out.println(cards[i].displayCard()); // printing the card
            
            // checking for the highest card
            if (cards[i].getValue() > maxValue) {
                maxValue = cards[i].getValue();
                highestCard = cards[i].displayCard();
            }
        }
        
        // printing the highest value card
        System.out.println("\nThe highest card is: " + highestCard);
        
    }
}

class Card {
    
    //instance variables
        private final String suit;
        private final int value;
            
    // constructor
        public Card() {
                
            // randomly select a suit
            String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
            Random rand = new Random();
            this.suit = suits[rand.nextInt(4)]; // random suit from the array
                
            // randomly select a card value (1-13)
            this.value = rand.nextInt(13) + 1; // random value between 1-13
        }
        
        // getter methods for suit and value
        public String getSuit() {
            return this.suit;
        }
        
        public int getValue() {
            return this.value;
        }
        
        // method to display card information
        public String displayCard() {
            return this.value + " of " + this.suit;
        }
}
