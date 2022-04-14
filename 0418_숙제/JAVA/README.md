1. user 패키지 생성

2. UserVO 클래스 생성 (main 함수 x)
```java
    //VO는 Value Object를 의미
    //Value Object는 필드변수,생성자,getter,setter만 존재
    public class UserVO{
        private String ename; //직원 이름
        private String dname; //부서 이름
        private int sal;  //급여
        private int lv; //직원 레벨
        
        public UserVO(String ename, String dname, int sal){
            this.ename = ename;
            this.dname = dname;
            this.sal = sal;
        }
        //getter,setter 만드시오. 
    }
```

3. UserService 클래스 생성 (main 함수 x)
```java
    public class UserService{

        //1. 부서이름이 DEVELOP인 사원 급여를 2배 인상하시오.
        public List<UserVO> updateSal(List<UserVO> list, String dname){
            return null;
        }

        //2. 급여가 0 ~ 100 : 1 레벨, 101 ~ 1000 : 2 레벨, 1001 이상부터는 3 레벨로 수정하시오.
        public List<UserVO> updateLv(List<UserVO> list){
            return null;
        }
        //3. 레벨 3이상 직원을 모두 해고하시오.
        public List<UserVO> deleteUser(List<UserVO> list, int lv){
            return null;
        }

    }
```

4. MainController 클래스 생성 (main 함수 o)
```java
    public class MainController{
        public static void main(String args[]){
            UserVO vo = new UserVO();
            
        }
    }
```