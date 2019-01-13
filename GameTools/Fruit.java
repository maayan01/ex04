package GameTools;

import GIS.My_Meta_data;
import Geom.Point3D;

public class Fruit 
{
	//----------Fields--------------
	private Point3D p ;
	
	//-----------------------constructor------------------------------
	public Fruit(Point3D p)
	{
		this.p = new Point3D(p);
	}
	
	public Fruit(String[] gameData)
	{
		double lat,lon,alt;
		lat = Double.parseDouble(gameData[2]);
		lon = Double.parseDouble(gameData[3]);
		alt = Double.parseDouble(gameData[4]);
		p =new Point3D (lat,lon,alt);
	}
	//------------------Get's methods---------------------------
	public Point3D get_fruitPoint()
	{
		return p;
	}
	//----------------------toString----------------------------
	public String toString ()
	{
		String res="fruit: ", place="";
		place="place:("+this.p.toString()+")";
		res= res+place+"\n";
		return res;
	}

}
