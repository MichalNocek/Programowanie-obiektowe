package pliki;

class Prostokat extends Figura  {
	double wys=0, szer=0;
	
	Prostokat(double wys,double szer){
		this.wys = wys;
		this.szer = szer;
			
	}

    double getPowierzchnia() {
        return (szer * wys);
    }

	Prostokat(float wys,float szer,String kolor){
		super(kolor);
		this.wys = wys;
		this.szer = szer;
	}
	public void przesuniecie(double x,double y){
		punkt.x= punkt.x+x;
		punkt.y= punkt.y+y;
	}

    
}