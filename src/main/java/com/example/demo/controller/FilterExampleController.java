package com.example.demo.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilterExampleController {

  

    @GetMapping(value = "/greeting")
    public int customGreetings(){
        return Utils.nbrtour;
    }
    
    @GetMapping(value = "/add/{ligne}/{colonne}/{value}")
    public void add(@PathVariable int ligne, @PathVariable int colonne, @PathVariable int value){
    	Utils.portepion[ligne][colonne] = value;
    }
    @GetMapping(value = "/getTable", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public int[][] getTable(){
    	return Utils.portepion;
    }
    @GetMapping(value = "/init", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public int[][] init(){
    	return Utils.portepion = new int[7][6];
    }
    
    @GetMapping(value = "/nbrTour", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public int nbrTour(){
    	return Utils.nbrtour++;
    }
    
    @GetMapping(value = "/reset")
    public void reset(){
    	Utils.reset=true;
    	Utils.nbrtour=1;
    	for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 6; j++)
				Utils.portepion[i][j]=0;
			
		}
    	
    	
	}
    @GetMapping(value = "/isReset", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public boolean isReset(){
    	return Utils.reset;
    }
    @GetMapping(value = "/setRe")
    public void setRe(){
    	Utils.reset= false;
    }
    
    @GetMapping(value = "/getWinOreEq", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public boolean[][] getWinOreEq(){
    	return Utils.winoreq ;
    }
   
    @GetMapping(value = "/setWinOrEq/{indice}/{value}")
    public void setWinOrEq(@PathVariable int indice, @PathVariable boolean value){
    	Utils.winoreq[indice][0] = value;
    }
    @GetMapping(value = "/resetWinOrEq")
    public void resetWinOrEq(){
    	for(int i=0; i<3 ;i++)
         Utils.winoreq[i][0]=false;
    }
}
    

