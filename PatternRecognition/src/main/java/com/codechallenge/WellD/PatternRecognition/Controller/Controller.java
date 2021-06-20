package com.codechallenge.WellD.PatternRecognition.Controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.codechallenge.WellD.PatternRecognition.Model.Point;
import com.codechallenge.WellD.PatternRecognition.Model.DTO.PointDTO;
import com.codechallenge.WellD.PatternRecognition.Service.LineSearching;

/***
 @Author: Frank Massoda
 @Date: 19 giu 2021
 @Time:17:35:14
 
 This class is use for defining a Spring REST-API application
**/
@RestController
public class Controller {
	
	private final LineSearching lineSearching;
	
	
	public Controller(LineSearching lineSearching) {
		this.lineSearching = lineSearching;
	}
	
	@PostMapping("/point")
	public Point addPoint(@RequestBody PointDTO that) {	
		return lineSearching.addPoint(PointDTO.toModel(that));
		
	}
	
	@DeleteMapping("/point")
	public void deletePoints() {	
		 lineSearching.removeAllPoints();
		
	}
	
	@GetMapping("/point/{n}")
	public Point[] getPointOnLines(@PathVariable int n) {	
		return lineSearching.getPointOnLines(n);
		
	}
	
	@GetMapping("/point")
	public PointDTO[] getPoints() {	
		return PointDTO.toDTOs(lineSearching.getAllPoints());
		
	}


}
