package com.lab.turnstille;

class StartMyRide {

    private static final double price = 4.00;

    public static void main(String[] args) {

        // Whats the price for a ride? 4.00 hrn! Damn
        Turnstille turnstille = new Turnstille(price);

        // Where is the cassa?
        CardEmitter cassa = new CardEmitter();

        // Emit cards
        PassCard student_1 = cassa.createCard(СardType.STUDENT, NumberOfTrips.FIVE, Validity.TENDAYS);
        PassCard student_2 = cassa.createCard(СardType.STUDENT, NumberOfTrips.TEN, Validity.MONTHLY);
        PassCard school_1 = cassa.createCard(СardType.SCHOOL, NumberOfTrips.TEN, Validity.TENDAYS);
        PassCard school_2 = cassa.createCard(СardType.SCHOOL, NumberOfTrips.FIVE, Validity.MONTHLY);
        PassCard standard_1 = cassa.createCard(СardType.STANDARD, 20.00);
        PassCard standard_2 = cassa.createCard(СardType.STANDARD, 80.00);
        PassCard standard_3 = cassa.createCard(СardType.STANDARD, 150.00);

        // get the price of one trip
        System.out.println("Price for one trip is: " + turnstille.getPrice() + " Hrn");

        // get the turnstille serialNumber
        System.out.println("TurnStill Serial Number is: " + turnstille.getSerialNumber());

        // check all those people
        int i = 0;
        int k = 0;
        int v = 0;
        while (i++ < 4){
            turnstille.checkCard(standard_1);
            turnstille.checkCard(standard_3);
        }
        while (k++ < 5){
            turnstille.checkCard(student_1);
            turnstille.checkCard(student_2);
            turnstille.checkCard(school_1);
            turnstille.checkCard(school_2);
        }
        while(v++ < 7){
            turnstille.checkCard(standard_2);
            turnstille.checkCard(student_1);
        }

        /*Output all emitted cards*/
        cassa.showAllCardsEmmited();

        /*Output all passes*/
        turnstille.showPasses();

        /*show by card types*/
        turnstille.showPasses(СardType.SCHOOL);
    }
}
