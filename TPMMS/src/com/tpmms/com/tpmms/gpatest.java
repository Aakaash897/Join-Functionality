package com.tpmms.com.tpmms;
import java.io.*;
 
public class gpatest
{
//    public static void main(String[] args) throws IOException 
	public static void GpaCalculation()
    {
      
    	long start = System.currentTimeMillis();
         
    	String outputFile = System.getProperty("user.dir") + "/gpatemp.txt";
    	   try {
    		   String inputFile =System.getProperty("user.dir") +System.getProperty("file.separator")+ "courseFile.txt";
    		   //String inputFile =System.getProperty("user.dir") +System.getProperty("file.separator")+ "outputFile.txt";
        BufferedReader br1 = new BufferedReader(new FileReader(inputFile));
    	BufferedWriter out1 = new BufferedWriter(new FileWriter(outputFile));
   
        long i = 0;
        int NoOfInputBlocks=0;
        int NoOfOutputBlocks=0;
        int studentidold = 0;
        int studentcreditsum=0;
        int counter=0;
        int outcounter=0;
        float studentgradesum = (float)0.0;
        float studentgrade = (float)0.0;
        String studentgradeletter = null;
        int studentcreditpoint = 0;
        String studentid = null;
        boolean run = true;
        int n=0;
        double studentaverage = 0;
        String studentaverage1;
        String line1;
     
        	out1.write("Studentid   AverageGrade");
            out1.newLine();
        	line1=br1.readLine();
        	if(line1!=null)
        	{
        	++n;
            counter++;
    	    studentid = line1.substring(0,8);
    	    studentgradeletter = line1.substring(23);
    	    studentcreditpoint = Integer.parseInt(line1.substring(21,22));
    		//studentgradeletter = line1.substring(115);
    		//System.out.println(studentgradeletter);
    	    if(studentgradeletter.trim().equals("A+"))
    		{
       			studentgrade=(float)4.3;
    		}
    		else if(studentgradeletter.trim().equals("A"))
    		{
    			studentgrade=(float)4.0;
    		}
    		else if(studentgradeletter.trim().equals("A-"))
    		{
    			studentgrade=(float)3.7;
    		}
    		else if(studentgradeletter.trim().equals("B+"))
    		{
    			studentgrade=(float)3.3;
    		}
    		else if(studentgradeletter.trim().equals("B"))
    		{
    			studentgrade=(float)3.0;
    		}
    		else if(studentgradeletter.trim().equals("B-"))
    		{
    			studentgrade=(float)2.7;
    		}
    		else if(studentgradeletter.trim().equals("C+"))
    		{
    			studentgrade=(float)2.3;
    		}
    		else if(studentgradeletter.trim().equals("C"))
    		{
    			studentgrade=(float)2.0;
    		}
    		else if(studentgradeletter.trim().equals("C-"))
    		{
    			studentgrade=(float)1.7;
    		}
    		else if(studentgradeletter.trim().equals("D+"))
    		{
    			studentgrade=(float)1.3;
    		}
    		else if(studentgradeletter.trim().equals("D"))
    		{
    			studentgrade=(float)1.0;
    		}
    		else if(studentgradeletter.trim().equals("D-"))
    		{
    			studentgrade=(float)0.7;
    		}
    		else if(studentgradeletter.trim().equals("F"))
    		{
    			studentgrade=(float)0.0;
    		}
    		else if(studentgradeletter.trim().equals("R"))
    		{
    			studentgrade=(float)0.0;
    		}
    		else if(studentgradeletter.trim().equals("GNR"))
    		{
    			studentgrade=(float)0.0;
    		}
    		studentcreditsum =(studentcreditsum+studentcreditpoint);
    		studentgradesum = (studentgradesum+studentgrade*studentcreditpoint);
    		//studentaverage = studentgradesum/studentcreditsum;
    		//System.out.println(studentcreditsum);
    		//System.out.println(studentgradesum);
    		++i;
    	
    		studentidold =  Integer.parseInt(studentid);
    		
        	}
    	
        while(run)
        {  
        	line1= br1.readLine();
        	if(line1!=null)
        	{
        	studentid = line1.substring(0,8);
        	counter ++;
        	if(counter==40)
    		{
    			NoOfInputBlocks++;
    			counter=0;
    		}
        	if(Integer.parseInt(studentid)==studentidold)
        	{
        		++n;
        		++i;
        		
        		studentgradeletter = line1.substring(23);
        		studentcreditpoint = Integer.parseInt(line1.substring(21,22));
        		//studentgradeletter = line1.substring(115);
        		//System.out.println(studentgradeletter);
        		if(studentgradeletter.trim().equals("A+"))
        		{
           			studentgrade=(float)4.3;
        		}
        		else if(studentgradeletter.trim().equals("A"))
        		{
        			studentgrade=(float)4.0;
        		}
        		else if(studentgradeletter.trim().equals("A-"))
        		{
        			studentgrade=(float)3.7;
        		}
        		else if(studentgradeletter.trim().equals("B+"))
        		{
        			studentgrade=(float)3.3;
        		}
        		else if(studentgradeletter.trim().equals("B"))
        		{
        			studentgrade=(float)3.0;
        		}
        		else if(studentgradeletter.trim().equals("B-"))
        		{
        			studentgrade=(float)2.7;
        		}
        		else if(studentgradeletter.trim().equals("C+"))
        		{
        			studentgrade=(float)2.3;
        		}
        		else if(studentgradeletter.trim().equals("C"))
        		{
        			studentgrade=(float)2.0;
        		}
        		else if(studentgradeletter.trim().equals("C-"))
        		{
        			studentgrade=(float)1.7;
        		}
        		else if(studentgradeletter.trim().equals("D+"))
        		{
        			studentgrade=(float)1.3;
        		}
        		else if(studentgradeletter.trim().equals("D"))
        		{
        			studentgrade=(float)1.0;
        		}
        		else if(studentgradeletter.trim().equals("D-"))
        		{
        			studentgrade=(float)0.7;
        		}
        		else if(studentgradeletter.trim().equals("F"))
        		{
        			studentgrade=(float)0.0;
        		}
        		else if(studentgradeletter.trim().equals("R"))
        		{
        			studentgrade=(float)0.0;
        		}
        		else if(studentgradeletter.trim().equals("GNR"))
        		{
        			studentgrade=(float)0.0;
        		}
        		studentcreditsum =(studentcreditsum+studentcreditpoint);
        		studentgradesum = (studentgradesum+studentgrade*studentcreditpoint);
        		//studentaverage = studentgradesum/studentcreditsum;
        		studentidold =  Integer.parseInt(studentid);
        		
        
        	}
        
        	else
        	{
        		//System.out.println("The student "+studentidold+"average is :"+studentaverage);
        	//	System.out.println(studentcreditsum);
        	//	System.out.println(studentgradesum);
        		studentaverage = studentgradesum/studentcreditsum;
        		out1.write(studentidold+"         "+String.format("%.2f",studentaverage));
        		out1.newLine();
        		outcounter++;
        		if(outcounter==40)
        		{
        			NoOfOutputBlocks++;
        			outcounter=0;
        		}
        		studentgradesum = 0;
        		studentcreditsum= 0;
        		n=0;
        		studentaverage=0;
        		++n;
        		++i;
        		
        		studentgradeletter = line1.substring(23);
        		studentcreditpoint = Integer.parseInt(line1.substring(21,22));
        		//studentgradeletter = line1.substring(115);
        		
        		if(studentgradeletter.trim().equals("A+"))
        		{
           			studentgrade=(float)4.3;
        		}
        		else if(studentgradeletter.trim().equals("A"))
        		{
        			studentgrade=(float)4.0;
        		}
        		else if(studentgradeletter.trim().equals("A-"))
        		{
        			studentgrade=(float)3.7;
        		}
        		else if(studentgradeletter.trim().equals("B+"))
        		{
        			studentgrade=(float)3.3;
        		}
        		else if(studentgradeletter.trim().equals("B"))
        		{
        			studentgrade=(float)3.0;
        		}
        		else if(studentgradeletter.trim().equals("B-"))
        		{
        			studentgrade=(float)2.7;
        		}
        		else if(studentgradeletter.trim().equals("C+"))
        		{
        			studentgrade=(float)2.3;
        		}
        		else if(studentgradeletter.trim().equals("C"))
        		{
        			studentgrade=(float)2.0;
        		}
        		else if(studentgradeletter.trim().equals("C-"))
        		{
        			studentgrade=(float)1.7;
        		}
        		else if(studentgradeletter.trim().equals("D+"))
        		{
        			studentgrade=(float)1.3;
        		}
        		else if(studentgradeletter.trim().equals("D"))
        		{
        			studentgrade=(float)1.0;
        		}
        		else if(studentgradeletter.trim().equals("D-"))
        		{
        			studentgrade=(float)0.7;
        		}
        		else if(studentgradeletter.trim().equals("F"))
        		{
        			studentgrade=(float)0.0;
        		}
        		else if(studentgradeletter.trim().equals("R"))
        		{
        			studentgrade=(float)0.0;
        		}
        		else if(studentgradeletter.trim().equals("GNR"))
        		{
        			studentgrade=(float)0.0;
        		}
        		
        		studentcreditsum =(studentcreditsum+studentcreditpoint);
        		studentgradesum = (studentgradesum+studentgrade*studentcreditpoint);
        	//	studentaverage = studentgradesum/studentcreditsum;
        		studentidold =  Integer.parseInt(studentid);
        		
        	}
       
        }
        	else
        	{
        		//System.out.println(studentgradesum);
        		run=false;
        		studentaverage = studentgradesum/studentcreditsum;
        		out1.write(studentidold+"         "+String.format("%.2f",studentaverage));
        		System.out.println("Number of Input blocks for Gpa Calculation using Sort Join: "+NoOfInputBlocks);
        		System.out.println("Number of Output blocks for Gpa Calculation using Sort Join: "+NoOfOutputBlocks);
        		//System.out.println("The student "+studentidold+"average is :"+studentaverage);
        	}
        }	
        
        br1.close();
        out1.close();
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        }
        
        
        long finish = System.currentTimeMillis();
        
        
        System.out.println("Time taken is :"+(finish-start) +"millisec");
    }
}




