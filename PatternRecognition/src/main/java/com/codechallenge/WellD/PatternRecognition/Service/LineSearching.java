package com.codechallenge.WellD.PatternRecognition.Service;

import java.util.Arrays;

import java.util.Collection;
import java.util.HashSet;

import org.springframework.stereotype.Service;

import com.codechallenge.WellD.PatternRecognition.Model.Line;
import com.codechallenge.WellD.PatternRecognition.Model.Point;

/***
 * @Author: Frank Massoda
 * @Date: 19 giu 2021
 * @Time:14:39:25
 * 
 * This class contain all the method needed for the application
 **/
@Service
public class LineSearching {

	private Collection<Point> space; //define the space

	public LineSearching() {
		space = new HashSet<Point>(); //Hashset for avoiding point duplication
	}

	/**
	 * 
	 * @param that
	 * @return point
	 * 
	 * this method add a point in the space
	 */
	public Point addPoint(Point that) {
		space.add(that);
		return that;
	}

	/**
	 * 
	 * @return array of Point
	 * this method return all the point in the space
	 */
	public Point[] getAllPoints() {
		return Arrays.copyOf(space.toArray(), space.size(), Point[].class); //convert to array of Point
	}

	/**
	 * remove all the point from the space
	 */
	public void removeAllPoints() {
		space.clear();
	}

	/**
	 * 
	 * @param numPoint
	 * @return array of Point
	 * 
	 * Algorithm: Take a reference point(first cycle), then take another point(second cycle), draw a line between those points, and search for all the points 
	 * in that line(third cycle) then check if those points are greater or equal to numPoint, if yes add those point in the result container else
	 * repeat the process
	 * 			 
	 * 
	 */
	public Point[] getPointOnLines(int numPoint) {

		Collection<Point> result = new HashSet<Point>();

		Point[] spaceTemp = Arrays.copyOf(space.toArray(), space.size(), Point[].class);
		for (int i = 0; i < spaceTemp.length; i++) {
			for (int j = i + 1; j < spaceTemp.length; j++) {
				Line line = new Line(spaceTemp[i], spaceTemp[j]); //draw a line
				Collection<Point> pointLine = new HashSet<Point>(); //container for point on a given line
				for (int k = 0; k < spaceTemp.length; k++) {
					if (line.isOnLine(spaceTemp[k]))
						pointLine.add(spaceTemp[k]);
				}
				if (pointLine.size() >= numPoint)
					result.addAll(pointLine);
			}
		}
		return Arrays.copyOf(result.toArray(), result.size(), Point[].class);
	}

}
