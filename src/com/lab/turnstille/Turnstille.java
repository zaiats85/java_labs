package com.lab.turnstille;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import java.util.stream.Collectors;

class Pass {
    LocalDateTime logTime;
    private СardType logType;
    String logID;

    public Pass(LocalDateTime logTime, СardType logType, String logID) {
        this.logID = logID;
        this.logTime = logTime;
        this.logType = logType;
    }

    public СardType getLogType() {
        return logType;
    }

    public static String formatTime(LocalDateTime time){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return time.format(formatter);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() +
                " id: " + logID +
                " time " + formatTime(logTime)+
                " cardType: " + logType;
    }
}

public class Turnstille {
    private double price;
    private static final int serialNumber = 312590419;

    private ArrayList<Pass> allPasses = new ArrayList<Pass>();

    public Turnstille(double price) {
        this.price = price;
    }

    public void checkCard(PassCard card) {

        try {
            СardType cardType = card.getCardType();
            String cardId = card.getId();

            switch (cardType) {
                case SCHOOL:
                case STUDENT:
                    if (!card.hasTrips()) {
                        showUserMessage("Denied", cardId, " No trips left");
                    } else if (card.expired()) {
                        showUserMessage("Denied", cardId, " Card expired");
                    } else {
                        card.takeTrip();
                        showUserMessage("Granted", cardId, "Welcome :)");
                    }
                    break;
                case STANDARD:
                    if (!card.hasMoney(price)) {
                        showUserMessage("Denied", cardId, "Not enought money");
                    } else {
                        card.takeMoney(price);
                        showUserMessage("Granted", cardId, "Welcome :)");
                    }
                    break;
            }

            /*Log turnstille pass attempt*/
            allPasses.add(new Pass(getTimeNow(), cardType, cardId));

        } catch (Exception e) {
            /*Output User Message*/
            // showUserMessage("Denied", "-", "can't read the card");

            /*Log turnstille pass attempt*/
            allPasses.add(new Pass(getTimeNow(), СardType.UNKNOWN, "unknown"));
        }
    }

    public LocalDateTime getTimeNow() {
        return LocalDateTime.now();
    }

    public void showUserMessage(String status, String id, String message) {
        System.out.printf("Access %s for %s. %s \n", status, id, message);
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public double getPrice() {
        return price;
    }

    public void showPasses() {

        System.out.println("Turnstille attempted " + this.allPasses.size() + " passes");

        Iterator passesIterator = allPasses.iterator();

        int index = 0;
        while (passesIterator.hasNext()) {
            System.out.println(++index + " " + passesIterator.next());
        }

    }

    public void showPasses(СardType param) {
        allPasses.stream()
                .filter(Objects::nonNull)
                .filter(name -> name.getLogType() == param)
                .forEach(System.out::println);
    }

}
