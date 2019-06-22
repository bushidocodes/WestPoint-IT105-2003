// My code from West Point's IT105 Class
// Writted around 19 NOVEMBER 2003 

public class Seven27Solution extends eecs.instructor.cobb.Seven27 {
    public static void main(String[] args) {
        initializeMatch();

        while (getDealerBank() >= 1000 && getHumanBank() >= 1000) {
            initializeNewRound();
            double playerDiff = 0;
            double dealerDiff = 0;
            int answer = chooseButton("Do you want another card?", "Yes", "No");
            while (answer == BUTTON1 && getPlayerCardTotal() <= 27) {
                givePlayerACard();
                if (getPlayerCardTotal() <= 27) {
                    answer = chooseButton("Do you want another card?", "Yes", "No");
                }
            }
            if (getPlayerCardTotal() > 27) {
                givePotToDealer();
            } else {
                if (getPlayerCardTotal() <= 7) {
                    playerDiff = playerDiff + (7 - getPlayerCardTotal());
                }

                if (getPlayerCardTotal() > 7) {
                    playerDiff = playerDiff + (27 - getPlayerCardTotal());
                }

                printLine(playerDiff);

                flipDownCard();

                while (getDealerCardTotal() < 6 || (getDealerCardTotal() > 7 && getDealerCardTotal() < 22)) {
                    giveDealerACard();
                }

                if (getDealerCardTotal() > 27) {
                    givePotToPlayer();
                } else {

                    if (getDealerCardTotal() <= 7) {
                        dealerDiff = dealerDiff + (7 - getDealerCardTotal());
                    }

                    if (getDealerCardTotal() > 7) {
                        dealerDiff = dealerDiff + (27 - getDealerCardTotal());
                    }

                    printLine(dealerDiff);

                    if (playerDiff < dealerDiff) {
                        givePotToPlayer();
                    }

                    if (dealerDiff < playerDiff) {
                        givePotToDealer();
                    }

                    if (dealerDiff == playerDiff) {
                        splitPot();
                    }
                }
                printLine("The dealer's card total for the round is " + getDealerCardTotal());
                printLine("The player's card total for the round is " + getPlayerCardTotal());
                printLine("The dealer's current bank is " + getDealerBank());
                printLine("The player's current bank is " + getHumanBank());

                updateDisplay();
            }
        }

        if (getHumanBank() == 0) {
            printLine("You're broke, and you've got too much dignity to bet the clothes off your back.");
        }

        if (getDealerBank() == 0) {
            printLine(
                    "You win.  Look at all that money.  HAHA.  You're buddies want to double down and pay the rest next week, but you know that they are not good for it.  Maybe you can buy better friends now, especially an attractive one of the opposite gender.  (or at least a cut out)");
        }
    }
}