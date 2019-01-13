package File_format;

import java.security.AlgorithmConstraints;

import GIS.GIS_layer;
import GIS.GIS_project;

public class TestKml 
{

	public static void main(String[] args) 
	{
		String path_file= "D:\\Users\\eli\\Documents\\ArielJAVAProjects\\Ex2\\csv_doc\\WigleWifi_20171201110209.csv";
		String fileName ="road_test";
		GIS_layer gisLayer;
		
		gisLayer = CSVread.CSVreader(path_file);
		Csv2Kml.makeKmlFile(gisLayer, fileName);
		
		//----------------------------------------
		//GIS_project manyRoads = Algorithms.MultiCSV();
	}

}
