package runKuai;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class plyUser {

    private String userId;
    private String userName;
    private List<String> spList = new ArrayList<String>();

    private String plyStatus = "IN GAME";



    public void doCard(String cardNum){
        if(cardNum.indexOf("@")==-1){
            int cardNumIndex = 0;
            for(int i = 0;i<spList.size();i++){
                if(cardNum.equals(spList.get(i))){
                    cardNumIndex = i;
                }
            }
            spList.remove(cardNumIndex);
        }else{
            String [] cardNumStr = cardNum.split("@");
            for(int k = 0;k<cardNumStr.length;k++){
                int cardNumIndex = 0;
                for(int i = 0;i<spList.size();i++){
                    if(cardNumStr[k].equals(spList.get(i))){
                        cardNumIndex = i;
                    }
                }
                spList.remove(cardNumIndex);
            }
        }
        if(spList.size()==0){
            this.plyStatus = "WIN";
        }
    }


    public String AiDoCard(String CardNum){
        String ret = "";
        if(CardNum==null){
            ret = doCardFrst();
            doCard(ret);
            return ret;
        }
        if(CardNum.indexOf("@")==-1){
            ret =  doCardDan(CardNum);
        }else{
            ret = "";
        }
        if(!"".equals(ret)){
            doCard(ret);
        }
        return  ret;
    }

/*    public void removeCard(String cardNum){
        for(int i= 0;i<spList.size();i++){
            if(cardNum.equals(spList.get(i))){
                spList.remove(i);
            }
        }
    }*/

    public String doCardFrst(){
        System.out.println(this.userName+" ÊÇfrst£¬spÎª"+this.spList.toString());
        List<String> cardList = spList;
        String minCard = cardList.get(cardList.size()-1);
        int cardIndex = 0;
            for(int i = 0;i<cardList.size();i++){
                if(minCard.equals(cardList.get(i))){
                    cardIndex ++;
                }
            }
        if(cardIndex>1){
           // return minCard+"@"+minCard;
            return minCard;
        }else{
            return minCard;
        }
    }

    public String doCardDan(String tableCardNum){
        int cardNum = cardNumChange(tableCardNum);
        String minCard = "";
        for(int i = 0;i<spList.size();i++){
            if(cardNumChange(spList.get(i))>cardNum){
                if("".equals(minCard)){
                    minCard = spList.get(i);
                }else{
                    if(cardNumChange(minCard)>cardNumChange(spList.get(i))){
                        minCard = spList.get(i);
                    }
                }
            }
        }
        if(!"".equals(minCard)){
           return minCard;
        }else{
            return "";
        }
    }



    public int cardNumChange(String cardNum){
        int ret = 0;
        if(cardNum.equals("2")){
            ret = 15;
        }else if(cardNum.equals("J")){
            ret = 11;
        }else if(cardNum.equals("Q")){
            ret = 12;
        }else if(cardNum.equals("K")){
            ret = 13;
        }else if(cardNum.equals("A")){
            ret = 14;
        }else{
            ret = Integer.parseInt(cardNum);
        }
        return ret;
    }


    public void spCrod(){
        List<String> sppxList = spList;
        List<String> retList = new ArrayList<>();
        boolean tof = true;
        while (tof){
            String maxCard = sppxList.get(0);
            int  maxIndex = 0;
            for(int i = 0;i<sppxList.size();i++){
               if(checkBatter(maxCard,sppxList.get(i))){
                   maxCard = sppxList.get(i);
                   maxIndex = i;
                }
            }
            retList.add(maxCard);
            sppxList.remove(maxIndex);
           if(sppxList.size()==0){
               tof = false;
           }
       }
       spList = retList;
    }


    public boolean checkBatter(String value1,String value2){
        int valNum1  = 0;
        int valNum2  = 0;

        if("J".equals(value1)){
            valNum1 = 11;
        }else if("Q".equals(value1)){
            valNum1 = 12;
        }else if("K".equals(value1)){
            valNum1 = 13;
        }else if("A".equals(value1)){
            valNum1 = 14;
        }else if("2".equals(value1)){
            valNum1 = 15;
        }else{
            valNum1 = Integer.parseInt(value1);
        }
        if("J".equals(value2)){
            valNum2 = 11;
        }else if("Q".equals(value2)){
            valNum2 = 12;
        }else if("K".equals(value2)){
            valNum2 = 13;
        }else if("A".equals(value2)){
            valNum2 = 14;
        }else if("2".equals(value2)){
            valNum2 = 15;
        }else{
            valNum2 = Integer.parseInt(value2);
        }
        if(valNum1<valNum2){
            return true;
        }else{
            return false;
        }
    }


    public void addSp(String card){
        spList.add(card);
    }

    public void showSp(){
        System.out.println(this.userName+" : "+this.spList.toString());
    }


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

    public String getPlyStatus() {
        return plyStatus;
    }

    public void setPlyStatus(String plyStatus) {
        this.plyStatus = plyStatus;
    }
}
