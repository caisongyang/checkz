package cardTable;

import java.sql.SQLOutput;
import java.util.*;

public class Table {
    private String tableId;
    private String tableName;
    private String tableStuts;
    private Map<String,Object> pz = new HashMap<String,Object>();
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


    public void tableInit(){
        cardInit();
        for(int i = 0;i<15;i++){
            u1.addUserCard(fp());
           u2.addUserCard(fp());
            u3.addUserCard(fp());
        }
        u1.userShow();
        u2.userShow();
        u3.userShow();

        int frist = (new Random()).nextInt(3);
        System.out.println("第"+frist+"首先开始");
        if(frist == 0){

        }else if(frist == 1){

        }else if(frist == 2){

        }
    }

    public void gameRun(String fristCardNum,String userName){
        boolean gameStatus = true;
        while (gameStatus){
            talCard = fristCardNum;
            usecheckNext(userName);



       }

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
        //System.out.println("size="+pzList.size());
        //System.out.println("cid="+cid);
        Card ret = (Card) pzList.get(cid);
        pzList.remove(cid);
        return ret;
    }


}
