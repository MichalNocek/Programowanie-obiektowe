
class Prostokat extends Figura {
	double wys=0, szer=0;
	
	Prostokat(double wys,double szer){
		this.wys = wys;
		this.szer = szer;
			
	}

    double getPowierzchnia() {
        return (szer * wys);
    }
    
    
}