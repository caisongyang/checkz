package runKuai;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class cardTable {
    private List<String> pz = new ArrayList<String>();
    private plyUser user1 = new plyUser();
    private plyUser user2 = new plyUser();
    private plyUser user3 = new plyUser();

  public void tableInit(){
      //1.pzInit()
      pzInit();
      //2.userInit();
      userInit();
      //3.spinit();
      spInit();
      //4. run
      runG();


  }


  public void runG(){
      boolean tof = true;
      String tableCard = "";
      String oneUserId = "u1";
      while(tof){
          oneUserId =  onePly(oneUserId);
          if(oneUserId.indexOf("WIN")!=-1){
              System.out.println(oneUserId);
              tof = false;
          }else{
              System.out.println("");
          }
      }
  }


  public String onePly(String userId){
      System.out.println("本轮第一位"+userId);
      String userNowid = userId;
      String passUserid = "";
      int passNum = 0;
      boolean psstof = true;
      String tableCard = userCheck(userNowid,"now").AiDoCard(null);
      System.out.println( userId + " :" +tableCard);
      if(userCheck(userNowid,"now").getPlyStatus().equals("WIN")){
         return userId+",WIN";
      }
      while(psstof){
          userNowid = userCheck(userNowid,"next").getUserId();
          //System.out.println(userNowid);
          if(passUserid.equals(userNowid)){
              userNowid = userCheck(userNowid,"next").getUserId();
          }
          String  nowCard = userCheck(userNowid,"now").AiDoCard(tableCard);
          //System.out.println(nowCard);
          if(nowCard.equals("")){
              passUserid = userNowid;
              passNum ++;
              System.out.println(passUserid+" : pass");
              userCheck(userNowid,"now").showSp();
          }else{
              tableCard = nowCard;
              System.out.println(userNowid+" :"+tableCard);
              userCheck(userNowid,"now").showSp();
              if(userCheck(userNowid,"now").getPlyStatus().equals("WIN")){
                  return userNowid+",WIN";
              }
          }
          if(passNum == 2){
              psstof = false;
          }
      }
      System.out.println("本轮结束，"+userId+" 下一轮第一");
      return userNowid;
  }

  public plyUser userCheck(String userId,String type){
      if("now".equals(type)){
           if(userId.equals("u1")){
                return user1;
           }else if(userId.equals("u2")){
               return user2;
           }else if(userId.equals("u3")){
               return user3;
           }
      }else {
          if(userId.equals("u1")){
              return user2;
          }else if(userId.equals("u2")){
              return user3;
          }else if(userId.equals("u3")){
              return user1;
          }
      }
       return null;
  }

    //1.pz初始化
    public void pzInit(){
         for(int i = 3;i<11;i++){
             pz.add(i+"");
             pz.add(i+"");
             pz.add(i+"");
             pz.add(i+"");
         }
        pz.add("J");
        pz.add("J");
        pz.add("J");
        pz.add("J");
        pz.add("Q");
        pz.add("Q");
        pz.add("Q");
        pz.add("Q");
        pz.add("K");
        pz.add("K");
        pz.add("K");
        pz.add("A");
        pz.add("2");
    }

    //2 userInit
    public void userInit(){
        user1.setUserName("Aiuser - One");
        user2.setUserName("Aiuser - Two");
        user3.setUserName("Aiuser - Thr");
        user1.setUserId("u1");
        user2.setUserId("u2");
        user3.setUserId("u3");
    }

    //3 fp
    public void spInit(){
        for(int i = 0;i<15;i++){
            user1.addSp(fp());
            user2.addSp(fp());
            user3.addSp(fp());
        }
/*        user1.showSp();
        user2.showSp();
        user3.showSp();*/
        user1.spCrod();
        user2.spCrod();
        user3.spCrod();
        user1.showSp();
        user2.showSp();
        user3.showSp();
    }


    public String fp(){
        Random random = new Random();
        int pzid = random.nextInt(pz.size());
        String ret = pz.get(pzid);
        pz.remove(pzid);
        return ret;
    }
}
