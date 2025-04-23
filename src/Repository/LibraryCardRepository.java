package Repository;

import entity.LibraryCard;
import java.util.*;

public class LibraryCardRepository {
    private Map<String, LibraryCard> cards = new HashMap<>();

    public void addCard(LibraryCard card) {
        cards.put(card.getCardId(), card);
    }

    public boolean exists(String cardId) {
        return cards.containsKey(cardId);
    }
}
