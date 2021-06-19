/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fredi
 */
class Us {
    private String mid,name,quan;
    private int pr;
    public Us(String mid,String name,String quan,int pr){
        this.mid = mid;
        //this.rg = rg;
        this.name = name;     
        this.quan = quan;
        this.pr = pr;
        //this.dat = dat;
    }
    public String getmid(){
        return mid;
    }
    //public String getrg(){
      //  return rg;
    //}
    public String getname(){
        return name;
    }
      public String getquan(){
        return quan;
    }     
public int getpr(){
        return pr;
    }
//public String getdat(){
  //  return dat;
//}
}
