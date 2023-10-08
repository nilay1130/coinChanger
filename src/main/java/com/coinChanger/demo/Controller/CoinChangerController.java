package com.coinChanger.demo.Controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;



import com.coinChanger.demo.Model.CoinChangeResponse;
import com.coinChanger.demo.Service.ChangerService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("/api/v1/")
@Api(value = "User Api documentation")

public class CoinChangerController {

	@Autowired
	private ChangerService changerService;
	
	
	@GetMapping(value = {"coin/change/{amount}"})
	@ApiOperation(value = "Calculate count of ways to make a change")
	public ResponseEntity<CoinChangeResponse>  getResult(@PathVariable("amount") int amount){
		
		List<Integer> coins = Arrays.asList(2,3,5,10);
		String result=changerService.getResult(amount,coins);
		CoinChangeResponse res=new CoinChangeResponse();
		res.setCount(result);
		return ResponseEntity.ok( res );
	}
}
