import java.util.Scanner;
class Bit_Stuffing{
	public static void main(String args[]){
		String data;
		String flag;
		String stuffed_data,unstuffed_data;
		
		// Taking Input data word
		Scanner in=new Scanner(System.in);
		System.out.println("Enter the data");
		data=in.nextLine();
	
		flag="01111110"; // Flag bits
		
		// Stuffing
		System.out.println("Data to be sent="+data);
		Sender s=new Sender();
		stuffed_data=s.stuff_data(data,flag);
		System.out.println("Stuffed data="+stuffed_data);

		// UnStuffing
		Reciever r=new Reciever();
		unstuffed_data=r.unstuff_data(stuffed_data);
		System.out.println("Unstuffed data="+unstuffed_data);
		System.out.println("Data recieved="+unstuffed_data.substring(8,unstuffed_data.length()-8));	
	}
}

class Sender{
	public String stuff_data(String data,String flag){
		String data1=new String();

		System.out.println("Stuffing data...");
		// Algo
		int count=0;
		for(int i=0;i<data.length();i++){
			if(data.charAt(i)=='1')
				count+=1;
			else
				count=0;
			if(count>5){
				count=0;
				data1=data1.concat("0");
			}
			
			data1=data1.concat(""+data.charAt(i));
		}
		
		// adding flags to data word
		data1=data1.concat(flag);
		data1=flag.concat(data1);
		
		return(data1);
	}
}
class Reciever{
	public String unstuff_data(String data){
		String data1=new String();
		String flag="01111110";
		System.out.println("Unstuffing data...");
		// Algo
		int count=0;
		for(int i=8;i<data.length()-8;i++){
			
			if(data.charAt(i)=='1')
				count+=1;
			else if(count>4){
				count=0;
				continue;
			}
			else
				count=0;
			
			data1=data1.concat(""+data.charAt(i));
			
		}

		// adding flags to data word
		data1=data1.concat(flag);
		data1=flag.concat(data1);
		return(data1);
	}
}