package com.coinChanger.demo.ServiceImpl;


import java.util.List;


import org.springframework.stereotype.Service;


import com.coinChanger.demo.Service.ChangerService;


@Service
public class ChangerServiceImpl implements ChangerService{
	

	@Override
	public String getResult(int amount,List<Integer> list) {
		int[][] coinArray=new int[4][amount+1];
		
		Integer[] intArray = new Integer[list.size()];
        intArray = list.toArray(intArray);
        
        for(int k=0; k<=3; k++){
        	coinArray[k][0] = 1;
        }
        
        for(int l=1;l<=amount;l++) {
        	if(l % intArray[0]==0) {
        		coinArray[0][l]=1;
        	}
        	else {
        		coinArray[0][l]=0;
        	}
        }
		for(int i=1;i<4;i++) {
			for(int j=1;j<=amount;j++) {
				
				if(intArray[i]>j) {
					coinArray[i][j]=coinArray[i-1][j];
				}
				else {
					coinArray[i][j]=coinArray[i-1][j]+coinArray[i][j-intArray[i]];
				}
			}
			
		}
		
		return String.valueOf(coinArray[3][amount]);
	}

}
