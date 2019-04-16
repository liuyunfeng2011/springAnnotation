package com.mvcAnnotation.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.Properties;

import javax.annotation.Resource;

import org.python.core.Py;
import org.python.core.PyFunction;
import org.python.core.PyInteger;
import org.python.core.PyObject;
import org.python.core.PySystemState;
import org.python.util.PythonInterpreter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mvcAnnotation.service.HelloService;
/**
 * python调用相关
 * @author snake
 *
 */
@Controller
public class TestController {
	@Resource(name="helloService")
	private HelloService helloService;
	  @ResponseBody
	 @RequestMapping(value = "sayHello.do", method = RequestMethod.GET)
	public String sayHello() {
		// System.setProperty("python.home","/Users/yexianyong/jython2.7.0/bin");
		  PySystemState sys = Py.getSystemState(); 
		  sys.path.add("/Users/yexianyong/jython2.7.0/Lib");
		  // sys.path.add("F:\\Python27\\Lib\\site-packages\\jieba");  添加第三方库
		 PythonInterpreter interp = new PythonInterpreter();
		    // 执行Python程序语句
		    interp.exec("import sys");
		    interp.set("a",new PyInteger(42));
		    interp.exec("print a");
		    interp.exec("x = 2+2");
		    PyObject x = interp.get("x");
		    System.out.println("x: " + x);
		    interp.exec("print sys.path");
		return "hello world";
	}
	  @ResponseBody
		 @RequestMapping(value = "sayHello2.do", method = RequestMethod.GET)
	  public String sayHello2() {
          PySystemState sys = Py.getSystemState(); 
		  sys.path.add("/Users/yexianyong/jython2.7.0/Lib");
		  sys.path.add("/Library/Frameworks/Python.framework/Versions/3.6/lib/python3.6/site-packages");
		  sys.path.add("/Library/Frameworks/Python.framework/Versions/3.6/lib/python3.6/site-packages/jieba");
		  sys.path.add(" /Library/Frameworks/Python.framework/Versions/3.6/lib/python3.6/site-packages/sqlalchemy");
			 PythonInterpreter interp = new PythonInterpreter();
			 interp.exec("import sys");
			    // 执行Python程序语句
			    PyObject res=null;
			    try {
			    	InputStream filepy = new FileInputStream("/Users/yexianyong/Desktop/sayHello 17.07.17.py");
			    	interp.execfile(filepy);
					PyFunction pyf = interp.get("sayHello", PyFunction.class);
					 res = pyf.__call__(Py.newInteger(1), Py.newInteger(3),Py.newString("123,324,5464,5454"));
					 System.out.println(res);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}   
			return "hello world";
		}
	  /**
	   * 控制台的方式操作jython
	   * @return
	   * @throws Exception
	   */
	  @ResponseBody
	    @RequestMapping(value = "sayHello3.do", method = RequestMethod.GET)
	    public String sayHello3() throws Exception {
	        String[] pythonData =new String[]{"python","/usr/local/py_model/sayHello.py","1","2"};
	        Process pr = Runtime.getRuntime().exec(pythonData);
	        InputStreamReader ir = new InputStreamReader(pr.getInputStream());
			LineNumberReader in = new LineNumberReader(ir);
			String line ;
			//获取到python中的所有print 数据，
			while((line=in.readLine()) != null){
				System.out.println("python print data"+line);
			}
			ir.close();
			in.close();
			pr.waitFor();
			System.out.println("end");
	        return "hello world" + line;
	    }
}
//1:所有的包引用路径全部整理出来
//2:所有第三包    dev jython /usr/local