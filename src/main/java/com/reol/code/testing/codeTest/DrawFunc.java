package com.reol.code.testing.codeTest;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class DrawFunc {
	private String shape;
	
	private String methodName;
	
	private int radius;
	
	private int width;
	
	private int length;
	
	private String inputParamName;

}
