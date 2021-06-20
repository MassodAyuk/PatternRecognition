package com.codechallenge.WellD.PatternRecognition.Model.DTO;

import java.io.Serializable;

import com.codechallenge.WellD.PatternRecognition.Model.Point;

/***
 @Author: Frank Massoda
 @Date: 19 giu 2021
 @Time:17:33:26
 
 This class serves as a Mapper between an object in POJO format to a JSON format for transmission over the network
**/
public class PointDTO implements Serializable{
	

	private static final long serialVersionUID = 1L;
	public double x;
	public double y;
	
	//mandatory for deserializing Object
	public PointDTO() {
		
	}
	
	public PointDTO(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * 
	 * @param point in JSON format
	 * @return a point in POJO format
	 */
	public static Point toModel(PointDTO point) {
		Point p = new Point(point.x, point.y);
		return p;
	}
	
	/**
	 * 
	 * @param array of point in POJO format
	 * @return array of point in JSON format
	 */
	public static PointDTO[] toDTOs(Point[] point) {
		PointDTO[] p = new PointDTO[point.length];
		for (int i = 0; i < p.length; i++) {
			p[i] = new PointDTO(point[i].getX(), point[i].getY());
		}
		return p;
	}
}
