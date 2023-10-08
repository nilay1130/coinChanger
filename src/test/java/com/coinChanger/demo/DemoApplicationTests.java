package com.coinChanger.demo;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.coinChanger.demo.ServiceImpl.ChangerServiceImpl;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class DemoApplicationTests {
	
	@InjectMocks
	 private ChangerServiceImpl changer;
	 
	 private List<Integer> list;
	 private int amount;
	 
	    
	
	 
	    @Test
	    public void getCount()
	    {
	      list= Arrays.asList(2,3,5,10);
	      amount=15;
	      String result=changer.getResult(amount, list);
	      assertThat(result).isEqualTo("9");
	    }
	    
	    @Test
	    public void getCountForAnother()
	    {
	      list= Arrays.asList(1,5,10,25);
	      amount=100;
	      String result=changer.getResult(amount, list);
	      assertThat(result).isEqualTo("242");
	    }


}
