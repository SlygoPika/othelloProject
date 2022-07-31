# Othello Project

### Description
This personal project aims to use concepts of object orientated programming to create a PvP Othello game. 
The Othello board will be an array of ASCII characters. 
In this variation of Othello, user can choose from 5 options of starting position. Furthermore, some board positions will be unplayable.

### Game Rules

Black must place a black disc on the board, in such a way that there is at least one straight (horizontal, vertical, or diagonal) occupied line between the new disc and another black disc, with one or more contiguous white pieces between them. In the starting position, Black has the following 4 options indicated by translucent discs:

After placing the disc, Black flips all white discs lying on a straight line between the new disc and any existing black discs. All flipped discs are now black. If Black decides to place a disc in the topmost location, one white disc gets flipped, and the board now looks like this:

Now White plays. This player operates under the same rules, with the roles reversed: White lays down a white disc, causing black discs to flip. Possibilities at this time would be:

If White plays the bottom left option and flips one disc:

Players alternate taking turns. If a player does not have any valid moves, play passes back to the other player. When neither player can move, the game ends. A game of Othello may end before the board is completely filled.

The player with the most discs on the board at the end of the game wins. If both players have the same number of discs, then the game is a draw.

#### Credits
The game rules was taken from https://www.eothello.com/ 
