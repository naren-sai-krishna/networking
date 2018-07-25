import java.util.Scanner;

class Crc{
	public static void main(String args[]){
	// Delaration of data types

	String data=new String();
	String key=new String();
	String dataword=new String();
	String cv=new String();
	int len_data;int i;
	String append_bits=new String();
	// Input

	System.out.println("Enter data and key");
	Scanner in=new Scanner(System.in);
	data=in.nextLine();
	key=in.nextLine();

	// Appending (n-1)0's to data
	dataword=append(data,key.length()-1);
	System.out.println("DataWord="+dataword);
	cv=CodeWord(key,data);
	//if(cv.length()!=(key.length()-1))
	//	cv=append(cv,key.length()-1-cv.length());
	System.out.println("CodeWord="+data.concat(cv));
	}
	// Append 0's
	public static String append(String data,int len){
		int i;
		for(i=0;i<len;i++){
			data=data.concat("0");	
		}
		return data;
	}	

	// Method to return the code word ie. (data + remainder)
	public static String CodeWord(String divisor,String divident){
		int len;	
		len=divisor.length();
		String comp=divident.substring(0,len);
		// Xor
		while(len<divident.length()){
			if(comp.charAt(0)=='1')
				comp= xor(divisor, comp) + divident.charAt(len);
			else
            			comp = xor(append("",len), comp) + divident.charAt(len);
 
        		len += 1;
 		}
   
    		if (comp.charAt(0) == '1')
        		comp = xor(divisor, comp);
    		else
       			comp = xor(append("",len), comp);
 
    		return comp;
	
	}

	// Method to perform xor of n bits
	public static String xor(String divisor,String comp){
		int i;
		String xorr="";
		int xor1= (Integer.parseInt(divisor, 2) ^ Integer.parseInt(comp, 2));
		xorr=Integer.toBinaryString(xor1);
		while((xorr.length()+1)<comp.length()){
			xorr="0".concat(xorr);
		}
		System.out.println(xorr);
		return xorr;
		}
	}
