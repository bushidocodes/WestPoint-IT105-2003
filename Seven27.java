// My code from West Point's IT105 Class
// Writted around 19 NOVEMBER 2003

import java.util.Random;

final int BUTTON1 = 0;
final int BUTTON2 = 1;

int dealerBank;
int humanBank;
int pot;
double playerCardTotal;
double dealerCardTotal;
double dealerHiddenCard;
Random random = new Random();

void main() {
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
            printLine("You busted! Dealer wins the pot.");
            printLine("The dealer's current bank is " + getDealerBank());
            printLine("The player's current bank is " + getHumanBank());
        } else {
            if (getPlayerCardTotal() <= 7) {
                playerDiff = playerDiff + (7 - getPlayerCardTotal());
            }

            if (getPlayerCardTotal() > 7) {
                playerDiff = playerDiff + (27 - getPlayerCardTotal());
            }

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

// Game-state helpers replace the methods that used to come from
// eecs.instructor.cobb.Seven27 so the program is self-contained.

void initializeMatch() {
    dealerBank = 5000;
    humanBank = 5000;
}

void initializeNewRound() {
    pot = 2000;
    dealerBank -= 1000;
    humanBank -= 1000;
    playerCardTotal = drawCard();
    dealerCardTotal = drawCard();
    dealerHiddenCard = drawCard();
    printLine("--- New round ---");
    printLine("Your starting card total: " + playerCardTotal);
    printLine("Dealer's visible card total: " + dealerCardTotal);
}

double drawCard() {
    int card = random.nextInt(13) + 1;
    if (card == 1) return 1.0;
    if (card >= 11) return 0.5;
    return card;
}

int getDealerBank() { return dealerBank; }
int getHumanBank() { return humanBank; }
double getPlayerCardTotal() { return playerCardTotal; }
double getDealerCardTotal() { return dealerCardTotal; }

void givePlayerACard() {
    double card = drawCard();
    playerCardTotal += card;
    printLine("You drew a card worth " + card + ". Total: " + playerCardTotal);
}

void giveDealerACard() {
    double card = drawCard();
    dealerCardTotal += card;
    printLine("Dealer drew a card worth " + card + ". Total: " + dealerCardTotal);
}

void flipDownCard() {
    dealerCardTotal += dealerHiddenCard;
    printLine("Dealer flips hidden card worth " + dealerHiddenCard + ". Total: " + dealerCardTotal);
}

void givePotToDealer() {
    dealerBank += pot;
    pot = 0;
}

void givePotToPlayer() {
    humanBank += pot;
    pot = 0;
}

void splitPot() {
    dealerBank += pot / 2;
    humanBank += pot / 2;
    pot = 0;
}

void updateDisplay() {
    // Console version — nothing to refresh.
}

int chooseButton(String prompt, String yesLabel, String noLabel) {
    String response = IO.readln(prompt + " (" + yesLabel + "/" + noLabel + "): ").trim();
    if (response.equalsIgnoreCase(yesLabel) || response.equalsIgnoreCase("y") || response.equals("1")) {
        return BUTTON1;
    }
    return BUTTON2;
}

void printLine(Object value) {
    IO.println(value);
}
