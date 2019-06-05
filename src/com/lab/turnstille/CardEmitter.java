package com.lab.turnstille;
import org.jetbrains.annotations.NotNull;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.*;

enum Validity {
    MONTHLY, TENDAYS
}

enum СardType {
    STUDENT, SCHOOL, STANDARD, UNKNOWN
}

enum NumberOfTrips {
    FIVE, TEN
}

public class CardEmitter {

    private List<PassCard> allCardsEmitted = new ArrayList<>();

    // Universally Unique Identifier
    public static UUID getUUID(){
        return UUID.randomUUID();
    };

    private int getNumberOfTrips(NumberOfTrips numberOfTrips){
        int trips;

        switch (numberOfTrips){
            case TEN:
                trips = 10;
                break;
            case FIVE:
                trips = 5;
                break;
            default:
                trips = 0;
        }

        return trips;
    }

    private LocalDate getExpirationDate(@NotNull Validity validFor){
        LocalDate endDate;

        switch (validFor){
            case MONTHLY:
                endDate = YearMonth.now().atEndOfMonth();
                break;
            case TENDAYS:
                endDate = LocalDate.now().plusDays(10);
                break;
            default:
                endDate = YearMonth.now().atEndOfMonth();
                break;
        }

        return endDate;
    }

    public PassCard createCard(СardType cardType, double refill){

        PassCard card = new PassCard(getUUID(), cardType, refill);

        /*Register the card emmited*/
        allCardsEmitted.add(card);
        return card;

    }

    public PassCard createCard(СardType cardType, NumberOfTrips numberOfTrips, Validity validity){

        LocalDate endDate = getExpirationDate(validity);
        int trips = getNumberOfTrips(numberOfTrips);

        PassCard card = new PassCard(getUUID(), cardType, trips, endDate);

        /*Register the card emitted*/
        allCardsEmitted.add(card);

        return card;

    }

    public void showAllCardsEmmited(){

        Iterator cardsIterator = allCardsEmitted.iterator();

        System.out.println("Cassa emitted "+ this.allCardsEmitted.size() + " cards");
        int index = 0;
        while (cardsIterator.hasNext()) {
            System.out.println(++index + " " + cardsIterator.next());
        }
    }
}
