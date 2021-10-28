# card-counter
Program I thought of while learning Java in university, playing blackjack online to kill some time.

This program uses the classic "High-Low" counting method:
 - Keep a running count starting at 0
 - For cards with a value of 2 to 6, add 1 to the count
 - For cards 7 to 9, add 0 to the count
 - For cards 10 to Ace, subtract 1 from the count

The program assumes that the dealer's shoe is using 8 decks. Probability is determined by dividing
the total cards of each tier by the total cards in the deck.

When the program ends, it provides a final report of the number of cards from each tier
that were dealt, the total cards pulled, and the average value of the count.
