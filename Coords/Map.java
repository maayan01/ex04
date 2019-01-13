package Coords;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Geom.Point3D;

public class Map 
{
	//-------------------------------

	private float mapScreenWidth; // Horizontal dimension of this map, in pixels
	private float mapScreenHeight; //Vertical dimension of this map, in pixels.
	
	private float topLatitude; // Northern border of this map, in degrees.
	private float bottomLatitude; // Southern border of this map, in degrees.
	private float leftLongitude; //Western border of this map, in degrees.
	private float rightLongitude; // Eastern border of this map, in degrees.
	  
	private BufferedImage img;


	//-----------------------------------------
	public Map (String imgPath)
	{
		try 
		{
			img = ImageIO.read(new File(imgPath));
		} 
		catch (IOException e) 
		{
			System.out.println("cannot find the img");
		}
		
		
	}

	//-----------------------------------------------
	public static Point3D	pix2Gps (Point3D pix)
	{
		int lat,lon;
		lat=0;
		lon  =0;
		return new Point3D (lat,lon);
	}

	//-----------------------------------------------
	public static Point3D	Gps2pix (Point3D gps)
	{
		int x,y;
		x=0;
		y=0;

		return new Point3D (x,y);
	}
	
	

}
