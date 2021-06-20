package com.codechallenge.WellD.PatternRecognition.Model;
/***
 @Author: Frank Massoda
 @Date: 19 giu 2021
 @Time:14:21:36
 This is a simple class for defining a Line: A line pass to at least two points
**/
public class Line {
	
	private Point pointA; //first point
	private Point pointB; //second point
	private double slope; //slope of the line
	private double intercept; //intercept for the line
	
	/**
	 * 
	 * @param pointA
	 * @param pointB
	 * The costructor take 2 points and draw a line passing through those point
	 */
	public Line(Point pointA, Point pointB) {
		this.pointA = pointA;
		this.pointB = pointB;
		lineDraw();
	}
	
	/**
	 * 
	 * @param that
	 * @return
	 * This method check if a point is on this line by replacing the coordinate of the point in the line equation
	 */
	public boolean isOnLine(Point that){
		return that.getY() == this.slope * that.getX() + this.intercept;
	}
	
	/**
	 * This method draw a line
	 */
	private void lineDraw() {
		lineSlope();
		lineIntercept();
	}
	
	/**
	 * This method compute the slope of a line
	 * given point A(xa, ya) and point B(xb, yb) the slope  = (ya - yb) / (xa - xb)
	 */
	private void lineSlope() {
		slope = (pointA.getY() - pointB.getY()) / (pointA.getX() - pointB.getX());
	}
	
	/**
	 * This method compute the intercept of a line
	 * the line is given by the equation y = ax + b so the intercept b  = y - ax where (x, y) coordinate for a point in the line
	 * for instance point A
	 */
	private void lineIntercept() {
		intercept = pointA.getY() - slope * pointA.getX();
	}


}
