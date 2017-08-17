package controller.database;

import java.sql.Connection;
import java.util.Map;

import javax.annotation.Resource;
import javax.sql.DataSource;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DatabaseController {
   
   @Resource(name="datasourceByJDBC")   
   private DataSource datasourceByJDBC;
   
   
   @Resource(name="datasourceByJNDI")
   private DataSource datasourceByJNDI;
   @RequestMapping("/Database/JDBCConnection.do")
   public String jdbc(@RequestParam String method,Map map) throws Exception{
      
      Connection conn =datasourceByJDBC.getConnection();
      map.put("message",conn==null? "데이타베이스 연결 실패" : "데이타베이스 연결 성공"+method);
      //커넥션 객체 메모리 해제
      if(conn != null) conn.close();
      return "/Database_08/Database.jsp";
   }
   @RequestMapping("/Database/JNDIConnection.do")
   public String jndi(@RequestParam String method,Map map) throws Exception{
      
      Connection conn =datasourceByJNDI.getConnection();
      map.put("message",conn==null? "데이타베이스 연결 실패" : "데이타베이스 연결 성공"+method);
      //커넥션 객체 메모리 해제
      if(conn != null) conn.close();
      return "/Database_08/Database.jsp";
   }
}