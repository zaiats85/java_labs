package com.lab.turnstille;
import java.time.LocalDate;
import java.util.UUID;

public class PassCard {
    private UUID id;
    private СardType cardType;
    private LocalDate endDate;
    private Double refill;
    private int numberOfTrips;

    /*constructor when Student || School card created*/
    public PassCard(UUID id, СardType cardType, double refill){
        this.id = id;
        this.cardType = cardType;
        this.refill = refill;
    }

    public СardType getCardType() {
        return cardType;
    }

    /*constructor when Standard card created*/
    public PassCard(UUID id, СardType cardType, int numberOfTrips, LocalDate endDate){
        this.id = id;
        this.cardType = cardType;
        this.numberOfTrips = numberOfTrips;
        this.endDate = endDate;
    }

    public Boolean hasTrips(){
        return this.numberOfTrips > 0;
    }

    public Boolean hasMoney(double price){
        return (this.refill - price) >= 0.0;
    }

    public Boolean expired(){
        return LocalDate.now().isAfter(this.endDate);
    }

    public void takeTrip(){
        this.numberOfTrips -= 1;
    }

    public void takeMoney(double price){
        this.refill -= price;
    }

    public String getId(){
        return id.toString();
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() +
        " type: " + cardType +
        " id: " + id +
        " valid till: " + endDate +
        " trips left: " + numberOfTrips+
        " money left: " + refill;

    }
}

