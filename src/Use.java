/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author breyo
 */
class Use {

    private String bd,name,rid;
    private int bn,ta;
    public Use (String bd,String rid,String name,int bn,int ta){
        this.bd = bd;
        this.name = name;
        this.rid = rid;
        this.bn= bn;
        this.ta = ta;

    }
    public String getbd(){
        return bd;
    }
    public String getname(){
        return name;
    }
      public String getrid(){
        return rid;
    }     
    public int getbn(){
        return bn;
    }
    public int getta(){
        return ta;
    }

    
}
