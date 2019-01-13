package File_format;

import GIS.GIS_layer;
import GameTools.Game;

public class TestCsvGame 
{
	String path_file;

	public static void main(String[] args) 
	{
		String fileName;
		String path_file= "D:\\Users\\eli\\Documents\\ArielJAVAProjects\\Ex3\\csv_doc\\game_1543684662657.csv";
		Game myGame = CSVread.CSVreaderGame(path_file) ;
		System.out.println(myGame);

		fileName ="Game01";
		myGame.saveGame2csv(fileName);
	}

}
