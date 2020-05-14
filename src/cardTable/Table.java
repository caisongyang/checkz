package cardTable;

import java.sql.SQLOutput;
import java.util.*;

public class Table {
    private String tableId;
    private String tableName;
    private String tableStuts;
    private static Map<String,Object> pz = new HashMap<String,Object>();
    private List<Card> pzList = new ArrayList<Card>();
    private Map<String,Object> qp = new HashMap<String,Object>();;
    private user u1 = new user();
    private user u2 = new user();
    private user u3 = new user();
    private String talCard;

    public String getTableId() {
        return tableId;
    }

    public void setTableId(String tableId) {
        this.tableId = tableId;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getTableStuts() {
        return tableStuts;
    }

    public void setTableStuts(String tableStuts) {
        this.tableStuts = tableStuts;
    }


    public void gomeStart(){
        System.out.println("kaishi");
        tableInit();
    }

    public void tableInit(){
        cardInit();
        for(int i = 0;i<15;i++){
            u1.addUserCard(fp());
            u2.addUserCard(fp());
            u3.addUserCard(fp());
        }
        u1.setUserName("u1");
        u2.setUserName("u2");
        u3.setUserName("u3");
        u1.userShow();
        u2.userShow();
        u3.userShow();
        int frist = (new Random()).nextInt(3);
        System.out.println("第"+(frist+1)+"位首先开始");
        if(frist == 0){
            gameRun("u1");
        }else if(frist == 1){
            gameRun("u2");
        }else if(frist == 2){
            gameRun("u3");
        }
    }

    public void gameRun(String userNameFst){
        boolean gameStatus = true;
        String nextUserName = "";
        while (gameStatus){
            nextUserName = onePly(userNameFst);
            if(nextUserName.indexOf("WIN")!=-1){
                gameStatus =false;
            }
            System.out.println("111111111111111111");
            gameStatus =false;
        }
    }


    public String onePly(String userName){
        String retUserName = "";
        String plyUserName = userName;
        String  plyCardAI =  usecheck(plyUserName).AidocCard("fst","0");
        if(plyCardAI.indexOf("WIN")!=-1){
            return plyCardAI;
        }else{
            talCard = plyCardAI;
        }
        System.out.println("userName="+plyUserName);
        System.out.println(userName+"  : "+cardidtoNum(talCard));
        int noStatus = 2;
        String outName = "";
        String nowUserName = "";
        while (noStatus!=0){
            plyUserName = usecheckNext(plyUserName).getUserName();
            System.out.println("userName="+plyUserName);
            if(outName.equals(plyUserName)){

            }else{
                String plyCard = usecheck(plyUserName).AidocCard(talCard,cardidtoNum(talCard));
                if("No".equals(plyCard)){
                    System.out.println(plyUserName+"  :   NO,Pass");
                    noStatus = noStatus - 1;
                    outName = plyUserName;
                }else{
                    if(plyCard.indexOf("WIN")!=-1){
                        return plyCard;
                    }else{
                        talCard = plyCard;
                    }
                    nowUserName = plyUserName;
                    //usecheck(nowUserName).showCard();
                    System.out.println(plyUserName+"  : "+cardidtoNum(talCard));
                }
            }
        }
        retUserName = nowUserName;
        return retUserName;
    }

    public user usecheckNext(String userName){
        if("u1".equals(userName)){
            return u2;
        }else if("u2".equals(userName)){
            return u3;
        }else if("u3".equals(userName)){
            return u1;
        }else{
            return u1;
        }
    }

    public user usecheck(String userName){
        if("u1".equals(userName)){
            return u1;
        }else if("u2".equals(userName)){
            return u2;
        }else if("u3".equals(userName)){
            return u3;
        }else{
            return u1;
        }
    }



    public void cardInit(){
        insertCard("0","3","3");
        insertCard("4","4","4");
        insertCard("8","5","5");
        insertCard("12","6","6");
        insertCard("16","7","7");
        insertCard("20","8","8");
        insertCard("24","9","9");
        insertCard("28","10","10");
        insertCard("32","11","J");
        insertCard("36","12","Q");
        insertCard("40","13","K");
        insertCard("43","14","A");
        insertCard("44","15","2");
        creatPz();
    }

    public void creatPz(){
        for(int i = 0;i<pzList.size();i++){
            pz.put(pzList.get(i).getCardId(),pzList.get(i).getCardName());
        }
    }


    public void insertCard(String cardId,String cardNum,String cardName){
        if("13".equals(cardNum)){
            Card c1 = (new Card()).newCard(cardId,cardNum,cardName,"梅");
            //pz.put(cardId,c1);
            pzList.add(c1);
            Card c2 = (new Card()).newCard((Integer.parseInt(cardId)+1)+"",cardNum,cardName,"桃");
            //pz.put((Integer.parseInt(cardId)+1)+"",c2);
            pzList.add(c2);
            Card c3 = (new Card()).newCard((Integer.parseInt(cardId)+2)+"",cardNum,cardName,"方");
            //pz.put((Integer.parseInt(cardId)+2)+"",c3);
            pzList.add(c3);
        }else if("14".equals(cardNum)){
            Card c1 = (new Card()).newCard(cardId,cardNum,cardName,"方");
            //pz.put(cardId,c1);
            pzList.add(c1);
        }else if("15".equals(cardNum)){
            Card c1 = (new Card()).newCard(cardId,cardNum,cardName,"方");
            //pz.put(cardId,c1);
            pzList.add(c1);
        }else{
            Card c1 = (new Card()).newCard(cardId,cardNum,cardName,"黑");
            //pz.put(cardId,c1);
            pzList.add(c1);
            Card c2 = (new Card()).newCard((Integer.parseInt(cardId)+1)+"",cardNum,cardName,"梅");
            //pz.put((Integer.parseInt(cardId)+1)+"",c2);
            pzList.add(c2);
            Card c3 = (new Card()).newCard((Integer.parseInt(cardId)+2)+"",cardNum,cardName,"桃");
            //pz.put((Integer.parseInt(cardId)+2)+"",c3);
            pzList.add(c3);
            Card c4 = (new Card()).newCard((Integer.parseInt(cardId)+3)+"",cardNum,cardName,"方");
            //pz.put((Integer.parseInt(cardId)+3)+"",c4);
            pzList.add(c4);
        }
    }


    public Card fp(){
        Random random = new Random();
        int cid = random.nextInt(pzList.size());
        Card ret = (Card) pzList.get(cid);
        pzList.remove(cid);
        return ret;
    }


    public String cardidtoNum(String CardId){
        String ret = "";
        if(CardId.indexOf("@")==-1){
          ret = pz.get(CardId).toString();
        }else{
            String [] retStr = CardId.split("@");
            for(int i = 0;i<retStr.length;i++){
                if(ret.length()==0){
                    ret = pz.get(retStr[i]).toString();
                }else{
                    ret = ret+"@"+pz.get(retStr[i]).toString();
                }
            }
        }
        return  ret;
    }


    public String CardidtoNum(String cardid){
        return pz.get(cardid).toString();
    }
}
