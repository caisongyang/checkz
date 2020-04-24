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

    public Card newCard(Map<String,String> valMap){
        Card thiscard  = new Card();
        thiscard.cardId = valMap.get("cardId");
        thiscard.cardNum = valMap.get("cardNum");
        thiscard.cardName = valMap.get("cardName");
        thiscard.cardYollow = valMap.get("cardYollow");
        return thiscard;
    }

}
