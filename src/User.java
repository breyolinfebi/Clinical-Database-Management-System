/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fredi
 */
class User {
    private String mid,name,quan,comp,plc;
    private int pr;
    public User (String mid,String name,String quan,int pr,String comp,String plc){
        this.mid = mid;
        this.name = name;
        this.quan = quan;
        this.pr = pr;
        this.comp = comp;
        this.plc = plc;
    }
    public String getmid(){
        return mid;
    }
    public String getname(){
        return name;
    }
      public String getquan(){
        return quan;
    }     
public int getpr(){
        return pr;
    }
public String getcomp(){
        return comp;
    }
public String getplc(){
        return plc;
    }
}
