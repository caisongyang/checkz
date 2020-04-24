package cardTable;

import java.util.Map;

public class user {

    private String userId;
    private String userName;
    private Map<String,Object> sp;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void addUserCard(Card addCard){
        this.sp.put(addCard.getCardId(),addCard);
    }

    public void delUserCard(String cardId){
        this.sp.remove(cardId);
    }

    public String userShow(){

      return "";
    }
}
