package GameTools;

import java.util.Collection;
import java.util.Iterator;
import GIS.GIS_element;
import Geom.Point3D;

public class Packman 
{
	//----------Fields--------------
	private Point3D p ;
	private double speed;
	private double radius;
	//-----------------------constructor------------------------------
	public Packman (Point3D p, double speed, double radius)
	{
		this.p = new Point3D(p);
		this.speed = speed;
		this.radius = radius;
	}

	public Packman(String[] gameData)
	{
		double lat,lon,alt;
		lat = Double.parseDouble(gameData[2]);
		lon = Double.parseDouble(gameData[3]);
		alt = Double.parseDouble(gameData[4]);
		p =new Point3D (lat,lon,alt);
		speed =Double.parseDouble(gameData[5]);
		radius = Double.parseDouble(gameData[6]);
	}
	
	//-----------------------Get's methods-----------------------------------
	public Point3D get_packmanPoint()
	{
		return p;
	}
	public double get_speed_P()
	{
		return speed;
	}
	public double get_radius_P()
	{
		return radius;
	}
	//---------------------------toString----------------------------------------
	public String toString()
	{
		String place ="place:(",speed="speed:" ,radius="radius:",res="packman:";
		place = place +p.toString();
		speed = speed + this.speed;
		radius= radius +this.radius;
		res= res+","+place+"), "+speed+", "+radius+"\n" ;
		return res;
	}
}
