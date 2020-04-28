package cardTable;

import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.Collectors;

public class user {

    private String userId;
    private String userName;
    private Map<String,Object> sp = new HashMap<>();
    private List<String> spshowList = new ArrayList<String>();
    private List<String> spshowNameList = new ArrayList<String>();

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

    public void userShow(){
        List<String> valList = new ArrayList<String>();
       for(String key:sp.keySet()){
           valList.add(key);
       }
        boolean whiletof = true;
        while(whiletof){
            if(valList.size()==0){
                whiletof = false;
            }else{
                String Maxval = valList.get(0);
                int maxkey = 0;
                for(int i = 0;i<valList.size();i++){
                    if(Integer.parseInt(Maxval)<Integer.parseInt(valList.get(i))){
                        Maxval = valList.get(i);
                        maxkey = i;
                    }
                }
                spshowList.add(Maxval);
                valList.remove(maxkey);
            }
        }

        for(int i = 0;i<spshowList.size();i++){
            spshowNameList.add(((Card)sp.get(spshowList.get(i))).getCardName());
        }
        System.out.println(spshowNameList.toString());
    }


    public void docCard(){


    }

}
