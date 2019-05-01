package com.tpmms.com.tpmms;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
//import java.util.ArrayList;
//import java.util.ArrayList;
//import java.util.List;

public class MergeJoin {

              public static String Join() {
            	  long startTime=System.currentTimeMillis();
            	  long endTime=0;
                           String inputFile1 =System.getProperty("user.dir") +System.getProperty("file.separator")+"buffer1" +System.getProperty("file.separator")+ "2-sublist-0_1";
                           String inputFile2 =System.getProperty("user.dir") +System.getProperty("file.separator")+"buffer2" +System.getProperty("file.separator")+"9-sublist-0_1";
                           String outputFile=System.getProperty("user.dir") +System.getProperty("file.separator")+"outputFile.txt";
                           String courseFile=System.getProperty("user.dir") +System.getProperty("file.separator")+"courseFile.txt";
                           try
                           {
                           BufferedReader brFile1 = new BufferedReader(new FileReader(inputFile1));
                           BufferedReader brFile2 = new BufferedReader(new FileReader(inputFile2));
                           BufferedWriter bwOutput=new BufferedWriter(new FileWriter(outputFile));
                           BufferedWriter bwCourseFile=new BufferedWriter(new FileWriter(courseFile));
                           String studentDetails=brFile1.readLine();
                           String enrollmentDetails=brFile2.readLine();
                          // List<String> studentCourseIds = new ArrayList<String>();
                           while((studentDetails!=null) && (enrollmentDetails!=null))
                           {
                           if(Integer.parseInt(studentDetails.substring(0, 8))<Integer.parseInt(enrollmentDetails.substring(0, 8)))
                           {
                        	   //studentCourseIds=null;
                                         studentDetails=brFile1.readLine();
                           }
                           else if(Integer.parseInt(studentDetails.substring(0, 8))>Integer.parseInt(enrollmentDetails.substring(0, 8)))
                           {
                        	 //  studentCourseIds=null;
                                         enrollmentDetails=brFile2.readLine();
                           }
                   		else if(Integer.parseInt(studentDetails.substring(0, 8))==Integer.parseInt(enrollmentDetails.substring(0, 8)))
                		{
//                			String courseId=enrollmentDetails.substring(8,15);
//                					if(studentCourseIds==null ||!studentCourseIds.contains(courseId) )
//                				{	
                					//studentCourseIds.add(courseId);
                					bwOutput.write(studentDetails+enrollmentDetails.substring(8));
                			bwOutput.write(System.lineSeparator());
                			bwOutput.flush();
                			bwCourseFile.write(enrollmentDetails);
                			bwCourseFile.write(System.lineSeparator());
                			bwCourseFile.flush();
                			enrollmentDetails=brFile2.readLine();
//                							}
                							}              
                                    
                           }                                                             
                           brFile1.close();
                           brFile2.close();
                           bwOutput.close();        
                           bwCourseFile.close();
                           endTime=System.currentTimeMillis();
                           }
                           catch(Exception ex)
                           {
                        	   ex.printStackTrace();          
                           }
                           System.out.println("done with the sorted join.Time Taken:"+(endTime-startTime));
                           return "success";
                                                       }
}
