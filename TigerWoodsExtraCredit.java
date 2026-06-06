// Name: CDT McBride
// Section: H2
// Date: 02NOV03
// Description:

void main() {
    int club = 0;
    int distanceToHole = Integer.parseInt(IO.readln("Enter the distance to the hole in yards: "));
    if (distanceToHole > 145 || distanceToHole < 1) {
        IO.println("Exceeds the Distance Limit");
        IO.println("Invalid Input.  Results Void.");
        return;
    }
    int elevationDifference = Integer.parseInt(IO.readln(
            "Enter the elevation difference to the hole in yards. + value is uphill.  - value is downhill: "));
    double windSpeed = Double.parseDouble(
            IO.readln("Enter the wind speed + value is a tailwind.  - value is a headwind: "));
    int terrain = Integer.parseInt(
            IO.readln("Enter -1 if in the Ruff.  Enter 0 if on the Fairway.  Enter 1 if in a divot: "));
    double windFactor = (windSpeed / 10) * (windSpeed / 10) + 2.2360679775;
    if (distanceToHole >= 121) {
        club = club + 5;
    } else if (distanceToHole >= 81) {
        club = club + 4;
    } else if (distanceToHole <= 80.0) {
        club = club + 3;
    }
    if (windFactor > 5) {
        if (windSpeed > 0) {
            club = club - 1;
        } else {
            club = club + 1;
        }
    }
    if (elevationDifference > 15) {
        club = club + 1;
    }
    if (elevationDifference < -15) {
        club = club - 1;
    }
    if (terrain == -1) {
        club = club - 1;
    }
    if (terrain == 1) {
        club = club + 1;
    }

    if (club == 0) {
        IO.print("P");
    }
    if (club == 1) {
        IO.print("FS");
    }
    if (club == 2) {
        IO.print("LWII");
    }
    if (club == 3) {
        IO.print("LW");
    }
    if (club == 4) {
        IO.print("SW");
    }
    if (club == 5) {
        IO.print("PW");
    }
    if (club == 6) {
        IO.print("9I");
    }
    if (club == 7) {
        IO.print("8I");
    }
    if (club == 8) {
        IO.print("7I");
    }
    if (club < 0) {
        IO.println("Invalid Input.  Results Void.");
    }
}
