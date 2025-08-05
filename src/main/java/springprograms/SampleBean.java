package springprograms;
/*
 * POJO = Any simple class

Bean = POJO + managed by Spring

Entity = POJO + mapped to DB table with JPA

| Scope       | Lifespan                         | Use Case                                 |
| ----------- | -------------------------------- | ---------------------------------------- |
| singleton   | Entire app lifecycle             | Shared services like DB connections      |
| prototype   | Every time you ask for it        | Per-use objects like Forms or DTOs       |
| request     | One per HTTP request             | Controllers or form beans (web)          |
| session     | One per HTTP session             | User-specific info (e.g., login session) |
| application | One per web app (ServletContext) | App-wide config or state                 |

| Scope         | Description                                              |
| ------------- | -------------------------------------------------------- |
| `singleton`   | **Default.** Only **one instance per Spring container**  |
| `prototype`   | A **new bean** is created **every time** it is requested |
| `request`     | (Web only) One bean **per HTTP request**                 |
| `session`     | (Web only) One bean **per HTTP session**                 |
| `application` | (Web only) One bean **per ServletContext**               |
| `websocket`   | (Web only) One bean **per WebSocket session**            |

 */
//Spring Beans are configured in 2 ways:: 1. XML 2.Annotation

public class SampleBean 
{
	String username;//beanproperty
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
