package com.tpmms.com.tpmms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class NestedJoin {
	
public static void nestedJoin(String file1,String file2) throws IOException
{
	String record1=null;
	String record2=null;
	int count =0;
	float studentaverage = (float)0.0;
	int n =0;
	float studentgradesum = (float)0.0;
    float studentgrade = (float)0.0;
    String studentgradeletter = null;
    String studentgradeletter1 = null;
    String studentid = null;
    String studentidold = null;
    String studentid1 = null;
    String outputFile = System.getProperty("user.dir") +System.getProperty("file.separator")+"gpatemp1.txt";
    String inputFile2 =System.getProperty("user.dir") +System.getProperty("file.separator")+"buffer2"+System.getProperty("file.separator")+"9-sublist-0_1";
	BufferedWriter nestjoin = new BufferedWriter(new FileWriter(System.getProperty("user.dir")+System.getProperty("file.separator")+"NestedJoin.txt"));
	int studentcreditsum =0;
	int studentcreditpoint = 0;
	int writefile=0;
	int writeblock=0;
	int outloop=0;
	int innerloop=0;
	int innerblock=0;
	int writegpa=0;
	int writegpablock=0;
	int counter2 = 0;
	int NoOfInputBlocks1= 0;
	int counter3 = 0;
	int NoOfOutputBlocks1= 0;
	try {
		BufferedWriter out2 = new BufferedWriter(new FileWriter(outputFile));
		out2.write("Studentid   AverageGrade");
		out2.newLine();
		System.out.println("join started");
		Long startTime=System.currentTimeMillis();
		BufferedReader read1 = new BufferedReader(new FileReader(file1));
		
		for (int i=0;(record1=read1.readLine())!=null;i++)
		{
			int flag=0;
			studentid = record1.substring(0,8);
			counter2++;
			if(counter2==40)
			{
				NoOfInputBlocks1++;
				counter2=0;
			}
			List<String> studentCourseIds = new ArrayList<String>();
			BufferedReader read2 = new BufferedReader(new FileReader(inputFile2));
			for(int j=0;(record2=read2.readLine())!=null;j++)
			{
				++innerblock;
				studentid1 = record2.substring(0,8);
				counter2++;
				if(counter2==40)
				{
					NoOfInputBlocks1++;
					counter2=0;
				}
				if(studentid.equals(studentid1))
				{
					flag=1;
					//studentidold = studentid1;
					//out2.newLine();
					studentgradeletter1 = record2.substring(23);
					studentcreditpoint = Integer.parseInt(record2.substring(21,22));
					//System.out.println(studentid);
					//System.out.println(studentgradeletter1);
					++n;
					if(studentgradeletter1.trim().equals("A+"))
	        		{
	           			studentgrade=(float)4.3;
	        		}
	        		else if(studentgradeletter1.trim().equals("A"))
	        		{
	        			studentgrade=(float)4.0;
	        		}
	        		else if(studentgradeletter1.trim().equals("A-"))
	        		{
	        			studentgrade=(float)3.7;
	        		}
	        		else if(studentgradeletter1.trim().equals("B+"))
	        		{
	        			studentgrade=(float)3.3;
	        		}
	        		else if(studentgradeletter1.trim().equals("B"))
	        		{
	        			studentgrade=(float)3.0;
	        		}
	        		else if(studentgradeletter1.trim().equals("B-"))
	        		{
	        			studentgrade=(float)2.7;
	        		}
	        		else if(studentgradeletter1.trim().equals("C+"))
	        		{
	        			studentgrade=(float)2.3;
	        		}
	        		else if(studentgradeletter1.trim().equals("C"))
	        		{
	        			studentgrade=(float)2.0;
	        		}
	        		else if(studentgradeletter1.trim().equals("C-"))
	        		{
	        			studentgrade=(float)1.7;
	        		}
	        		else if(studentgradeletter1.trim().equals("D+"))
	        		{
	        			studentgrade=(float)1.3;
	        		}
	        		else if(studentgradeletter1.trim().equals("D"))
	        		{
	        			studentgrade=(float)1.0;
	        		}
	        		else if(studentgradeletter1.trim().equals("D-"))
	        		{
	        			studentgrade=(float)0.7;
	        		}
	        		else if(studentgradeletter1.trim().equals("F"))
	        		{
	        			studentgrade=(float)0.0;
	        		}
	        		else if(studentgradeletter1.trim().equals("R"))
	        		{
	        			studentgrade=(float)0.0;
	        		}
	        		else if(studentgradeletter1.trim().equals("GNR"))
	        		{
	        			studentgrade=(float)0.0;
	        		}
					studentcreditsum =(studentcreditsum+studentcreditpoint);
		    		studentgradesum = (studentgradesum+studentgrade*studentcreditpoint);
					/*studentgradesum = (studentgradesum+studentgrade);
					System.out.println(studentgradesum);*/
					/*studentaverage = studentgradesum/n;*/
					++writefile;
					if(writefile%40==0)
					{
						writefile=0;
						++writeblock;
					}
					nestjoin.write(record1.concat(record2.substring(8)));
					nestjoin.write(System.lineSeparator());
					nestjoin.flush();
				}
				else
					if((!(studentid.equals(studentid1)))&&flag==1)
					{
						flag=0;
						break;
					}
				if(innerblock%40==0)
				{
					++innerloop;
					innerblock=0;
				}
				 
			}
			  
			if(i%40==0)
			{
				++outloop;
			}
			
			++writegpa;
			if(writegpa%40==0)
			{
				writegpablock++;
			}
			studentaverage = studentgradesum/studentcreditsum;
    		out2.write(studentid+"         "+String.format("%.2f",studentaverage));
    		out2.newLine();
    		counter3++;
    		if(counter3==40)
    		{
    			NoOfOutputBlocks1++;
    			counter3=0;
    		}
    		studentgradesum =(float) 0.0;
    		studentcreditsum = 0;
    		studentaverage=(float) 0.0;
    		n=0;
			read2.close();
		}
		Long endTime=System.currentTimeMillis();
		System.out.println("nested time in :"+(endTime-startTime)/60000+" min");
		System.out.println("Total number of the disk IO for the nested loop join for reading is "+(outloop+innerloop));
		System.out.println("Total number of the disk IO for the nested loop join for writing is "+writeblock);
		System.out.println("Total number of the disk IO for writing the GPA for the nested loop join is "+writegpablock);
		System.out.println("Total number of the disk IO for the nested loop join for reading and  writing is "+(outloop+innerloop+writeblock+writegpablock));
		System.out.println("Number of Input blocks for Gpa Calculation using Nested Join: "+NoOfInputBlocks1);
		System.out.println("Number of Output blocks for Gpa Calculation using Nested Join: "+NoOfOutputBlocks1);	
		read1.close();
		out2.close();
	    
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	nestjoin.close();
	//return courses;
	
}

//public static void main(String[] args) throws IOException {
//
//	if((args!=null)&&(args.length==2))
//	{
//		NestedJoin jointpmms=new NestedJoin();
//		jointpmms.nestedJoin(args[0],args[1]);
//	}
//}
}