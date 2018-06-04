package js.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import jquery.test.vo.User;

/**
 * Servlet implementation class Test8Servlet
 */
@WebServlet(name = "Test8", urlPatterns = { "/test8" })
public class Test8Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Test8Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<User> list = new ArrayList<User>();
		list.add(new User("홍길동",3,"경기도"));
		list.add(new User("가나다",4,"서울시"));
		list.add(new User("라마바",5,"같기도"));
		list.add(new User("사아자",6,"가지도"));
		list.add(new User("차카타",7,"개똥도"));
		list.add(new User("파하",8,"약에도"));
		list.add(new User("기니디",209,"쓸데도"));
		list.add(new User("리미비",99,"없다도"));
		list.add(new User("시이지",54,"캐나다"));
		list.add(new User("치키티",56,"안드로메다"));
		list.add(new User("피히",14,"어디루간다"));
		
		request.setCharacterEncoding("UTF-8");
		
		String userIndexs2 = request.getParameter("userIndexs2");
		StringTokenizer sT = new StringTokenizer(userIndexs2, ",");
		
		
		ArrayList<Integer> userSelect = new ArrayList<Integer>();
		while(sT.hasMoreTokens()) {
			userSelect.add(Integer.parseInt(sT.nextToken())-1);
			
		}
		JSONObject resultMap = new JSONObject();
		int index=0;
		while(index<userSelect.size()) {
			User user = list.get(userSelect.get(index));
			JSONObject result = new JSONObject();
			result.put("name", user.getName());
			result.put("age", user.getAge());
			result.put("addr", user.getAddr());
			
			resultMap.put(index, result);
			index++;
		}
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(resultMap);
		response.getWriter().close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
