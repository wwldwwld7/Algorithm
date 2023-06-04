import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] sub = new String[20];
		float[] num = new float[20];
		float[] score = new float[20];
		for(int i=0 ; i<20 ; i++) {
			String[] str = br.readLine().split(" ");
			sub[i] = str[0];
			num[i] = Float.parseFloat(str[1]);
			if(str[2].equals("A+")) score[i] = (float) 4.5;
			else if(str[2].equals("A0")) score[i] = (float)4;
			else if(str[2].equals("B+")) score[i] = (float)3.5;
			else if(str[2].equals("B0")) score[i] = (float)3;
			else if(str[2].equals("C+")) score[i] = (float)2.5;
			else if(str[2].equals("C0")) score[i] = (float)2;
			else if(str[2].equals("D+")) score[i] = (float)1.5;
			else if(str[2].equals("D0")) score[i] = (float)1;
			else if(str[2].equals("F")) score[i] = (float)0;
			else if(str[2].equals("P")) score[i] = (float)-1;
		}
		
		float result=0;
		int plus=0;
		for(int i=0 ; i<20 ; i++) {
			if(score[i]!=-1) {
				plus += num[i];
				result += num[i]*score[i];
			}
		}
		if(plus==0) plus = 1;
		System.out.printf("%.6f",result/plus);
	}
}