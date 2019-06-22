// Name: CDT McBride 
// Section: H2 
// Date: 02NOV03 
// Description:  

public class selection extends eecs.Gui {
  public static void main(String[] args) {
    int club = 0;
    int distanceToHole = getInt("Enter the distance to the hole in yards:");
    if (distanceToHole > 145 || distanceToHole < 1) {
      printLine("Exceeds the Distance Limit");
      club = club - 999;
    }
    int elevationDifference = getInt(
        "Enter the elevation difference to the hole in yards. + value is uphill.  - value is downhill:");
    double windSpeed = getDouble("Enter the wind speed + value is a tailwind.  - value is a headwind:");
    double windFactor = (windSpeed / 10) * (windSpeed / 10) + 2.2360679775;

    if (distanceToHole >= 121) {
      club = club + 5;
    } else if (distanceToHole >= 81) {
      club = club + 4;
    } else if (distanceToHole <= 80 && distanceToHole > 0) {
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

    if (club == 1) {
      printLine("FS");
    }

    if (club == 2) {
      printLine("LWII");
    }

    if (club == 3) {
      printLine("LW");
    }

    if (club == 4) {
      printLine("SW");
    }

    if (club == 5) {
      printLine("PW");
    }

    if (club == 6) {
      printLine("9I");
    }

    if (club == 7) {
      printLine("8I");
    }

    if (club < 0) {
      printLine("Invalid Input.  Results Void.");
    }

  }

}