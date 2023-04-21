class TopUpHistory{
	public String topupdate;
	public double topup;
	public double lastbal;

	TopUpHistory(String topupdate, double topup, double lastbal){
		this.topupdate = topupdate;
		this.topup = topup;
		this.lastbal = lastbal;
	}

	public void setTopupdate(String topupdate){
    this.topupdate = topupdate;
}
    public String getTopupdate(){
    return topupdate;
}
    public void setTopup(double topup){
	this.topup = topup;
} 
    public double getTopup(){
	return topup;
}
    public void setLastbal(double lastbal){
	this.lastbal = lastbal;
}
    public double getLastbal(){
	return lastbal;
}

}