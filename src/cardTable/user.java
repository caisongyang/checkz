package cardTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class user {

    private String userId;
    private String userName;
    private Map<String,Object> sp = new HashMap<>();
    private List<String> spshowList = new ArrayList<String>();
    private List<String> spshowNameList = new ArrayList<String>();
    private static Table table = new Table();
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
        System.out.println(userName+" : "+spshowNameList.toString());
    }


    public String userCard(String CradNum){
        String CardNumId = "";
        String CardNum = "";
        if(CradNum.indexOf("@")!=-1){
            for(int i = 0;i<spshowNameList.size();i++){
                if(CradNum.equals(spshowNameList.get(i))){
                    if(CardNum.length()==0){
                        CardNum = ""+i;
                        CardNumId = ""+spshowList.get(i);
                    }else{
                        CardNum = CardNum+"@"+i;
                        CardNumId = CardNumId+"@"+spshowList.get(i);
                    }
                }
            }
            String [] a = CradNum.split("@");
            List<String> carddel = new ArrayList<String>();
            for(int i = 0;i<a.length;i++){
                carddel.add(a[i]);
            }
            while(true){
               if(carddel.size()==0){
                   return CradNum;
               }
               String delCard = carddel.get(0);
               carddel.remove(0);
                for(int i = 0;i<spshowNameList.size();i++){
                    if(delCard.equals(spshowNameList.get(i))){
                        if(CardNum.length()==0){
                            CardNum = ""+i;
                            CardNumId = ""+spshowList.get(i);
                        }else{
                            CardNum = CardNum+"@"+i;
                            CardNumId = CardNumId+"@"+spshowList.get(i);
                        }
                    }
                }
                spshowNameList.remove(CardNum);
                spshowList.remove(CardNum);
                sp.remove(CardNumId);
            }
        } else{
            for(int i = 0;i<spshowNameList.size();i++){
                if(CradNum.equals(spshowNameList.get(i))){
                        CardNum = ""+i;
                        CardNumId = ""+spshowList.get(i);
                }
            }
            spshowNameList.remove(CardNum);
            spshowList.remove(CardNum);
            sp.remove(CardNumId);
        }
        //System.out.println(userName + "" + spshowNameList.toString());
        if(sp.size()==0&&spshowNameList.size()==0){
            System.out.println(userName+" WIN!");
            return userName+" WIN";
        }
        return  CradNum;
    }

    public String AidocCard(String tableCard,String tableCardNum){
            if(tableCard.equals("fst")){
            String AIret = Aiuser(tableCard,"fst",tableCardNum);
            String ret = userCard(AIret);
            if(ret.indexOf("WIN")!=-1){
                    return ret;
            }
            return AIret;
        }else{
            if(tableCard.indexOf("@")==-1){
                tableCard = "dan@"+tableCard;
            }else{
                tableCard = "dui@"+tableCard;
            }

            if(tableCard.split("@")[0].equals("dan")){
                String AIret = Aiuser(tableCard,"dan", tableCardNum);
                String ret  = userCard(AIret);
                if(ret.indexOf("WIN")!=-1){
                    return ret;
                }
                return AIret;
            }else if(tableCard.split("@")[0].equals("dui")){
                String AIret = Aiuser(tableCard,"dui",tableCardNum);
                String ret  = userCard(AIret);
                if(ret.indexOf("WIN")!=-1){
                    return ret;
                }
                return AIret;
            }else if(tableCard.split("@")[0].equals("san")){
                return "";
            }else if(tableCard.split("@")[0].equals("lian")){
                return "";
            }else if(tableCard.split("@")[0].equals("shun")){
                return "";
            }else{
                return "";
            }
        }
    }

    public String Aiuser(String tableCard,String type,String tableCardNum){
        String retCard = "";
        if("dan".equals(type)){
            retCard = checkCardDan(tableCard);
        }else if("dui".equals(type)){
            retCard = checkCardDui(tableCard);
        }else if("fst".equals(type)){
            retCard = checkCardFst();
        }
        System.out.println("桌面是"+tableCardNum+", AI结果是："+table.CardidtoNum(retCard));
        System.out.println(userName+" : "+spshowNameList.toString());
        return retCard;
    }


    public String checkCardDan(String tableCard){
        String tableCardNum = tableCard.split("@")[1];
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

    public String checkCardDui(String tableCard){
        String tableCardNum = tableCard.split("@")[1];
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
        if("100".equals(minCardDui)){
            return "No";
        }else{
            return minCardDui;
        }
    }

    public String checkCardFst(){
        Map<String,String> cMap = new HashMap<String,String>();
        for(String key:sp.keySet()){
            String cardNum = ((Card) sp.get(key)).getCardNum();
            String cardId  = ((Card) sp.get(key)).getCardId();
            if(cMap.get(cardNum)==null){
                cMap.put(cardNum,((Card) sp.get(key)).getCardId());
            }else{
                String cid = cMap.get(cardNum)+"@"+cardId;
                cMap.remove(cardNum);
                cMap.put(cardNum,cid);
            }
        }
        int danNum = 0;
        int duiNum = 0;
        String  minDan = "100";
        String  minDui = "100";
        for(String key:cMap.keySet()){
            if(cMap.get(key).indexOf("@")==-1){
                danNum+=1;
                if(Integer.parseInt(minDan)>Integer.parseInt(cMap.get(key))){
                    minDan = cMap.get(key);
                }
            }else{
                duiNum+=1;
                String [] ids = cMap.get(key).split("@");
                for(int i = 0;i<ids.length;i++){
                    if(Integer.parseInt(minDui)>Integer.parseInt(ids[i])){
                        minDui = ids[i];
                    }
                }
            }
        }
        if(danNum>danNum){
            return minDan;
        }else{
            return minDui;
        }
    }


    public void showCard(){
        System.out.println(spshowNameList.toString());
    }



}
