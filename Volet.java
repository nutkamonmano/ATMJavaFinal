class Volet {
	private double inputvo;
	private String inputvnumber;

	Volet(){}

    Volet(double inputvo,String inputvnumber){
	this.inputvo = inputvo;
	this.inputvnumber = inputvnumber;
} 
    public void setinputvo(double inputvo){
    this.inputvo = inputvo;
}
    public double getinputvo(){
    return inputvo;
}
    public void setinputvnumber(String inputvnumber){
    this.inputvnumber = inputvnumber;
}
    public String getinputvnumber(){
    return inputvnumber;
}

}
