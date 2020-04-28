package cardTable;


import java.util.Map;

public class Card {
    private String cardId;
    private String cardNum;
    private String cardName;
    private String cardYollow;

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getCardYollow() {
        return cardYollow;
    }

    public void setCardYollow(String cardYollow) {
        this.cardYollow = cardYollow;
    }

    public Card newCard(String cardId,String cardNum,String cardName,String cardYollow){
        Card thiscard  = new Card();
        thiscard.cardId = cardId;
        thiscard.cardNum = cardNum;
        thiscard.cardName = cardName;
        thiscard.cardYollow = cardYollow;
        return thiscard;
    }

}
