# Builder Pattern
### Builder Pattern에 대해서 정리하기.**

### **1\. 빌더 패턴을 사용하는 이유**

**\- 원하는 값만 세팅할 수 있다.**

예를들어 name과 email이라는 두개의 필드가 있을때, name값을 뺀 email값만 db에 Insert한다고 가정해보자.

이런 경우 name에는 별도의 null값을 처리해야 하거나 새로운 생성자를 만들어 주어야 할것이다.

하지만, 빌더 패턴을 사용하면 위의 null처리나 생성자를 새로 만들 필요없이 email값만 insert가 가능하다.

아래의 테스트 코드를 보면 이해가 될것이다.

\-  User DTO의 필드 값은 아래와 같다.

```
public class User {
    private final String name;
    private final String email;
    ...
```

\- UserService의 내용은 아래와 같다.

```
    public void userBuilder() {
        User user = new User.UserBuilder()
                .setName("Seung Kim")
                .setEmail("Seungkim@example.com")
                .build();
        userMapper.insertUser(user);
    }

    public void userBuilderForEmail() {
        User user = new User.UserBuilder()
                .setEmail("Seungkim@example.com")
                .build();
        userMapper.insertUser(user);
    }
```

\- DB에 Insert된 결과는 아래와 같다. name 필드에 값이 없으므로, null로 표시 되었고, email 필드의 값만 insert된것을 확인 할 수 있다. 이렇듯, 필드 값을 원하는 값만 세팅하여 적용 할 수 있으므로 편리하다.

![다운로드](https://github.com/Nanninggu/Builder-Pattern/assets/54211801/88e56c9e-40ff-40c1-a959-defe85dd0485)


**\- 불변성을 확보 할 수있다.**

(setter)를 사용하는 거는 것은 불필요한 확장을 초래 할 수 있다.

final로 선언하고 객체의 생성을 builder에게 맡기는것이 좋다.

```
public class User {
    private final String name;
    private final String email;
```

**\- 일관성 유지**

객체를 생성하는 순간 필드의 값을 할당하기 때문에 생성 시점에서 객체의 일관성을 유지한다.

그리고 생성하는 객체별로 필요한 값만 설정할 수 있는 유연한 특성을 가지고 있으며, 

**build() 를 호출해야만 Builder 클래스에서 해당 객체가 생성되므로, 클래스의 일관성을 지킬 수 있다.**

**\- 기타 관련 내용 정리**

**@Builder**

빌더 패턴은 생성자 기반 객체 생성과 Setter 기반 객체 생성의 장점을 모두 살린 유용한 디자인 패턴이지만, 클래스별로 Builder 클래스를 반복적으로 생성하는데는 불편함이 있다.

이를 해결할 방법으로는 Lombok 의 @Builder 어노테이션을 클래스에 적용시키면, 주어진 클래스의 필드를 기반으로 빌더 패턴을 자동으로 생성한다.

**\- 주의사항**

final 키워드는 수동으로 적용 해야한다.

성능이 약간 저하 될수는 있으나, 큰 차이는 없다.

#### **2\. CoreLogic 설명**

```
빌더 패턴의 핵심 로직은 복잡한 객체를 생성하는 과정을 단계별로 나누는 것이다. 
이 프로젝트에서는 User 객체를 생성하는 데 빌더 패턴을 사용하고 있다.  
User.UserBuilder: User 객체를 생성하기 위한 빌더 클래스이다. 
	          setName과 setEmail 메서드를 통해 User 객체의 필드를 설정하고,
                  build 메서드를 통해 설정된 필드를 가진 User 객체를 생성한다.
UserService: UserBuilder를 사용하여 User 객체를 생성하고, 이를 UserMapper를 통해 
	     데이터베이스에 삽입하는 로직을 담당한다.  
UserMapper: User 객체를 데이터베이스에 삽입하는 SQL 쿼리를 정의한다.  
	    이렇게 빌더 패턴을 사용하면 객체 생성 과정을 단계별로 나누어 코드의 가독성을 높이고, 
            필요한 필드만을 선택적으로 설정할 수 있다.
```

### 2\. FlowDiagram

\- FlowDiagram

이건 다음에 시간 있을때 그리자.

\- 끝 -
