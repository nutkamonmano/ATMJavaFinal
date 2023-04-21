class TopUpHistory{
	public String topupdate;
	public double topup;
	public double lastbal;
	public String topuptype;

	public String getTopuptype() {
		return topuptype;
	}

	public void setTopuptype(String topuptype) {
		this.topuptype = topuptype;
	}

	TopUpHistory(String topupdate, String topuptype, double topup, double lastbal){
		this.topupdate = topupdate;
		this.topuptype = topuptype;
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