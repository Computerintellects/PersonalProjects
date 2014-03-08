package com.cnsi.examination.results.persistence;

import com.cnsi.examination.results.persistence.StudentDao;
import com.cnsi.examination.results.vo.Student;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class StudentDaoImpl implements StudentDao {
    private static ArrayList Students;
    private static Connection connection =null;
    static {
        Students = new ArrayList();
		String	query="select * from student";
		connection= DBconnection.getConnection();
		Statement statement = null;
		try {
			statement = connection.createStatement();
			ResultSet resultset=statement.executeQuery(query);;
			while(resultset.next())
			{
				Student studentdetails=new Student();
				studentdetails.setStudentname(resultset.getString("studentname"));
				studentdetails.setStudentregno(resultset.getInt("studentregno"));
				studentdetails.setStd(resultset.getInt("sId"));
				studentdetails.setTamil(resultset.getInt("tamil"));
				studentdetails.setEnglish(resultset.getInt("english"));
				studentdetails.setMaths(resultset.getInt("maths"));
				studentdetails.setScience(resultset.getInt("science"));
				studentdetails.setSocial(resultset.getInt("social"));
				studentdetails.setTotalmarks(resultset.getInt("totalmarks"));
				Students.add(studentdetails);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
    }

    Log logger = LogFactory.getLog(this.getClass());

    public List getAllStudents() {
		return Students;
    }

    public Student getStudent(Integer id) {
        Student emp = null;
        for(Iterator iter = Students.iterator(); iter.hasNext(); ) {
            emp = (Student)iter.next();
            if ( emp.getStd().equals( id ) ) {
                 break;
            }
        }
        return emp;
    }

    public void update(Student emp) {
        Integer id = emp.getStd();
        Integer total = 0;
        for(int i = 0; i < Students.size(); i++ ) {
            Student tempEmp = (Student)Students.get(i);
            if ( tempEmp.getStd().equals( id ) ) {
                 Students.set( i, emp );
                 try
         		{
         			Connection connection=DBconnection.getConnection();
         			emp.setTotalmarks(0);
         			total = emp.getEnglish()+emp.getTamil()+emp.getMaths()+emp.getScience()+emp.getSocial();
         			emp.setTotalmarks(total);
         			PreparedStatement pstmt=connection.prepareStatement("update student set studentname=?,sid=?,tamil=?,english=?,maths=?," +
         					"science=?,social=?,totalmarks=? where studentregno=?");

         			pstmt.setString(1,emp.getStudentname());
         			pstmt.setInt(2,emp.getStd());
         			pstmt.setInt(3,emp.getTamil());
         			pstmt.setInt(4,emp.getEnglish());
         			pstmt.setInt(5,emp.getMaths());
         			pstmt.setInt(6,emp.getScience());
         			pstmt.setInt(7,emp.getSocial());
         			pstmt.setInt(8,emp.getTotalmarks());
         			pstmt.setInt(9,emp.getStudentregno());
         			pstmt.executeUpdate();

         		}
         		catch(Exception e)
         		{
         			e.printStackTrace();
         		}
                 break;
            }
        }
    }

    public void insert(Student emp) {
        int lastId = 0;
        Integer total = 0;
        for(Iterator iter = Students.iterator(); iter.hasNext(); ) {
            Student temp = (Student)iter.next();
            if ( temp.getStd().intValue() > lastId ) {
                lastId = temp.getStd().intValue();
            }
        }
        emp.setStd(new Integer(lastId + 1));
        try{
        	connection= DBconnection.getConnection();
        	emp.setTotalmarks(0);
 			total = emp.getEnglish()+emp.getTamil()+emp.getMaths()+emp.getScience()+emp.getSocial();
 			emp.setTotalmarks(total);
        Statement st=connection.createStatement();	
		PreparedStatement pstmt=connection.prepareStatement("insert into student values(?,?,?,?,?,?,?,?,?)"); 
		pstmt.setInt(1,emp.getStd());
		pstmt.setString(3,emp.getStudentname());
		pstmt.setInt(2,emp.getStudentregno());
		pstmt.setInt(4,emp.getEnglish());
		pstmt.setInt(5,emp.getTamil());
		
		pstmt.setInt(6,emp.getMaths());
		pstmt.setInt(7,emp.getScience());
		pstmt.setInt(8,emp.getSocial());
		pstmt.setInt(9,emp.getTotalmarks());
		pstmt.executeUpdate();
		connection.commit();
		System.out.println("connection is"+connection.getAutoCommit());
	}
	catch(Exception e)
	{
		e.printStackTrace();
	} finally{
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

        Students.add(emp);
    }
   

    public void delete(Integer id) {
        for(int i = 0; i < Students.size(); i++ ) {
            Student tempEmp = (Student)Students.get(i);
            if ( tempEmp.getStd().equals( id ) ) {
                 Students.remove( i );
                 try
         		{
         			Connection connection=DBconnection.getConnection();

         			PreparedStatement pstmt=connection.prepareStatement("delete from student where sid=?");
         			pstmt.setInt(1,tempEmp.getStd());
         			pstmt.executeUpdate();

         		}
         		catch(Exception e)
         		{
         			e.printStackTrace();
         		}
                 break;
            }
        }
    }
}
