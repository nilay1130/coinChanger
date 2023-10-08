package com.coinChanger.demo.Model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@ApiModel(value = "User Api model documentation", description = "Model")
public class Coin {
	
	@ApiModelProperty(value = "Change amount field")
	private Double amount;
	

}
