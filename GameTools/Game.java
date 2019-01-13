package GameTools;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import File_format.CSVread;
import GIS.GIS_element;
import GIS.My_GIS_element;
import Geom.Point3D;

public class Game
{
	//------------------fields-----------------------------
	Set<Fruit> setFruits;
	Set<Packman> setPackmans;

	//------------------constructor------------------------
	public Game ()
	{
		setFruits = new HashSet<Fruit>();
		setPackmans = new HashSet<Packman>();
	}
	public Game (String path_file )
	{
		Game myGame;
		myGame = CSVread.CSVreaderGame(path_file) ;
	}
	
	
   //-------------------------------------------------
	/**
	 * make a new csv file
	 * @param fileName
	 * */
	private File newCsvFile(String fileName)
	{
	    String folderName="D:\\Users\\eli\\Documents\\ArielJAVAProjects\\Ex3\\new_csv\\";
		File file = new File( folderName+fileName+".csv");
		// creates the file
		try 
		{
			file.createNewFile();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		return file;
	}
	//------------------------------------------
	/**
	 * save the game data to csv file
	 * @param fileName
	 * */
	public void saveGame2csv (String fileName)
	{

		String gameData="";
		File file = newCsvFile(fileName);
		gameData= StringGameCSV ();
		try
		{
			FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(gameData);
		//	wellDone(file);
			bw.close();
		} 
		catch (IOException e) 
		{
			System.out.println("Failed to create csv file ");
			e.printStackTrace();
		}
	}
	
	//-------------------------------------------
	/**make form game data String in form of csv 
	 * */
	public String StringGameCSV ()
	{
		String firstline,fruitData="" , packmanData="" ,csvGame="";
		firstline="Type,id,Lat,Lon,Alt,Speed/Weight,Radius\n";
		int i_fruit=0 , i_packman=0;
		
		//packman data
				for (Packman packman : setPackmans) 
				{
					packmanData=packmanData+"P,"+i_packman+","+packman.get_packmanPoint()+","+packman.get_speed_P()+","+packman.get_radius_P()+"\n";
					i_packman++;
				}
		//fruit data
		for (Fruit fruit : setFruits) 
		{
			fruitData=fruitData+"F,"+i_fruit+","+fruit.get_fruitPoint()+",\n";
			i_fruit++;
		}
		csvGame= firstline+packmanData+fruitData;
		return csvGame;
	}
	
	//--------------set methods Fruit------------------------
	public boolean add_f(Fruit arg0) 
	{
		return setFruits.add(arg0);
	}
	public boolean addAll_f(Collection<? extends Fruit> arg0) 
	{
		return setFruits.addAll(arg0);
	}
	public void clear_f() 
	{
		setFruits.clear();
	}
	public boolean contains_f(Object arg0) 
	{
		return setFruits.contains(arg0);
	}
	public boolean containsAll_f(Collection<?> arg0) 
	{
		return setFruits.containsAll(arg0);
	}
	public boolean isEmpty_f() 
	{
		return setFruits.isEmpty();
	}
	public Iterator<Fruit> iterator_f() 
	{
		return setFruits.iterator();
	}
	public boolean remove_f(Object arg0) 
	{
		return setFruits.remove(arg0);
	}
	public boolean removeAll_f(Collection<?> arg0) 
	{
		return setFruits.removeAll(arg0);
	}
	public boolean retainAll_f(Collection<?> arg0) 
	{
		return setFruits.retainAll(arg0);
	}
	public int size_f() 
	{
		return setFruits.size();
	}
	public Object[] toArray_f()
	{
		return setFruits.toArray();
	}
	public <T> T[] toArray_f(T[] arg0) 
	{
		return setFruits.toArray(arg0);
	}

	//--------------set methods packman------------------------
	public boolean add_p(Packman arg0) 
	{
		return setPackmans.add(arg0);
	}
	public boolean addAll_p(Collection<? extends Packman> arg0) 
	{
		return setPackmans.addAll(arg0);
	}
	public void clear_p() 
	{
		setPackmans.clear();
	}
	public boolean contains_p(Object arg0) 
	{
		return setPackmans.contains(arg0);
	}
	public boolean containsAll_p(Collection<?> arg0) 
	{
		return setPackmans.containsAll(arg0);
	}
	public boolean isEmpty_p() 
	{
		return setPackmans.isEmpty();
	}
	public Iterator <Packman> iterator_p() 
	{
		return setPackmans.iterator();
	}
	public boolean remove_p(Object arg0) 
	{
		return setPackmans.remove(arg0);
	}
	public boolean removeAll_p(Collection<?> arg0) 
	{
		return setPackmans.removeAll(arg0);
	}
	public boolean retainAll_p(Collection<?> arg0) 
	{
		return setPackmans.retainAll(arg0);
	}
	public int size_p() 
	{
		return setPackmans.size();
	}
	public Object[] toArray_p()
	{
		return setPackmans.toArray();
	}
	public <T> T[] toArray_p(T[] arg0) 
	{
		return setPackmans.toArray(arg0);
	}

	//--------------------toString-----------------------
	public String toString ()
	{
		String res="" , setFruits , setPackmans;
		setFruits = this.setFruits.toString();
		setPackmans = this.setPackmans.toString();
		res = setFruits+" \n "+setPackmans;
		return res; 
	}
	
}
