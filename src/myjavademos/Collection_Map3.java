package myjavademos;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

class Prods
{
	int pno;
	String pname;
	float price;
	public int getPno() {
		return pno;
	}
	public void setPno(int pno) {
		this.pno = pno;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public Prods(int pno, String pname, float price) {
		super();
		this.pno = pno;
		this.pname = pname;
		this.price = price;
	}
	@Override
	public String toString() {
		return "Prods [pno=" + pno + ", pname=" + pname + ", price=" + price + "]";
	}
}
public class Collection_Map3 {
	public static void main(String[] args) {
		Prods p1=new Prods(11,"Laptop",90800);
		Prods p2=new Prods(12,"Harddisk",9000);
		Prods p3=new Prods(1,"RAM",9800);
		Prods p4=new Prods(51,"SMPS",9500);

		//KEY->Integer,Value->Prods
				HashMap<Integer,Prods> hobj=new HashMap<Integer,Prods>();//Random order
				hobj.put(1001, p1);//key,productobj
				hobj.put(2001, p2);
				hobj.put(3001, p3);
				hobj.put(4001, p4);
		
				for(Map.Entry<Integer, Prods> s1: hobj.entrySet())
				{
				System.out.println("Key&Value:: "+s1.getKey() + " "+s1.getValue());
				}
			
				//updating
				p2.setPname("Inverter");
				p2.setPrice(34090.43f);
				for(Map.Entry<Integer, Prods> s1: hobj.entrySet())
				{
					System.out.println("(Update)Key&Value:: "+s1.getKey() + " "+s1.getValue());
				}
				
				//Iterator cannot be used in directly MAP interface!
				Iterator<Integer> i=hobj.keySet().iterator();//hobj.iterator()=>invalid
				while(i.hasNext())
				{
				int key1=i.next();
				System.out.println("Key:: "+key1 + " " + "Value:: "+hobj.get(key1));//get(1001),get(2001),get(3001),get(4001)
				}


	}

}
/*
Key&Value:: 2001 Prods [pno=12, pname=Harddisk, price=9000.0]
Key&Value:: 4001 Prods [pno=51, pname=SMPS, price=9500.0]
Key&Value:: 1001 Prods [pno=11, pname=Laptop, price=90800.0]
Key&Value:: 3001 Prods [pno=1, pname=RAM, price=9800.0]
(Update)Key&Value:: 2001 Prods [pno=12, pname=Inverter, price=34090.43]
(Update)Key&Value:: 4001 Prods [pno=51, pname=SMPS, price=9500.0]
(Update)Key&Value:: 1001 Prods [pno=11, pname=Laptop, price=90800.0]
(Update)Key&Value:: 3001 Prods [pno=1, pname=RAM, price=9800.0]
Key:: 2001 Value:: Prods [pno=12, pname=Inverter, price=34090.43]
Key:: 4001 Value:: Prods [pno=51, pname=SMPS, price=9500.0]
Key:: 1001 Value:: Prods [pno=11, pname=Laptop, price=90800.0]
Key:: 3001 Value:: Prods [pno=1, pname=RAM, price=9800.0]
*/