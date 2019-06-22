# West Point IT105 Java (Fall 2003)

A variety of Java programs I wrote for West Point's IT105 Intro to IT course in Fall 2003.

## Tiger Wood's Automated Caddy

### Problem Statement.

Tiger Woods has fired his caddy, and he has decided to have a program developed to assist him in determining the golf club he should use for a given shot. Specifically, this program is to help him with his approach shot of 145 or fewer yards. The program will output the optimal club (using an assigned acronym) for the shot determined by the wind speed, elevation difference to the hole, and the distance to the hole (as well as the terrain type in the extra credit program). If the distance to the hole is less than or equal to 80 yards, then the Lob Wedge will be used by default. If the distance to the hole is between 81 and 120 yards, then the Sand Wedge will be used by default. If the distance is from 121 to 145 yards, then the Pitching Wedge will be used by default. This computer program does not address distances over 145 yards. The wind is adjusted for, in the case of a headwind, by increasing the club by one, and, in the case of a tailwind, by decreasing the club by one, if the wind is significant enough so that the result is greater than five when calculated through the equation (wind speed/10)2 +. If the elevation of the hole is more than 15 yards above the current position, the club will be increased by one. If the elevation of the hole is more than 15 yards below the current position, the club will be decreased by one. (Extra Credit: if the ball is in the rough, the club will be decrease by one. If the ball is on a divot, the club will be increased by one. Increases and decreases of the clubs are determined by the following chart:

Clubs (in order from longest to shortest)

- 7 Iron (7I)
- 8 Iron (8I)
- 9 Iron (9I)
- Pitching Wedge (PW)
- Sand Wedge (SW)
- Lob Wedge (LW)
- Lob Wedge II (LWII)
- Flop Shot (FS)
- Putter (P)

### Assumptions.

Several assumptions had to be made in the modeling of this system. It is assumed that the effects of side winds will be negligible on the shot. It is assumed that the wind will never be so strong, the elevation will never be so different, and the terrain will never be so extreme as to require an adjustment of more than one club for a single variable. The model also assumes that there will be no significant barriers between the ball and the hole that may require a larger club or make a direct shot impossible.

## Seven Twenty-Seven:

### Problem Statement.

A computer program is to be created modeling the card game Seven Twenty-Seven. This game is similar to Black Jack in that players try to be closer to a specific number to win, differs by having the players be closer to either seven or twenty-seven without going over. Number cards are worth their numerical value, face cards are worth one-half of a point, and aces are worth one point. The program is modeled so that one player (the user) plays against the dealer (the computer). The dealer and the player each begin with $5000 and they each bet $1000 on a round. Winner takes all, and the pot is split in the case of a tie. The game is over once either the dealer or the player runs out of money. Creation of the program is accomplished by designing the solution and utilizing the given methods to model the game. Specific instructions were provided for the artificial intelligence of the computer dealer. When his point score for his current hand is between six and seven or twenty-two or above, he will stay. In all other situations, he will take a hit.

### Assumptions.

The program models a deck of playing cards by randomly choosing a card when a card is needed. Because the cards are selected randomly and not limited by having only one of each card in a deck, it is possible for a single card to be drawn multiple times. It is assumed that the deck model in the program will generate random cards much like a well-shuffled actual deck of playing cards without significant variances due to repeat card generation.
