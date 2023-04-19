public class Addbank {
    public String bankdate;
    //เงินที่จะโอน
    public double tranferin;
    //คงเหลือ
    public double bathtranfer;

    public Addbank(String bankdate1,double tranfer1,double bathtranfer1){
        this.bankdate = bankdate1;
        this.tranferin = tranfer1;
        this.bathtranfer = bathtranfer1; 
   }
    public Addbank(double tranfer1,double bathtranfer1){
        this.tranferin = tranfer1;
        this.bathtranfer = bathtranfer1; 
    }

    public Addbank(double m){
        this.money = m;
    }

    public void setBankdate (String bankdate1){
        this.bankdate = bankdate1;
    }

    public String getBankdate(){
        return bankdate;
    }

    public void setTranfer(Double tranfer1 ){
        this.tranferin = tranfer1;
    }

    public Double getTranfer(){
        return tranferin;

    }

    public void setBathtranfer(Double bathtranfer1 ){
        this.bathtranfer = bathtranfer1; 
    }

    public Double getBathtranfer(){
        return bathtranfer;

    }

   //จำลองเงินที่มีอยู่(ลบได้)
    public double money;
    public void setMoney(Double m ){
        this.money = m; 
    }

    public Double getMoney(){
        return money;

    }




}
