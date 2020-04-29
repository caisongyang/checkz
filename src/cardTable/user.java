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


    public String AidocCard(String tableCard){
        if("".equals(tableCard)){

        }else if(tableCard.split("@")[0].equals("dan")){

        }else if(tableCard.split("@")[0].equals("dui")){

        }else if(tableCard.split("@")[0].equals("san")){

        }else if(tableCard.split("@")[0].equals("lian")){

        }else if(tableCard.split("@")[0].equals("shun")){

        }

        return "";
    }

    public String Aiuser(String tableCard,String type){
        String retCard = "";
        if("dan".equals(type)){
            retCard = checkCardDan(tableCard);
        }else if("dui".equals(type)){

        }
        return retCard;
    }


    public String checkCardDan(String tableCardNum){
        Map<String,String> cMap = new HashMap<String,String>();
        for(String key:sp.keySet()){
            String cardNum = ((Card) sp.get(key)).getCardNum();
            String cardId  = ((Card) sp.get(key)).getCardId();
            if(Integer.parseInt(tableCardNum)<Integer.parseInt(cardNum)){
                if(cMap.get(cardNum)==null){
                    cMap.put(cardNum,((Card) sp.get(key)).getCardId());
                }else{
                    String cid = cMap.get(cardNum)+"@"+cardId;
                    cMap.remove(cardNum);
                    cMap.put(cardNum,cid);
                }
            }
        }
        if(cMap.size()==0){
            return "No";
        }
        boolean cardA = false;
        String minCard = "100";
        String minCardDui = "100";
        for(String key:cMap.keySet()){
           if(cMap.get(key).indexOf("@")==-1){
               cardA = true;
               if(Integer.parseInt(minCard)>Integer.parseInt(cMap.get(key))){
                   minCard = cMap.get(key);
               }
           }else{
               if(Integer.parseInt(minCardDui)>Integer.parseInt(cMap.get(key).split("@")[0])){
                   minCardDui = cMap.get(key).split("@")[0];
               }
           }
        }
        if(cardA){
            return minCard;
        }else{
            return minCardDui;
        }
    }

    public String checkCardDui(String tableCardNum){
        String CardNum = tableCardNum.split("@")[0];
        Map<String,String> cMap = new HashMap<String,String>();
        for(String key:sp.keySet()){
            String cardNum = ((Card) sp.get(key)).getCardNum();
            String cardId  = ((Card) sp.get(key)).getCardId();
            if(Integer.parseInt(CardNum)<Integer.parseInt(cardNum)){
                if(cMap.get(cardNum)==null){
                    cMap.put(cardNum,((Card) sp.get(key)).getCardId());
                }else{
                    String cid = cMap.get(cardNum)+"@"+cardId;
                    cMap.remove(cardNum);
                    cMap.put(cardNum,cid);
                }
            }
        }
        if(cMap.size()==0){
            return "No";
        }
        String minCardDui = "100";
        for(String key:cMap.keySet()){
            if(cMap.get(key).indexOf("@")!=-1){
                if(Integer.parseInt(minCardDui)>Integer.parseInt(cMap.get(key))){
                    minCardDui = cMap.get(key);
                }
            }
        }

        return "";
    }

}
