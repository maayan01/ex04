package Coords;

import Geom.Point3D;

public class MercatorMap {
	  public static final double DEFAULT_TOP_LATITUDE = 80;
	  public static final double DEFAULT_BOTTOM_LATITUDE = -80;
	  public static final double DEFAULT_LEFT_LONGITUDE = -180;
	  public static final double DEFAULT_RIGHT_LONGITUDE = 180;
	  
	  /** Horizontal dimension of this map, in pixels. */
	  protected double mapScreenWidth;
	  /** Vertical dimension of this map, in pixels. */
	  protected double mapScreenHeight;

	  /** Northern border of this map, in degrees. */
	  private double topLatitude;
	  /** Southern border of this map, in degrees. */
	  private double bottomLatitude;
	  /** Western border of this map, in degrees. */
	  private double leftLongitude;
	  /** Eastern border of this map, in degrees. */
	  private double rightLongitude;

	  private double topLatRelative;
	  private double bottomLatRelative;
	  private double leftLongitudeRadians;
	  private double rightLongitudeRadians;

	  //---------------------- constructor-----------------------------------------
	  public MercatorMap(double mapScreenWidth, double mapScreenHeight) 
	  {
	    this(mapScreenWidth, mapScreenHeight, DEFAULT_TOP_LATITUDE, DEFAULT_BOTTOM_LATITUDE, DEFAULT_LEFT_LONGITUDE, DEFAULT_RIGHT_LONGITUDE);
	  }
	  
	  /**
	   * Creates a new MercatorMap with dimensions and bounding box to convert between geo-locations and screen coordinates.
	   *
	   * @param mapScreenWidth Horizontal dimension of this map, in pixels.
	   * @param mapScreenHeight Vertical dimension of this map, in pixels.
	   * @param topLatitude Northern border of this map, in degrees.
	   * @param bottomLatitude Southern border of this map, in degrees.
	   * @param leftLongitude Western border of this map, in degrees.
	   * @param rightLongitude Eastern border of this map, in degrees.
	   */
	  public MercatorMap(double mapScreenWidth, double mapScreenHeight, double topLatitude, double bottomLatitude, double leftLongitude, double rightLongitude) {
	    this.mapScreenWidth = mapScreenWidth;
	    this.mapScreenHeight = mapScreenHeight;
	    this.topLatitude = topLatitude;
	    this.bottomLatitude = bottomLatitude;
	    this.leftLongitude = leftLongitude;
	    this.rightLongitude = rightLongitude;

	    this.topLatRelative = getScreenYRelative(topLatitude);
	    this.bottomLatRelative = getScreenYRelative(bottomLatitude);
	    this.leftLongitudeRadians = getRadians(leftLongitude);
	    this.rightLongitudeRadians = getRadians(rightLongitude);
	  }

	  /**
	   * Projects the geo location to Cartesian coordinates, using the Mercator projection.
	   *
	   * @param geoLocation Geo location with (latitude, longitude) in degrees.
	   * @returns The screen coordinates with (x, y).
	   */
	  public Point3D getScreenLocation(Point3D geoLocation) 
	  {
	    double latitudeInDegrees = geoLocation.x;
	    double longitudeInDegrees = geoLocation.y;

	    return new Point3D(getScreenX(longitudeInDegrees), getScreenY(latitudeInDegrees));
	  }

	  private double getScreenYRelative(double latitudeInDegrees) 
	  {
	    return Math.log(Math.tan(latitudeInDegrees / 360f * Math.PI + Math.PI / 4));
	  }

	  protected double getScreenY(double latitudeInDegrees) 
	  {
	    return mapScreenHeight * (getScreenYRelative(latitudeInDegrees) - topLatRelative) / (bottomLatRelative - topLatRelative);
	  }
	  
	  // מעבר ממעלות לרדינאנים
	  private double getRadians(double deg) 
	  {
	    return deg * Math.PI / 180;
	  }

	  protected double getScreenX(double longitudeInDegrees) 
	  {
	    double longitudeInRadians = getRadians(longitudeInDegrees);
	    return mapScreenWidth * (longitudeInRadians - leftLongitudeRadians) / (rightLongitudeRadians - leftLongitudeRadians);
	  }
}
